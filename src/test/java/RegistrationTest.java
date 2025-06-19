import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.PageObjects.LoginPage;
import ru.yandex.praktikum.PageObjects.MainPage;
import ru.yandex.praktikum.PageObjects.RegistrationPage;

import java.time.Duration;

import static ru.yandex.praktikum.Statics.ALERT_MESSAGE;
import static ru.yandex.praktikum.Statics.BASE_URL;

@Feature("Группа тестов для проверки регистрации пользователя")
@DisplayName("Регистрация пользователя")
public class RegistrationTest {
    private final String browserType = "chrome"; // или "yandex"
    private WebDriver driver;
    private MainPage mainPage;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;
    private String name;
    private String email;
    private String password;
    private String incorrectPassword;

    @Before
    @Step("Создаем драйвер в зависимости от выбранного браузера")
    public void setUp() {
        driver = DriverFactory.getDriver(browserType);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        email = (org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(2, 10) + "@" +
                org.apache.commons.lang3.RandomStringUtils.randomAlphabetic(2, 8) + "." + "ru").toLowerCase();
        password = org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(6, 10);
        name = org.apache.commons.lang3.RandomStringUtils.randomAlphabetic(5, 10);
        incorrectPassword = org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(1, 5);
    }

    @Test
    @Step("Регистрация через флоу Войти в аккаунт->Зарегистрироваться")
    @Description("Успешная регистрация")
    public void RegistrationWithLoginButtonTest() {
        driver.get(BASE_URL);
        mainPage.clickLoginButton();
        loginPage.clickRegistrationButton();
        registrationPage.enterName(name);
        registrationPage.enterEmail(email);
        registrationPage.enterPassword(password);
        registrationPage.clickRegisterButton();
    }

    @Test
    @Step("Регистрация через флоу Личный кабинет->Зарегистрироваться")
    @Description("Успешная регистрация")
    public void RegistrationWithPersonalAccountButtonTest() {
        driver.get(BASE_URL);
        mainPage.clickPersonalAccountButton();
        loginPage.clickRegistrationButton();
        registrationPage.enterName(name);
        registrationPage.enterEmail(email);
        registrationPage.enterPassword(password);
        registrationPage.clickRegisterButton();
    }

    @Test
    @Step("Попытка регистрации с некорректной длинной пароля через флоу Войти в аккаунт->Зарегистрироваться")
    @Description("Сообщение об ошибке с текстом Некорректный пароль")
    public void AlertWithWIncorrectPasswordRegistrationWithLoginButtonTest() {
        driver.get(BASE_URL);
        mainPage.clickLoginButton();
        loginPage.clickRegistrationButton();
        registrationPage.enterName(name);
        registrationPage.enterEmail(email);
        registrationPage.enterPassword(incorrectPassword);
        registrationPage.clickRegisterButton();
        String actualTextOfAlert = registrationPage.getIncorrectPasswordAlert();
        registrationPage.compareAlertText(ALERT_MESSAGE, actualTextOfAlert);
    }


    @Test
    @Step("Попытка регистрации с некорректной длинной пароля через флоу Личный кабинет->Зарегистрироваться")
    @Description("Сообщение об ошибке с текстом Некорректный пароль")
    public void AlertWithWIncorrectPasswordRegistrationWithPersonalAccountButtonTest() {
        driver.get(BASE_URL);
        mainPage.clickLoginButton();
        loginPage.clickRegistrationButton();
        registrationPage.enterName(name);
        registrationPage.enterEmail(email);
        registrationPage.enterPassword(incorrectPassword);
        registrationPage.clickRegisterButton();
        String actualTextOfAlert = registrationPage.getIncorrectPasswordAlert();
        registrationPage.compareAlertText(ALERT_MESSAGE, actualTextOfAlert);
    }

    @After
    @Step("Закрытие браузера")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
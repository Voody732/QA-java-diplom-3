import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.page.objects.ForgetPasswordPage;
import ru.yandex.praktikum.page.objects.LoginPage;
import ru.yandex.praktikum.page.objects.MainPage;
import ru.yandex.praktikum.page.objects.RegistrationPage;
import ru.yandex.praktikum.steps.CreatingUserSteps;

import java.time.Duration;

import static ru.yandex.praktikum.Statics.BASE_URL;
import static ru.yandex.praktikum.Statics.CREATE_ORDER_BUTTON_TEXT;

@Feature("Группа тестов для проверки авторизации")
@DisplayName("Авторизация")
public class LoginTest {
    private final CreatingUserSteps userSteps = new CreatingUserSteps();
    private String email;
    private String password;
    private String name;
    private String accessToken;
    private WebDriver driver;
    private MainPage mainPage;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;
    private ForgetPasswordPage forgetPasswordPage;

    @Before
    @Step("Подготовка тестовых данных и инициализация нужный страниц")
    public void prepareData() {
        email = (RandomStringUtils.randomAlphanumeric(2, 10) +
                "@" + RandomStringUtils.randomAlphabetic(2, 8) +
                "." + "ru").toLowerCase();
        password = RandomStringUtils.randomAlphanumeric(6, 10);
        name = RandomStringUtils.randomAlphabetic(5, 10);
        ValidatableResponse response = userSteps.createUser(email, password, name);
        accessToken = response.extract().path("accessToken");
        String browser = System.getProperty("browser", "chrome");
        driver = DriverFactory.getDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        forgetPasswordPage = new ForgetPasswordPage(driver);
    }

    @Test
    @Step("Авторизация через нажатие кнопки Личный кабинет")
    @Description("Успешная авторизация, автоматический переход на стартовую страницу," +
            "кнопка Войти в аккаунт поменялась на Оформить заказ")
    public void loginWithPersonalAccountButtonTest() {
        driver.get(BASE_URL);
        mainPage.clickPersonalAccountButton();
        loginPage.fillEmailField(email);
        loginPage.fillPasswordField(password);
        loginPage.clickOnEnterButton();
        String actualText = mainPage.getCreateOrderButtonText();
        mainPage.compareCreateOrderButtonText(CREATE_ORDER_BUTTON_TEXT, actualText);
    }

    @Test
    @Step("Авторизация через нажатие кнопки Войти в аккаунт")
    @Description("Успешная авторизация, автоматический переход на стартовую страницу," +
            "кнопка Войти в аккаунт поменялась на Оформить заказ")
    public void loginWithLoginButtonTest() {
        driver.get(BASE_URL);
        mainPage.clickLoginButton();
        loginPage.fillEmailField(email);
        loginPage.fillPasswordField(password);
        loginPage.clickOnEnterButton();
        String actualText = mainPage.getCreateOrderButtonText();
        mainPage.compareCreateOrderButtonText(CREATE_ORDER_BUTTON_TEXT, actualText);
    }

    @Test
    @Step("Авторизация через нажатие кнопки Войти на странице Регистрации, " +
            "на которую заходим через флоу Личный кабинет->Зарегистрироваться")
    @Description("Успешная авторизация, автоматический переход на стартовую страницу," +
            "кнопка Войти в аккаунт поменялась на Оформить заказ")
    public void loginWithEnterButtonOnRegistrationPageThroughPersonalAccountButtonTest() {
        driver.get(BASE_URL);
          mainPage.clickPersonalAccountButton();
        loginPage.clickRegistrationButton();
        registrationPage.clickEnterButtonOnRegistrationPage();
        loginPage.fillEmailField(email);
        loginPage.fillPasswordField(password);
        loginPage.clickOnEnterButton();
        String actualText = mainPage.getCreateOrderButtonText();
        mainPage.compareCreateOrderButtonText(CREATE_ORDER_BUTTON_TEXT, actualText);
    }

    @Test
    @Step("Авторизация через нажатие кнопки Войти на странице Регистрации, " +
            "на которую заходим через флоу Личный кабинет->Зарегистрироваться")
    @Description("Успешная авторизация, автоматический переход на стартовую страницу," +
            "кнопка Войти в аккаунт поменялась на Оформить заказ")
    public void loginWithEnterButtonOnRegistrationPageThroughLoginButtonTest() {
        driver.get(BASE_URL);
        mainPage.clickLoginButton();
        loginPage.clickRegistrationButton();
        registrationPage.clickEnterButtonOnRegistrationPage();
        loginPage.fillEmailField(email);
        loginPage.fillPasswordField(password);
        loginPage.clickOnEnterButton();
        String actualText = mainPage.getCreateOrderButtonText();
        mainPage.compareCreateOrderButtonText(CREATE_ORDER_BUTTON_TEXT, actualText);
    }

    @Test
    @Step("Авторизация через нажатие кнопки Войти на странице Восстановления пароля, " +
            "на которую заходим через флоу Личный кабинет->Восстановить пароль")
    @Description("Успешная авторизация, автоматический переход на стартовую страницу," +
            "кнопка Войти в аккаунт поменялась на Оформить заказ")
    public void loginWithEnterButtonOnOnForgetPasswordPageThroughPersonalAccountButtonTest() {
        driver.get(BASE_URL);
        mainPage.clickPersonalAccountButton();
        loginPage.clickOnResetPasswordButton();
        forgetPasswordPage.clickEnterButtonOnForgetPasswordPage();
        loginPage.fillEmailField(email);
        loginPage.fillPasswordField(password);
        loginPage.clickOnEnterButton();
        String actualText = mainPage.getCreateOrderButtonText();
        mainPage.compareCreateOrderButtonText(CREATE_ORDER_BUTTON_TEXT, actualText);
    }

    @Test
    @Step("Авторизация через нажатие кнопки Войти на странице Восстановления пароля, " +
            "на которую заходим через флоу Войти в аккаунт->Восстановить пароль")
    @Description("Успешная авторизация, автоматический переход на стартовую страницу," +
            "кнопка Войти в аккаунт поменялась на Оформить заказ")
    public void loginWithEnterButtonOnOnForgetPasswordPageThroughLoginButtonTest() {
        driver.get(BASE_URL);
        mainPage.clickLoginButton();
        loginPage.clickOnResetPasswordButton();
        forgetPasswordPage.clickEnterButtonOnForgetPasswordPage();
        loginPage.fillEmailField(email);
        loginPage.fillPasswordField(password);
        loginPage.clickOnEnterButton();
        String actualText = mainPage.getCreateOrderButtonText();
        mainPage.compareCreateOrderButtonText(CREATE_ORDER_BUTTON_TEXT, actualText);
    }

    @After
    @Step("Удаление пользователя и закрытие браузера")
    public void tearDown() {
        if (accessToken != null && !accessToken.isEmpty()) {
            userSteps.deleteUser(accessToken);
        }
        if (driver != null) {
            driver.quit();
        }
    }
}

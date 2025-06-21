import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.page.objects.MainPage;

import java.time.Duration;

import static ru.yandex.praktikum.Statics.BASE_URL;

@Feature("Группа тестов для проверки переключения между разделами конструктора")
@DisplayName("Конструктор заказа")
public class ConstructorTest {
    private WebDriver driver;
    private MainPage mainPage;

    @Before
    @Step("Создаем драйвер в зависимости от выбранного браузера")
    public void setUp() {
        String browser = System.getProperty("browser", "chrome");
        driver = DriverFactory.getDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        mainPage = new MainPage(driver);
    }

    @Test
    @Step("Переход по клику в раздел Соусы из начального положения")
    @Description("Раздел Соусы активен")
    public void changeToSauceWithClickTest() {
        driver.get(BASE_URL);
        mainPage.clickOnSauceButton();
        mainPage.waitSauceOnAir();
    }

    @Test
    @Step("Переход по клику в раздел Начинки из начального положения")
    @Description("Раздел Начинки активен")
    public void changeToFillWithClickTest() {
        driver.get(BASE_URL);
        mainPage.clickOnFillButton();
        mainPage.waitFillOnAir();
    }

    @Test
    @Step("Переход по клику в раздел Булки, предварительно переходим в раздел Начинки из начального положения")
    @Description("Раздел Булки активен")
    public void changeToBunWithClickTest() {
        driver.get(BASE_URL);

        mainPage.clickOnFillButton();
        mainPage.clickOnBunButton();
        mainPage.waitBunOnAir();
    }

    @Test
    @Step("Переход скроллом в раздел Соусы из начального положения")
    @Description("Раздел Соусы активен")
    public void changeToSauceWithScrollTest() {
        driver.get(BASE_URL);
        mainPage.scrollToSauce();
        mainPage.waitSauceOnAir();
    }

    @Test
    @Step("Переход скроллом в раздел Начинки из начального положения")
    @Description("Раздел Начинки активен")
    public void changeToFillWithScrollTest() {
        driver.get(BASE_URL);
        mainPage.scrollToFill();
        mainPage.waitFillOnAir();
    }

    @Test
    @Step("Переход скроллом в раздел Булки, предварительно переходим в раздел Начинки из начального положения")
    @Description("Раздел Булки активен")
    public void changeToBunWithScrollTest() {
        driver.get(BASE_URL);
        mainPage.scrollToFill();
        mainPage.scrollToBun();
        mainPage.waitBunOnAir();
    }

    @After
    @Step("Закрываем браузер")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

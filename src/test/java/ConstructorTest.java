import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.PageObjects.MainPage;

import java.time.Duration;

import static ru.yandex.praktikum.Statics.BASE_URL;

@Feature("Группа тестов для проверки переключения между разделами конструктора")
@DisplayName("Конструктор заказа")
public class ConstructorTest {
    private final String browserType = "chrome"; // или "yandex"
    private WebDriver driver;
    private MainPage mainPage;

    @Before
    @Step("Создаем драйвер в зависимости от выбранного браузера")
    public void setUp() {
        driver = DriverFactory.getDriver(browserType);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        mainPage = new MainPage(driver);
    }

    @Test
    @Step("Переход по клику в раздел Соусы из начального положения")
    @Description("Раздел Соусы активен")
    public void ChangeToSauceWithClickTest() throws InterruptedException {
        driver.get(BASE_URL);
        Thread.sleep(3000);
        mainPage.clickOnSauceButton();
        Thread.sleep(3000);
        mainPage.waitSauceOnAir();
    }

    @Test
    @Step("Переход по клику в раздел Начинки из начального положения")
    @Description("Раздел Начинки активен")
    public void ChangeToFillWithClickTest() throws InterruptedException {
        driver.get(BASE_URL);
        Thread.sleep(3000);
        mainPage.clickOnFillButton();
        Thread.sleep(3000);
        mainPage.waitFillOnAir();
    }

    @Test
    @Step("Переход по клику в раздел Булки, предварительно переходим в раздел Начинки из начального положения")
    @Description("Раздел Булки активен")
    public void ChangeToBunWithClickTest() throws InterruptedException {
        driver.get(BASE_URL);
        Thread.sleep(3000);
        mainPage.clickOnFillButton();
        Thread.sleep(3000);
        mainPage.clickOnBunButton();
        Thread.sleep(3000);
        mainPage.waitBunOnAir();
    }

    @Test
    @Step("Переход скроллом в раздел Соусы из начального положения")
    @Description("Раздел Соусы активен")
    public void ChangeToSauceWithScrollTest() throws InterruptedException {
        driver.get(BASE_URL);
        Thread.sleep(3000);
        mainPage.scrollToSauce();
        Thread.sleep(3000);
        mainPage.waitSauceOnAir();
    }

    @Test
    @Step("Переход скроллом в раздел Начинки из начального положения")
    @Description("Раздел Начинки активен")
    public void ChangeToFillWithScrollTest() throws InterruptedException {
        driver.get(BASE_URL);
        Thread.sleep(3000);
        mainPage.scrollToFill();
        Thread.sleep(3000);
        mainPage.waitFillOnAir();
    }

    @Test
    @Step("Переход скроллом в раздел Булки, предварительно переходим в раздел Начинки из начального положения")
    @Description("Раздел Булки активен")
    public void ChangeToBunWithScrollTest() throws InterruptedException {
        driver.get(BASE_URL);
        mainPage.scrollToFill();
        Thread.sleep(3000);
        mainPage.scrollToBun();
        Thread.sleep(3000);
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

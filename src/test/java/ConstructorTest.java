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

import static ru.yandex.praktikum.Statics.*;

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
    @DisplayName("Переход по клику в раздел Соусы из начального положения")
    @Description("Раздел Соусы активен")
    public void changeToSauceWithClickTest() {
        driver.get(BASE_URL);
        mainPage.clickOnSauceButton();
        mainPage.waitSauceOnAir();
        boolean isDisplayed = mainPage.isSaucePartDisplayed();
        assert isDisplayed : "Раздел 'Соусы' не отображается";
        mainPage.verifyActiveSaucePart(EXPECTED_ON_AIR_CONSTRUCTOR_CLASS_NAME, SAUCE_PART_TEXT);
    }

    @Test
    @DisplayName("Переход по клику в раздел Начинки из начального положения")
    @Description("Раздел Начинки активен")
    public void changeToFillWithClickTest() {
        driver.get(BASE_URL);
        mainPage.clickOnFillButton();
        mainPage.waitFillOnAir();
        boolean isDisplayed = mainPage.isFillPartDisplayed();
        assert isDisplayed : "Раздел 'Начинки' не отображается";
        mainPage.verifyActiveFillPart(EXPECTED_ON_AIR_CONSTRUCTOR_CLASS_NAME, FILL_PART_TEXT);
    }

    @Test
    @DisplayName("Переход по клику в раздел Булки, предварительно переходим в раздел Начинки из начального положения")
    @Description("Раздел Булки активен")
    public void changeToBunWithClickTest() {
        driver.get(BASE_URL);
        mainPage.clickOnFillButton();
        mainPage.clickOnBunButton();
        mainPage.waitBunOnAir();
        boolean isDisplayed = mainPage.isBunPartDisplayed();
        assert isDisplayed : "Раздел 'Булки' не отображается";
        mainPage.verifyActiveBunTab(EXPECTED_ON_AIR_CONSTRUCTOR_CLASS_NAME, BUN_PART_TEXT);
    }

    @Test
    @DisplayName("Переход скроллом в раздел Соусы из начального положения")
    @Description("Раздел Соусы активен")
    public void changeToSauceWithScrollTest() {
        driver.get(BASE_URL);
        mainPage.scrollToSauce();
        mainPage.waitSauceOnAir();
        boolean isDisplayed = mainPage.isSaucePartDisplayed();
        assert isDisplayed : "Раздел 'Соусы' не отображается";
        mainPage.verifyActiveSaucePart(EXPECTED_ON_AIR_CONSTRUCTOR_CLASS_NAME, SAUCE_PART_TEXT);
    }

    @Test
    @DisplayName("Переход скроллом в раздел Начинки из начального положения")
    @Description("Раздел Начинки активен")
    public void changeToFillWithScrollTest() {
        driver.get(BASE_URL);
        mainPage.scrollToFill();
        mainPage.waitFillOnAir();
        boolean isDisplayed = mainPage.isFillPartDisplayed();
        assert isDisplayed : "Раздел 'Начинки' не отображается";
        mainPage.verifyActiveFillPart(EXPECTED_ON_AIR_CONSTRUCTOR_CLASS_NAME, FILL_PART_TEXT);
    }

    @Test
    @DisplayName("Переход скроллом в раздел Булки, предварительно переходим в раздел Начинки из начального положения")
    @Description("Раздел Булки активен")
    public void changeToBunWithScrollTest() {
        driver.get(BASE_URL);
        mainPage.scrollToFill();
        mainPage.scrollToBun();
        mainPage.waitBunOnAir();
        boolean isDisplayed = mainPage.isBunPartDisplayed();
        assert isDisplayed : "Раздел 'Булки' не отображается";
        mainPage.verifyActiveBunTab(EXPECTED_ON_AIR_CONSTRUCTOR_CLASS_NAME, BUN_PART_TEXT);
    }

    @After
    @Step("Закрываем браузер")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
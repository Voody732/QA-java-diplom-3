import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
    public static WebDriver getDriver(String browserName) {
        switch (browserName.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case "yandex":
                WebDriverManager.chromedriver()
                        .driverVersion("134.0.6998.0") // твой Chromium из Яндекса
                        .setup();
                ChromeOptions options = new ChromeOptions();
                String yandexPath = System.getProperty("yandex.browser.path", "C:\\Users\\Артемий\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
                options.setBinary(yandexPath);
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                return new ChromeDriver(options);
            default:
                throw new IllegalArgumentException("Неизвестный браузер: " + browserName);
        }
    }

//    private static String getBrowserType() {
//        // Попытка получить из системных свойств
//        String browserType = System.getProperty("browser.type");
//        if (browserType != null && !browserType.isEmpty()) {
//            return browserType;
//        }
//        // Попытка получить из переменных окружения
//        browserType = System.getenv("BROWSER_TYPE");
//        if (browserType != null && !browserType.isEmpty()) {
//            return browserType;
//        }
//        // Значение по умолчанию
//        return "chrome";
//    }

//    public static WebDriver getDriver() {
//        String browserType = getBrowserType();
//        switch (browserType.toLowerCase()) {
//            case "chrome":
//                WebDriverManager.chromedriver().setup();
//                return new ChromeDriver();
//            case "yandex":
//                WebDriverManager.chromedriver()
//                        .driverVersion("134.0.6998.0") // твой Chromium из Яндекса
//                        .setup();
//                ChromeOptions options = new ChromeOptions();
//                String yandexPath = System.getProperty("yandex.browser.path",
//                        "C:\\Users\\Артемий\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
//                options.setBinary(yandexPath);
//                options.addArguments("--no-sandbox");
//                options.addArguments("--disable-dev-shm-usage");
//                return new ChromeDriver(options);
//            default:
//                throw new IllegalArgumentException("Поддерживаемые браузеры: chrome, yandex");
//        }
//    }
}
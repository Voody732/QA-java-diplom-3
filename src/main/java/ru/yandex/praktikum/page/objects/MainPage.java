package ru.yandex.praktikum.page.objects;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private final By loginButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By personalAccountButton = By.xpath(".//p[text()='Личный Кабинет']");
    private final By createOrderButton = By.xpath(".//button[text()='Оформить заказ']");
    private final By bunButton = By.xpath(".//span[text()='Булки']");
    private final By fillButton = By.xpath(".//span[text()='Начинки']");
    private final By sauceButton = By.xpath(".//span[text()='Соусы']");
    private final By sauceOnAir = By.xpath("//div[contains(@class, 'tab_tab_type_current') and span[text()='Соусы']]");
    private final By fillOnAir = By.xpath("//div[contains(@class, 'tab_tab_type_current') and span[text()='Начинки']]");
    private final By bunOnAir = By.xpath("//div[contains(@class, 'tab_tab_type_current') and span[text()='Булки']]");
    private final By toSauce = By.xpath(".//h2[text()='Соусы']");
    private final By toFill = By.xpath(".//h2[text()='Начинки']");
    private final By toBun = By.xpath(".//h2[text()='Булки']");

    private final WebDriver driver;
    private final WebDriverWait wait;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    @Step("Нажатие на кнопку Войти в аккаунт на главной странице")
    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    @Step("Нажатие на кнопку Личный кабинет на главной странице")
    public void clickPersonalAccountButton() {
        wait.until(ExpectedConditions.elementToBeClickable(personalAccountButton)).click();
    }

    @Step("Извлечение текста из кнопки Оформить заказ")
    public String getCreateOrderButtonText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(createOrderButton)).getText();
    }

    @Step("Нажатие на кнопку Булки на главной странице")
    public void clickOnBunButton() {
        wait.until(ExpectedConditions.elementToBeClickable(bunButton)).click();
    }

    @Step("Нажатие на кнопку Начинки на главной странице")
    public void clickOnFillButton() {
        wait.until(ExpectedConditions.elementToBeClickable(fillButton)).click();
    }

    @Step("Нажатие на кнопку Соусы на главной странице")
    public void clickOnSauceButton() {
        wait.until(ExpectedConditions.elementToBeClickable(sauceButton)).click();
    }

    @Step("Сравнение текста кнопки Оформить заказ и полученного текста из появившейся кнопки")
    public void compareCreateOrderButtonText(String expected, String actual) {
        Assert.assertEquals("Неверный текст на кнопке", expected, actual);
    }

    @Step("Ожидание, что раздел в конструкторе перешел на Соусы")
    public void waitSauceOnAir() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(sauceOnAir));
        System.out.println();
    }

    @Step("Ожидание, что раздел в конструкторе перешел на Начинки")
    public void waitFillOnAir() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(fillOnAir));
    }

    @Step("Ожидание, что раздел в конструкторе перешел на Булки")
    public void waitBunOnAir() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(bunOnAir));
    }

    @Step("Скроллим до раздела Соусы")
    public void scrollToSauce() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(toSauce));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    @Step("Скроллим до раздела Начинки")
    public void scrollToFill() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(toFill));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    @Step("Скроллим до раздела Булки")
    public void scrollToBun() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(toBun));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    @Step("Получить название класса активного раздела 'Соусы'")
    public String getClassNameSauce() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(sauceOnAir));
        return element.getAttribute("class");
    }

    @Step("Получить текст активного раздела 'Соусы'")
    public String getTextSauce() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(sauceOnAir));
        return element.getText();
    }

    @Step("Проверка, что раздел 'Соусы' отображается на странице")
    public boolean isSaucePartDisplayed() {
        try {
            WebElement sauceSection = wait.until(ExpectedConditions.visibilityOfElementLocated(sauceButton));
            return sauceSection.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    @Step("Проверка, что активный раздел 'Соусы' имеет правильный класс и текст")
    public void verifyActiveSaucePart(String expectedClassName, String expectedText) {
        String actualClass = getClassNameSauce();
        String actualText = getTextSauce();
        Assert.assertTrue("Неверное имя класса", actualClass.contains(expectedClassName));
        Assert.assertEquals("Неверный текст", expectedText, actualText);
    }

    @Step("Получить название класса активного раздела 'Начинки'")
    public String getClassNameFill() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(fillOnAir));
        return element.getAttribute("class");
    }

    @Step("Получить текст активного раздела 'Начинки'")
    public String getTextFill() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(fillOnAir));
        return element.getText();
    }

    @Step("Проверка, что активный раздел 'Начинки' имеет правильный класс и текст")
    public void verifyActiveFillPart(String expectedClassSubstring, String expectedText) {
        String actualClass = getClassNameFill();
        String actualText = getTextFill();

        Assert.assertTrue("Неверное имя класса", actualClass.contains(expectedClassSubstring));
        Assert.assertEquals("Неверное текст",
                expectedText, actualText);
    }

    @Step("Проверка, что раздел 'Начинки' отображается на странице")
    public boolean isFillPartDisplayed() {
        try {
            WebElement sauceSection = wait.until(ExpectedConditions.visibilityOfElementLocated(fillButton));
            return sauceSection.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }


    @Step("Получить название класса активного раздела 'Булки'")
    public String getClassNameBun() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(bunOnAir));
        return element.getAttribute("class");
    }

    @Step("Получить текст активного раздела 'Булки'")
    public String getTextBun() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(bunOnAir));
        return element.getText();
    }

    @Step("Проверка, что активный раздел 'Булки' имеет правильный класс и текст")
    public void verifyActiveBunTab(String expectedClassSubstring, String expectedText) {
        String actualClass = getClassNameBun();
        String actualText = getTextBun();

        Assert.assertTrue("Неверное имя класса",
                actualClass.contains(expectedClassSubstring));
        Assert.assertEquals("Неверный текст",
                expectedText, actualText);
    }

    @Step("Проверка, что раздел 'Булки' отображается на странице")
    public boolean isBunPartDisplayed() {
        try {
            WebElement sauceSection = wait.until(ExpectedConditions.visibilityOfElementLocated(bunButton));
            return sauceSection.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }



}
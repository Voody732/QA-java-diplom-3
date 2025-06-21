package ru.yandex.praktikum.page.objects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    private final By sauceOnAir = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Соусы']");
    private final By fillOnAir = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Начинки']");
    private final By bunOnAir = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Булки']");
    private final By toSauce = By.xpath(".//h2[text()='Соусы']");
    private final By toFill = By.xpath(".//h2[text()='Начинки']");
    private final By toBun = By.xpath(".//h2[text()='Булки']");

    private final WebDriver driver;
    private final WebDriverWait wait;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    public void clickPersonalAccountButton() {
        wait.until(ExpectedConditions.elementToBeClickable(personalAccountButton)).click();
    }

    public String getCreateOrderButtonText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(createOrderButton)).getText();
    }

    public void clickOnBunButton() {
        wait.until(ExpectedConditions.elementToBeClickable(bunButton)).click();
    }

    public void clickOnFillButton() {
        wait.until(ExpectedConditions.elementToBeClickable(fillButton)).click();
    }

    public void clickOnSauceButton() {
        wait.until(ExpectedConditions.elementToBeClickable(sauceButton)).click();
    }

    public void compareCreateOrderButtonText(String expected, String actual) {
        Assert.assertEquals("Неверный текст на кнопке", expected, actual);
    }

    public void waitSauceOnAir() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(sauceOnAir));
    }

    public void waitFillOnAir() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(fillOnAir));
    }

    public void waitBunOnAir() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(bunOnAir));
    }

    public void scrollToSauce() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(toSauce));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void scrollToFill() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(toFill));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void scrollToBun() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(toBun));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }
}
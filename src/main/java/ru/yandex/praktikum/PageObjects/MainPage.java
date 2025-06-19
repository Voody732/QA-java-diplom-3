package ru.yandex.praktikum.PageObjects;

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

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void clickPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
    }

    public String getCreateOrderButtonText() {
        return driver.findElement(createOrderButton).getText();
    }

    public void clickOnBunButton() {
        driver.findElement(bunButton).click();
    }

    public void clickOnFillButton() {
        driver.findElement(fillButton).click();
    }

    public void clickOnSauceButton() {
        driver.findElement(sauceButton).click();
    }

    public void compareCreateOrderButtonText(String expectedCreateOrderButton, String actualCreateOrderButton) {
        Assert.assertEquals("Неверный текст на кнопке", expectedCreateOrderButton, actualCreateOrderButton);
    }

    public void waitSauceOnAir() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(sauceOnAir));
    }

    public void waitFillOnAir() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(fillOnAir));
    }

    public void waitBunOnAir() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(bunOnAir));
    }

    public void scrollToSauce(){
        WebElement element = driver.findElement(toSauce);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void scrollToFill(){
        WebElement element = driver.findElement(toFill);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    public void scrollToBun(){
        WebElement element = driver.findElement(toBun);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }
}
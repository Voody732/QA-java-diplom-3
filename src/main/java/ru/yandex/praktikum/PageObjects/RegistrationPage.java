package ru.yandex.praktikum.PageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private final WebDriver driver;
    private final By nameField = By.xpath(".//label[text()='Имя']/../input");
    private final By emailField = By.xpath(".//label[text()='Email']/../input");
    private final By passwordField = By.xpath(".//label[text()='Пароль']/../input");
    private final By registrationButton = By.xpath("//button[text()='Зарегистрироваться']");
    private final By enterButtonOnRegistrationPage = By.xpath(".//a[text()='Войти']");
    private final By incorrectPasswordAlert = By.xpath(".//p[text()='Некорректный пароль']");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void compareAlertText(String expectedTextAlert, String actualTextOfAlert) {
        Assert.assertEquals("Неверный текст ошибки", expectedTextAlert, actualTextOfAlert);
    }

    public void enterName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickRegisterButton() {
        driver.findElement(registrationButton).click();
    }

    public void clickEnterButtonOnRegistrationPage() {
        driver.findElement(enterButtonOnRegistrationPage).click();
    }

    public String getIncorrectPasswordAlert() {
        return driver.findElement(incorrectPasswordAlert).getText();
    }
}
package ru.yandex.praktikum.page.objects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By nameField = By.xpath(".//label[text()='Имя']/../input");
    private final By emailField = By.xpath(".//label[text()='Email']/../input");
    private final By passwordField = By.xpath(".//label[text()='Пароль']/../input");
    private final By registrationButton = By.xpath("//button[text()='Зарегистрироваться']");
    private final By enterButtonOnRegistrationPage = By.xpath(".//a[text()='Войти']");
    private final By incorrectPasswordAlert = By.xpath(".//p[text()='Некорректный пароль']");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public void compareAlertText(String expectedTextAlert, String actualTextOfAlert) {
        Assert.assertEquals("Неверный текст ошибки", expectedTextAlert, actualTextOfAlert);
    }

    public void enterName(String name) {
        WebElement nameInput = wait.until(ExpectedConditions.elementToBeClickable(nameField));
        nameInput.clear();
        nameInput.sendKeys(name);
    }

    public void enterEmail(String email) {
        WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(emailField));
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordInput = wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickRegisterButton() {
        WebElement registerBtn = wait.until(ExpectedConditions.elementToBeClickable(registrationButton));
        registerBtn.click();
    }

    public void clickEnterButtonOnRegistrationPage() {
        WebElement enterBtn = wait.until(ExpectedConditions.elementToBeClickable(enterButtonOnRegistrationPage));
        enterBtn.click();
    }

    public String getIncorrectPasswordAlert() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(incorrectPasswordAlert)).getText();
    }
}
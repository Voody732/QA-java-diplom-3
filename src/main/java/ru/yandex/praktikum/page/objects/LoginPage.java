package ru.yandex.praktikum.page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final By RegistrationButton = By.xpath("//a[text()='Зарегистрироваться']");
    private final By emailField = By.xpath(".//input[@name='name']");
    private final By passwordField = By.xpath(".//input[@name='Пароль']");
    private final By enterButton = By.xpath(".//button[text()='Войти']");
    private final By resetPasswordButton = By.xpath(".//a[text()='Восстановить пароль']");
    private final WebDriver driver;
    private final WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public void clickRegistrationButton() {
        wait.until(ExpectedConditions.elementToBeClickable(RegistrationButton)).click();
    }

    public void fillEmailField(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
    }

    public void fillPasswordField(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
    }

    public void clickOnEnterButton() {
        wait.until(ExpectedConditions.elementToBeClickable(enterButton)).click();
    }

    public void clickOnResetPasswordButton() {
        wait.until(ExpectedConditions.elementToBeClickable(resetPasswordButton)).click();
    }
}
package ru.yandex.praktikum.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final By RegistrationButton = By.xpath("//a[text()='Зарегистрироваться']");
    private final By emailField = By.xpath(".//input[@name='name']");
    private final By passwordField = By.xpath(".//input[@name='Пароль']");
    private final By enterButton = By.xpath(".//button[text()='Войти']");
    private final By resetPasswordButton = By.xpath(".//a[text()='Восстановить пароль']");
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickRegistrationButton() {
        driver.findElement(RegistrationButton).click();
    }

    public void fillEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void fillPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickOnEnterButton() {
        driver.findElement(enterButton).click();
    }

    public void clickOnResetPasswordButton() {
        driver.findElement(resetPasswordButton).click();
    }
}
package ru.yandex.praktikum.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgetPasswordPage {
    private final By enterButtonOnForgetPasswordPage = By.xpath(".//a[text()='Войти']");
    private final WebDriver driver;

    public ForgetPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickEnterButtonOnForgetPasswordPage() {
        driver.findElement(enterButtonOnForgetPasswordPage).click();
    }
}

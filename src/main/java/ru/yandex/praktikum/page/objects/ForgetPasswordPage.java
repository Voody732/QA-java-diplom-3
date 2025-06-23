package ru.yandex.praktikum.page.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ForgetPasswordPage {
    private final By enterButtonOnForgetPasswordPage = By.xpath(".//a[text()='Войти']");
    private final WebDriver driver;
    private final WebDriverWait wait;

    public ForgetPasswordPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }
@Step("Нажатие на кнопку Войти на странице восстановления пароля")
    public void clickEnterButtonOnForgetPasswordPage() {
        wait.until(ExpectedConditions.elementToBeClickable(enterButtonOnForgetPasswordPage));
        driver.findElement(enterButtonOnForgetPasswordPage).click();
    }
}
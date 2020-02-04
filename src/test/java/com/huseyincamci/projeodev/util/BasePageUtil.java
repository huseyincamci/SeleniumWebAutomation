package com.huseyincamci.projeodev.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageUtil {

    public WebDriver driver;

    public BasePageUtil(WebDriver driver){
        this.driver = driver;
    }

    public void clickElement(By selector) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(selector)).click();
    }

    public void setText(By selector, String text) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(selector)).sendKeys(text);
    }

    public String getText(By selector) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(selector)).getText();
    }

    public boolean isElementDisplayed(By selector) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(selector)).isDisplayed();
    }



}

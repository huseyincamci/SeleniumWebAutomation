package com.huseyincamci.projeodev.page;

import com.huseyincamci.projeodev.util.BasePageUtil;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class SearchProductPage extends BasePageUtil {
    protected final By page2 = By.xpath("/html/body/div[1]/div[2]/div/div/div[2]/div[4]/a[2]");

    public SearchProductPage(WebDriver driver) {
        super(driver);
    }

    public SearchProductPage goSecondPage() {
        clickElement(page2);
        return new SearchProductPage(driver);
    }


    public void validateCurrentPage(){
        Assert.assertEquals("2", currentPage());
    }

    public String currentPage() {
        WebElement currentPage = driver.findElement(By.id("currentPage"));
        return currentPage.getAttribute("value");
    }

    public ProductPage clickRandomProduct() {
        By listView = By.className("listView");

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(listView));

        List<WebElement> els = driver.findElements(By.className("columnContent"));

        int random = new Random().nextInt(els.size());

        WebElement el = els.get(random);
        WebElement link = el.findElement(By.className("plink"));
        wait.until(ExpectedConditions.elementToBeClickable(link)).click();

        return new ProductPage(driver);
    }
}

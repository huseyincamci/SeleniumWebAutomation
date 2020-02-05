package com.huseyincamci.projeodev.page;

import com.huseyincamci.projeodev.util.BasePageUtil;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePageUtil {
    protected final By linkGirisYap = By.className("btnSignIn");
    protected final By searchBox = By.id("searchData");
    protected final By searchBtn = By.className("searchBtn");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage callLoginPage() {
        clickElement(linkGirisYap);

        return new LoginPage(driver);
    }

    public void validateHomePage() {
        Assert.assertEquals(getTitle(), "n11.com - Alışverişin Uğurlu Adresi");
    }


    public String getTitle() {
        return driver.getTitle();
    }

    public SearchProductPage search(String productName) {
        setText(searchBox, productName);
        clickElement(searchBtn);
        return new SearchProductPage(driver);
    }
}

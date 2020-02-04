package com.huseyincamci.projeodev.page;

import com.huseyincamci.projeodev.util.BasePageUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePageUtil {

    protected final By linkGirisYap = By.className("btnSignIn");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage callLoginPage() {
        clickElement(linkGirisYap);

        return new LoginPage(driver);
    }

    public String getTitle() {
        return  driver.getTitle();
    }
}

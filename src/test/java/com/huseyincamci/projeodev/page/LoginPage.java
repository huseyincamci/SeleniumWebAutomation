package com.huseyincamci.projeodev.page;

import com.huseyincamci.projeodev.util.BasePageUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePageUtil {
    protected final By usernameField = By.id("email");
    protected final By passwordField = By.id("password");
    protected final By buttonSignIn = By.id("loginButton");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public HomePage login(String email, String password) {
        setText(usernameField, email);
        setText(passwordField, password);
        clickElement(buttonSignIn);
        return new HomePage(driver);
    }
}

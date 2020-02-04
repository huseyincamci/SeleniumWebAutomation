package com.huseyincamci.projeodev.tests;

import com.huseyincamci.projeodev.page.HomePage;
import org.junit.Test;

public class LoginTest extends BaseTest {
    @Test
    public void loginTest() {
        new HomePage(getDriver()).callLoginPage().login("", "");
    }

}

package com.huseyincamci.projeodev.tests;

import com.huseyincamci.projeodev.driver.LocalDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;
    String APP_URL = "https://www.n11.com";

    @Before
    public void initializeDriver() {
        driver = LocalDriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(APP_URL);
    }

    public WebDriver getDriver() {
        return driver;
    }

    @After
    public void closeDriver() {
        driver.quit();
    }
}

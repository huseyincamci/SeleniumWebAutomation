package com.huseyincamci.projeodev.driver;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {

    public static WebDriver getDriver() {

        String browser = System.getenv("BROWSER");
        browser = (browser == null) ? "CHROME" : browser;

        if ("IE".equals(browser)) {
            InternetExplorerDriverManager.getInstance(DriverManagerType.IEXPLORER).setup();
            return new InternetExplorerDriver();
        } else if ("FIREFOX".equals(browser)) {
            FirefoxDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
            return new FirefoxDriver();
        }
        ChromeDriverManager.getInstance(DriverManagerType.CHROME).arch32();
        ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();

        ChromeOptions options = new ChromeOptions();
        if ("Y".equalsIgnoreCase(System.getenv("HEADLESS"))) {
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            options.addArguments("disable-popup-blocking");
            options.addArguments("ignore-certificate-errors");
            options.addArguments("disable-translate");
            options.addArguments("--disable-notifications");
        }

        return new ChromeDriver(options);
    }
}

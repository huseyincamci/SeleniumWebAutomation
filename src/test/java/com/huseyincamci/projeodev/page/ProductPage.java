package com.huseyincamci.projeodev.page;

import com.huseyincamci.projeodev.util.BasePageUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends BasePageUtil {
    protected final By btnAddBasket = By.className("btnAddBasket");
    protected final By myBasket = By.className("myBasket");
    protected final By productCount = By.xpath("/html/body/div[1]/header/div/div/div[2]/div[2]/div[4]/a/span");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public String getProductPrice() {
        By newPrice = By.xpath("/html/body/div[1]/div[2]/div/div[3]/div[2]/div[3]/div[2]/div/div[1]/div/ins");
        String price = driver.findElement(newPrice).getText().split(" ")[0];
        return price;
    }

    public ProductPage addBasket() {
        clickElement(btnAddBasket);
        return this;
    }

    public BasketPage goBasketPage() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(productCount));

        BasketPage basketPage = new BasketPage(driver);
        basketPage.priceInProductPage = getProductPrice();

        clickElement(myBasket);
        return basketPage;
    }
}

package com.huseyincamci.projeodev.page;

import com.huseyincamci.projeodev.util.BasePageUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePageUtil {
    protected final By btnAddBasket = By.className("btnAddBasket");
    protected final By myBasket = By.className("myBasket");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public String getProductPrice() {
        By newPrice = By.xpath("/html/body/div[1]/div[2]/div/div[3]/div[2]/div[3]/div[2]/div/div[1]/div/ins");
        String price = driver.findElement(newPrice).getText().split(" ")[0];
        return price;
    }

    public BasketPage addBasket() {
        clickElement(btnAddBasket);
        return new BasketPage(driver);
    }

    public BasketPage callBasketPage() {
        clickElement(myBasket);
        return new BasketPage(driver);
    }
}

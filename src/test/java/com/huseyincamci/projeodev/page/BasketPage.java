package com.huseyincamci.projeodev.page;

import com.huseyincamci.projeodev.util.BasePageUtil;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasketPage extends BasePageUtil {
    protected final By productPrice = By.xpath("/html/body/div[1]/div/div/div[1]/div[2]/div[1]/section/table[2]/tbody/tr/td[3]/div[2]/div/span");
    protected final By spinnerUp = By.xpath("/html/body/div[1]/div/div/div[1]/div[2]/div[1]/section/table[2]/tbody/tr/td[3]/div[1]/div/span[1] ");
    protected final By quantity = By.className("quantity");
    protected final By removeBtn = By.className("svgIcon_trash");
    protected final By title = By.xpath("/html/body/div[1]/div[2]/div/div[1]/div[1]/h2");

    protected String priceInProductPage;

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public String getProductPrice() {
        return getText(productPrice).split(" ")[0];
    }

    public BasketPage addQuantity() {
        clickElement(spinnerUp);
        return this;
    }

    public String getProductQuantity() {
        WebElement quantityInput = driver.findElement(quantity);
        return quantityInput.getAttribute("value");
    }

    public BasketPage removeProduct() {
        clickElement(removeBtn);
        return this;
    }

    public BasketPage validateProductPrice() {
        Assert.assertEquals(priceInProductPage, getProductPrice());
        return this;
    }

    public BasketPage validateQuantity(){

        int quantity = Integer.parseInt(this.getProductQuantity());
        Assert.assertEquals(2, quantity);
        return this;
    }

    public void validateEmptyBasket() {
        Assert.assertEquals("Sepetiniz Boş", this.getEmptyText());
    }

    public String getEmptyText() {
        return getText(title);
    }
}

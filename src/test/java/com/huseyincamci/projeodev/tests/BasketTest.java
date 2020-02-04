package com.huseyincamci.projeodev.tests;

import com.huseyincamci.projeodev.page.BasketPage;
import com.huseyincamci.projeodev.page.ProductPage;
import com.huseyincamci.projeodev.page.SearchProductPage;
import org.junit.Assert;
import org.junit.Test;

public class BasketTest extends BaseTest {

    //Ürün sayfasındaki ürün fiyatı ile sepetteki ürün fiyatını karşılaştırır.
    @Test
    public void isEqualsPriceInProductPageAndBasketPage() {

        ProductPage page = new SearchProductPage(getDriver()).search("bilgisayar")
                .getSecondPage().clickRandomProduct();
        String priceInProductPage = page.getProductPrice();
        page.addBasket();
        String priceInBasketPage = page.callBasketPage().getProductPrice();
        Assert.assertEquals(priceInProductPage, priceInBasketPage);
    }

    //Ürün adedi arttırıldıktan sonra 2'ye eşit olup olmadığını kontrol et
    @Test
    public void isEqualsQuantity() {

        ProductPage page = new SearchProductPage(getDriver()).search("bilgisayar")
                .getSecondPage().clickRandomProduct();
        page.addBasket();
        BasketPage basketPage = page.callBasketPage();
        basketPage.addQuantity();
        int quantity = Integer.parseInt(basketPage.getProductQuantity());
        Assert.assertEquals(2, quantity);
    }

    //Sepetin boş olup olmadığını test et
    @Test
    public void isBasketEmpty() {
        ProductPage page = new SearchProductPage(getDriver()).search("bilgisayar")
                .getSecondPage().clickRandomProduct();
        page.addBasket();
        BasketPage basketPage = page.callBasketPage();
        basketPage.removeProduct();
        Assert.assertEquals("Sepetiniz Boş", basketPage.getEmptyText());
    }
}

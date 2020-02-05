package com.huseyincamci.projeodev.tests;

import com.huseyincamci.projeodev.page.HomePage;
import com.huseyincamci.projeodev.page.SearchProductPage;
import org.junit.Test;

public class ShoppingTest  extends BaseTest {

    @Test
    public void shoppingTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.validateHomePage();

        homePage.callLoginPage().login("testeraut0mation33@gmail.com", "Password123!")
        .search("bilgisayar").goSecondPage().validateCurrentPage();

        SearchProductPage productPage = new SearchProductPage(getDriver());
        productPage.clickRandomProduct().addBasket().goBasketPage()
                .validateProductPrice().addQuantity().validateQuantity()
                .removeProduct().validateEmptyBasket();

    }
}

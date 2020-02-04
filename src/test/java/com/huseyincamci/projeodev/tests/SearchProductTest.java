package com.huseyincamci.projeodev.tests;

import com.huseyincamci.projeodev.page.SearchProductPage;
import org.junit.Assert;
import org.junit.Test;

public class SearchProductTest extends BaseTest{

    //2. sayfanın açılıp açılmadığını kontrol et
    @Test
    public void isSecondPage(){
        String currentPage = new SearchProductPage(getDriver()).search("bilgisayar").getSecondPage().currentPage();
        Assert.assertEquals(2, Integer.parseInt(currentPage));
    }
}

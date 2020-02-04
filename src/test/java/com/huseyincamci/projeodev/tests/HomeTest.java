package com.huseyincamci.projeodev.tests;

import com.huseyincamci.projeodev.page.HomePage;
import org.junit.Assert;
import org.junit.Test;

public class HomeTest extends BaseTest {

    //Anasayfanın açılıp açılmadığını kontrol et
    @Test
    public void isHomePage(){
        HomePage home = new HomePage(getDriver());
        Assert.assertEquals("n11.com - Alışverişin Uğurlu Adresi", home.getTitle());
    }
}

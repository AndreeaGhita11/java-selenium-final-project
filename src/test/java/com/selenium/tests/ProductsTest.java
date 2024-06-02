package com.selenium.tests;

import org.junit.*;
import com.selenium.testdata.URLs;
import com.selenium.testdata.pages.FilterOptions;

public class ProductsTest extends BaseTest {


    @Test
    public void addProductToTheCart() {
        driver.get(URLs.TEST_ENV);
        loginPage.authenticate(correctUser);
        // add two products to cart
        productsPage.clickToAddOneProductToCart();
        productsPage.clickToAddOneProductToCart();
        // expect 2 products in the cart
        Assert.assertEquals(2, productsPage.getCartItemCount());
    }

    @Test
    public void removeProductToTheeCart() {
        driver.get(URLs.TEST_ENV);
        loginPage.authenticate(correctUser);
        // remove all products from cart in case added by previous test
        productsPage.removeAllProductsFromCart();
        // expect 0 products in the cart
        Assert.assertEquals(0, productsPage.getCartItemCount());

        // add one product to cart
        productsPage.clickToAddOneProductToCart();
        // expect 1 product in the cart
        Assert.assertEquals(1, productsPage.getCartItemCount());
        // remove one product to cart
        productsPage.clickToRemoveOneProductFromCart();
        // shopping cart badge should not be displayed
        Assert.assertEquals(0, productsPage.getCartItemCount());
    }

    @Test
    public void selectFilterOptions() {
        driver.get(URLs.TEST_ENV);
        loginPage.authenticate(correctUser);
        productsPage.selectFilterByIndex(0);
        Assert.assertTrue(productsPage.getActiveOptionName().contains(FilterOptions.FILTER_AZ));
        productsPage.selectFilterByIndex(1);
        Assert.assertTrue(productsPage.getActiveOptionName().contains(FilterOptions.FILTER_ZA));
        productsPage.selectFilterByIndex(2);
        Assert.assertTrue(productsPage.getActiveOptionName().contains(FilterOptions.FILTER_PRICE_LOW_HIGH));
        productsPage.selectFilterByIndex(3);
        Assert.assertTrue(productsPage.getActiveOptionName().contains(FilterOptions.FILTER_PRICE_HIGH_LOW));
    }

    @Test
    public void logoIsDisplayed() {
        driver.get(URLs.TEST_ENV);
        loginPage.authenticate(correctUser);
        Assert.assertTrue(header.appLogoIsDisplayed());
    }
}



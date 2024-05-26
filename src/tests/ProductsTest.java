package tests;

import org.junit.*;
import testdata.URLs;
import testdata.pages.FilterOptions;

public class ProductsTest extends BaseTest {
    @Test
    public void addProductToTheCart() {
        driver.get(URLs.TEST_ENV);
        loginPage.authenticate(correctUser);
        productsPage.addProducts();
        Assert.assertTrue(productsPage.areRemoveButtonsDisplayed());
        Assert.assertTrue(header.appLogoIsDisplayed());
    }

    @Test
    public void removeProductToTheeCart() {
        driver.get(URLs.TEST_ENV);
        loginPage.authenticate(correctUser);
        productsPage.removeProducts();
        Assert.assertFalse(productsPage.shoopingCartBadgeisDisplayed());
        Assert.assertTrue(header.appLogoIsDisplayed());
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
}



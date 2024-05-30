package com.java.tests;

import org.junit.Assert;
import org.junit.Test;
import com.java.testdata.URLs;
import com.java.testdata.pages.ItemCheck;

public class ShoppingCartTests extends BaseTest {
    @Test
    public void itemInShoppingCart() {
        driver.get(URLs.TEST_ENV);
        loginPage.authenticate(correctUser);
        shoppingCartPage.openAProduct();
        Assert.assertTrue(shoppingCartPage.getProductName().contains(ItemCheck.PRODUCT_NAME));
        Assert.assertTrue(shoppingCartPage.getProductPrice().contains(ItemCheck.PRODUCT_PRICE));
        shoppingCartPage.clickShoppingCartButton();
        Assert.assertTrue(shoppingCartPage.getProductDetails().contains(ItemCheck.PRODUCT_DETAILS));
        Assert.assertTrue(shoppingCartPage.getProductPrice().contains(ItemCheck.PRODUCT_PRICE));
        shoppingCartPage.checkoutOrder();
        shoppingCartPage.completeInfo(orderDetailsData);
        Assert.assertTrue(shoppingCartPage.getCheckoutInfo().contains(ItemCheck.CHECKOUT_INFO));
        shoppingCartPage.continueOrder();
        Assert.assertTrue(shoppingCartPage.getCheckoutOV().contains(ItemCheck.CHECKOUT_OV));
        Assert.assertTrue(shoppingCartPage.getShippingInfoText().contains(ItemCheck.SHIPPING_INFO));
        Assert.assertTrue(shoppingCartPage.getProductDetails().contains(ItemCheck.PRODUCT_DETAILS));
        shoppingCartPage.finishOrder();
        Assert.assertTrue(shoppingCartPage.getSuccessTitle().contains(ItemCheck.COMPLETE_ORDER_HEADER));
        Assert.assertTrue(shoppingCartPage.getSuccessText().contains(ItemCheck.COMPLETE_ORDER_TEXT));
    }
}

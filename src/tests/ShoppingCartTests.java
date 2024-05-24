package tests;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LoginPage;
import pages.ProductsPage;
import pages.ShoppingCartPage;
import testdata.URLs;
import testdata.classes.*;
import testdata.pages.ItemCheck;

import java.time.Duration;

public class ShoppingCartTests extends BaseTest {
    @Test
    public void itemInShoppingCart() throws InterruptedException {
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

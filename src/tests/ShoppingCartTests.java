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

public class ShoppingCartTests {
    static WebDriver driver;
    public static LoginPage loginPage;
    public CorrectUser correctUser = new CorrectUser("correctuser");
    public InvalidUserData invalidData = new InvalidUserData("invaliduserdata");
    public MissingUserData missingData = new MissingUserData("missinguserdata");
    public LockedOutUser lockedOutUser = new LockedOutUser("lockedoutuser");
    public OrderDetailsData orderDetailsData = new OrderDetailsData("orderdetailsdata");
    public static ProductsPage productsPage;
    public static ShoppingCartPage shoppingCartPage;

    @BeforeClass
    public static void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");
        System.setProperty("webdriver.chrome.driver", "src/resource/chromedriver.exe");
        driver = new ChromeDriver(chromeOptions);
        //wait implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

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

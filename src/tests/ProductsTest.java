package tests;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import pages.LoginPage;
import pages.ProductsPage;
import testdata.URLs;
import testdata.classes.CorrectUser;
import testdata.classes.InvalidUserData;
import testdata.classes.LockedOutUser;
import testdata.classes.MissingUserData;
import testdata.pages.FilterOptions;

import java.time.Duration;

public class ProductsTest extends BaseTest {
    @Test
    public void addProductToTheCart () {
        driver.get(URLs.TEST_ENV);
        loginPage.authenticate(correctUser);
        productsPage.addProducts();
        Assert.assertTrue(productsPage.areRemoveButtonsDisplayed());
    }
    @Test
    public void removeProductToTheeCart()  {
        driver.get(URLs.TEST_ENV);
        loginPage.authenticate(correctUser);
        productsPage.removeProducts();
        Assert.assertFalse(productsPage.shoopingCartBadgeisDisplayed());
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
    @Test@Ignore
    public void logoutUser() {
        driver.get(URLs.TEST_ENV);
        loginPage.authenticate(correctUser);
        productsPage.addProducts();
        productsPage.logoutUser();
        WebElement loginButton = driver.findElement(By.id("login-button"));
        WebElement loginLogo = driver.findElement(By.xpath("//div[@class='login_container']//div"));
        Assert.assertTrue(loginLogo.isDisplayed());
        Assert.assertTrue(loginButton.isDisplayed());
    }
}



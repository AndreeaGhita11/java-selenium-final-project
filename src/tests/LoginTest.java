package tests;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LoginPage;
import testdata.URLs;
import testdata.classes.CorrectUser;
import testdata.classes.InvalidUserData;
import testdata.classes.LockedOutUser;
import testdata.classes.MissingUserData;
import testdata.pages.LoginErrors;

import java.time.Duration;

public class LoginTest extends BaseTest {
    @Test
    public void loginWithCorrectUser() {
        driver.get(URLs.TEST_ENV);
        loginPage.authenticate(correctUser);
        WebElement shoppingcartButton = driver.findElement(By.id("shopping_cart_container"));
        Assert.assertTrue(shoppingcartButton.isDisplayed());
    }
    @Test
    public void loginWithInvalidData(){
        driver.get(URLs.TEST_ENV);
        loginPage.authenticateInvalidUser(invalidData);
        Assert.assertTrue(loginPage.getError().contains(LoginErrors.INVLALID_DATA));
    }
    @Test
    public void loginWithMissingData() {
        driver.get(URLs.TEST_ENV);
        loginPage.authenticateMissingData(missingData);
        Assert.assertTrue(loginPage.getError().contains(LoginErrors.MISSING_DATA));
    }
    @Test
    public void loginWithLockedOutUser() {
        driver.get(URLs.TEST_ENV);
        loginPage.authenticateLockedOutUser(lockedOutUser);
        Assert.assertTrue(loginPage.getError().contains(LoginErrors.LOCKED_OUT_USER));
    }
}
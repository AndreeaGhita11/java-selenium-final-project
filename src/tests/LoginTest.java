package tests;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import testdata.URLs;
import testdata.pages.LoginErrors;

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
    @Test
    public void logoutUser() {
        driver.get(URLs.TEST_ENV);
        loginPage.authenticate(correctUser);
        loginPage.logoutUser();
        WebElement loginButton = driver.findElement(By.id("login-button"));
        WebElement loginLogo = driver.findElement(By.xpath("//div[@class='login_container']//div"));
        Assert.assertTrue(loginLogo.isDisplayed());
        Assert.assertTrue(loginButton.isDisplayed());
    }
}
package tests;

import org.junit.*;
import testdata.URLs;
import testdata.pages.LoginErrors;

public class LoginTest extends BaseTest {
    @Test
    public void loginWithCorrectUser() {
        driver.get(URLs.TEST_ENV);
        loginPage.authenticate(correctUser);
        Assert.assertTrue(header.appLogoIsDisplayed());
        Assert.assertTrue(loginPage.shoppingCartButtonIsDisplayed());
    }
    @Test
    public void loginWithInvalidData(){
        driver.get(URLs.TEST_ENV);
        loginPage.authenticateInvalidUser(invalidData);
        Assert.assertTrue(loginPage.getError().contains(LoginErrors.INVLALID_DATA));
        Assert.assertTrue(header.loginLogoIsDisplayed());
    }
    @Test
    public void loginWithMissingData() {
        driver.get(URLs.TEST_ENV);
        loginPage.authenticateMissingData(missingData);
        Assert.assertTrue(loginPage.getError().contains(LoginErrors.MISSING_DATA));
        Assert.assertTrue(header.loginLogoIsDisplayed());
    }
    @Test
    public void loginWithLockedOutUser() {
        driver.get(URLs.TEST_ENV);
        loginPage.authenticateLockedOutUser(lockedOutUser);
        Assert.assertTrue(loginPage.getError().contains(LoginErrors.LOCKED_OUT_USER));
        Assert.assertTrue(header.loginLogoIsDisplayed());
    }
    @Test
    public void logoutUser() {
        driver.get(URLs.TEST_ENV);
        loginPage.authenticate(correctUser);
        Assert.assertTrue(header.appLogoIsDisplayed());
        loginPage.logoutUser();
        Assert.assertTrue(header.loginLogoIsDisplayed());
        Assert.assertTrue(loginPage.loginButtonIsDisplayed());
    }
}
package com.selenium.pages;

import com.selenium.testdata.classes.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By usernameInput = By.id("user-name");
    private By passwordInput = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.xpath("//div[@class='error-message-container error']");
    private By menuButton = By.id("react-burger-menu-btn");
    private By logoutSideBarLink = By.id("logout_sidebar_link");
    private By shoppingCartButton = By.id("shopping_cart_container");


    public void enterUsername(String username) {
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public boolean loginButtonIsDisplayed() {
        return driver.findElement(loginButton).isDisplayed();
    }

    public boolean shoppingCartButtonIsDisplayed() {
        return driver.findElement(shoppingCartButton).isDisplayed();
    }

    public String getError() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> !driver.findElement(errorMessage).getText().isEmpty());

        return driver.findElement(errorMessage).getText();
    }

    public void clickMenuButton() {
        driver.findElement(menuButton).click();
    }

    public void clickToLogoutLink() {
        driver.findElement(logoutSideBarLink).click();
    }

    public void authenticate(UserData correctUser) {
        enterUsername(correctUser.getUsername());
        enterPassword(correctUser.getPassword());
        clickLoginButton();
    }

    public void authenticateInvalidUser(UserData invalidUserData) {
        enterUsername(invalidUserData.getUsername());
        enterPassword(invalidUserData.getPassword());
        clickLoginButton();
    }

    public void authenticateMissingData(UserData missingUserData) {
        enterUsername(missingUserData.getUsername());
        enterPassword(missingUserData.getPassword());
        clickLoginButton();
    }

    public void authenticateLockedOutUser(UserData lockedOutUser) {
        enterUsername(lockedOutUser.getUsername());
        enterPassword(lockedOutUser.getPassword());
        clickLoginButton();
    }

    public void logoutUser() {
        clickMenuButton();
        clickToLogoutLink();
    }

}

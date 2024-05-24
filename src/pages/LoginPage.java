package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import testdata.classes.CorrectUser;
import testdata.classes.InvalidUserData;
import testdata.classes.LockedOutUser;
import testdata.classes.MissingUserData;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    public LoginPage (WebDriver driver) {
        this.driver = driver;
    }
    private By usernameInput = By.id("user-name");
    private By passwordInput = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.xpath("//div[@class='error-message-container error']");

    public void enterUsername(String username) {
        driver.findElement(usernameInput).sendKeys(username);
    }
    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
    public String getError() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> !driver.findElement(errorMessage).getText().isEmpty());

        return driver.findElement(errorMessage).getText();
    }
    public void authenticate(CorrectUser correctUser) {
        enterUsername(correctUser.getUsername());
        enterPassword(correctUser.getPassword());
        clickLoginButton();
    }
    public void authenticateInvalidUser(InvalidUserData invalidUserData) {
        enterUsername(invalidUserData.getUsername());
        enterPassword(invalidUserData.getPassword());
        clickLoginButton();
    }
    public void authenticateMissingData(MissingUserData missingUserData) {
        enterUsername(missingUserData.getUsername());
        enterPassword(missingUserData.getPassword());
        clickLoginButton();
    }
    public void authenticateLockedOutUser(LockedOutUser lockedOutUser) {
        enterUsername(lockedOutUser.getUsername());
        enterPassword(lockedOutUser.getPassword());
        clickLoginButton();
    }
}

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

public class LoginTest {
    static WebDriver driver;
    public static LoginPage loginPage;
    public CorrectUser correctUser = new CorrectUser("correctuser");
    public InvalidUserData invalidData = new InvalidUserData("invaliduserdata");
    public MissingUserData missingData = new MissingUserData("missinguserdata");
    public LockedOutUser lockedOutUser = new LockedOutUser("lockedoutuser");

    @BeforeClass
    public static void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");
        System.setProperty("webdriver.chrome.driver", "src/resource/chromedriver.exe");
        driver = new ChromeDriver(chromeOptions);
        //wait implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        loginPage = new LoginPage(driver);
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

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
package tests;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LoginPage;
import pages.ProductsPage;
import testdata.URLs;
import testdata.classes.CorrectUser;
import testdata.classes.InvalidUserData;
import testdata.classes.LockedOutUser;
import testdata.classes.MissingUserData;

import java.time.Duration;

public class ProductsTest {

    static WebDriver driver;
    public static LoginPage loginPage;
    public CorrectUser correctUser = new CorrectUser("correctuser");
    public InvalidUserData invalidData = new InvalidUserData("invaliduserdata");
    public MissingUserData missingData = new MissingUserData("missinguserdata");
    public LockedOutUser lockedOutUser = new LockedOutUser("lockedoutuser");
    public static ProductsPage productsPage;

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
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test@Ignore
    public void addProductToTheCart () {
        driver.get(URLs.TEST_ENV);
        loginPage.authenticate(correctUser);
        productsPage.addProducts();
        Assert.assertTrue(productsPage.areRemoveButtonsDisplayed());
    }
    @Test
    public void removeProductToTheeCart() throws InterruptedException {
        driver.get(URLs.TEST_ENV);
        loginPage.authenticate(correctUser);
        productsPage.removeProducts();
        Assert.assertFalse(productsPage.shoopingCartBadgeisDisplayed());
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



package tests;

import components.Header;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LoginPage;
import pages.ProductsPage;
import pages.ShoppingCartPage;
import testdata.classes.*;

import java.time.Duration;

public class BaseTest {
    static WebDriver driver;
    public static LoginPage loginPage;
    public static Header header;
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
        header = new Header(driver);
        productsPage = new ProductsPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }
}

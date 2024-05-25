package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import testdata.classes.OrderDetailsData;

import java.time.Duration;

public class ShoppingCartPage {
    WebDriver driver;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
    }

    private By backpackItemLink = By.xpath("//div[@data-test='inventory-item-name']");
    private By addBackpackButton = By.id("add-to-cart");
    private By shoppingCartButton = By.className("shopping_cart_link");
    private By checkoutButton = By.id("checkout");
    private By firstNameInput = By.id("first-name");
    private By lastNameInput = By.id("last-name");
    private By postalCodeInput = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By finishButton = By.id("finish");
    private By productNameElement = By.xpath("//div[contains(@class, 'inventory_item_name') or contains(@class, 'inventory_details_name ')]");
    private By productDetailElement = By.xpath("//div[contains(@class, 'inventory_item_desc') or contains(@class, 'inventory_details_desc ')]");
    private By productPriceElement = By.xpath("//div[contains(@class, 'inventory_item_price') or contains(@class, 'inventory_details_price')]");
    private By checkoutInfoText = By.xpath("//span[@data-test='title']");
    private By checkoutOverviewText = By.xpath("//span[@data-test='title']");
    private By shippingInfoLabel = By.xpath("//div[@data-test='shipping-info-label']");
    private By successTitle = By.xpath("//h2[@data-test='complete-header']");
    private By successText = By.xpath("//h2[@class='complete-header']/following-sibling::div[1]");

    public void clickToItemLink() {
        driver.findElement(backpackItemLink).click();
    }

    public void addItemToShoopingCart() {
        driver.findElement(addBackpackButton).click();
    }

    public void clickShoppingCartButton() {
        driver.findElement(shoppingCartButton).click();
    }

    public void checkoutOrder() {
        driver.findElement(checkoutButton).click();
    }

    public void enterFirstName(String firstname) {
        driver.findElement(firstNameInput).sendKeys(firstname);
    }

    public void enterLastName(String lastname) {
        driver.findElement(lastNameInput).sendKeys(lastname);
    }

    public void enterPostalCode(String postalcode) {
        driver.findElement(postalCodeInput).sendKeys(postalcode);
    }

    public void completeInfo(OrderDetailsData orderDetailsData) {
        enterFirstName(orderDetailsData.getFirstname());
        enterLastName(orderDetailsData.getLastname());
        enterPostalCode(orderDetailsData.getPostalcode());
    }

    public void continueOrder() {
        driver.findElement(continueButton).click();
    }

    public void finishOrder() {
        driver.findElement(finishButton).click();
    }

    public void openAProduct() {
        clickToItemLink();
        addItemToShoopingCart();
    }

    public String getProductInfoTextByElement(By element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> !driver.findElement(element).getText().isEmpty());

        return driver.findElement(element).getText();
    }

    public String getProductName() {
        return getProductInfoTextByElement(productNameElement);
    }

    public String getProductDetails() {
        return getProductInfoTextByElement(productDetailElement);
    }

    public String getProductPrice() {
        return getProductInfoTextByElement(productPriceElement);
    }

    public String getCheckoutInfo() {
        return getProductInfoTextByElement(checkoutInfoText);
    }

    public String getCheckoutOV() {
        return getProductInfoTextByElement(checkoutOverviewText);
    }

    public String getShippingInfoText() {
        return getProductInfoTextByElement(shippingInfoLabel);
    }

    public String getSuccessTitle() {
        return getProductInfoTextByElement(successTitle);
    }

    public String getSuccessText() {
        return getProductInfoTextByElement(successText);
    }
}

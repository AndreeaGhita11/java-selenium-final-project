package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import testdata.classes.OrderDetailsData;

import java.time.Duration;

public class ShoppingCartPage {
    WebDriver driver;
    public ShoppingCartPage(WebDriver driver){
        this.driver = driver;
    }
    private By backpackItemLink = By.xpath("//div[text()='Sauce Labs Backpack']");
    private By addBackpackButton = By.id("add-to-cart");
    private By shoppingCartButton = By.className("shopping_cart_link");
    private By checkoutButton = By.id("checkout");
    private By firstNameInput = By.id("first-name");
    private By lastNameInput = By.id("last-name");
    private By postalCodeInput = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By finishButton = By.id("finish");
    private By backHomeButton = By.id("back-to-products");
    private By productNameElement = By.xpath("//div[text()='Sauce Labs Backpack']");
    private By productDetailElement = By.xpath("//div[text()='carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.']");
    private By productPriceElement = By.xpath("//div[text()='29.99']");
    private By checkoutInfoText = By.xpath("//span[text()='Checkout: Your Information']");
    private By checkoutOverviewText = By.xpath("//span[text()='Checkout: Overview']");
    private By shippingInfoLabel = By.xpath("//div[text()='Shipping Information:']");
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
    public void checkoutOrder(){
        driver.findElement(checkoutButton).click();
    }
    public void enterFirstName(String firstname){
        driver.findElement(firstNameInput).sendKeys(firstname);
    }
    public void enterLastName(String lastname) {
        driver.findElement(lastNameInput).sendKeys(lastname);
    }
    public void enterPostalCode(String postalcode) {
        driver.findElement(postalCodeInput).sendKeys(postalcode);
    }
    public void completeInfo(OrderDetailsData orderDetailsData){
        enterFirstName(orderDetailsData.getFirstname());
        enterLastName(orderDetailsData.getLastname());
        enterPostalCode(orderDetailsData.getPostalcode());
    }
    public void continueOrder(){
        driver.findElement(continueButton).click();
    }

    public void finishOrder() {
        driver.findElement(finishButton).click();
    }

    public void backToProductsPage() {
        driver.findElement(backHomeButton).click();
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
   public String getProductPrice(){
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


    //1.ma loghez
    //2. adaug un produs in cos
    //3. dau click pe shopping cart button
    //4. verific daca produsul a fost adaugat in cos
    //5. dau click pe continue button
    //6. creez o clasa de random generator pt a completa diferit valorile din complete data for order....
    //7. verific?
    //8. click pe finish order
    //9. verific mesajul
    //10. click pe back to pp
}

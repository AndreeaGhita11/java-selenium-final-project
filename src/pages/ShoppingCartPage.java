package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage {
    WebDriver driver;
    public ShoppingCartPage(WebDriver driver){
        this.driver = driver;
    }
    private By removeTshirtButton = By.id("remove-sauce-labs-bolt-t-shirt");
    private By checkoutButton = By.id("checkout");
    private By firstNameInput = By.id("first-name");
    private By lastNameInput = By.id("last-name");
    private By postalCodeInput = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By finishButton = By.id("finish");
    private By backHomeButton = By.id("back-to-products");

    public void removeProductFromCart() {
        driver.findElement(removeTshirtButton).click();
    }

    public void checkoutOrder(){
        driver.findElement(checkoutButton).click();
    }
    public void completeDataForOrder(String firstName, String lastName, String postalCode){
        driver.findElement(firstNameInput).sendKeys(firstName);
        driver.findElement(lastNameInput).sendKeys(lastName);
        driver.findElement(postalCodeInput).sendKeys(postalCode);
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


}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage {
    WebDriver driver;
    public ShoppingCartPage(WebDriver driver){
        this.driver = driver;
    }
    private By shoppingCartButton = By.className("shopping_cart_link");
    private By checkoutButton = By.id("checkout");
    private By firstNameInput = By.id("first-name");
    private By lastNameInput = By.id("last-name");
    private By postalCodeInput = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By finishButton = By.id("finish");
    private By backHomeButton = By.id("back-to-products");

    public void clickShoppingCartButton() {
        driver.findElement(shoppingCartButton).click();
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

    public void addProductToShoppingCart() {
        clickShoppingCartButton();
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

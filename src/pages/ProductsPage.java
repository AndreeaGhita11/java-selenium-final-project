package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage {
    WebDriver driver;
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }
    private By addToCartBackpackButton = By.id("add-to-cart-sauce-labs-backpack");
    private By addToCartTshirtButton = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private By menuButton = By.id("react-burger-menu-btn");
    private By logoutSideBarLink = By.id("logout_sidebar_link");
    private By productSortFilter = By.className("product_sort_container");

    public void clickToAddToCartBackpackButton(){
        driver.findElement(addToCartBackpackButton).click();
    }
    public void clickToAddToCartTshirtButton() {
        driver.findElement(addToCartTshirtButton).click();
    }
    public void clickMenuButton() {
        driver.findElement(menuButton).click();
    }
    public void clickToLogoutLink() {
        driver.findElement(logoutSideBarLink).click();
    }
    public void selectFilter() {
        driver.findElement(productSortFilter).click();
    }
    public WebElement removeBackpackButton() {
        return driver.findElement(By.id("remove-sauce-labs-backpack"));
    }
    public WebElement removeTshirtButton() {
        return driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt"));
    }

    public boolean areRemoveButtonsDisplayed() {
        return removeBackpackButton().isDisplayed() && removeTshirtButton().isDisplayed();
    }
    public void addProducts() {
        clickToAddToCartBackpackButton();
        clickToAddToCartTshirtButton();
    }
    public void removeProducts()  {
        clickToAddToCartBackpackButton();
        removeBackpackButton().click();
    }
    public WebElement shoppingCartBadge() {
        return driver.findElement(By.className("shopping_cart_badge"));
    }
    public boolean shoopingCartBadgeisDisplayed() {
        boolean isDisplayed;
        try {
            isDisplayed = shoppingCartBadge().isDisplayed();
        } catch ( NoSuchElementException e) {
            isDisplayed = false;
        }
        return isDisplayed;
    }
    public void logoutUser(){
        clickMenuButton();
        clickToLogoutLink();
    }

}

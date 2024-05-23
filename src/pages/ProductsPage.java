package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage {
    WebDriver driver;
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    //locators
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
    public WebElement getRemoveBackpackButton() {
        return driver.findElement(By.id("remove-sauce-labs-backpack"));
    }
    public WebElement getRemoveTshirtButton() {
        return driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt"));
    }

    public boolean areRemoveButtonsDisplayed() {
        return getRemoveBackpackButton().isDisplayed() && getRemoveTshirtButton().isDisplayed();
    }

    public void addProducts() {
        clickToAddToCartBackpackButton();
        clickToAddToCartTshirtButton();
    }

    public void logoutUser(){
        clickMenuButton();
        clickToLogoutLink();
    }

}

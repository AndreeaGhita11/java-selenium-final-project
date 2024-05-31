package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage {
    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By addToCartBackpackButton = By.id("add-to-cart-sauce-labs-backpack");
    private By addToCartTshirtButton = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private By sortActiveOptionElement = By.className("active_option");
    private By removeBypackButton = By.id("remove-sauce-labs-backpack");
    private By removeTshitButton = By.id("remove-sauce-labs-bolt-t-shirt");
    private By shoppingCardBadge = By.className("shopping_cart_badge");
    private By shoppingCartContainer = By.className("product_sort_container");

    public void clickToAddToCartBackpackButton() {
        driver.findElement(addToCartBackpackButton).click();
    }

    public void clickToAddToCartTshirtButton() {
        driver.findElement(addToCartTshirtButton).click();
    }

    public WebElement removeBackpackButton() {
        return driver.findElement(removeBypackButton);
    }

    public WebElement removeTshirtButton() {
        return driver.findElement(removeTshitButton);
    }

    public boolean areRemoveButtonsDisplayed() {
        return removeBackpackButton().isDisplayed() && removeTshirtButton().isDisplayed();
    }

    public void addProducts() {
        clickToAddToCartBackpackButton();
        clickToAddToCartTshirtButton();
    }

    public void removeProducts() {
        clickToAddToCartBackpackButton();
        removeBackpackButton().click();
    }


    public boolean shoopingCartBadgeisDisplayed() {
        return driver.findElements(shoppingCardBadge).size() > 0;
    }

    public void selectFilterByIndex(int index) {
        Select classicSelect = new Select(driver.findElement(shoppingCartContainer));
        classicSelect.selectByIndex(index);
    }

    public String getActiveOptionName() {
        return driver.findElement(sortActiveOptionElement).getText();
    }
}

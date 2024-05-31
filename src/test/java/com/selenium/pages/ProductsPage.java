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

    public void clickToAddToCartBackpackButton() {
        driver.findElement(addToCartBackpackButton).click();
    }

    public void clickToAddToCartTshirtButton() {
        driver.findElement(addToCartTshirtButton).click();
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

    public void removeProducts() {
        clickToAddToCartBackpackButton();
        removeBackpackButton().click();
    }


    public boolean shoopingCartBadgeisDisplayed() {
        return driver.findElements(By.className("shopping_cart_badge")).size() > 0;
    }

    public void selectFilterByIndex(int index) {
        Select classicSelect = new Select(driver.findElement(By.className("product_sort_container")));
        classicSelect.selectByIndex(index);
    }

    public String getActiveOptionName() {
        return driver.findElement(sortActiveOptionElement).getText();
    }
}

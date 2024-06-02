package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class ProductsPage {
    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    private By addToCartButton = By.xpath("//button[contains(@class, 'btn_primary')]");
    private By removeFromCartButton = By.xpath("//button[contains(@class, 'btn_secondary')]");
    private By shoppingCartBadge = By.xpath("//span[@class='shopping_cart_badge']");
    private By sortActiveOptionElement = By.xpath("//span[@class='active_option']");
    private By sortProductsElement = By.xpath("//select[@class='product_sort_container']");

    public int getCartItemCount() {
        if (driver.findElements(shoppingCartBadge).size() == 0) {
            return 0;
        } else {
            return Integer.parseInt(driver.findElement(shoppingCartBadge).getText());
        }
    }

    public void clickToAddOneProductToCart() {
        driver.findElement(addToCartButton).click();
    }

    public void removeAllProductsFromCart() {
        driver.findElements(removeFromCartButton).forEach(
                button -> button.click()
        );
    }

    public void clickToRemoveOneProductFromCart() {
        driver.findElement(removeFromCartButton).click();
    }

    public void selectFilterByIndex(int index) {
        Select classicSelect = new Select(driver.findElement(sortProductsElement));
        classicSelect.selectByIndex(index);
    }

    public String getActiveOptionName() {
        return driver.findElement(sortActiveOptionElement).getText();
    }
}

package com.java.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header {
    public WebDriver driver;

    private By loginLogo = By.className("login_logo");
    private By appLogo = By.className("app_logo");

    public Header (WebDriver driver) {
        this.driver = driver;
    }

    public boolean loginLogoIsDisplayed() {
        return driver.findElement(loginLogo).isDisplayed();
    }
    public boolean appLogoIsDisplayed() {return driver.findElement(appLogo).isDisplayed();}
}

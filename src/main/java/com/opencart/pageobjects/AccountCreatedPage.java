package com.opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountCreatedPage extends Page {
    @FindBy(xpath = "//a[@class='dropdown-item'][normalize-space()='Logout']")
    private WebElement logOutOption;

    public AccountCreatedPage(WebDriver driver) {
        super(driver);
    }

    public void logOutFromTheAccount() {
        accountIcon.click();
        logOutOption.click();
        System.out.println("The user is logged out.");
    }
}

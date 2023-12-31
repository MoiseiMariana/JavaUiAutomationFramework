package com.opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page {
    @FindBy(css = "#input-email")
    private WebElement emailInput;
    @FindBy(css = "#input-password")
    private WebElement passwordInput;
    @FindBy(css = "button[type='submit']")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void fillInTheLoginForm(String email, String password) {
        emailInput.sendKeys(email);
        System.out.println("Entered email: " + email);
        passwordInput.sendKeys(password);
        System.out.println("Entered password: " + password);
    }

    public void clickOnLoginButton() {
        loginButton.click();
        System.out.println("The login button was clicked");
    }
}

package com.opencart;

import com.opencart.managers.DataFakerManager;
import com.opencart.managers.DriverManager;
import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.RegisterPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class RegistrationFlowTestSuite {
    WebDriver driver;
    HomePage homePage;
    RegisterPage registerPage;
    int counter = 0;

    @BeforeEach
    public void executeTheCodeBeforeEachTestFromThisClass() {
        driver = DriverManager.getInstance().getDriver();
        driver.get("https://andreisecuqa.host/");
        registerPage = new RegisterPage(driver);
        homePage = new HomePage(driver);
        counter++;
        System.out.println("The test number " + counter + "started");
    }
    @Test
    @DisplayName("The URL contains success keyword after registration with valid data")
    public void registerFlowRedirectsTheUserToTheCorrectUrl() throws InterruptedException {
        homePage.navigateToRegisterPageFromHeaderMenu();
        String firstName = DataFakerManager.getRandomName();
        String lastName = DataFakerManager.getRandomName();
        String email = DataFakerManager.getRandomEmail();
        String password = DataFakerManager.getRandomPassword(21, 22);

        registerPage.fillInTheRegisterForm(firstName, lastName, email, password);
        registerPage.switchOnThePrivacyToggle(driver);
        registerPage.clickOnTheContinueBtn();
        Thread.sleep(2000);

        System.out.println(driver.getCurrentUrl());
        boolean urlContaisTheCorrectKeyWords = driver.getCurrentUrl().contains("/index.php?route=account/success&language");
        Assertions.assertTrue(urlContaisTheCorrectKeyWords, "The Url " + driver.getCurrentUrl() + "contains success keyword");


        Thread.sleep(1000);
        System.out.println(driver.getCurrentUrl());

    }

    @Test
    @DisplayName("The URL contains register keyword when privacy policy is not accepted ")
    public void registerFlowIsBlockedByPrivacyToggleThatIsNotAccepted() throws InterruptedException {

        homePage.navigateToRegisterPageFromHeaderMenu();

        String firstName = DataFakerManager.getRandomName();
        String lastName = DataFakerManager.getRandomName();
        String email = DataFakerManager.getRandomEmail();
        String password = DataFakerManager.getRandomPassword(21, 22);

        registerPage.fillInTheRegisterForm(firstName, lastName, email, password);
        // Don't enable the Privacy Toggle
        // registerPage.switchOnThePrivacyToggle(driver);
        registerPage.clickOnTheContinueBtn();
        Thread.sleep(2000);

        System.out.println(driver.getCurrentUrl());
        boolean urlContaisTheCorrectKeyWords = driver.getCurrentUrl().contains("/index.php?route=account/success&language");
        Assertions.assertFalse(urlContaisTheCorrectKeyWords, "The Url " + driver.getCurrentUrl() + "does not contains success keyword");

        boolean urlContainsRegisterKeyword = driver.getCurrentUrl().contains("route=account/success&language=en-gb");

        Assertions.assertFalse(urlContainsRegisterKeyword, "The Url belongs to register page");

        Thread.sleep(1000);
        System.out.println(driver.getCurrentUrl());
    }

    @AfterEach
    public void executeThisMethodsAfterEachTestCase() {
        DriverManager.getInstance().quitTheDriver();
        System.out.println("The test number" + counter + " finished!");
    }

}

package com.epam.mobile.pageObjects.nativeApp.ContactManagerApp;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class StartScreen {
    String pageTitle = "Contact Manager";
    private AppiumDriver driver;
    private By title = By.id("android:id/title");
    private By addButton = By.id("com.example.android.contactmanager:id/addContactButton");

    public StartScreen(AppiumDriver appiumDriver) {

        this.driver = appiumDriver;
    }

    //    Check Screen title
    public void checkTitle() {
        assertEquals(driver.findElement(title).getText(), pageTitle);
    }

    //    Check the button is present on the screen
    public void checkAddButtonIsVisible() {
        assertTrue(driver.findElement(addButton).isDisplayed());
    }

    //click on AddButton
    public void clickOnAddBtn() {
        driver.findElement(addButton).click();
    }
}

package com.epam.mobile.pageObjects.nativeApp.ContactManagerApp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AddContactScreen {

    private AppiumDriver driver;

    private String pageTitle = "Add Contact";
    private String targetAccountFieldText = "Target Account";

    private By screenTitle = By.id("android:id/title");
    private By targetAccountField = By.xpath("//android.widget.TextView[@content-desc=\"Target Account\"]");
    private By dropdownMenu = By.id("com.example.android.contactmanager:id/accountSpinner");
    private By contactNameField = By.id("com.example.android.contactmanager:id/contactNameEditText");
    private By contactPhoneField = By.id("com.example.android.contactmanager:id/contactPhoneEditText");
    private By contactEmailField = By.id("com.example.android.contactmanager:id/contactEmailEditText");
    private By saveButton = By.id("com.example.android.contactmanager:id/contactSaveButton");

    public AddContactScreen(AppiumDriver appiumDriver) {
        this.driver = appiumDriver;
    }

    //Assert that scree title is correct
    public void checkScreenTitle() {
        assertEquals(driver.findElement(screenTitle).getText(), pageTitle);
    }

    //    Assert that Target Account Field contains correct Text
    public void checkTargetAccountFieldText() {
        assertEquals(driver.findElement(targetAccountField).getText(), targetAccountFieldText);
    }

    //    Assert Account dropdown menu is Visible
    public void checkAccountDropDownMenuIsVisible() {
        assertTrue(driver.findElement(dropdownMenu).isDisplayed());
    }

    //Assert contact field is visible
    public void checkContactNameFieldIsVisible() {
        assertTrue(driver.findElement(contactNameField).isDisplayed());
    }

    //Assert phone field is visible
    public void checkContactPhoneFieldIsVisible() {
        assertTrue(driver.findElement(contactPhoneField).isDisplayed());
    }

    //Assert email field is visible
    public void checkEmailFieldIsVisible() {
        assertTrue(driver.findElement(contactEmailField).isDisplayed());
    }

    //Assert button field is visible
    public void checkSaveButtonIsVisible() {
        assertTrue(driver.findElement(saveButton).isDisplayed());
    }

    //Keyboard will be hidden if present
    public void hideKeyboard() {
        driver.hideKeyboard();
    }
}

package com.epam.mobile.pageObjects.nativeApp.ContactManagerApp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class StartScreen {
    private AppiumDriver driver;

    String pageTitle = "Contact Manager";

    private By title = By.id("android:id/title");
    private By addButton = By.id("com.example.android.contactmanager:id/addContactButton");

    public StartScreen(AppiumDriver appiumDriver) {

        this.driver = appiumDriver;
    }

//    Check Screen title
    public void checkTitle(){
        assertEquals(driver.findElement(title).getText(),pageTitle);
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

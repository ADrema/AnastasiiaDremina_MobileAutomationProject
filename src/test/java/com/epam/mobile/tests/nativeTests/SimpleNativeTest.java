package com.epam.mobile.tests.nativeTests;

import com.epam.mobile.pageObjects.nativeApp.ContactManagerApp.AddContactScreen;
import com.epam.mobile.pageObjects.nativeApp.ContactManagerApp.StartScreen;
import com.epam.mobile.setup.DriverSetup;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;

@Test(groups = "native")
public class SimpleNativeTest extends DriverSetup {
    private StartScreen startScreen;
    private AddContactScreen addContactScreen;

    protected SimpleNativeTest() throws IOException {
        super();
    }

    @BeforeSuite(description = "Prepare driver to run test(s)")
    public void setUp() throws Exception {
        prepareDriver();
        System.out.println("DriverSetup is prepared");
        startScreen = new StartScreen(driver());
        addContactScreen = new AddContactScreen(driver());
    }

    @AfterSuite(description = "Close driver on all tests completion")
    public void tearDown() throws Exception {
        driver().quit();
        System.out.println("DriverSetup is closed");
    }

    @Test(description = "Just click on button 'Add contact'")
    public void simplestTest() throws Exception {

//        Step 1: Check page title
        startScreen.checkTitle();

//        Step 2: Check that "Add Contact" button is visible
        startScreen.checkAddButtonIsVisible();

//        Step 3: Click on "Add Contact" button
        startScreen.clickOnAddBtn();

//        Step 4: Check screen title
        addContactScreen.checkScreenTitle();

//        Step 5: Check "Target Account" field text
        addContactScreen.checkTargetAccountFieldText();

//        Step 6: Check that "Target Account" dropdown menu is Visible
        addContactScreen.checkAccountDropDownMenuIsVisible();

//        Step 7: Check that "Contact Name" field is Visible
        addContactScreen.checkContactNameFieldIsVisible();

//        Step 8: Check that "Contact Phone" field is visible
        addContactScreen.checkContactPhoneFieldIsVisible();

//        Step 9: Check that "Contact email" field is visible
        addContactScreen.checkEmailFieldIsVisible();

//        Step 10: Check that save button is Visible
        addContactScreen.checkSaveButtonIsVisible();

//        Step 11: Hide the keyboard
        addContactScreen.hideKeyboard();

        System.out.println("Simplest Appium test done");
    }
}

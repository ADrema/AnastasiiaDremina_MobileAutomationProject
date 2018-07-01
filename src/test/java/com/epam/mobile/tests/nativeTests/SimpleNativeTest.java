package com.epam.mobile.tests.nativeTests;

import com.epam.mobile.setup.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.epam.mobile.enumObjects.PropertiesEnum.NATIVE_PROPERTIES;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Test(groups = "native")
public class SimpleNativeTest extends DriverSetup {
    protected SimpleNativeTest() throws IOException {
        super();
    }

    @BeforeSuite(description = "Prepare driver to run test(s)")
    public void setUp() throws Exception {
        prepareDriver(NATIVE_PROPERTIES);
        System.out.println("DriverSetup is prepared");
    }

    @AfterSuite(description = "Close driver on all tests completion")
    public void tearDown() throws Exception {
        driver().quit();
        System.out.println("DriverSetup is closed");
    }

    @Test(description = "Just click on button 'Add contact'")
    public void simplestTest() throws Exception {
        String app_package_name = "com.example.android.contactmanager:id/";
        By add_btn = By.id(app_package_name + "addContactButton");
        driver().findElement(add_btn).click();
        WebElement title = driver().findElement(By.id("android:id/title"));
        assertEquals(title.getText(), "Add Contact");
        WebElement targetAccountfield = driver().findElement(By.xpath("//android.widget.TextView[@content-desc=\"Target Account\"]"));
        //Assert that Target Account has correct Text
        assertEquals(targetAccountfield.getText(), "Target Account");
        WebElement targetAccountDropDownMenu = driver().findElement(By.id("com.example.android.contactmanager:id/accountSpinner"));
        //Assert that TargetAccoun Drop down menu is visible
        assertTrue(targetAccountDropDownMenu.isDisplayed());
        WebElement contactNameField = driver().findElement(By.id("com.example.android.contactmanager:id/contactNameEditText"));
        //Assert contact field is visible
        assertTrue(contactNameField.isDisplayed());

        WebElement contactPhoneField = driver().findElement(By.id("com.example.android.contactmanager:id/contactPhoneEditText"));
        //Assert phone field is visible
        assertTrue(contactPhoneField.isDisplayed());

        WebElement contactEmailField = driver().findElement(By.id("com.example.android.contactmanager:id/contactEmailEditText"));
        //Assert email field is visible
        assertTrue(contactEmailField.isDisplayed());

        WebElement saveButton = driver().findElement(By.id("com.example.android.contactmanager:id/contactSaveButton"));
        //Assert button field is visible
        assertTrue(saveButton.isDisplayed());
        //Keyboard will be hidden if present
        driver().hideKeyboard();

        System.out.println("Simplest Appium test done");
    }
}

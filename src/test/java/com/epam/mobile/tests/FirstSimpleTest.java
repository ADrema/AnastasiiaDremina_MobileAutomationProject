package com.epam.mobile.tests;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstSimpleTest extends DriverSetup {
    @BeforeClass(description = "Prepare driver to run test(s)")
    public void setUp() throws Exception {
//        prepareAndroidNative();
        prepareAndroidWeb();
    }

    //    @Test(description = "This simple test just click on button 'Add contact'")
    public void SimplestTest() {
//        To define element by id
//        String app_package_name = "com.example.android.contactmanager:id/";
//        By add_btn = By.id(app_package_name + "addContactButton");
//        To define element by xpath
//        By add_btn = By.xpath("//android.widget.Button[@content-desc=\"Add Contact\"]");
//        To define element by className
        By add_btn = By.className("android.widget.Button");

        driver.findElement(add_btn).click();
        System.out.println("Simplest Appium test done");
    }

    @Test(description = "This simple test to open iana.org via browser")
    public void webTest() throws InterruptedException {
        driver.get("http://iana.org");
        //must be deleted in future
        Thread.sleep(5000);
        System.out.println("Site opening done");
    }

    @AfterClass(description = "Close driver on all tests completion")
    public void tearDown() {
        driver.quit();
    }
}

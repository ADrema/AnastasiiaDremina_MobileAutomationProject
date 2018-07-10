package com.epam.mobile.tests.webTests;

import com.epam.mobile.pageObjects.nativeApp.ContactManagerApp.StartScreen;
import com.epam.mobile.pageObjects.web.ianaOrg.HomePage;
import com.epam.mobile.setup.DriverSetup;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;

@Test(groups = "web")
public class SimpleWebTest extends DriverSetup {
    HomePage homePage;
    protected SimpleWebTest() throws IOException {
        super();
    }

    @BeforeSuite(description = "Prepare driver to run test(s)")
    public void setUp() throws Exception {
        prepareDriver();
        homePage = new HomePage(driver());
        System.out.println("DriverSetup is prepared");
    }

    @AfterSuite(description = "Close driver on all tests completion")
    public void tearDown() throws Exception {
        driver().quit();
        System.out.println("DriverSetup is closed");
    }

    @Test(description = "Open website")
    public void webTest() throws Exception {
//        Step 1: Open site
        homePage.open(SUT,driverWait());

//        Step 2: Check page Title
        homePage.checkPageTitle();

//        Step 3: Check Page URL
        homePage.checkUrl();

//        Step 4: Check the header is Visible
        homePage.checkPageHeaderIsVisible();

        System.out.println("Site was opened");
    }
}

package com.epam.mobile.tests.webTests;

import com.epam.mobile.setup.DriverSetup;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.epam.mobile.enumObjects.PropertiesEnum.WEB_PROPERTIES;

@Test(groups = "web")
public class SimpleWebTest extends DriverSetup {
    protected SimpleWebTest() throws IOException {
        super();
    }

    @BeforeSuite(description = "Prepare driver to run test(s)")
    public void setUp() throws Exception {
        prepareDriver(WEB_PROPERTIES);
        System.out.println("DriverSetup is prepared");
    }

    @AfterSuite(description = "Close driver on all tests completion")
    public void tearDown() throws Exception {
        driver().quit();
        System.out.println("DriverSetup is closed");
    }

    @Test(description = "Open website")
    public void webTest() throws Exception {
        driver().get(SUT);
        driverWait().until(ExpectedConditions.urlToBe(SUT + "/"));
        // Assert Title
        Assert.assertEquals(driver().getTitle(), "Internet Assigned Numbers Authority");
        // Assert the URL is correct
        Assert.assertEquals(driver().getCurrentUrl(), "http://www.iana.org/");

        // TODO Check response code
        System.out.println("Site was opened");


    }
}

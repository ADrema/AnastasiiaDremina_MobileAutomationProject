package com.epam.mobile.pageObjects.web.ianaOrg;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static org.testng.Assert.assertEquals;

public class HomePage {
    private AppiumDriver driver;
    private String pageUrl = "https://www.iana.org/";
    private String pageTitle = "Internet Assigned Numbers Authority";
    private By domainNamesPanel = By.id("home-panel-domains");
    private By numberResourcesPanel = By.id("home-panel-numbers");
    private By protocolAssignmentsPanel = By.id("home-panel-numbers");

    public HomePage(AppiumDriver appiumDriver) {
        this.driver = appiumDriver;
    }

    public void open(String sut, WebDriverWait driverWait) {
        driver.get(sut);
        driverWait.until(ExpectedConditions.urlToBe(sut + "/"));
    }

    // Assert Title
    public void checkPageTitle() {
        assertEquals(driver.getTitle(), pageTitle);
    }

    // Assert the URL is correct
    public void checkUrl() {
        assertEquals(driver.getCurrentUrl(), pageUrl);
    }

    //Check that main panels are displayed
    public void checkMainPanelsAreVisible() {
        Assert.assertTrue(driver.findElement(domainNamesPanel).isDisplayed());
        Assert.assertTrue(driver.findElement(numberResourcesPanel).isDisplayed());
        Assert.assertTrue(driver.findElement(protocolAssignmentsPanel).isDisplayed());
    }
}

package com.epam.mobile.pageObjects.web.ianaOrg;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.sql.Driver;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class HomePage {
    private AppiumDriver driver;
    private String pageUrl = "https://www.iana.org/";
    private String pageTitle = "Internet Assigned Numbers Authority";
    private List<String> headerTextContent = Arrays.asList( "The global coordination of the DNS Root, " +
            "IP addressing, and other Internet protocol resources is performed as" +
            " the Internet Assigned Numbers Authority (IANA) functions. Learn more.");

    private By header = By.id("//android.webkit.WebView[@content-desc=\"Internet Assigned Numbers Authority\"]/android.view.View[1]");

    public HomePage(AppiumDriver appiumDriver) {
        this.driver = appiumDriver;
    }

    public void open(String sut, WebDriverWait driverWait){
        driver.get(sut);
        driverWait.until(ExpectedConditions.urlToBe(sut + "/"));
    }

    // Assert Title
    public void checkPageTitle(){
        assertEquals(driver.getTitle(), pageTitle);
    }

    // Assert the URL is correct
    public void checkUrl(){
        assertEquals(driver.getCurrentUrl(), pageUrl);
    }
    //Check that header is Visible
    public void checkPageHeaderIsVisible(){
        driver.findElement(header).isDisplayed();
    }
}

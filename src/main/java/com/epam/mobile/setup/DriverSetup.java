package com.epam.mobile.setup;

import com.epam.mobile.enumObjects.BrowsersEnum;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import static com.epam.mobile.enumObjects.BrowsersEnum.*;
import static io.appium.java_client.remote.MobileCapabilityType.*;

/**
 * Initialize a driver with test properties
 */
public class DriverSetup extends TestProperties {

    private static AppiumDriver driverSingle = null;
    private static WebDriverWait waitSingle;

    protected DesiredCapabilities capabilities;
    // Properties to be read
    private String AUT; // (mobile) app under testing
    protected String SUT; // site under testing
    private String TEST_PLATFORM;
    private String DRIVER;
    private String DEVICE_NAME;
    private String UDID;
    private String APP_PACKAGE;
    private String APP_ACTIVITY;
    private String TEST_PLATFORM_VERSION;

    private Properties properties;

    // Constructor initializes properties on driver creation
    protected DriverSetup() throws IOException {

    }

    /**
     * Initialize driver with appropriate capabilities depending on platform and application
     * * @throws Exception
     */
    protected void prepareDriver() throws Exception {

        String resourcePath = "src/main/resources/";
        String mobileAppName = getProp("aut");
        AUT = mobileAppName == null ? null : resourcePath + mobileAppName;
        String t_sut = getProp("sut");
        SUT = t_sut == null ? null : "https://" + t_sut;
        TEST_PLATFORM = getProp("platform");
        DRIVER = getProp("driver");
        DEVICE_NAME = getProp("deviceName");
        UDID = getProp("udid");
        APP_PACKAGE = getProp("appPackage");
        APP_ACTIVITY = getProp("appActivity");
        TEST_PLATFORM_VERSION =  getProp("PlatformVersion");
        String browserName;

        capabilities = new DesiredCapabilities();


        // Setup test platform: Android or iOS. Browser also depends on a platform.
        switch (TEST_PLATFORM) {
            case "Android":
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME); // default Android emulator
                browserName = CHROME.browserName;
                break;
            case "iOS":
                browserName = SAFARI.browserName;
                break;
            default:
                throw new Exception("Unknown mobile platform");
        }

        capabilities.setCapability(PLATFORM_NAME, TEST_PLATFORM);

        // Setup type of application: mobile, webTests (or hybrid)
        if (AUT != null && SUT == null) {
            // Native
            File app = new File(AUT);
            capabilities.setCapability(APP, app.getAbsolutePath());
            capabilities.setCapability("appPackage", APP_PACKAGE);
            capabilities.setCapability("appActivity", APP_ACTIVITY);
            capabilities.setCapability(PLATFORM_VERSION, TEST_PLATFORM_VERSION);
            capabilities.setCapability(MobileCapabilityType.UDID, UDID);
        } else if (SUT != null && AUT == null) {
            // Web
            capabilities.setCapability("chromedriverExecutableDir", System.getProperty("user.dir") + "\\src\\main\\resources\\driver");
            capabilities.setCapability(BROWSER_NAME, browserName);
        } else {
            throw new Exception("Unclear type of mobile app");
        }
        // Init driver for local Appium server with capabilities have been set
        if (driverSingle == null) {
            driverSingle = new AppiumDriver(new URL(DRIVER), capabilities);
        }


        // Init driver for local Appium server with capabilities
        switch (TEST_PLATFORM) {
            case "Android":
                driverSingle = new AndroidDriver(new URL(DRIVER), capabilities);
                break;
            case "iOS":
                driverSingle = new IOSDriver(new URL(DRIVER), capabilities);
                break;
            default:
                throw new Exception("Unknown mobile platform");
        }



        // Set an object to handle timeouts
        if (waitSingle == null) {
            waitSingle = new WebDriverWait(driver(), 10);
        }
    }

    protected AppiumDriver driver() throws Exception {
        if (driverSingle == null) {
            prepareDriver();
        }
        return driverSingle;
    }

    protected WebDriverWait driverWait() throws Exception {
        return waitSingle;
    }
}

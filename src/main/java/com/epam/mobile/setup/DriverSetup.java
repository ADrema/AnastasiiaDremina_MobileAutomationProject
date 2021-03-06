package com.epam.mobile.setup;

import com.epam.mobile.enumObjects.ErrorMessagesEnum;
import com.epam.mobile.enumObjects.PropertiesEnum;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.URL;
import java.util.Properties;

import static com.epam.mobile.enumObjects.BrowsersEnum.CHROME;
import static com.epam.mobile.enumObjects.BrowsersEnum.SAFARI;
import static com.epam.mobile.enumObjects.ErrorMessagesEnum.*;
import static com.epam.mobile.enumObjects.PropertiesEnum.*;
import static io.appium.java_client.remote.MobileCapabilityType.*;

/**
 * Initialize a driver with test properties
 */
public class DriverSetup extends TestProperties {

    private static AppiumDriver driverSingle = null;
    private static WebDriverWait waitSingle;

    protected DesiredCapabilities capabilities;
    protected String SUT; // site under testing
    // Properties to be read
    private String AUT; // (mobile) app under testing
    private String TEST_PLATFORM;
    private String DRIVER;
    private String DEVICE_NAME;
    private String UDID;
    private String APP_PACKAGE;
    private String APP_ACTIVITY;

    private Properties properties;

    /**
     * Initialize driver with appropriate capabilities depending on platform and application
     * * @throws Exception
     */
    protected void prepareDriver() throws Exception {

        String resourcePath = "src/main/resources/";
        String mobileAppName = getProp(PropertiesEnum.AUT.value);
        AUT = mobileAppName == null ? null : resourcePath + mobileAppName;
        String t_sut = getProp(PropertiesEnum.SUT.value);
        SUT = t_sut == null ? null : "https://" + t_sut;
        TEST_PLATFORM = getProp(PropertiesEnum.TEST_PLATFORM.value);
        DRIVER = getProp(PropertiesEnum.DRIVER.value);
        DEVICE_NAME = getProp(PropertiesEnum.DEVICE_NAME.value);
        UDID = getProp(PropertiesEnum.UDID.value);
        APP_PACKAGE = getProp(PropertiesEnum.APP_PACKAGE.value);
        APP_ACTIVITY = getProp(PropertiesEnum.APP_ACTIVITY.value);
        String browserName;

        capabilities = new DesiredCapabilities();
        capabilities.setCapability(PropertiesEnum.APP_PACKAGE.value, APP_PACKAGE);
        capabilities.setCapability(PropertiesEnum.APP_ACTIVITY.value, APP_ACTIVITY);
        capabilities.setCapability(MobileCapabilityType.UDID, UDID);
        capabilities.setCapability(PLATFORM_NAME, TEST_PLATFORM);

        // Setup test platform: Android or iOS. Browser also depends on a platform.
        switch (TEST_PLATFORM) {
            case "Android":
                browserName = CHROME.browserName;
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME); // default Android emulator
                break;
            case "iOS":
                browserName = SAFARI.browserName;
                break;
            default:
                throw new Exception(UNKNOWN_PLATFORM.value);
        }

        // Setup type of application: mobile, webTests (or hybrid)
        if (AUT != null && SUT == null) {
            // Native
            File app = new File(AUT);
            capabilities.setCapability(APP, app.getAbsolutePath());
        } else if (SUT != null && AUT == null) {
//            uncomment in case of error "No Chrome driver found"
//            capabilities.setCapability("chromedriverExecutableDir", System.getProperty("user.dir") + "\\src\\main\\resources\\driver");
            // Web
            capabilities.setCapability(BROWSER_NAME, browserName);
        } else {
            throw new Exception(UNKNOWN_APPLICATION.value);
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
                throw new Exception(UNKNOWN_PLATFORM.value);
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

package com.epam.mobile.enumObjects;

public enum PropertiesEnum {
    AUT("aut"),
    SUT("sut"),
    TEST_PLATFORM("platform"),
    DRIVER("driver"),
    DEVICE_NAME("deviceName"),
    UDID("udid"),
    APP_PACKAGE("appPackage"),
    APP_ACTIVITY("appActivity");

    public String value;

    PropertiesEnum(String value) {
        this.value = value;
    }
}

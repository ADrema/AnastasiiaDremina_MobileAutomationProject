package com.epam.mobile.enumObjects;

public enum BrowsersEnum {
    CHROME("Chrome"),
    SAFARI("Safari");

    public String browserName;

    BrowsersEnum(String browserName) {
        this.browserName = browserName;
    }
}

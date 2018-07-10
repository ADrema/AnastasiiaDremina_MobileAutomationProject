package com.epam.mobile.enumObjects;

public enum DevicesEnum {
    ANDROID("Android"),
    IOS("iOS");

    public String deviceOS;

    DevicesEnum(String deviceOS) {
        this.deviceOS = deviceOS;
    }
}

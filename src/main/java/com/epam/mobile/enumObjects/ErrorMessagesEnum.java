package com.epam.mobile.enumObjects;

public enum ErrorMessagesEnum {
    UNKNOWN_PLATFORM("Unknown mobile platform"),
    UNKNOWN_APPLICATION("Unknown mobile app");

    public String value;
    ErrorMessagesEnum(String value){
        this.value = value;
    }
}

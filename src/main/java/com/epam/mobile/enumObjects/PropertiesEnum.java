package com.epam.mobile.enumObjects;

public enum PropertiesEnum {
    WEB_PROPERTIES("/src/main/resources/webtest.properties"),
    NATIVE_PROPERTIES("/src/main/resources/nativetest.properties");

    public String path;

    PropertiesEnum(String path) {
        this.path = path;
    }
}

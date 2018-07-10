package com.epam.mobile.setup;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

    Properties currentProps;

    Properties getCurrentProps() throws IOException {
        if (currentProps != null) {
            return currentProps;
        }
        currentProps = new Properties();
        FileInputStream in = new FileInputStream(System.getProperty("property"));
        currentProps.load(in);
        in.close();
        return currentProps;
    }

    public String getProp(String propKey) throws IOException {
        return getCurrentProps().getProperty(propKey, null);
    }
}

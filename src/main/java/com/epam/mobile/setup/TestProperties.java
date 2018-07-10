package com.epam.mobile.setup;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

    Properties currentProps = new Properties();

    Properties getCurrentProps() throws IOException {
        FileInputStream in = new FileInputStream(System.getProperty("property"));
        currentProps.load(in);
        in.close();
        return currentProps;
    }

    protected String getProp(String propKey) throws IOException {
        if (!currentProps.containsKey(propKey)) currentProps = getCurrentProps();
        // "default" form used to handle the absence of parameter
        return currentProps.getProperty(propKey, null);
    }
}

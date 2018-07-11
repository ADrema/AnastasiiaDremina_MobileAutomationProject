package com.epam.mobile.setup;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

    private static Properties currentProps;

    Properties getCurrentProps() throws IOException {
        return (currentProps != null) ? currentProps : readPropertyFromFile();
    }

    public String getProp(String propKey) throws IOException {
        return getCurrentProps().getProperty(propKey, null);
    }

    private Properties readPropertyFromFile() throws IOException {
        this.currentProps = new Properties();
        FileInputStream in = new FileInputStream(System.getProperty("property"));
        this.currentProps.load(in);
        in.close();
        return this.currentProps;
    }
}
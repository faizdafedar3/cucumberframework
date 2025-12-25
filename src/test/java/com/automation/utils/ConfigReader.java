package com.automation.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop;

    // Load properties file
    public static void loadProperties() {

        prop = new Properties();

        try {
            FileInputStream fis = new FileInputStream(
                    "src/test/resources/config.properties");
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Get value by key
    public static String getProperty(String key) {

        if (prop == null) {
            loadProperties();
        }
        return prop.getProperty(key);
    }
}

package com.autotesting.framework.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    private static PropertiesReader propertiesReader;
    private static Properties properties;

    public static synchronized PropertiesReader getPropertiesReader() throws Exception{
        return (propertiesReader != null) ? propertiesReader : (propertiesReader = new PropertiesReader());
    }

    PropertiesReader() throws IOException {
        synchronized (PropertiesReader.class) {
            if (propertiesReader != null) {
                throw new IllegalStateException();
            }
            properties = new Properties();
            String PATH_TO_PROPERTIES_FILE = "src//main//resources//config.properties";
            properties.load(new FileInputStream(new File(PATH_TO_PROPERTIES_FILE)));
        }
    }

    public static String getLogin() {
        return properties.getProperty("username");
    }

    public static String getPlace() {
        return properties.getProperty("place");
    }

    public static String getSumAdd() {
        return properties.getProperty("sum");
    }

    public static String getSumRemove() {
        return properties.getProperty("sum");
    }

    public static String getPassword() {
        return properties.getProperty("password");
    }

    /*public static String getIdentifierERIP() {
        return properties.getProperty("identifierERIP");
    }*/

    public static String getCurrentURL() {
        return properties.getProperty("url");
    }
}

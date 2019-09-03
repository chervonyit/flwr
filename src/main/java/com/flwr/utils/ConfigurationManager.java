package com.flwr.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * this class reading properties from configuration file "application.properties" from resource
 */
public class ConfigurationManager {

    private String configFile = "/application.properties";

    private Properties properties;
    private static ConfigurationManager instance;

    private ConfigurationManager() throws IOException {
        properties = new Properties();
        InputStream inputStream = getClass().getResourceAsStream(configFile);
        if(inputStream != null){
            properties.load(inputStream);
        } else {
            throw new FileNotFoundException("configuration file not found. please check file name of file path");
        }
    }

    public static ConfigurationManager getInstance() throws IOException {
        if(instance == null){
            instance = new ConfigurationManager();
        }
        return instance;
    }

    public String getProperty(String name){
        return properties.getProperty(name);
    }
}

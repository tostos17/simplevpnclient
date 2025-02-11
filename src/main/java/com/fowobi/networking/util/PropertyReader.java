package com.fowobi.networking.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

public class PropertyReader {

    public static String getPropertyValue(String propertyKey) throws Exception {
//        FileReader reader = new FileReader("C:/Users/Admin/Documents/code/properties/vpnClient.properties");
        FileReader reader = new FileReader("/home/tostos/Documents/code/properties/vpnClient.properties");

        Properties properties = new Properties();
        properties.load(reader);

        return properties.getProperty(propertyKey);
    }

}

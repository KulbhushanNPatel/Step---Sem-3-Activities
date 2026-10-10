package com.gdb.domain;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class AccountRulesPropertiesLoader {
    private Properties properties = new Properties();

    public AccountRulesPropertiesLoader(String configPath) {
        loadProperties(configPath);
    }

    // TODO: Step 2.1 - Load the key=value pairs from configPath into 'properties' with properties.load(InputStream):
    //   1. Try the classpath first: getClass().getClassLoader().getResourceAsStream(configPath).
    //   2. If that returns null and new File(configPath) exists, open it with a FileInputStream instead.
    //   3. Close the stream afterwards. Catch any exception and print a warning (leave 'properties' empty).
    private void loadProperties(String configPath) {
        InputStream input = getClass().getClassLoader().getResourceAsStream(configPath);
        if (input == null) {
            File file = new File(configPath);
            if (file.exists()) {
                try {
                    input = new FileInputStream(file);
                } catch (Exception e) {
                    System.err.println("Warning: Could not load properties from " + configPath + ": " + e.getMessage());
                }
            }
        }
        if (input != null) {
            try (InputStream in = input) {
                properties.load(in);
            } catch (Exception e) {
                System.err.println("Warning: Could not load properties from " + configPath + ": " + e.getMessage());
            }
        } else {
            System.err.println("Warning: Could not load properties from " + configPath);
        }
    }

    // TODO: Step 2.2 - Return the value stored for key, or defaultValue if the key is missing.
    public String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    // TODO: Step 2.2 - Parse the value for key as a double (trim it first).
    //   Return defaultValue if the key is missing or the value is not a number (NumberFormatException).
    public double getDouble(String key, double defaultValue) {
        String value = properties.getProperty(key);
        if (value != null) {
            try {
                return Double.parseDouble(value.trim());
            } catch (NumberFormatException e) {
                     }
        }
        return defaultValue;
    }

    // TODO: Same as getDouble, but parse the value with Integer.parseInt.
    public int getInt(String key, int defaultValue) {
        String value = properties.getProperty(key);
        if (value != null) {
            try {
                return Integer.parseInt(value.trim());
            } catch (NumberFormatException e) {
            }
        }
        return defaultValue;
    }
}

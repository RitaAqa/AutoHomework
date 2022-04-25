package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;
import java.util.Properties;

import io.restassured.config.Config;


public class PropertiesLoader {

    private static Properties prop = setPropertiesPath();
    public static final String BASE_URL = prop.getProperty("host");
    public static final String AUTH_BASIC = prop.getProperty("authBasic");

    private static Properties setPropertiesPath() {
        final String path = "common.properties";
        Properties prop = new Properties();
        File propFile;
        URL url = Config.class.getClassLoader().getResource(path);

        try {
            propFile = new File(Objects.requireNonNull(url).toURI());
        } catch (URISyntaxException e) {
            throw new NullPointerException("Can't get URI to file");
        }

        try (FileInputStream flPropStream = new FileInputStream(propFile)) {
            prop.load(flPropStream);
            return prop;
        } catch (IOException | NullPointerException e) {
            throw new NullPointerException("Exception while reading file path in stream");
        }
    }
}
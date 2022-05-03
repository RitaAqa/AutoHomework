package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;
import java.util.Properties;

import io.restassured.config.Config;

/**
 * class for loading variables from properties file
 */
public class PropertiesLoader {

    private static Properties prop = setPropertiesPath();
    public static final String BASE_URL = prop.getProperty("host");

    /*Constants for login*/
    public static final String AUTH_BASIC = prop.getProperty("authBasic");

    public static final String EXPIRATION_TIME_FOR_TOKEN = prop.getProperty("expiry");
    public static final String LOGIN_FROM = prop.getProperty("loginFrom");

    /*Constants for default values */
    public static final String DEFAULT_LIMIT = prop.getProperty("defaultLimit");


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
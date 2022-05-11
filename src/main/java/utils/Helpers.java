package utils;

import java.net.MalformedURLException;
import java.net.URL;

import static utils.PropertiesLoader.BASE_URL;

public class Helpers {
    /**
     * Method returns start URL
     * @param relUrl - start endpoint
     * @return start URL
     */
    public static String prepareUrl(String relUrl) {
        URL mergedURL = null;
        try {
            mergedURL = new URL(new URL(BASE_URL), relUrl);
        } catch (MalformedURLException e) {
             throw new AssertionError("Cannot get Url");
        }
        return mergedURL.toString();
    }
}

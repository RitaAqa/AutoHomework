package app.ui.utils;

import app.ui.Urls;
import org.openqa.selenium.WebDriver;
import java.net.MalformedURLException;
import java.net.URL;

import static utils.PropertiesLoader.BASE_URL;

/**
 * Class for setting driver
 */
public class DriverSetup {
    protected WebDriver driver;

    /**
     * Method sets up driver and opens start page
     * @param browser - specifies browser for test (Now we do it via common.properties file)
     * @throws Exception - if browser is not found
     */
    public void setUpDriver(String browser) throws Exception {

        switch (browser) {
           case "Chrome":
                 driver = Browsers.getChromeDriver();
                break;
            case "Firefox":
                driver = Browsers.getFirefoxDriver();
                break;
            default:
                throw new Exception("Browser is not found");
        }
        driver.manage().window().maximize();
        String url = prepareUrl(Urls.LOGIN_URL);
        driver.get(url);
    }

    /**
     * Method returns start URL
     * @param relUrl - start endpoint
     * @return start URL
     */
    public String prepareUrl(String relUrl) {
        URL mergedURL = null;
        try {
            mergedURL = new URL(new URL(BASE_URL), relUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return mergedURL.toString();
    }
}

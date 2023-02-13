package framework.ui.utilsForUIOnly;

import org.openqa.selenium.WebDriver;

/**
 * Class for setting driver   Factorymethod?
 */
public class DriversProvider {
    private static WebDriver driver;

    /**
     * Method returns driver for specified browser
     *
     * @param browser - specifies browser for test
     * @throws Exception - if browser is not found
     */
    public static WebDriver getDriver(String browser) throws Exception {

        switch (browser) {
            case "chrome":
                driver = Drivers.getChromeDriver();
                break;
            case "firefox":
                driver = Drivers.getFirefoxDriver();
                break;
            default:
                throw new Exception("Browser is not found");
        }
        driver.manage().window().maximize();
        return driver;
    }
}
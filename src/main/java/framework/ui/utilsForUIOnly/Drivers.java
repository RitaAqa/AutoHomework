package framework.ui.utilsForUIOnly;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Class contains different web drivers with their settings
 */
public class Drivers {
    /**
     * @return ChromeDriver
     */
    public static ChromeDriver getChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/webdrivers/chromedriver.exe");
        //add capabilities if it's needed
        return new ChromeDriver();

    }

    /**
     * @return FirefoxDriver
     */
    public static FirefoxDriver getFirefoxDriver() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/webdrivers/geckodriver.exe");
        //add capabilities if it's needed
        return new FirefoxDriver();
    }
}

package app.ui.utils;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Class contains different web drivers with their settings
 */
public class Browsers {
    /**
     * @return ChromeDriver
     */
    static ChromeDriver getChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/webdrivers/chromedriver");
        //add capabilities if it's needed
        return new ChromeDriver();
    }

    /**
     * @return FirefoxDriver
     */
    static FirefoxDriver getFirefoxDriver() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/webdrivers/geckodriver");
        //add capabilities if it's needed
        return new FirefoxDriver();
    }
}

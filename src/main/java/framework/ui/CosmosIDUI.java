package framework.ui;

import framework.ui.page_object.LoginPage;
import framework.ui.page_object.SignUpPage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import static framework.ui.utilsForUIOnly.DriversProvider.getDriver;
import static utils.Helpers.prepareUrl;
import static utils.PropertiesLoader.BROWSER;

/**
 * class initiates application pages and contains common methods for application
 */
public class CosmosIDUI {
    //how to top test case execution if element not found testng!!

    static final Logger logger = LoggerFactory.getLogger(CosmosIDUI.class);
    private WebDriver driver;

    private LoginPage loginPage;

    private SignUpPage signUpPage;

    public CosmosIDUI() throws Exception {
        try {
            logger.info("New driver initialization");
            this.driver = getDriver(BROWSER);

            // var BROWSER is added to run config of the testNG.xml as env var (system wind var). Works only if run via testng.xml
           // this.driver = getDriver(System.getenv("BROWSER"));
            // property BROWSER is added to run config of the testNG.xml as VM options(java var). Works only if run via testng.xml
           //this.driver = getDriver(System.getProperty("BROWSER"));
        } catch (Exception e) {
            throw new Exception();
        }
    }


    /**
     * Method opens browser on start page (login page)
     */
    public void navigateToStartPage() {
        String url = prepareUrl(Urls.LOGIN_URL);
        driver.get(url);
    }


    /**
     * Method closes browser
     */
    public void closeApp() {
        driver.quit();
    }

    //implemented fluent interface
    public CosmosIDUI closePopupOnStart() {
        getLoginPage().clickDoNotShowAgainBtn();
        return this;
    }


    public void login(String username, String password) {
        getLoginPage().login(username, password);
    }


// init object when it's needed first time
    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }

    public SignUpPage getSignUpPage() {
        if (signUpPage == null) {
            signUpPage = new SignUpPage(driver);
        }
        return signUpPage;
    }

}



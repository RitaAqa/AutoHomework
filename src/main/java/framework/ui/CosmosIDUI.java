package framework.ui;

import framework.ui.pageobject.LoginPage;
import framework.ui.pageobject.SignUpPage;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;


import static utils.DriversProvider.getNewDriver;
import static utils.Helpers.prepareUrl;
import static utils.PropertiesLoader.BROWSER;

/**
 * class initiates application pages and contains common methods for application
 */
public class CosmosIDUI {

    static final Logger logger = Logger.getLogger(CosmosIDUI.class);

    public static WebDriver getDriver() {
        return driver;
    }

    private static WebDriver driver;

    private LoginPage loginPage;

    private SignUpPage signUpPage;

    public CosmosIDUI() throws Exception {
        try {
            logger.info("New driver initialization");
            this.driver = getNewDriver(BROWSER);
            // if property BROWSER is added to run config as VM options(java var) of executed file or passes through cmd -DBROWSER=chrome (e.g.)
            // this.driver = getNewDriver(System.getProperty("BROWSER"));
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


    //----------------------------------- pages initiation--------------------------------------------------------------

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


    //---------------------------------------------------------common methods-------------------------------------------


    // implemented fluent interface
    public CosmosIDUI closePopupOnStart() {
        getLoginPage().clickDoNotShowAgainBtn();
        return this;
    }

    public void login(String username, String password) {
        getLoginPage().login(username, password);
    }


}



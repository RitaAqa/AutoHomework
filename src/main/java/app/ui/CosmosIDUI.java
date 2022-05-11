package app.ui;

import app.ui.page_object.LoginPage;
import app.ui.page_object.SignUpPage;
import org.openqa.selenium.WebDriver;


import static utils.Helpers.prepareUrl;

/**
 * class initiates application pages and contains common methods for application
 */
public class CosmosIDUI {
    //how to top test case execution if element not found testng!!
    private WebDriver driver;
    public LoginPage loginPage;
    public SignUpPage signUpPage;
    public CosmosIDUI (WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
        signUpPage = new SignUpPage(driver);
    }


    /**
     * Method opens browser on start page (login page)
     */
    public void startApp() {
        String url = prepareUrl(Urls.LOGIN_URL);
        driver.get(url);
    }


    /**
     * Method closes browser
     */
    public void closeApp() {
        driver.quit();
    }

    public void closePopupOnStart() {
        loginPage.clickDoNotShowAgainBtn();
    }

    public void login(String username, String password) {
        loginPage.login(username, password);
    }



}



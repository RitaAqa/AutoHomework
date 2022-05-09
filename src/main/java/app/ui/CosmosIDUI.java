package app.ui;

import app.ui.page_object.LoginPage;
import app.ui.page_object.SignUpPage;
import org.openqa.selenium.WebDriver;

/**
 * class initiates application pages and contains common methods for application
 */
public class CosmosIDUI {

    private LoginPage loginPage;
    private SignUpPage signUpPage;
    public CosmosIDUI (WebDriver driver) {
        loginPage = new LoginPage(driver);
        signUpPage = new SignUpPage(driver);
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public SignUpPage getSignUpPage() {
        return signUpPage;
    }

    public void closePopupOnStart() {
        loginPage.clickDoNotShowAgainBtn();
    }

    public void login(String username, String password) {
        loginPage.login(username, password);
    }
}

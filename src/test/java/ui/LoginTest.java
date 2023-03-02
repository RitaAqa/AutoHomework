package ui;

import framework.ui.base.BaseTestUI;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.listeners.TestListener;

import static org.testng.Assert.*;

@Listeners({TestListener.class})


public class LoginTest extends BaseTestUI {
    @Test(groups = "loginTC", description = "Verify that login is failed")
    public void testLoginIsFailed1() {
        logger.info("Close popup on app start");
        logger.info("Login with invalid credentials");
        app.closePopupOnStart()
                .login("email@test.com", "passwordtest");
        logger.info("Check if an error message is displayed");
        assertTrue(app.getLoginPage().isLoginFailed(), "Error Login message is not displayed");
    }

    @Test(groups = "loginTC", description = "Verify that SignUp page is opened")
    public void testSignUpPageIsOpened() {
        logger.info("Close popup on app start");
        logger.info("Navigate to Sign Up page");
        app.closePopupOnStart()
                .getLoginPage()
                .navigateToSignUpPage();
        logger.info("Check if the Sign Up page is displayed");
        assertTrue(app.getSignUpPage().isSignUpPageDisplayed(), "Sign Up page is not displayed");
    }

}

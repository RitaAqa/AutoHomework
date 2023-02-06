package ui;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LoginTest extends BaseTestUI {

    @Test(description = "Verify that login is failed")
    public void testLoginIsFailed() {
        logger.info("Close popup on app start");
        logger.info("Login with invalid credentials");
        app.closePopupOnStart()
                .login("email@test.com", "passwordtest");
        logger.info("Check if an error message is displayed");
        assertTrue(app.getLoginPage().isLoginFailed(), "Error Login message is not displayed");
    }


    @Test(description = "Verify that SignUp page is opened")
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

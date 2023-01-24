package ui;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class LoginPageTest extends BaseTestUI {

    @Test(description = "Verify that login is failed")
    public void testLoginIsFailed()
    {
        logger.info("Close popup on app start");
        app.closePopupOnStart();
        logger.info("Login with invalid credentials");
        app.login("email@test.com" , "passwordtest");
        logger.info("Check if an error message is displayed");
        assertTrue(app.loginPage.isLoginFailed(), "Error Login message is not displayed");
    }


    @Test(description = "Verify that SignUp page is opened")
    public void testSignUpPageIsOpened()
    {
        logger.info("Close popup on app start");
        app.closePopupOnStart();
        logger.info("Navigate to Sign Up page");
        app.loginPage.navigateToSignUpPage();
        logger.info("Check if the Sign Up page is displayed");
        assertTrue(app.signUpPage.isSignUpPageDisplayed(), "Sign Up page is not displayed");
    }
}

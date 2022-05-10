package ui;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class LoginPageTest extends BaseTestUI {

    @Test(description = "Verify that login is failed")
    public void testLoginIsFailed()
    {
        app.closePopupOnStart();
        app.login("email@test.com" , "passwordtest");
        assertTrue(app.getLoginPage().isLoginFailed(), "Error Login message is not displayed");
    }

    @Test(description = "Verify that SignUp page is opened")
    public void testSignUpPageIsOpened()
    {
        app.closePopupOnStart();
        app.getLoginPage().navigateToSignUpPage();
        assertTrue(app.getSignUpPage().isSignUpPageDisplayed(), "Sign Up page is not displayed");
    }
}
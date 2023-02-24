package ui;

import framework.ui.BaseTestUI;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import framework.ui.utilsForUIOnly.listeners.MyITestListener;

import static org.testng.Assert.*;
@Listeners(MyITestListener.class)


public class LoginTest extends BaseTestUI {
/*


    @Test(description = "Verify that login is failed")
    public void testLoginIsFailed1() {
        System.out.println(System.getenv("BROWSER"));
        System.out.println(System.getProperty("BROWSER"));
        logger.info("Close popup on app start");
        logger.info("Login with invalid credentials");
        app.closePopupOnStart()
                .login("email@test.com", "passwordtest");
        logger.info("Check if an error message is displayed");
        assertTrue(app.getLoginPage().isLoginFailed(), "Error Login message is not displayed");
    }



    @Test(description = "Verify that SignUp page is opened")
    public void testSignUpPageIsOpened() {

     *//*   logger.trace("TRACE");
        logger.debug("DEBUG");
        logger.info("INFO");
        logger.warn("WARN");
        logger.error("ERROR");
        logger.fatal("FATAL");*//*

       logger.info("Close popup on app start");
        logger.info("Navigate to Sign Up page");
        app.closePopupOnStart()
                .getLoginPage()
                .navigateToSignUpPage();
        logger.info("Check if the Sign Up page is displayed");
        assertTrue(app.getSignUpPage().isSignUpPageDisplayed(), "Sign Up page is not displayed");
        //test.log(LogStatus.PASS, "Passed");
   }*/


    @Test (groups = "pass", description = "this is passed test")
    public void checkTCPass() {
        assertNull(null);
   }

    @Test (groups = "fail", description = "this is failed test")
    public void checkTCFail() {
        assertNull("dsd");
    }
    @Test (groups = "skipped")
    public void checkTCSkip() {
        throw new SkipException("skip");
    }
}

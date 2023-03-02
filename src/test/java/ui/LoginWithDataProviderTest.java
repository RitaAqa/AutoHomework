package ui;

import framework.datamodels.UserLoginData;
import framework.datamodels.UserLoginDataProvider;
import framework.ui.base.BaseTestUI;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.listeners.TestListener;

import static org.testng.Assert.assertTrue;

@Listeners(TestListener.class)


public class LoginWithDataProviderTest extends BaseTestUI {

    //test with data provider from code and file
    @Test(description = "Verify that login is failed", dataProvider = "users", dataProviderClass = UserLoginDataProvider.class)
    public void testLoginIsFailed2(UserLoginData userLoginData) {
        logger.info("Close popup on app start");
        logger.info("Login with invalid credentials");
        app.closePopupOnStart()
                .login(userLoginData.login, userLoginData.password);
        logger.info("Check if an error message is displayed");
        assertTrue(app.getLoginPage().isLoginFailed(), "Error Login message is not displayed");
    }
}

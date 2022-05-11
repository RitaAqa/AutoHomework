package ui;

import app.ui.CosmosIDUI;
import app.ui.page_object.BasePage;
import app.ui.utils.DriversProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

/**
 * Class contains instruction that should be executed before each test method
 */
public class BaseTestUI extends DriversProvider {
    static final Logger logger = LoggerFactory.getLogger(BasePage.class);
    CosmosIDUI app;

    @BeforeMethod(description = "Test setup")
    @Parameters("browser")
    public void setUp(String browser) {
        try {
            getDriver(browser);
        } catch (Exception e) {
            logger.error("Cannot get driver. Test cases are skipped");
            throw new SkipException("Testing is stopped");
        }
        app = new CosmosIDUI(driver);
        app.startApp();
    }

    @AfterMethod
    public void tearDown() {
        app.closeApp();
    }


}

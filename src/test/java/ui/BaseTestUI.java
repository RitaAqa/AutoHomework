package ui;

import framework.ui.CosmosIDUI;
import framework.ui.page_object.BasePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.SkipException;
import org.testng.annotations.*;

/**
 * Class contains instruction that should be executed before each test method
 */
public class BaseTestUI {
    static final Logger logger = LoggerFactory.getLogger(BasePage.class);
    protected static CosmosIDUI app;

    @BeforeTest(description = "Driver setup")
    public void startApp() {
        logger.info("Start application");
        try {
            app = new CosmosIDUI();
        } catch (Exception e) {
            logger.error("Cannot get driver. Test cases are skipped");
            throw new SkipException("Testing is stopped");
        }
    }


    //it might be not necessary for each test. Maybe wee are already located on necessary page/ Think about it
    @BeforeMethod(description = "Start application")
    public void goToStartPage() {
        logger.info("Go to start page");
        app.navigateToStartPage();
    }

    @AfterClass
    public void tearDown() {
        logger.info("Browser closed");
        app.closeApp();
    }


}

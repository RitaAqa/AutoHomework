package ui;

import app.ui.CosmosIDUI;
import app.ui.page_object.BasePage;
import app.ui.utils.DriverSetup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import static utils.PropertiesLoader.BROWSER;

/**
 * Class contains instruction that should be executed before each test method
 */
public class BaseTestUI extends DriverSetup {
    static final Logger logger = LoggerFactory.getLogger(BasePage.class);
    CosmosIDUI app;

    @BeforeMethod(description = "Test setup")
    @Parameters("browser")
    public void setUp(String browser) {
        try {
            setUpDriver(browser);
        } catch (Exception e) {
            logger.error("Cannot get driver. Test cases are skipped");
            throw new SkipException("Testing is stopped");
        }
        app = new CosmosIDUI(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}

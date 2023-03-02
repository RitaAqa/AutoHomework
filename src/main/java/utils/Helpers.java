package utils;

import framework.ui.CosmosIDUI;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static utils.PropertiesLoader.BASE_URL;

/**
 * Class contains different helpers
 */
public final class Helpers {

    static final Logger logger = Logger.getLogger(Helpers.class);

    /**
     * Method returns start URL
     *
     * @param relUrl - start endpoint
     * @return start URL
     */
    public static String prepareUrl(String relUrl) {
        URL mergedURL = null;
        try {
            mergedURL = new URL(new URL(BASE_URL), relUrl);
        } catch (MalformedURLException e) {
            throw new AssertionError("Cannot get Url");
        }
        return mergedURL.toString();
    }


    /**
     * Method takes screenshot
     *
     * @param methodName
     */
    public static void captureScreenshot(String methodName) {

        DateFormat dateFormat = new SimpleDateFormat("yyyy MM d");
        Calendar calendar = Calendar.getInstance();
        String currentDate = dateFormat.format(calendar.getTime());
        String fileName = methodName + ".png";
        String filePath = System.getProperty("user.dir") + File.separator + "target" + File.separator + "result" + File.separator;// + currentDate +  File.separator;

        try {
            File screenshot = ((TakesScreenshot) CosmosIDUI.getDriver()).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(screenshot, new File(filePath + fileName));
            logger.error("Screenshot is taken");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

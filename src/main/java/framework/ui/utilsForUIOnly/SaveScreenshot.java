package framework.ui.utilsForUIOnly;

import framework.ui.CosmosIDUI;
import framework.ui.utilsForUIOnly.listeners.MyITestListener;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SaveScreenshot {
    static final Logger logger = Logger.getLogger(MyITestListener.class);

    public static void captureScreenshot(String methodName) {

        DateFormat dateFormat = new SimpleDateFormat("yyyy MM d");
        Calendar calendar = Calendar.getInstance();
        String currentDate = dateFormat.format(calendar.getTime());
        String fileName = methodName + ".png";
        String filePath = System.getProperty("user.dir") +  File.separator + "target" +  File.separator + "result" +  File.separator;// + currentDate +  File.separator;

        try {
            File screenshot = ((TakesScreenshot) CosmosIDUI.getDriver()).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(screenshot, new File(filePath + fileName));
            logger.error("Screenshot is taken");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

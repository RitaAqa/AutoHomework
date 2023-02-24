package framework.ui.utilsForUIOnly.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.extentReport.ExtentManager;


import java.io.File;
import java.util.Arrays;

import static framework.ui.utilsForUIOnly.SaveScreenshot.captureScreenshot;

public class MyITestListener implements ITestListener{

    static final Logger logger = Logger.getLogger(MyITestListener.class);

    private static ExtentReports extent;
    private static ExtentTest test;


    @Override
    public void onTestStart(ITestResult result) {
        logger.info("New TC started " + result.getName());
        test = extent.createTest(result.getName());
        test.log(Status.INFO, result.getMethod().getMethodName());
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Test successfully finished " + result.getName());
        test.log(Status.PASS, result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
          String failedTest = result.getName();
        //refactor!!!
        String filePath = System.getProperty("user.dir") +  File.separator + "target" +  File.separator + "result" +  File.separator;// + currentDate +  File.separator;
        logger.error("Test " + failedTest + "was failed");
        captureScreenshot(failedTest);

        // add failed test info
        test //       .log(Status.FAIL, "test failed")
                .log(Status.FAIL, result.getThrowable())
                .addScreenCaptureFromPath(filePath + failedTest + ".png")
                .assignCategory(result.getMethod().getGroups())
                .info(result.getMethod().getDescription())
                .info(Arrays.toString(result.getMethod().getGroups()));
    }
    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn("Test was skipped " + result.getName());
        test.log(Status.SKIP, result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        logger.info("This is OnStart method "  + context.getOutputDirectory());
        extent = ExtentManager.getInstance();
    }
    @Override
    public void onFinish(ITestContext context) {
        logger.info("this is OnFinish method. Number of passed TCs: " + context.getPassedTests().getAllResults().size());
        logger.info("this is OnFinish method. Number of failed TCs: " + context.getFailedTests().getAllResults().size());
        extent.flush();
    }
}

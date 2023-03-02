package utils.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class creates extent report
 */
public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null)
            createInstance();

        return extent;
    }
    public static ExtentReports createInstance() {
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("MM_dd_yyyy");

        ExtentSparkReporter reporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/target/extent-reports/" + ft.format(dNow) + "_WEB_" + "testreport.html");
        //Set dashboard as default view of the report
        reporter.viewConfigurer().viewOrder().as(new ViewName[]{ViewName.DASHBOARD, ViewName.TEST, ViewName.CATEGORY, ViewName.EXCEPTION, ViewName.LOG});
        reporter.config().setReportName("AppName");
        reporter.config().setDocumentTitle("Acceptance Tests");
        reporter.config().setEncoding("utf-8");
        reporter.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(reporter);

        return extent;
    }
}

package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test =
            new ThreadLocal<ExtentTest>();

    public static synchronized void setupReport() {
        if (extent == null) {
            ExtentSparkReporter spark =
                    new ExtentSparkReporter(
                            "target/ExtentReport.html");

            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
    }

    public static void createTest(String name) {
        if (extent == null) {
            setupReport();
        }

        test.set(extent.createTest(name));
    }

    public static ExtentTest getTest() {
        return test.get();
    }

    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }

    public static void removeTest() {
        test.remove();
    }
}
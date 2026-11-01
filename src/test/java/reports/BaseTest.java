package reports;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

import reports.ExtentReportManager;
import reports.ReportUtils;

public class BaseTest {

    @BeforeSuite
    public void startReport() {
        ExtentReportManager.setupReport();
    }

    @BeforeMethod
    public void startTest() {
        String testName =
                org.testng.Reporter.getCurrentTestResult()
                        .getMethod().getMethodName();

        ExtentReportManager.createTest(testName);
        ReportUtils.info("Test execution started");
    }

    @AfterMethod
    public void finishTest(
            org.testng.ITestResult result) {

        if (result.getStatus() ==
                org.testng.ITestResult.SUCCESS) {
            ReportUtils.pass("Test passed");
        } else if (result.getStatus() ==
                org.testng.ITestResult.FAILURE) {
            ReportUtils.fail(
                    "Test failed: "
                            + result.getThrowable());
        } else {
            ReportUtils.skip("Test skipped");
        }

        ExtentReportManager.removeTest();
    }

    @AfterSuite
    public void finishReport() {
        ExtentReportManager.flushReport();
    }
}
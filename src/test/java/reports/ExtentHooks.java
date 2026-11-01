package reports;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import reports.ExtentReportManager;

public class ExtentHooks {

    @Before(order = 0)
    public void startReport(Scenario scenario) {
        ExtentReportManager.setupReport();
        ExtentReportManager.createTest(
                scenario.getName());
    }

    @After
    public void finishReport(Scenario scenario) {
        try {
            if (scenario.isFailed()) {
                ExtentReportManager.getTest()
                        .fail("Scenario failed: "
                                + scenario.getName());
            }
        } finally {
            ExtentReportManager.removeTest();
            ExtentReportManager.flushReport();
        }
    }
}

package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import utilities.DriverFactory;

public class Hooks {

    @Before
    public void setUp() {
        DriverFactory.getDriver();
    }

    @After
    public void tearDown(Scenario scenario) {

        WebDriver driver = DriverFactory.getDriver();

        try {
            if (scenario.isFailed() && driver != null) {

                byte[] screenshot =
                        ((TakesScreenshot) driver)
                                .getScreenshotAs(OutputType.BYTES);

                scenario.attach(
                        screenshot,
                        "image/png",
                        "Failure Screenshot"
                );
            }

        } catch (Exception e) {
            System.out.println(
                    "Screenshot capture failed: " + e.getMessage()
            );

        } finally {
            DriverFactory.quitDriver();
        }
    }
}

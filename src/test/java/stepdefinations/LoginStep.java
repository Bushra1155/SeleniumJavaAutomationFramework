package stepdefinations;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.LoginPage;
import reports.ReportUtils;
import utilities.ActionsUtils;

import javax.swing.text.Utilities;
import java.io.IOException;

public class LoginStep {
   LoginPage lp=new LoginPage();

    WebDriver driver;
    @Before
    public void beforeScenario() {
        System.out.println("***** STEP CLASS LOADED *****");
    }
    @Given("User launches Chrome browser")
    public void user_launches_chrome_browser() {
      lp.openBrowser();
        ReportUtils.info("Chrome open");

    }

    @When("User opens Flipkart website")
    public void user_opens_flipkart_website() throws IOException {
    lp.openFlipkart();
        ReportUtils.pass("Flipkart open");

    }

    @Then("Flipkart homepage should be displayed")
    public void flipkart_homepage_should_be_displayed() {

        lp.titleFlipkart();
        ReportUtils.pass("Completed");
    }
}
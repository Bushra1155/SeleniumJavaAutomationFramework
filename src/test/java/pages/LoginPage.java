package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import reports.ReportUtils;
import utilities.CommanMethods;

import java.io.IOException;

public class LoginPage  {

    WebDriver driver;




    public void openBrowser(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();


        System.out.println("Chrome Browser Launched");

    }
    public void openFlipkart() throws IOException {
        driver.get("https://www.flipkart.com");
        CommanMethods.captureScreenshot(driver,"Bushra");



        System.out.println("Flipkart Opened");

    }
    public void titleFlipkart(){
        String actualTitle = driver.getTitle();

        System.out.println("Title : " + actualTitle);

        Assert.assertTrue(actualTitle.contains("Online Shopping"));


        driver.quit();
    }
}

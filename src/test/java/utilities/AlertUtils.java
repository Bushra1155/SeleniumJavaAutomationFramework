package utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class AlertUtils {

    public String getAlertText(WebDriver driver) {
        return driver.switchTo().alert().getText();
    }

    public void acceptAlert(WebDriver driver) {
        driver.switchTo().alert().accept();
    }

    public void dismissAlert(WebDriver driver) {
        driver.switchTo().alert().dismiss();
    }

    public void enterAlertText(
            WebDriver driver, String text) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
    }
}
package utilities;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class WaitUtils {

    private WebDriver driver;
    private WebDriverWait wait;

    public WaitUtils(WebDriver driver, int timeout) {
        this.driver = driver;
        this.wait = new WebDriverWait(
                driver, Duration.ofSeconds(timeout));
    }

    public WebElement waitForVisible(By locator) {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForClickable(By locator) {
        return wait.until(
                ExpectedConditions.elementToBeClickable(locator));
    }

    public boolean waitForInvisible(By locator) {
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public boolean waitForTitle(String title) {
        return wait.until(
                ExpectedConditions.titleContains(title));
    }

    public boolean waitForUrl(String url) {
        return wait.until(
                ExpectedConditions.urlContains(url));
    }

    public boolean waitForText(By locator, String text) {
        return wait.until(
                ExpectedConditions.textToBePresentInElementLocated(
                        locator, text));
    }

    public boolean waitForAlert() {
        return wait.until(
                ExpectedConditions.alertIsPresent()) != null;
    }
}
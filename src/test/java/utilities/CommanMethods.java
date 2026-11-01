package utilities;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

public class CommanMethods {


    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;
    private Actions actions;


    public CommanMethods(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
        this.js = (JavascriptExecutor) driver;
    }

    public CommanMethods(WebDriver driver, int timeout) {
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

    public void selectByVisibleText(
            WebDriver driver, By locator, String text) {
        new Select(driver.findElement(locator))
                .selectByVisibleText(text);
    }

    public void selectByValue(
            WebDriver driver, By locator, String value) {
        new Select(driver.findElement(locator))
                .selectByValue(value);
    }

    public void selectByIndex(
            WebDriver driver, By locator, int index) {
        new Select(driver.findElement(locator))
                .selectByIndex(index);
    }

    public String getSelectedOption(
            WebDriver driver, By locator) {
        return new Select(driver.findElement(locator))
                .getFirstSelectedOption().getText();
    }

    public List<WebElement> getAllOptions(
            WebDriver driver, By locator) {
        return new Select(driver.findElement(locator))
                .getOptions();
    }

    public boolean isMultiple(
            WebDriver driver, By locator) {
        return new Select(driver.findElement(locator))
                .isMultiple();
    }

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

    public void switchToFrame(
            WebDriver driver, By locator) {
        driver.switchTo().frame(driver.findElement(locator));
    }

    public void switchToFrame(
            WebDriver driver, int index) {
        driver.switchTo().frame(index);
    }

    public void switchToParentFrame(WebDriver driver) {
        driver.switchTo().parentFrame();
    }

    public void switchToDefaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();
    }
    public void switchToWindow(
            WebDriver driver, String handle) {
        driver.switchTo().window(handle);
    }

    public void closeCurrentWindow(WebDriver driver) {
        driver.close();
    }

    public void switchToMainWindow(
            WebDriver driver, String mainWindow) {
        driver.switchTo().window(mainWindow);
    }

    public int getWindowCount(WebDriver driver) {
        return driver.getWindowHandles().size();
    }
    public void hover(By locator) {
        actions.moveToElement(
                driver.findElement(locator)).perform();
    }

    public void doubleClick(By locator) {
        actions.doubleClick(
                driver.findElement(locator)).perform();
    }

    public void rightClick(By locator) {
        actions.contextClick(
                driver.findElement(locator)).perform();
    }

    public void dragAndDrop(By source, By target) {
        actions.dragAndDrop(
                driver.findElement(source),
                driver.findElement(target)).perform();
    }

    public void clickAndHold(By locator) {
        actions.clickAndHold(
                driver.findElement(locator)).perform();
    }

    public void release(By locator) {
        actions.release(
                driver.findElement(locator)).perform();
    }

    public void pressKey(CharSequence key) {
        actions.sendKeys(key).perform();
    }

    public void moveToOffset(By locator, int x, int y) {
        actions.moveToElement(
                driver.findElement(locator), x, y).perform();
    }
    public void clickElement(WebElement element) {
        js.executeScript("arguments[0].click();", element);
    }

    public void enterText(
            WebElement element, String text) {
        js.executeScript(
                "arguments[0].value = arguments[1];",
                element, text);
    }

    public String getPageTitle() {
        return (String) js.executeScript(
                "return document.title;");
    }

    public String getPageUrl() {
        return (String) js.executeScript(
                "return window.location.href;");
    }

    public void refreshPage() {
        js.executeScript("history.go(0);");
    }

    public void scrollToBottom() {
        js.executeScript(
                "window.scrollTo(0, document.body.scrollHeight);");
    }

    public void scrollToTop() {
        js.executeScript("window.scrollTo(0, 0);");
    }

    public void scrollIntoView(WebElement element) {
        js.executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                element);
    }

    public Object executeScript(String script) {
        return js.executeScript(script);
    }
    public void scrollBy(
            WebDriver driver, int x, int y) {
        ((JavascriptExecutor) driver).executeScript(
                "window.scrollBy(arguments[0], arguments[1]);",
                x, y);
    }

    public void scrollToElement(
            WebDriver driver, By locator) {
        WebElement element = driver.findElement(locator);

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(true);", element);
    }
    public static String captureScreenshot(
            WebDriver driver, String testName)
            throws IOException {

            String timestamp = LocalDateTime.now().format(
                    DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

            Path directory = Paths.get(
                    "target", "screenshots").toAbsolutePath();

            Files.createDirectories(directory);

            Path destination = directory.resolve(
                    testName + "_" + timestamp + ".png");

            File source = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            Files.copy(source.toPath(), destination,
                    StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Screenshot saved at: " + destination);

            return destination.toString();
        }
    }



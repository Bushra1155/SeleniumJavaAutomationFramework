package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import utilities.WaitUtils;

public class ElementUtils {

    private WebDriver driver;
    private WaitUtils wait;

    public ElementUtils(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver, 10);
    }

    public void click(By locator) {
        wait.waitForClickable(locator).click();
    }

    public void enterText(By locator, String text) {
        WebElement element = wait.waitForVisible(locator);
        element.clear();
        element.sendKeys(text);
    }

    public String getText(By locator) {
        return wait.waitForVisible(locator).getText();
    }

    public String getAttribute(By locator, String attribute) {
        return wait.waitForVisible(locator)
                .getAttribute(attribute);
    }

    public boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        } catch (StaleElementReferenceException e) {
            return false;
        }
    }

    public boolean isEnabled(By locator) {
        return wait.waitForVisible(locator).isEnabled();
    }

    public boolean isSelected(By locator) {
        return driver.findElement(locator).isSelected();
    }

    public void clearText(By locator) {
        wait.waitForVisible(locator).clear();
    }

    public void submit(By locator) {
        wait.waitForVisible(locator).submit();
    }

    public int getElementCount(By locator) {
        return driver.findElements(locator).size();
    }
}
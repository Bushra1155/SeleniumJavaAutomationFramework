package utilities;

import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class DropdownUtils {

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
}
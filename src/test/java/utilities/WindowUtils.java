package utilities;

import java.util.Set;
import org.openqa.selenium.WebDriver;

public class WindowUtils {

    public void switchToNewWindow(WebDriver driver) {
        String current = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();

        for (String handle : handles) {
            if (!handle.equals(current)) {
                driver.switchTo().window(handle);
                return;
            }
        }

        throw new IllegalStateException("No new window found");
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
}
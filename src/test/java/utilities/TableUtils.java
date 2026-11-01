package utilities;

import java.util.List;
import org.openqa.selenium.*;

public class TableUtils {

    public int getRowCount(
            WebDriver driver, By rowsLocator) {
        return driver.findElements(rowsLocator).size();
    }

    public int getColumnCount(
            WebDriver driver, By firstRowCellsLocator) {
        return driver.findElements(
                firstRowCellsLocator).size();
    }

    public String getCellText(
            WebDriver driver, By tableLocator,
            int row, int column) {

        WebElement table = driver.findElement(tableLocator);

        List<WebElement> rows =
                table.findElements(By.tagName("tr"));

        return rows.get(row)
                .findElements(By.xpath("./th | ./td"))
                .get(column).getText();
    }

    public boolean containsText(
            WebDriver driver, By tableLocator,
            String expectedText) {

        return driver.findElement(tableLocator)
                .getText().contains(expectedText);
    }
}
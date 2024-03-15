package util;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import static ge.tbcitacademy.data.Constants.*;
import java.util.List;

public class HelperFunctions {
    public static boolean hasAttributeWithValue(WebElement element, String attributeName, String expectedValue) {
        String value = element.getAttribute(attributeName);
        return value != null && value.equalsIgnoreCase(expectedValue);
    }

    public static void universalSelector(Object element, String visibleText) {
        if(element instanceof Select) {
            ((Select) element).selectByVisibleText(visibleText);
        } else if (element instanceof WebElement) {
            String xPath = String.format("//*[text()='%s']", visibleText);
            WebElement anchorElem = ((WebElement) element).findElement(By.xpath(xPath));
            anchorElem.click();
        } else {
            throw new IllegalArgumentException(UNSUPPORTED_ELEMENT_TYPE_MESSAGE);
        }
    }

    public static WebElement getElementFromTable(WebElement table, String tableRow, String tableColumnHeader) {
        int indexHeader = -1;
        int indexRow = -1;
        List<WebElement> tableRowElements;
        List<WebElement> tableHeaders;
        List<WebElement> tableFooterElements = table.findElements(By.tagName("tfoot"));
        tableRowElements = table.findElements(By.xpath(".//tbody//tr"));

        if (table.findElements(By.tagName("thead")).isEmpty()) {
            tableHeaders = table.findElements(By.tagName("th"));
        } else {
            tableHeaders = table.findElements(By.xpath(".//thead//th"));
        }
        if (!tableFooterElements.isEmpty()) {
            tableRowElements.addAll(tableFooterElements);
        }
        for (int i = 0; i < tableHeaders.size(); i++) {
            if (tableHeaders.get(i).getText().equals(tableColumnHeader.trim())) {
                indexHeader = i;
                break;
            }
        }
        for (int j = 0; j < tableRowElements.size(); j++) {
            if (tableRowElements.get(j).getText().contains(tableRow.trim())) {
                indexRow = j;
                break;
            }
        }
        if (indexHeader == -1 && tableColumnHeader.trim().isEmpty()) {
            return tableRowElements.get(indexRow).findElement(By.tagName("td"));
        } else if (indexHeader != -1 && indexRow != -1) {
            return tableRowElements.get(indexRow).findElement(By.xpath("*[position()=" + (indexHeader + 1) + "]"));
        } else if (indexRow == -1) {
            throw new NoSuchElementException("Table row not found: " + tableRow);
        } else {
            throw new NoSuchElementException("Table column header not found: " + tableColumnHeader);
        }
    }
};
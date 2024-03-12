package util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import static ge.tbcitacademy.data.Constants.*;

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
        System.out.println("I AM A FIX");
        System.out.println("I AM A CHANGE MEANWHILE");
        System.out.println("NO CONFLICT PLS LETS BE FRIENDS :)");
    }
}

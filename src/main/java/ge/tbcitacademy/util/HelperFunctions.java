package ge.tbcitacademy.util;
import org.openqa.selenium.WebElement;

public class HelperFunctions {
    public static boolean hasAttributeWithValue(WebElement element, String attributeName, String expectedValue) {
        String value = element.getAttribute(attributeName);
        return value != null && value.equalsIgnoreCase(expectedValue);
    }
}

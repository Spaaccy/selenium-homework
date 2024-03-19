import baseConfig.BaseClassCrossBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.List;
import static ge.tbcitacademy.data.Constants.*;


public class JSexecutor extends BaseClassCrossBrowser {
    @Test(priority = 1)
    public void deleteTest() {
        driver.get(TODO_LIST_URL);
        WebElement deleteMagic = driver.findElement(By.xpath(".//li[normalize-space(text()) = 'Practice magic']/span"));
        WebElement magicElement = driver.findElement(By.xpath(".//li[normalize-space(text()) = 'Practice magic']"));
        action.moveToElement(magicElement).build().perform();
        js.executeScript(CLICK_THE_ELEMENT, deleteMagic);
//        waitLong.until(ExpectedConditions.stalenessOf(magicElement));
        waitLong.until(ExpectedConditions.invisibilityOf(magicElement));
        try {
            driver.findElement(By.xpath(".//li[normalize-space(text()) = 'Practice magic']"));
            Assert.fail(ELEMENT_UNEXPECTEDLY_FOUND_MSG);
        } catch (NoSuchElementException e) {
            Assert.assertTrue(true, ELEMENT_DELETED_SUCCESS_MSG);
        }
    }
    @Test(priority = 2)
    public void scrollTest() {
        driver.get(TECHLISTIC_TABLE_URL);
//        waitLong.until(ExpectedConditions.jsReturnsValue("return document.readyState == 'complete'"));
        List<WebElement> headingExamples = driver.findElements(By.xpath(CODE_EXAMPLE_XPATH + "//preceding::h3[not(@class='title')]/span//parent::h3"));
        List<WebElement> codeExamples = driver.findElements(By.xpath(CODE_EXAMPLE_XPATH));
        HashMap<String, String> codePairs = new HashMap<>();

        for (int i = 0; i < headingExamples.size() && i < codeExamples.size(); i++) {
            codePairs.put(headingExamples.get(i).getText(), codeExamples.get(i).getText());
            js.executeScript(SCROLL_TO_ELEMENT, codeExamples.get(i));
        }
        Assert.assertEquals(codePairs.size(), EXPECTED_CODE_PAIR_COUNT);

        WebElement popTutTitle = driver.findElement(By.xpath(".//span[contains(text(), 'Popular Tutorials')]"));
        List<WebElement> popTutLinks = driver.findElements(By.xpath(".//a[contains(text(), 'Appium Tutorial')]//ancestor::ul//li//a"));

        js.executeScript(SCROLL_TO_ELEMENT, popTutTitle);
        HashMap<String, String> popTutPairsMap = new HashMap<>();
        for (WebElement popTutPair : popTutLinks) {
            String anchorText = popTutPair.getText();
            String anchorHref = popTutPair.getAttribute(HREF_ATTRIBUTE);
            popTutPairsMap.put(anchorText, anchorHref);
        }
        js.executeScript(SCROLL_TO_ELEMENT_CUSTOM);
    }
    @Test(priority = 3)
    public void anotherScrollTest() {
        driver.get(SCROLLING_PRACTICE_URL);

        WebElement entriesElement = driver.findElement(By.id("zone2"));
        js.executeScript(SCROLL_TO_ELEMENT, entriesElement);

        String entriesDisplayText = (String) js.executeScript(GET_ELEMENT_INNER_TEXT, entriesElement);
        Assert.assertEquals(entriesDisplayText.trim(), EXPECTED_ENTRIES_TEXT);
    }

}

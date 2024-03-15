import baseConfig.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import static ge.tbcitacademy.data.Constants.*;

public class JSexecutor extends BaseClass {
    @Test(priority = 1)
    public void deleteTest() {
        driver.get(TODO_LIST_URL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT_SECONDS_MEDIUM));
        WebElement deleteMagic = driver.findElement(By.xpath(".//li[normalize-space(text()) = 'Practice magic']/span"));
        WebElement magicElement = driver.findElement(By.xpath(".//li[normalize-space(text()) = 'Practice magic']"));
        action.moveToElement(magicElement).build().perform();

        js.executeScript(CLICK_THE_ELEMENT, deleteMagic);
        wait.until(ExpectedConditions.stalenessOf(magicElement));
//        wait.until(ExpectedConditions.invisibilityOf(magicElement));
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
        WebElement codeExample1 = driver.findElement(By.xpath(".//span[text()='html']/parent::div/parent::div[@class='bg-black rounded-md mb-4']"));
        WebElement codeExampleHeading1 = driver.findElement(By.xpath(".//span[contains(text(), 'HTML Tags for Table')]"));
//        WebElement codeExampleHeading1 = codeExample1.findElement(By.xpath(".//ancestor::span//parent::div//preceding-sibling::h3"));
        js.executeScript(SCROLL_TO_ELEMENT, codeExample1);

        WebElement codeExample2 = driver.findElement(By.xpath(".//span[text()='Table']/ancestor::div[contains(@style, 'background:#fff')]"));
        WebElement codeExampleHeading2 = driver.findElement(By.xpath(".//span[contains(text(), '3.1. Practice Exercises')]"));
//        WebElement codeExampleHeading2 = codeExample2.findElement(By.xpath(".//parent::div//preceding-sibling::h3"));
        js.executeScript(SCROLL_TO_ELEMENT, codeExample2);

        WebElement codeExample3 = driver.findElement(By.xpath(".//span[text()='StructureValuesVerification']/ancestor::div[contains(@class, 'p-4')]"));
        WebElement codeExampleHeading3 = driver.findElement(By.xpath(".//span[contains(text(), '4.1. Practice Exercise:')]/parent::h3"));
//        WebElement codeExampleHeading3 = codeExample3.findElement(By.xpath(".//ancestor::div[@style='text-align:left']/h3"));
        js.executeScript(SCROLL_TO_ELEMENT, codeExample3);

        WebElement codeExample4 = driver.findElement(By.xpath(".//span[text()='BurjKhalifaHeightVerification']/ancestor::div[contains(@class, 'p-4')]"));
        WebElement codeExampleHeading4 = driver.findElement(By.xpath(".//span[contains(text(), '4.2. Practice Exercise:')]/parent::h3"));
        js.executeScript(SCROLL_TO_ELEMENT, codeExample4);

        WebElement codeExample5 = driver.findElement(By.xpath(".//span[text()='python']/parent::div/following-sibling::div[contains(@class, 'p-4')]"));
        WebElement codeExampleHeading5 = driver.findElement(By.xpath(".//b[contains(text(), 'Solution Code (Python):')]"));
        js.executeScript(SCROLL_TO_ELEMENT, codeExample5);

        WebElement codeExample6 = driver.findElement(By.xpath(".//span[text()='LastRowVerification']/ancestor::div[contains(@class, 'p-4')]"));
        WebElement codeExampleHeading6 = driver.findElement(By.xpath(".//span[contains(text(), '4.3. Practice Exercise:')]/parent::h3"));
        js.executeScript(SCROLL_TO_ELEMENT, codeExample6);

        WebElement codeExample7 = driver.findElement(By.xpath(".//span[text()='TallestStructureFinder']/ancestor::div[contains(@class, 'p-4')]"));
        WebElement codeExampleHeading7 = driver.findElement(By.xpath(".//span[contains(text(), '4.4. Practice Exercise:')]/parent::h3"));
        js.executeScript(SCROLL_TO_ELEMENT, codeExample7);

        WebElement codeExample8 = driver.findElement(By.xpath(".//span[text()='DynamicTable']/ancestor::div[contains(@style, 'background:#fff')]"));
        WebElement codeExampleHeading8 = driver.findElement(By.xpath(".//span[contains(text(), '4.5. Practice Exercise:')]/parent::h3"));
        js.executeScript(SCROLL_TO_ELEMENT, codeExample8);

        HashMap<String, String> codePairs = new HashMap<>();
        codePairs.put(codeExampleHeading1.getText(), codeExample1.getText());
        codePairs.put(codeExampleHeading2.getText(), codeExample2.getText());
        codePairs.put(codeExampleHeading3.getText(), codeExample3.getText());
        codePairs.put(codeExampleHeading4.getText(), codeExample4.getText());
        codePairs.put(codeExampleHeading5.getText(), codeExample5.getText());
        codePairs.put(codeExampleHeading6.getText(), codeExample6.getText());
        codePairs.put(codeExampleHeading7.getText(), codeExample7.getText());
        codePairs.put(codeExampleHeading8.getText(), codeExample8.getText());
        Assert.assertEquals(codePairs.size(), EXPECTED_CODE_PAIR_COUNT);

        codePairs.forEach((key, val) -> {
            System.out.println(key + "\n" + val);
        });

        WebElement popTutTitle = driver.findElement(By.xpath(".//span[contains(text(), 'Popular Tutorials')]"));
        List<WebElement> popTutLinks = driver.findElements(By.xpath(".//a[contains(text(), 'Appium Tutorial')]//ancestor::ul//li//a"));

        js.executeScript(SCROLL_TO_ELEMENT, popTutTitle);

        HashMap<String, String> popTutPairsMap = new HashMap<>();
        for (WebElement popTutPair : popTutLinks) {
            String anchorText = popTutPair.getText();
            String anchorHref = popTutPair.getAttribute("href");
            popTutPairsMap.put(anchorText, anchorHref);
        }
        popTutPairsMap.forEach((key, val) -> {
            System.out.println(key + "\n" + val);
        });

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

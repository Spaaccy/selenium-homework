import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.List;
import java.util.stream.IntStream;
import static ge.tbcitacademy.data.Constants.*;

@SuppressWarnings("SpellCheckingInspection")
public class LocatorsTest {
    WebDriver driver;
    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void unorderedListTest() {
        driver.get(JQUERY_UI_SLIDER_URL);
        WebElement asideElem = driver.findElement(By.xpath(ASIDE_XPATH_BASE));
        List<WebElement> liElements = asideElem.findElements(By.xpath(LIST_ITEM_XPATH));
        List<WebElement> filteredLiElements = liElements.stream().filter(webElement -> webElement.getText().toLowerCase().contains(FILTER_KEYWORD)).toList();
        filteredLiElements.parallelStream().forEach(listItem -> {
            WebElement anchorElement = listItem.findElement(By.tagName(ANCHOR_TAG));
            String anchorHref = anchorElement.getAttribute(HREF_ATTRIBUTE);
            if (!anchorHref.toLowerCase().contains(EXCLUDED_URL_KEYWORD)) {
                System.out.println(anchorHref);
            }
        });
    }
    @Test
    public void buttonsTest() throws InterruptedException {
        driver.get(ADD_REMOVE_ELEMENTS_URL);
        WebElement addButton = driver.findElement(By.xpath(ADD_BUTTON_XPATH));
        IntStream.range(0, CLICK_BUTTON_AMOUNT).forEach(i -> addButton.click());
        // მაინც იყოს :დ
        Thread.sleep(BUTTONS_TEST_SLEEP_MILISEC);

//        რადგან waits არვიცით არვარ დარწუმებული ამიტომ ჯერ უბრალოდ დავაკომენტარე
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement lastBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button.added-manually:last-of-type")));
//        List<WebElement> deleteBtns = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("button[class^='added-manually']")));

        WebElement deleteBtn = driver.findElement(By.cssSelector(LAST_DELETE_BTN_CSS_PATH));
        String lastDeleteBtnClass = deleteBtn.getAttribute(CLASS_ATTRIBUTE);
        Assert.assertEquals(lastDeleteBtnClass, ADDED_MANUALLY_CLASS, DELETE_BUTTON_ERROR_MESSAGE);

        List<WebElement> deleteBtns = driver.findElements(By.cssSelector(DELETE_BTNS_CSS_PATH));
        WebElement lastDeleteBtn = deleteBtns.get(deleteBtns.size() - 1);
        String lastDeleteBtnAttr = lastDeleteBtn.getAttribute(DELETE_BUTTON_ONCLICK_ATTRIBUTE);
        Assert.assertEquals(lastDeleteBtnAttr, EXPECTED_DELETE_BUTTON_ONCLICK, DELETE_BUTTON_ONCLICK_ERROR_MESSAGE);
    }
    @Test
    public void challengingDomTest() {
        driver.get(CHALLENGING_DOM_URL);
        String loremValueHardCodedIndex1 = driver.findElement(By.xpath(LOREM_VALUE_1_XPATH)).getText();
        String loremValueHardCodedIndex2 = driver.findElement(By.xpath(LOREM_VALUE_2_XPATH)).getText();

        List<WebElement> tableRows = driver.findElements(By.xpath(TABLE_ROWS_XPATH));

        int rowIndex = -1;
        int cellIndex = -1;

        for (int i = 0; i < tableRows.size(); i++) {
            List<WebElement> cells = tableRows.get(i).findElements(By.xpath(CELL_XPATH));
            for (int j = 0; j < cells.size(); j++) {
                if (cells.get(j).getText().equals(TARGET_CELL_TEXT)) {
                    rowIndex = i + 1;
                    cellIndex = j + 1;
                    break;
                }
            }
            if (rowIndex != -1) {
                break;
            }
        }
            String targetCellPath = String.format("//tbody/tr[%s]/td[%s]", rowIndex, cellIndex);
            WebElement IpsumValueDynamicCodedIndex = driver.findElement(By.xpath(targetCellPath));
            WebElement loremValueDynamicCodedIndex = IpsumValueDynamicCodedIndex.findElement(By.xpath(PRECEDING_SIBLING_TD_XPATH));
            String loremValueDynamicCodedIndexFinal = loremValueDynamicCodedIndex.getText();

            Assert.assertEquals(loremValueHardCodedIndex1, TARGET_LOREM_TEXT, TARGET_LOREM_TEXT_ERROR_MESSAGE);
            Assert.assertEquals(loremValueHardCodedIndex2, TARGET_LOREM_TEXT, TARGET_LOREM_TEXT_ERROR_MESSAGE);
            Assert.assertEquals(loremValueDynamicCodedIndexFinal, TARGET_LOREM_TEXT, TARGET_LOREM_TEXT_ERROR_MESSAGE);
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

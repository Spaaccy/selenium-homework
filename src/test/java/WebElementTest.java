import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.Objects;
import static ge.tbcitacademy.data.Constants.DRAG_AND_DROP_URL;
import static ge.tbcitacademy.util.HelperFunctions.hasAttributeWithValue;

public class WebElementTest {
    WebDriver driver;
    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(DRAG_AND_DROP_URL);
    }
    @AfterClass
    // სელენიუმის დომენტაციიდან: Important note: the quit method is different from the close method, and it is recommended to always use quit to end the session
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void dimensionsTest() {
       WebElement colA = driver.findElement(By.id("column-a"));
       WebElement colB = driver.findElement(By.id("column-b"));
       int colApositionY = colA.getLocation().getY();
       int colBpositionY = colB.getLocation().getY();

       System.out.println(Objects.equals(colApositionY, colBpositionY));
       System.out.println(hasAttributeWithValue(colA, "draggable", "true"));
       System.out.println(hasAttributeWithValue(colB, "draggable", "true"));

       Assert.assertEquals(colApositionY, colBpositionY, "Column A and Column B should have the same Y position.");
       Assert.assertTrue(hasAttributeWithValue(colA, "draggable", "true"), "colA attribute 'draggable' isn't true");
       Assert.assertTrue(hasAttributeWithValue(colB, "draggable", "true"), "colB attribute 'draggable' isn't true");
       // შეიძლება რო დავწეროთ პირდაპირ getAttribute() მაგრამ ვფიქრობ უკეთესია თუ გავიტანთ ცალკე helper ფუნქციაში
    }
    @Test
    public void linkTest() {
        WebElement elementalLink = driver.findElement(By.xpath("//*[@id=\"page-footer\"]/div/div/a"));

        System.out.println(Objects.equals(elementalLink.getAttribute("href"), "http://elementalselenium.com/"));
        Assert.assertEquals(elementalLink.getAttribute("href"), "http://elementalselenium.com/", "Elemental Selenium link should have the correct href value.");
    }
}

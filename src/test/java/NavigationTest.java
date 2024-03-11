import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.Objects;
import static ge.tbcitacademy.data.Constants.*;

public class NavigationTest {
    WebDriver driver;
    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(AUTOMATION_URL);
    }
    @AfterClass
    // სელენიუმის დომენტაციიდან: Important note: the quit method is different from the close method, and it is recommended to always use quit to end the session
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void goToSuccessStoriesAndBack() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT_SECONDS_MEDIUM));
        WebElement successStoryLink = driver.findElement(By.xpath("//*[@id=\"menu-item-218098\"]/a"));
        successStoryLink.click();
        wait.until(ExpectedConditions.urlToBe("https://ultimateqa.com/testimonials/"));

        System.out.println(Objects.equals(driver.getCurrentUrl(), "https://ultimateqa.com/testimonials/"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://ultimateqa.com/testimonials/");

        driver.navigate().back();
        wait.until(ExpectedConditions.urlToBe(AUTOMATION_URL));

        System.out.println(Objects.equals(driver.getCurrentUrl(), "https://ultimateqa.com/automation"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://ultimateqa.com/automation");
    }
}

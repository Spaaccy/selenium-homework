package baseConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.time.Duration;
import static ge.tbcitacademy.data.Constants.*;

public class BaseClass {
    protected WebDriver driver;
    protected JavascriptExecutor js;
    protected Actions action;
    protected WebDriverWait waitLong;
    protected WebDriverWait superShortWaitMed;
    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("src/main/resources/adblock.crx"));
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        action = new Actions(driver);
        js = (JavascriptExecutor) driver;
        waitLong = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT_SECONDS_LONG));
        superShortWaitMed = new WebDriverWait(driver, Duration.ofMillis(DEFAULT_TIMEOUT_MILISEC_MEDIUM));
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}

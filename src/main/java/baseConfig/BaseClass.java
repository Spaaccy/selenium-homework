package baseConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.io.File;

public class BaseClass {
    protected WebDriver driver;
    protected JavascriptExecutor js;
    protected Actions action;
    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("src/main/resources/adblock.crx"));
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        action = new Actions(driver);
        js = (JavascriptExecutor) driver;
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}

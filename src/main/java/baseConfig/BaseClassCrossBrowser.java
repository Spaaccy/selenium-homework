package baseConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.io.File;
import java.time.Duration;
import static ge.tbcitacademy.data.Constants.*;

public class BaseClassCrossBrowser {
    protected WebDriver driver;
    protected JavascriptExecutor js;
    protected Actions action;
    protected WebDriverWait waitLong;
    protected WebDriverWait superShortWaitMed;

    @BeforeClass
    @Parameters("browser")
    public void setUp(String browser) {
        if (browser.equalsIgnoreCase(BROWSER_CHROME)){
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addExtensions(new File("src/main/resources/adblock.crx"));
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase(BROWSER_EDGE)){
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();
            options.addExtensions(new File("src/main/resources/adblock.crx"));
            driver = new EdgeDriver(options);
        } else if (browser.equalsIgnoreCase(BROWSER_FIREFOX)){
              WebDriverManager.firefoxdriver().setup();
              FirefoxProfile profile = new FirefoxProfile(new File("src/main/resources/firefox"));
              FirefoxOptions options = new FirefoxOptions();
              options.setProfile(profile);
              driver = new FirefoxDriver(options);
        } else {
            throw new IllegalArgumentException(INVALID_BROWSER_MESSAGE);
        }
        waitLong = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT_SECONDS_LONG));
        superShortWaitMed = new WebDriverWait(driver, Duration.ofMillis(DEFAULT_TIMEOUT_MILISEC_MEDIUM));
        action = new Actions(driver);
        js = (JavascriptExecutor) driver;
    }
    @AfterClass
    public void teardown() {
        driver.quit();
    }
}

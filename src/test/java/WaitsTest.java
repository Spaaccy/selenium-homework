import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.File;
import java.time.Duration;
import static ge.tbcitacademy.data.Constants.*;


@SuppressWarnings("SpellCheckingInspection")
public class WaitsTest {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("src/main/resources/adblock.crx"));
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }
    @Test
    public void waitForDisappearance() {
        driver.get(DYNAMIC_CONTROLS_URL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT_SECONDS_MEDIUM));
        WebElement enableDisableButton = driver.findElement(By.cssSelector("button[onclick='swapInput()']"));
        enableDisableButton.click();

        WebElement loadingBar = driver.findElement(By.id("loading"));
        wait.until(ExpectedConditions.invisibilityOf(loadingBar));
        Assert.assertEquals(enableDisableButton.getText(), EXPECTED_BUTTON_TEXT, BUTTON_MISMATCH_MESSAGE);

        WebElement inputElement = driver.findElement(By.cssSelector("form#input-example input[type='text']"));
        inputElement.sendKeys(ACCESS_GRANTED_MESSAGE);
    }
    @Test
    public void waitForText() {
        driver.get(PROGRESS_BAR_URL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT_SECONDS_LONG));
//        adblock-ერის გარეშე ასე მეწერა.
//        JavascriptExecutor jse = (JavascriptExecutor) driver;
//        jse.executeScript("window.scrollBy(0, 150);");

        WebElement startStopButton = driver.findElement(By.id("startStopButton"));
        startStopButton.click();

        String progressBarXpath = ".//div[contains(@class, 'progress-bar')]";
        WebElement progressBar = driver.findElement(By.xpath(progressBarXpath));
        wait.until(ExpectedConditions.textToBe(By.xpath(progressBarXpath), EXPECTED_PROGRESS_TEXT));
        System.out.println(progressBar.getText());
//      System.out.println(EXPECTED_PROGRESS_TEXT");

//      ასეც შეიძლება მაგრამ ვფიქრობ პირველი ვარიანტი უკეთესია, რადგან შეიძლება საიტი შეიცვალოს და ბათონი აღარ გაქრეს, და progressBar 100მდე ყველა შემთხვევაში ავა
//      wait.until(ExpectedConditions.invisibilityOf(startStopButton));
//      System.out.println(progressBar.getText());
//      System.out.println(EXPECTED_PROGRESS_TEXT);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

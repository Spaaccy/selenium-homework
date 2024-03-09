import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Objects;
import static ge.tbcitacademy.data.Constants.DYNAMIC_CONTROLS_URL;

public class CommandsTest {
    WebDriver driver;
    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(DYNAMIC_CONTROLS_URL);
    }
    @AfterClass
    // სელენიუმის დომენტაციიდან: Important note: the quit method is different from the close method, and it is recommended to always use quit to end the session
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void buttonsTest()  {
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
       WebElement button = driver.findElement(By.xpath("//*[@id=\"input-example\"]/button"));
       WebElement inputField = driver.findElement(By.xpath("//*[@id=\"input-example\"]/input"));
       button.click();
       wait.until(ExpectedConditions.elementToBeClickable(inputField));
       WebElement stateMessage = driver.findElement(By.id("message"));
       String buttonText = button.getText();

       System.out.println(inputField.isEnabled());
       System.out.println(stateMessage.isDisplayed());
       System.out.println(Objects.equals(buttonText, "Disable"));

       Assert.assertTrue(inputField.isEnabled(), "Input element is not enabled.");
       Assert.assertTrue(stateMessage.isDisplayed(), "State message is not displayed.");
       Assert.assertEquals(buttonText, "Disable", "Button text doesnt equal 'disabled'.");

       inputField.sendKeys("TBC IT Academy");
       inputField.clear();
    }

    @Test
    public void labelsTest() {
        WebElement h4Heading = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/h4[1]"));
        WebElement Pdescription = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/p"));
        String h4HeadingText = h4Heading.getText();
        String PdescriptionText = Pdescription.getText();

        System.out.println(Objects.equals(h4HeadingText, "Dynamic Controls"));
        System.out.println(Objects.equals(PdescriptionText, "This example demonstrates when elements (e.g., checkbox, input field, etc.) are changed asynchronously."));

        Assert.assertEquals(h4HeadingText, "Dynamic Controls", "H4heading text is incorrect.");
        Assert.assertEquals(PdescriptionText, "This example demonstrates when elements (e.g., checkbox, input field, etc.) are changed asynchronously.", "Pdescription text is incorrect.");
    }
}

import baseConfig.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;
import static ge.tbcitacademy.data.Constants.*;

@SuppressWarnings("SpellCheckingInspection")
public class SwitchToTest extends BaseClass {
    @Test(priority = 1)
    public void iFrameTest() {
        driver.get(I_FRAMES_URL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT_SECONDS_MEDIUM ));

        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);

        WebElement paraElement = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath(".//body[@id='tinymce']/p"))
        );
        paraElement.clear();
        paraElement.sendKeys(TEXT_TO_SEND);

        driver.switchTo().parentFrame();
        WebElement alignCenterButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//button[@title='Align center']")));
        alignCenterButton.click();
    }
    @Test(priority = 2)
    public void demoQAtest() {
        driver.get(DEMO_QA_ALERTS_URL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT_SECONDS_MEDIUM ));

        WebElement alertButton = driver.findElement(By.id("alertButton"));
        alertButton.click();

        // იმ შემთხვევაში თუ delay აქვს მაინც იყოს.
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }
}

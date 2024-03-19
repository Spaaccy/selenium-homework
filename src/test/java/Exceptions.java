import baseConfig.BaseClassCrossBrowser;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
import static ge.tbcitacademy.data.Constants.*;

public class Exceptions extends BaseClassCrossBrowser {
    @Test(priority = 4)
    public void NoSuchElementException() {
        driver.get(DYNAMIC_LOADING_URL);
        WebElement anchor2 = driver.findElement(By.xpath("//a[contains(text(), 'Example 2')]"));
        anchor2.click();
        WebElement button = driver.findElement(By.xpath("//div[@id='start']/button"));
        button.click();

        try {
//            waitLong.until(ExpectedConditions.presenceOfElementLocated(By.id("finish")));
            WebElement text1 = driver.findElement(By.id("finish"));
            System.out.println(text1.getText());
        } catch (NoSuchElementException e){
            System.out.println(e.getClass().getName());
        }
    }
    @Test(priority = 5)
    public void StaleElementReferenceException() {
        // StaleElementReferenceException
        driver.get(JOBS_GE_URL);
        WebElement postButton = driver.findElement(By.xpath("//a[text()='გამოაქვეყნე']"));
        WebElement checkBox = driver.findElement(By.xpath("//input[@name='is_ge']"));

        postButton.click();

        try {
//            driver.navigate().back();
//            checkBox = driver.findElement(By.xpath("//input[@name='is_ge']"));
            checkBox.click();
        } catch (StaleElementReferenceException e) {
            System.out.println(e.getClass().getName());
        }
    }
    @Test(priority = 6)
    public void NoSuchFrameException() {
        // NoSuchFrameException
        driver.get(SELENIUM_CLICK_IN_IFRAME_URL);
        WebElement iframe = driver.findElement(By.id("ifr"));

        try {
//            driver.switchTo().frame(0);
//            driver.switchTo().frame(iframe);
            driver.switchTo().frame(FRAME_INDEX_1);
        } catch (NoSuchFrameException e) {
            System.out.println(e.getClass().getName());
        }
//        driver.switchTo().defaultContent();
    }
    @Test(priority = 7)
    public void TimeoutException() {
        // TimeoutException
        driver.get(SELENIUM_DYNAMIC_URL);
        WebElement adderButton = driver.findElement(By.id("adder"));
        adderButton.click();

        try {
            WebElement redBox = superShortWaitMed.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='redbox']")));
//            WebElement redBox = waitLong.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='redbox']")));

        } catch (TimeoutException e) {
            System.out.println(e.getClass().getName());
        }
    }
    @Test(priority = 8)
    public void MoveTargetOutOfBoundsException() {
        // MoveTargetOutOfBoundsException
        driver.get(SMASHING_MAGAZINE_LONG_SCROLLING_URL);
        WebElement a = driver.findElement(By.xpath("//a[text()='Delivery times']"));
        try {
//            action.moveToElement(a).click().build().perform();
            action.moveByOffset(X_OFFSET, Y_OFFSET).click().build().perform();
        } catch (MoveTargetOutOfBoundsException e) {
            System.out.println(e.getClass().getName());
        }
    }
    @Test(priority = 9)
    public void NoSuchWindowException() {
        // NoSuchWindowException
        driver.get(DEMOQA_BROWSER_WINDOWS_URL);
        WebElement newWindowButton = driver.findElement(By.xpath("//button[text()='New Window']"));
        String originalWindow = driver.getWindowHandle();
        newWindowButton.click();
        List<String> allWindowHandles = new ArrayList<>(driver.getWindowHandles());

        try {
//            driver.switchTo().window(allWindowHandles.get(allWindowHandles.size()-1));
            driver.switchTo().window(WINDOW_HANDLE_2);

        } catch (NoSuchWindowException e) {
            System.out.println(e.getClass().getName());
        }
//        driver.switchTo().window(originalWindow);
    }
    @Test(priority = 10)
    public void InvalidSelectorException() {
        // InvalidSelectorException
        driver.get(BATUMI_GOV_URL);

        try {
            // დავწეროთ სწორი სელექტორი, გადავამოწმოთ ბრაუზერის კონსოლში
            WebElement batumiBestCity = driver.findElement(By.xpath("//span[//text//()='კეთილმოწყობა']"));
        } catch (InvalidSelectorException e) {
            System.out.println(e.getClass().getName());
        }
    }
    @Test(priority = 11)
    public void NoSuchSessionException() {
        // NoSuchSessionException
        driver.get(GOOGLE_URL);
        WebElement aboutButton = driver.findElement(By.xpath("//a[text()='About']"));

        try {
//            driver.quit(); click ის მერე უნდა დაიწეროს
            driver.quit();
            aboutButton.click();
        } catch (NoSuchSessionException e) {
            System.out.println(e.getClass().getName());
        }
    }
}

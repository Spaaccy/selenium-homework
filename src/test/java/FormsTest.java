import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.HelperFunctions;
import java.io.File;
import java.time.Duration;
import static ge.tbcitacademy.data.Constants.*;

@SuppressWarnings("SpellCheckingInspection")
public class FormsTest {
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
    public void customDropDownTest() {
        driver.get(CUSTOM_DROP_DOWN_TEST_URL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT_SECONDS_SHORT));
        WebElement btnDemo = driver.findElement(By.xpath(".//a[text()='Demo 2']"));
        btnDemo.click();

        WebElement dropDownBtn = driver.findElement(By.id("dd"));
        WebElement ulList = dropDownBtn.findElement(By.xpath("./ul[@class='dropdown']"));

        Assert.assertFalse(ulList.isDisplayed());

        wait.until(ExpectedConditions.elementToBeClickable(dropDownBtn));
        dropDownBtn.click();

        wait.until(ExpectedConditions.visibilityOf(ulList));
        Assert.assertTrue(ulList.isDisplayed());

        HelperFunctions.universalSelector(ulList, GITHUB_OPTION);
    }
    @Test
    public void nativeDropDownTest() {
        driver.get(CANVAS_REGISTER_URL);

        WebElement radioGender = driver.findElement(By.xpath(".//input[@value='female']"));
        radioGender.click();

        Select selectElem = new Select(driver.findElement(By.cssSelector("select[name='model']")));
        HelperFunctions.universalSelector(selectElem, MEGA_MEDIUM_OPTION);
        Assert.assertEquals(selectElem.getFirstSelectedOption().getText(), MEGA_MEDIUM_OPTION, SELECT_MISMATCH_MESSAGE);

//        List<WebElement> inputElements = driver.findElements(By.cssSelector("input[type='text']"));
//        String[] mockData = {"Luka", "Tsinaridze", "Shandor petefi", "Selim khimshiashvili", "Tbilisi", "579020004", "588887143"};
//        for (int i = 0; i < inputElements.size() && i < mockData.length; i++) {
//            inputElements.get(i).sendKeys(mockData[i]);
//        }
        WebElement firstNameInput = driver.findElement(By.xpath(".//input[@value='First Name']"));
        firstNameInput.sendKeys(FIRST_NAME);

        WebElement lastNameInput = driver.findElement(By.xpath(".//input[@value='Last Name']"));
        lastNameInput.sendKeys(LAST_NAME);

        WebElement adressInput1 = driver.findElement(By.xpath(".//input[@value='Address1']"));
        adressInput1.sendKeys(ADDRESS_1);

        WebElement adressInput2 = driver.findElement(By.xpath(".//input[@value='Address2']"));
        adressInput2.sendKeys(ADDRESS_2);

        WebElement cityInpur = driver.findElement(By.xpath(".//input[@value='City']"));
        cityInpur.sendKeys(CITY);

        WebElement contactInput1 = driver.findElement(By.xpath(".//input[@value='Contact1']"));
        contactInput1.sendKeys(CONTACT_1);

        WebElement contactInput2 = driver.findElement(By.xpath(".//input[@value='Contact2']"));
        contactInput2.sendKeys(CONTACT_2);

        WebElement checkBox = driver.findElement(By.xpath(".//input[@value='Yes']"));
        if(!checkBox.isSelected()) checkBox.click();

        WebElement submit = driver.findElement(By.xpath(".//input[@type='submit']"));
        submit.click();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

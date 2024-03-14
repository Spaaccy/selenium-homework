import baseConfig.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import static ge.tbcitacademy.data.Constants.*;
import static util.HelperFunctions.*;

public class TablesTest extends BaseClass {
    @Test(priority = 1)
    public void techlisticTables1Test() {
        driver.get(TECHLISTIC_TABLE_URL);
        WebElement table1Elem = getElementFromTable(driver.findElement(By.id("customers")), TABLE1_ROW ,TABLE1_COLUMN_HEADER);
        System.out.println(table1Elem.getText());
        Assert.assertEquals(table1Elem.getText(), EXPECTED_TABLE1_COUNTRY, TABLE1_NAME_MISMATCH_MESSAGE);
    }
    @Test(priority = 2)
    public void techlisticTables2Test() {
        driver.get(TECHLISTIC_TABLE_URL);
//        ფუნქციაში ისე გავაკეთე რომ თუ tableheader ნეიმი არ გვაქვს გადაცემული row name გვერდით td ელემენტს დააბრუნებს, მგონი საუკეთესო ვარიანტია
//        WebElement table2Elem = getElementFromTable(driver.findElement(By.cssSelector("table.tsc_table_s13")),"Total", "");
//        System.out.println(table2Elem.getText());

        WebElement table2Elem = getElementFromTable(driver.findElement(By.cssSelector("table.tsc_table_s13")),TABLE2_ROW, TABLE2_COLUMN_HEADER);
        System.out.println(table2Elem.getText());
        Assert.assertEquals(table2Elem.getText(), EXPECTED_TABLE2_YEAR, TABLE2_YEAR_MISMATCH_MESSAGE);
    }
    @Test(priority = 3)
    public void techCanvasTableTest() {
        driver.get(TECH_CANVAS_TABLE_URL);
        WebElement table3Elem = getElementFromTable(driver.findElement(By.id("t01")), TABLE3_ROW, TABLE3_COLUMN_HEADER);
        System.out.println(table3Elem.getText());
        Assert.assertEquals(table3Elem.getText(), EXPECTED_TABLE_MAKE, TABLE_MAKE_MISMATCH_MESSAGE);
    }
    @Test(priority = 4)
    public void hardDomTableTest() {
        driver.get(HARD_DOM_TABLE_URL);
        WebElement table4Elem = getElementFromTable(driver.findElement(By.tagName("table")), TABLE4_ROW, TABLE4_COLUMN_HEADER);
        System.out.println(table4Elem.getText());
        Assert.assertEquals(table4Elem.getText(), EXPECTED_TABLE_CONSEQUUNTUR, TABLE_CONSEQUUNTUR_MISMATCH_MESSAGE);
    }
    @Test(priority = 5)
    public void depressionTableTest() {
        driver.get(DEPRESSION_IS_REAL_TABLE_URL);
        WebElement table5Elem = getElementFromTable(driver.findElement(By.cssSelector("table.responsive")), TABLE5_ROW, TABLE5_COLUMN_HEADER);
        System.out.println(table5Elem.getText());
        Assert.assertEquals(table5Elem.getText(), EXPECTED_TABLE_PERC , TABLE_PERC_MISMATCH_MESSAGE);
    }
    @Test(priority = 6)
    public void geoPopulationTableTest() {
        driver.get(WIKIPEDIA_TABLE_URL);
        WebElement table6Elem = getElementFromTable(driver.findElement(By.xpath(".//table[@class='wikitable' and .//text()[normalize-space() = 'Overview of basic table markup']]")), TABLE6_ROW, TABLE6_COLUMN_HEADER);
        System.out.println(table6Elem.getText());
        Assert.assertEquals(table6Elem.getText(), EXPECTED_TABLE_NOTE, TABLE_NOTE_MISMATCH_MESSAGE);
    }
}

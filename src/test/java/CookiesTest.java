import baseConfig.BaseClass;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static ge.tbcitacademy.data.Constants.*;

public class CookiesTest extends BaseClass {
    @Test(priority = 1)
    public void filterCookies() {
        driver.get(TECHLISTIC_TABLE_URL);
        // საიტზე cookies იტვირთბა js ფაილით "cookienotice.js" ამიტომ კარგი აზრია ასეთი wait ის დამატება.
        waitLong.until(ExpectedConditions.jsReturnsValue(DOCUMENT_READY_STATE_COMPLETE));
        Set<Cookie> cookiesSet = new HashSet<>(driver.manage().getCookies());

        // შეიძლება რამოდენიმე cookie შეიცავდეს "active_template" ნეიმში ამიტო ვფიქრობ ასე ჯობია
        List<Cookie> filteredCookies = cookiesSet.stream()
                .filter(cookie -> cookie.getName().contains(COOKIE_NAME_FILTER)).toList();

        // აბრუნებს true ს თუ ერთერთი cookie შეიცავს "pub_site" ველიუში
        boolean cookieContains = filteredCookies.stream()
                .anyMatch(cookie -> cookie.getValue().contains(COOKIE_VALUE_SEARCH));

        Assert.assertTrue(cookieContains, COOKIE_MISMATCH_MESSAGE);
        System.out.println("I AM HOTFIX");
    }

    @Test(priority = 2)
    public void injectCookie() {
        driver.get(TECHLISTIC_TABLE_URL);
        // საიტზე cookies იტვირთბა js ფაილით "cookienotice.js" ამიტომ კარგი აზრია ასეთი wait ის დამატება.
        waitLong.until(ExpectedConditions.jsReturnsValue(DOCUMENT_READY_STATE_COMPLETE));

        int cookiesSizeBefore = driver.manage().getCookies().size();
//        Set<Cookie> cookiesBefore = new HashSet<>(driver.manage().getCookies());

        for (int i = 0; i < COOKIE_NAMES.length; i++) {
            driver.manage().addCookie(new Cookie(COOKIE_NAMES[i], COOKIE_VALUES[i]));
        }

        for (String cookieName : COOKIE_NAMES) {
            Cookie ourCookie = driver.manage().getCookieNamed(cookieName);
            System.out.println(ourCookie.getName() + " " + ourCookie.getValue());
        }

        for (String cookieName : COOKIE_NAMES) {
            Cookie toBeDeletedCookie = driver.manage().getCookieNamed(cookieName);
            driver.manage().deleteCookie(toBeDeletedCookie);
        }

//        Set<Cookie> cookiesAfter = new HashSet<>(driver.manage().getCookies());

//        ასეც შეიძლებოდა გაკეთება, კოდი უფრო კომპაქტურია მაგრამ რადგან პირობაში print და delete ცალცალკე იყო დავწერე ცალცალკე for ლუპებით.
//        cookiesAfter.stream()
//                .filter(cookieAfter -> !cookiesBefore.contains(cookieAfter))
//                .forEach(cookieAfter -> {
//                    System.out.println(cookieAfter.getName() + " " + cookieAfter.getValue());
//                    driver.manage().deleteCookieNamed(cookieAfter.getName());
//                });

        int cookiesSizeAfter = driver.manage().getCookies().size();
        Assert.assertEquals(cookiesSizeAfter, cookiesSizeBefore, COOKIE_SIZE_MISMATCH_MESSAGE);
    }

    @Test(priority = 3)
    public void autoCompleteTest() {
        driver.get(AUTOCOMPLETE_DEMO_URL);
        WebElement hiddenStatus = driver.findElement(By.xpath("//span[@role='status']"));
        WebElement searchField = driver.findElement(By.id("searchbox"));

        String oldText = hiddenStatus.getText();
        searchField.sendKeys(SEARCH_TERM_COUNTRY);

//        ასეც შეიძლებოდა პირდაპირ მაგრამ ცოტა განსხვავებული გზაც ვიპოვე.
//        waitLong.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div#menucontainer li:first-child")));

        waitLong.until(driver -> !driver.findElement(By.xpath("//span[@role='status']")).getText().equals(oldText));
        if (hiddenStatus.getText().equalsIgnoreCase(SEARCH_INVALID_STATUS_MESSAGE)) throw new IllegalArgumentException(SEARCH_ARGUMENT_ERROR_MESSAGE);

        action.sendKeys(searchField, Keys.ARROW_DOWN, Keys.ENTER).perform();
        waitLong.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='ui-autocomplete-multiselect-item']")));
    }
}

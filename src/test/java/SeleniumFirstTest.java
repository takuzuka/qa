import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumFirstTest {

    private final By HOME_PAGE_ARTICLE = By.xpath(".//h1[contains(@class,'headline__title')]");
    private final By ARTICLE_PAGE_TITLE = By.xpath(".//h1[contains(@class, 'd-inline')]");

    @Test
    public void delfiFirstTest() {

        System.setProperty("webdriver.chrome.driver", "chrome/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://rus.delfi.lv/");

        //find first article title
        WebElement firstArticleTitle = driver.findElement(HOME_PAGE_ARTICLE);
        //Get text and save it
        String firstArticleTitleText = firstArticleTitle.getText();
        //Click on first article title
        firstArticleTitle.click();
        //find article title
        WebElement articleTitle = driver.findElement(ARTICLE_PAGE_TITLE);
        //get text and save it
        String articleTitleText = articleTitle.getText();
        //compare both titles
        Assertions.assertEquals(firstArticleTitleText, articleTitleText, "Titles are not equals");
//vtoroj statji odinakovie na glavnoj stranice na stranice samoj statji i na stranici kommentariev
        //dlja vtoroj statji proverit' kolichestvo kommentariev
    }
}

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TVNetTest {

    private final By ALL_ARTICLES = By.tagName("article");
    private final By ARTICLE_TITLE = By.xpath(".//span[contains(@class, 'list-article__headline')]");
//    private final By ARTICLE_TITLE = By.xpath(".//span[@class='list-article__headline']");
    // private final By HOME_PAGE_ARTICLE = By.xpath(".//span[contains(@class, 'list-article__headline')]");
    private final By ARTICLE_COMMENTS = By.xpath(".//span[@class='list-article__comment section-font-color']");
    private final By TITLE_NAME = By.xpath(".//h1[@class='article-headline']");

    @Test
    public void TvNetArticleTest() {
        System.setProperty("webdriver.chrome.driver", "chrome/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tvnet.lv/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.elementToBeClickable(ALL_ARTICLES));


        List<WebElement> articles = driver.findElements(ALL_ARTICLES);
        WebElement secondArticle = articles.get(1);
        String secondArticleText = secondArticle.findElement(ARTICLE_TITLE).getText();
        String commentCount = secondArticle.findElement(ARTICLE_COMMENTS).getText().replaceAll("[^0-9]", "");
        int commentCountInteger = Integer.parseInt(commentCount);
        secondArticle.click();
//        wait.until(ExpectedConditions.elementToBeSelected(TITLE_NAME));
        //find article title
        WebElement articleTitle = driver.findElement(TITLE_NAME);
        //get text and save it
        String articleTitleText = articleTitle.getText();
        //compare both titles
        Assertions.assertEquals(secondArticleText.trim(), articleTitleText, "Titles are not equals");
//substring(1,string.length-1)

    }
}

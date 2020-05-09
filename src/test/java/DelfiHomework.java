import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DelfiHomework {
    private final By ARTICLES = By.tagName("article");
    private final By HOME_PAGE_ARTICLE = By.xpath(".//h1[contains (@class, 'headline__title')]");
    private final By HOME_PAGE_COMMENTS = By.xpath(".//a[@class='comment-count text-red-ribbon']");

    private final By ARTICLE_TITLE = By.xpath(".//div[contains(@class, 'article-title')]");
    private final By TITLE_NAME = By.xpath(".//h1[contains(@class, 'd-inline')]");

    @Test
    public void DelfiSecondArticles() {
        System.setProperty("webdriver.chrome.driver", "chrome/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://rus.delfi.lv/");

        List<WebElement> allArticles = driver.findElements(ARTICLES);
        WebElement article = allArticles.get(3);
        String articleText = article.findElement(HOME_PAGE_ARTICLE).getText();
        System.out.println(articleText);

        List<WebElement> comments = article.findElements(HOME_PAGE_COMMENTS);
        String comment = "";
        if (comments.size() > 0) {
            String commentWithBraces = comments.get(0).getText();
            comment = commentWithBraces.substring(1, commentWithBraces.length() - 1);

        } else if (comments.size() == 0) {
            comment = "0";
        }



        article.click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        List<WebElement> articlePage = driver.findElements(ARTICLE_TITLE);
        WebElement articleTitle = articlePage.get(0);
        String title = articleTitle.findElement(TITLE_NAME).getText();
        Assertions.assertEquals(articleText.trim(), title.trim(), "Article names is not equal");
    }

}

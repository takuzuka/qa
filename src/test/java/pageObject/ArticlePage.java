package pageObject;

import org.openqa.selenium.By;

public class ArticlePage {
    private BaseFunc baseFunc;
    private final By TITLE = By.xpath(".//h1[contains(@class, 'd-inline')]");
    public ArticlePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public String getTitle() {
        return baseFunc.findElement(TITLE).getText();


    }
}

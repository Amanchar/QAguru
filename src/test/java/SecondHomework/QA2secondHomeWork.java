package SecondHomework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class QA2secondHomeWork {
    private final By ARTICLE_TITLE_MOBILE_VERSION = By.xpath(".//a[@class = 'md-scrollpos']");
    private final By ARTICLE_TITLE_MAIN_VERSION = By.xpath(".//h1[contains(@class, 'headline__title')]");
    private final String HOME_PAGE_MOBILE_VERSION = "http://m.rus.delfi.lv";
    private final String HOME_PAGE_MAIN_VERSION = "http://rus.delfi.lv";

    private WebDriver browser;

    @Test
    public void compareArticleTitles() {
        System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get(HOME_PAGE_MOBILE_VERSION);

        List<WebElement> elementsFromMobileVersion = browser.findElements(ARTICLE_TITLE_MOBILE_VERSION);
        List<String> articlesFromMobileVersion = new ArrayList<String>();
        for (int i = 0; i < 5; i++) {
            articlesFromMobileVersion.add(elementsFromMobileVersion.get(i).getText());
        }

        browser.get(HOME_PAGE_MAIN_VERSION);
        List<WebElement> elementsFromMainVersion = browser.findElements(ARTICLE_TITLE_MAIN_VERSION);

        for (int i = 0; i < articlesFromMobileVersion.size(); i++) {
            Assertions.assertEquals(articlesFromMobileVersion.get(i), elementsFromMainVersion.get(i).getText(), "This is not true Article!");
        }
    }

    @AfterEach
    public void closeBrowser() {
        browser.close();
    }
}

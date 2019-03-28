package FourthHomework.Pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BaseFunc {
    private WebDriver browser;

    public BaseFunc() {
        System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().window().maximize();
    }

    public void goToPage(String url) {
        if (!url.contains("http://") && !url.contains("https://")) {
            url = "http://" + url;
        }
        browser.get(url);
    }

    public WebElement getElement(By locator) {
        Assertions.assertFalse(browser.findElements(locator).isEmpty(), "There is no element!");
        return browser.findElement(locator);
    }

    public List<WebElement> getElements(By locator) {
        Assertions.assertFalse(browser.findElements(locator).isEmpty(), "There are no elements!");
        return browser.findElements(locator);
    }

    public void closeBrowser() {
        browser.close();
    }
}

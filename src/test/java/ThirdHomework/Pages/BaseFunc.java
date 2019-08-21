package ThirdHomework.Pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class BaseFunc {
    public WebDriver browser;
    Actions action;

    public BaseFunc() {
        System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        action = new Actions(browser);

    }

    public void waitTime() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public Actions moveToElement(WebElement locator) {
        return action.moveToElement(locator);
    }


    public void goToPage(String url) {
        if (!url.contains("http://") && !url.contains("https://")) {
            url = "http://" + url;
        }
        browser.get(url);
    }


    public WebElement getElement(By locator) {
        return browser.findElement(locator);
    }

    public List<WebElement> getElements(By locator) {
        Assertions.assertFalse(browser.findElements(locator).isEmpty(), "No elements!");
        return browser.findElements(locator);
    }

    public void waitForElementToBeClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(browser, 5);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public void waitForElementToBeVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(browser, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForElementDisappear(By locator) {
        WebDriverWait wait = new WebDriverWait(browser, 5);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public double getItemsDigit(By locator) {
        WebElement el = browser.findElement(locator);
        return Double.parseDouble(el.getText().substring(1));
    }


    public void closeBrowser() {
        browser.close();
    }

    public void navigateBack() {
        browser.navigate().back();
    }


}
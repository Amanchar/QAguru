package ThirdHomework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.junit.jupiter.api.Test;
import ThirdHomework.Pages.*;
import org.openqa.selenium.WebElement;

import java.text.DecimalFormat;


public class DressesTest {
    private BaseFunc baseFunc = new BaseFunc();
    private JavascriptExecutor js = (JavascriptExecutor) baseFunc.browser;

    private final By CART = By.xpath(".//a[contains(@title,'View my shopping cart')]");
    private final By CART_TOTAL = By.xpath(".//span[contains(@class,'price cart_block_total')]");

    @Test
    void automationTest() throws InterruptedException {
        String MAIN_PAGE = "http://automationpractice.com/index.php";
        baseFunc.goToPage(MAIN_PAGE);
        MainPage mainPage = new MainPage(baseFunc);

        // Go to summer dresses page:
        SummerDressesPage summerDressesPage = mainPage.goToSummerDressesPage();
        // Scroll down and pause for a while:
        js.executeScript("arguments[0].scrollIntoView();", baseFunc.browser.findElement(summerDressesPage.CATEGORY));
        Thread.sleep(1000);
        // Get actual displayed item count:
        int itemDisplayed = baseFunc.getElements(summerDressesPage.PRODUCT_ITEMS).size();
        // Get counter value displayed on page:
        int itemCounter = summerDressesPage.getCounterValue(summerDressesPage.PRODUCT_COUNTER);
        // Output to console received values and
        // assert actual and displayed counter values:
        System.out.printf("Items actually displayed: %d\n" +
                "Items counter value:      %d\n\n", itemDisplayed, itemCounter);
        Assertions.assertEquals(itemDisplayed, itemCounter, "Page counter and actual product count are not equal!");


        // Output to console first item price value and
        // save first item price value to double variable:

        String color = "Red";
        baseFunc.waitForElementToBeVisible(summerDressesPage.FIRST_PRODUCT_PRICE);
        System.out.printf("Test: %s\n", summerDressesPage.getDisplayedProductItemPrices(summerDressesPage.PRODUCT_ITEM_PRICES));



        double price = baseFunc.getItemPrice(summerDressesPage.FIRST_PRODUCT_PRICE);
        // Output to console if all displayed items contain yellow color in color picker:
        System.out.printf("Summer dresses page: All items contains %s: %s;\n", color, summerDressesPage.checkIfAllItemsHaveColor(color));

        // Flow over first product, wait until "more" button show up and click it:
        ProductPage productPage = summerDressesPage.goToProductPage(0);

        Assertions.assertEquals(price, baseFunc.getItemPrice(productPage.PRODUCT_PRICE), "Prices are not equal!");
        System.out.printf("Product page: Product item contains %s color: %s\n", color, productPage.isColorPresent());
        baseFunc.browser.navigate().back();

        summerDressesPage.addToCartAllDisplayedProductItems();
        js.executeScript("arguments[0].scrollIntoView();", baseFunc.browser.findElement(CART));

        WebElement cart = baseFunc.getElement(CART);
        baseFunc.moveToElement(cart).perform();
        baseFunc.waitForElementToBeVisible(CART_TOTAL);

        double totalPriceInCart = baseFunc.getItemPrice(CART_TOTAL);

        System.out.printf("Total price: %s\n", (totalPriceInCart - 2.00));
        System.out.println("Total item sum: " + summerDressesPage.getDisplayedProductItemSum());
        Assertions.assertEquals(totalPriceInCart - 2.00, summerDressesPage.getDisplayedProductItemSum(), "Different values!!!!");
    }

    @AfterEach
    void closeBrowser() {
        baseFunc.closeBrowser();
    }
}

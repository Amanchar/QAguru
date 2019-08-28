package ThirdHomework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.junit.jupiter.api.Test;
import ThirdHomework.Pages.*;
import org.openqa.selenium.WebElement;


class DressesTest {
    private BaseFunc baseFunc = new BaseFunc();
    private JavascriptExecutor js = (JavascriptExecutor) baseFunc.browser;

    private final By CART = By.xpath(".//a[contains(@title,'View my shopping cart')]");
    private final By CART_TOTAL = By.xpath(".//span[contains(@class,'price cart_block_total')]");

    @Test
    void ColorPriceAssertTest() {
        String MAIN_PAGE = "http://automationpractice.com/index.php";
        String colorToCheckFor = "Yellow";

        baseFunc.goToPage(MAIN_PAGE);
        MainPage mainPage = new MainPage(baseFunc);

        // Go to summer dresses page:
        SummerDressesPage summerDressesPage = mainPage.goToSummerDressesPage();
        // Scroll down:
        js.executeScript("arguments[0].scrollIntoView();", baseFunc.browser.findElement(summerDressesPage.CATEGORY));

        Assertions.assertTrue(summerDressesPage.assertCounters(), "Page counter and actual product count are not equal!");

        double firstProductItemPriceOnSummerDressesPage = baseFunc.getItemPrice(summerDressesPage.FIRST_PRODUCT_PRICE);

        Assertions.assertTrue(summerDressesPage.checkIfAllItemsHaveColor(colorToCheckFor), "Selected items do not contain wanted color!");


        ProductPage productPage = summerDressesPage.goToProductPage(0);
        double productItemPriceFromProductDescriptionPage = baseFunc.getItemPrice(productPage.PRODUCT_PRICE);
        Assertions.assertEquals(firstProductItemPriceOnSummerDressesPage, productItemPriceFromProductDescriptionPage, "Prices are not equal!");
        Assertions.assertTrue(productPage.isColorPresent(colorToCheckFor), "Product items does not contain wanted color!");

        baseFunc.browser.navigate().back();

        summerDressesPage.addToCartAllDisplayedProductItems();
        WebElement cart = baseFunc.getElement(CART);
        js.executeScript("arguments[0].scrollIntoView();", cart);
        baseFunc.moveToElement(cart).perform();
        baseFunc.waitForElementToBeVisible(CART_TOTAL);
        double totalPriceInCart = baseFunc.getItemPrice(CART_TOTAL);
        Assertions.assertEquals(totalPriceInCart - 2.00, summerDressesPage.getDisplayedProductItemSum(), "Different price values!!!");


    }

    @AfterEach
    void closeBrowser() {
        baseFunc.closeBrowser();
    }
}

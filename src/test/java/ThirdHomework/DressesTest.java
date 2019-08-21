package ThirdHomework;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;

import org.junit.jupiter.api.Test;
import ThirdHomework.Pages.*;

import java.text.DecimalFormat;
import java.util.Set;


public class DressesTest {
    private BaseFunc baseFunc = new BaseFunc();

    @Test
    void automationTest() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) baseFunc.browser;
        String MAIN_PAGE = "http://automationpractice.com/index.php";
        baseFunc.goToPage(MAIN_PAGE);
        MainPage mainPage = new MainPage(baseFunc);

        // Go to summer dresses page:
        SummerDressesPage summerDressesPage = mainPage.goToSummerDressesPage();
        // Scroll down and pause for a while:
        js.executeScript("arguments[0].scrollIntoView();", baseFunc.browser.findElement(summerDressesPage.CATEGORY));
        Thread.sleep(1000);
        // Get actual displayed item count:
        int itemDisplayed = baseFunc.getElements(summerDressesPage.PRODUCTS).size();
        // Get counter value displayed on page:
        int itemCounter = (int) summerDressesPage.getCounter(summerDressesPage.ITEM_COUNTER);
        // Output to console received values and
        // assert actual and displayed counter values:
        System.out.printf("Items actually displayed: %d\n" +
                "Items counter value:      %d\n\n", itemDisplayed, itemCounter);
        Assertions.assertEquals(itemDisplayed, itemCounter, "Values are not equal!");
        // Output to console first item price value and
        // save first item price value to double variable:

        baseFunc.waitForElementToBeVisible(summerDressesPage.FIRST_PRODUCT_PRICE);
        System.out.printf("First item price is: %s\n\n", baseFunc.getItemsDigit(summerDressesPage.FIRST_PRODUCT_PRICE));
        double price = baseFunc.getItemsDigit(summerDressesPage.FIRST_PRODUCT_PRICE);
        // Output to console if all displayed items contain yellow color in color picker:
        System.out.println("All items contain yellow:   " + summerDressesPage.checkIfAllItemsHaveColor("Yellow"));

        // Flow over first product, wait until "add to cart" button show up and click it:
        PopUp popUp = summerDressesPage.goToPopUp(summerDressesPage.FIRST_PRODUCTS_IMAGE, summerDressesPage.FIRST_PRODUCTS_ADD);
        // Checks and output to console if PopUp layer is visible:
        System.out.println("Layer is visible:           " + popUp.checkLayerVisible(PopUp.POPUP_LAYER));
        // Wait until price element is visible, get price and write it to double var:
        baseFunc.waitForElementToBeClickable(PopUp.POPUP_LAYER_PRODUCT_PRICE);
        System.out.printf("First item price is: %s\n", baseFunc.getItemsDigit(PopUp.POPUP_LAYER_PRODUCT_PRICE));
        double price2 = baseFunc.getItemsDigit(PopUp.POPUP_LAYER_PRODUCT_PRICE);
        // Assert dresses page and popup layer displayed price values of item:
        Assertions.assertEquals(price, price2, "Prices are not equal!");
        // close pop up layer:
        popUp.closePopUpLayer();

        ProductPage productPage = summerDressesPage.goToProductPage();
        System.out.println("Product page contain color: " + productPage.isColorPresent());
        SummerDressesPage summerDressesPage1 = productPage.goToSummerDressesPage();

        DecimalFormat df = new DecimalFormat("#.00");

        float price3 = (float)baseFunc.getItemsDigit(summerDressesPage.SECOND_PRODUCT_PRICE);
        System.out.println("Second item price is: " + df.format(price3));
        summerDressesPage1.goToPopUp(summerDressesPage1.SECOND_PRODUCTS_IMAGE, summerDressesPage1.SECOND_PRODUCTS_ADD);
        baseFunc.waitForElementToBeVisible(PopUp.POPUP_LAYER_PRODUCT_PRICE);
        float result = (float)(price + price3);

        float totalPrice = Float.parseFloat(baseFunc.getElement(summerDressesPage.TOTAL_PRICE).getText().substring(1));
        System.out.printf("Total price is: %s\n" +
                "Calc total:     %s", Float.parseFloat(baseFunc.browser.findElement(summerDressesPage.TOTAL_PRICE).getText().substring(1)), result);

        Assertions.assertEquals(totalPrice, result,"Are not equal!");

    }

    /*@AfterEach
    public void closeBrowser() {
        baseFunc.closeBrowser();
    }*/

}

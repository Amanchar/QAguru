package ThirdHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.junit.jupiter.api.Test;
import ThirdHomework.Pages.*;
import org.openqa.selenium.WebElement;


public class DressesTest {
    private BaseFunc baseFunc = new BaseFunc();

    @Test
    void automationTest() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) baseFunc.browser;
        String MAIN_PAGE = "http://automationpractice.com";
        baseFunc.goToPage(MAIN_PAGE);
        MainPage mainPage = new MainPage(baseFunc);

        DressesPage dressesPage = mainPage.goToDressesPage();
        SummerDressesPage summerDressesPage = dressesPage.goSummerDressesPage();

        //WebElement element = baseFunc.browser.findElement(By.linkText("Information"));

        System.out.println(summerDressesPage.checkIfAllItemsHaveColor("Yellow"));

        js.executeScript("arguments[0].scrollIntoView();", baseFunc.browser.findElement(summerDressesPage.CATEGORY));
        Thread.sleep(2000);

        baseFunc.waitForElementToBeClickable(summerDressesPage.LIST_VIEW);
        baseFunc.getElement(summerDressesPage.LIST_VIEW).click();
        ProductPage productPage = summerDressesPage.goToProductPage(0);
        System.out.println(productPage.isColorPresent());

        //System.out.println("List contains: " + dressesPage.getElementInfo(dressesPage.COLOR_PICK).size());
        // System.out.println(dressesPage.getElementInfoByAttribute(dressesPage.COLOR_PICK,"style"));
        /*baseFunc.waitTime();
        dressesPage.checkColorBox();

        Assertions.assertTrue(dressesPage.isColorPresent("background: rgb(243, 156, 17);"), "There is no that color!");

        ProductPage productPage = dressesPage.goProductPage("Printed Dress");
        Assertions.assertTrue(productPage.isColorPresent("background: rgb(243, 156, 17);"), "There is no that color!");
        baseFunc.waitTime();

        baseFunc.navigateBack();
        baseFunc.waitForElement(dressesPage.FILTERED_ELEMENTS);


        baseFunc.waitTime();

        DresesPopUp dresesPopUp = dressesPage.addToCartFirstItem();
        baseFunc.waitTime();

        dresesPopUp.closePopUp();
        dresesPopUp = dressesPage.addToCartSecondItem();
        baseFunc.waitTime();

        CheckoutPage checkout = dresesPopUp.proceedToCheckout();


        baseFunc.waitTime();

        checkout.getSelectedProductPrices();
        checkout.convertSelectedProductPricesToDouble();
        Assertions.assertEquals(checkout.totalPrice(), checkout.sumOfSelectedProducts(), "not equals!!!");*/
    }

    /*@AfterEach
    public void closeBrowser() {
        baseFunc.closeBrowser();
    }*/

}

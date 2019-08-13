package ThirdHomework;

import org.junit.jupiter.api.Test;
import ThirdHomework.Pages.*;


public class DressesTest {
    private BaseFunc baseFunc = new BaseFunc();

    private final String MAIN_PAGE = "http://automationpractice.com";

    @Test
    public void automationTest() {

        baseFunc.goToPage(MAIN_PAGE);
        MainPage mainPage = new MainPage(baseFunc);

        DressesPage dressesPage = mainPage.goToDressesPage();
        SummerDressesPage summerDressesPage = dressesPage.goSummerDressesPage();

        System.out.print(summerDressesPage.getElementInfoTest());

        baseFunc.waitForElementToBeClickable(summerDressesPage.LIST_VIEW);

        baseFunc.getElement(summerDressesPage.LIST_VIEW).click();


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

package ThirdHomework.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SummerDressesPage {
    private BaseFunc baseFunc;

    private final By ALL_ADD_TO_CART = By.xpath(".//a[contains(@title,'Add to cart')]");
    private final By PRODUCT_MORE = By.xpath(".//a[contains(@class,'button lnk_view')]");

    public final By FIRST_PRODUCT_PRICE = By.xpath("(.//*[@class='price product-price'])[2]");

    private final By PRODUCT_ITEM_PRICES = By.xpath(".//span[@class='price product-price']");

    private final By PRODUCT_ITEMS = By.xpath(".//div[@class='product-container']");
    private final By PRODUCT_COUNTER = By.xpath(".//span[@class='heading-counter']");

    private final By COLOR_PICK = By.xpath(".//a[@class='color_pick']");
    public final By CATEGORY = By.xpath(".//span[@class='cat-name']");

    private static By POPUP_CONTINUE_SHOPPING = By.xpath(".//span[contains(@title,'Continue shopping')]");
    private static By POPUP_LAYER = By.id("layer_cart");

    SummerDressesPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }


    public boolean checkIfAllItemsHaveColor(String color) {
        List<WebElement> elParent = baseFunc.getElements(PRODUCT_ITEMS);
        List<WebElement> el;
        List<String> webElementsStrings = new ArrayList<String>();
        int counter = 0;

        for (int i = 0; i < elParent.size(); i++) {
            el = elParent.get(i).findElements(COLOR_PICK);
            for (WebElement item : el
            ) {
                webElementsStrings.add(item.getAttribute("style").substring(item.getAttribute("style").indexOf('('), item.getAttribute("style").length() - 1));
                baseFunc.colorParser(webElementsStrings);
            }
            if (webElementsStrings.contains(color)) {
                System.out.printf("Item Nr.: %d\nColor list: %s\n", i + 1, webElementsStrings);
                System.out.printf("Item Nr.%d contains %s color!\n\n", i + 1, color);
                counter++;
                webElementsStrings.clear();
                continue;
            } else {
                System.out.printf("Item Nr. %s does not contains %s color!\n\n", i + 1, color);
            }
            webElementsStrings.clear();
        }
        return counter == elParent.size();
    }

    private int getCounterValue(By locator) {
        WebElement el = baseFunc.browser.findElement(locator);
        return Integer.parseInt(el.getText().replaceAll("\\D+", ""));
    }

    public boolean assertCounters() {
        int itemDisplayed = baseFunc.getElements(PRODUCT_ITEMS).size();
        int itemCounter = getCounterValue(PRODUCT_COUNTER);

        return itemCounter == itemDisplayed;
    }

    private List<Double> getDisplayedProductItemPrices(By locator) {
        List<WebElement> elemDisplayedProducts = baseFunc.getElements(PRODUCT_ITEMS);
        List<WebElement> elemPrices;
        List<Double> strPrices = new ArrayList<Double>();

        for (WebElement elemDisplayedProduct : elemDisplayedProducts) {
            elemPrices = elemDisplayedProduct.findElements(locator);
            for (WebElement elemPrice : elemPrices) {
                String str = elemPrice.getText();
                if (!str.isEmpty()) {
                    strPrices.add(Double.parseDouble(elemPrice.getText().substring(1)));
                }
            }
        }
        return strPrices;
    }

    public double getDisplayedProductItemSum() {
        double sum = 0;
        for (double i : getDisplayedProductItemPrices(PRODUCT_ITEM_PRICES)) {
            sum += i;
        }
        return baseFunc.roundValue(sum);
    }

    public void addToCartAllDisplayedProductItems() {
        List<WebElement> elemAddList = baseFunc.getElements(ALL_ADD_TO_CART);
        List<WebElement> elemDisplayedProductItems = baseFunc.getElements(PRODUCT_ITEMS);
        for (int i = 0; i < elemDisplayedProductItems.size(); i++) {
            baseFunc.waitForWebElementToBeVisible(elemDisplayedProductItems.get(i));
            baseFunc.moveToElement(elemDisplayedProductItems.get(i)).perform();

            baseFunc.waitForWebElementToBeVisible(elemAddList.get(i));
            baseFunc.moveToElement(elemAddList.get(i)).click().perform();

            baseFunc.waitForElementToBeVisible(POPUP_LAYER);
            closePopUpLayer();
        }
    }

    private void closePopUpLayer() {
        baseFunc.getElement(POPUP_CONTINUE_SHOPPING).click();
    }

    public ProductPage goToProductPage(int item) {
        List<WebElement> productList = baseFunc.getElements(PRODUCT_ITEMS);
        List<WebElement> firstProductAddToCart = baseFunc.getElements(PRODUCT_MORE);

        baseFunc.moveToElement(productList.get(item)).perform();
        baseFunc.waitForElementToBeClickable(PRODUCT_MORE);
        baseFunc.moveToElement(firstProductAddToCart.get(item)).click().perform();

        return new ProductPage(baseFunc);
    }


}

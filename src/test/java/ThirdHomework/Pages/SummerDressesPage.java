package ThirdHomework.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SummerDressesPage {
    private BaseFunc baseFunc;

    public final By ALL_ADD_TO_CART = By.xpath(".//a[contains(@title,'Add to cart')]");
    public final By FIRST_PRODUCTS_IMAGE = By.xpath("(.//div[@class='product-container'])[1]");
    public final By FIRST_PRODUCTS_ADD = By.xpath("(.//a[contains(@title,'Add to cart')])[1]");
    public final By PRODUCT_MORE = By.xpath(".//a[contains(@class,'button lnk_view')]");


    public final By FIRST_PRODUCT_PRICE = By.xpath("(.//*[@class='price product-price'])[2]");
    public final By SECOND_PRODUCT_PRICE = By.xpath("(.//*[@class='price product-price'])[4]");
    public final By THIRD_PRODUCT_PRICE = By.xpath("(.//*[@class='price product-price'])[6]");

    public final By TOTAL_PRICE = By.xpath(".//*[contains(@class,'block_products_total')]");
    public final By PRODUCT_ITEM_PRICES = By.xpath(".//span[@class='price product-price']");


    public final By PRODUCT_ITEMS = By.xpath(".//div[@class='product-container']");
    public final By PRODUCT_COUNTER = By.xpath(".//span[@class='heading-counter']");


    public final By COLOR_PICK = By.xpath(".//a[@class='color_pick']");
    public final By LIST_VIEW = By.id("list");
    public final By CATEGORY = By.xpath(".//span[@class='cat-name']");
    public final By MORE_BTN = By.xpath(".//a[contains(@class,'button lnk_view')]/span");

    public static By POPUP_CLOSE = By.xpath(".//span[@class='cross']");
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
                System.out.println(" " + item.getAttribute("style"));
                webElementsStrings.add(item.getAttribute("style").substring(item.getAttribute("style").indexOf('('), item.getAttribute("style").length() - 1));
                for (int k = 0; k < webElementsStrings.size(); k++) {
                    if (webElementsStrings.get(k).contains("(255, 255, 255)")) {
                        webElementsStrings.remove(k);
                        webElementsStrings.add("White");
                    } else if (webElementsStrings.get(k).contains("(67, 74, 84)")) {
                        webElementsStrings.remove(k);
                        webElementsStrings.add("Black");
                    } else if (webElementsStrings.get(k).contains("(243, 156, 17)")) {
                        webElementsStrings.remove(k);
                        webElementsStrings.add("Orange");
                    } else if (webElementsStrings.get(k).contains("(93, 156, 236)")) {
                        webElementsStrings.remove(k);
                        webElementsStrings.add("Blue");
                    } else if (webElementsStrings.get(k).contains("(160, 212, 104)")) {
                        webElementsStrings.remove(k);
                        webElementsStrings.add("Green");
                    } else if (webElementsStrings.get(k).contains("(241, 196, 15)")) {
                        webElementsStrings.remove(k);
                        webElementsStrings.add("Yellow");
                    }
                }
            }
            if (webElementsStrings.contains(color)) {
                System.out.printf("Iteration: %d\nItem Nr.: %d\nColor list: %s\n", i, i + 1, webElementsStrings);
                System.out.printf("Item Nr. %d contains %s color!\n\n", i + 1, color);
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

    public int getCounterValue(By locator) {
        WebElement el = baseFunc.browser.findElement(locator);
        return Integer.parseInt(el.getText().replaceAll("\\D+", ""));
    }

    public List<Double> getDisplayedProductItemPrices(By locator) {
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

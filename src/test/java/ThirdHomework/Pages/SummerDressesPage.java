package ThirdHomework.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SummerDressesPage {
    private BaseFunc baseFunc;

    public final By FIRST_PRODUCTS_IMAGE = By.xpath(".//div[@class='product-container']");
    public final By FIRST_PRODUCTS_ADD = By.xpath("(.//a[contains(@title,'Add to cart')])[1]");
    public final By FIRST_PRODUCT_PRICE = By.xpath("(.//*[@class='price product-price'])[2]");

    public final By PRODUCTS = By.xpath(".//div[@class='product-container']");
    public final By COLOR_PICK = By.xpath(".//a[@class='color_pick']");
    public final By LIST_VIEW = By.id("list");
    public final By CATEGORY = By.xpath(".//span[@class='cat-name']");
    public final By MORE_BTN = By.xpath(".//a[contains(@class,'button lnk_view')]/span");


    public SummerDressesPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void getElemetsCont() {
        List<WebElement> elParent = baseFunc.getElements(PRODUCTS);
        List<WebElement> el = elParent.get(1).findElements(COLOR_PICK);
        ;
        List<String> webElementsStrings = new ArrayList<String>();
        Map<Integer, String> states = new HashMap<Integer, String>();

    }

    public boolean getElementInfoTest2() {
        List<WebElement> elParent = baseFunc.getElements(PRODUCTS);
        List<WebElement> el;
        List<String> webElementsStrings = new ArrayList<String>();
        int counter = 0;
        System.out.println("Elements contain color:\n");
        for (int i = 0; i < elParent.size(); i++) {
            el = elParent.get(i).findElements(COLOR_PICK);

            for (WebElement item : el) {
                webElementsStrings.add(item.getAttribute("style"));

            }
            System.out.printf("iterantion: %d\nList: %s", i, webElementsStrings);
            if (webElementsStrings.contains("(611, 114, 185)")) {
                System.out.printf("Product: %d\nPicker size: %d\nColor: %s\n\n", i, el.size(), webElementsStrings);
                counter++;
                //return webElementsStrings;
            } else if (counter == elParent.size()) {
                return true;
            } else {
                webElementsStrings.clear();
                break;
            }
        }
        return false;
    }

    public boolean checkIfAllItemsHaveColor(String color) {
        List<WebElement> elParent = baseFunc.getElements(PRODUCTS);
        List<WebElement> el;
        List<String> webElementsStrings = new ArrayList<String>();
        int counter = 0;

        for (int i = 0; i < elParent.size(); i++) {
            el = elParent.get(i).findElements(COLOR_PICK);
            for (WebElement item : el
            ) {
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



    public PopUp goToPopUp() {

        WebElement firstProductImage = baseFunc.getElement(FIRST_PRODUCTS_IMAGE);
        WebElement firstProductAddToCart = baseFunc.getElement(FIRST_PRODUCTS_ADD);

        baseFunc.moveToElement(firstProductImage).perform();
        baseFunc.waitForElementToBeClickable(FIRST_PRODUCTS_ADD);
        baseFunc.moveToElement(firstProductAddToCart).click().perform();

       /* List<WebElement> webElements = baseFunc.getElements(MORE_BTN);
        webElements.get(item).click();*/
        return new PopUp(baseFunc);
    }
}

package ThirdHomework.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DressesPage {
    BaseFunc baseFunc;
    private final By LOADER = By.xpath("(.//img/@src)[14]");
    private final By FILTER_COLOR = By.name("layered_id_attribute_group_13");

    public final By PRODUCTS = By.xpath(".//div[@class='product-container']");

    public final By COLOR_PICK = By.xpath(".//a[@class='color_pick']");

    private final By ITEM_NAME = By.xpath(".//a[@class='product-name']");
    private final By FIRST_ITEM = By.xpath(".//*[contains(@class,'first-item-of-tablet-line')]/div");
    private final By SECOND_ITEM = By.xpath("(.//*[contains(@class,'ajax_block_product')]/div)[2]");
    public final By SUMMER_DRESSES = By.xpath("//div[@id='subcategories']/ul/li[3]");

    private final By BUTTON_CONTAINER = By.xpath(".//div[@class='right-block']");
    private final By ADD_TO_CART = By.xpath("(.//*[contains(@class,'first-item-of-tablet-line')]/div/div/div/a/span)[2]");
    private final By ADD_TO_CART_2 = By.xpath("((.//*[contains(@class,'ajax_block_product')]/div)[2]/div/div/a/span)[2]");

    public DressesPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public List<String> getElementInfo(By locator) {
        List<WebElement> webElements = baseFunc.getElements(locator);
        List<String> webElementsStrings = new ArrayList<String>();
        for (WebElement item : webElements) {
            webElementsStrings.add(item.getText());
        }
        return webElementsStrings;
    }

    public List<String> getElementInfoByAttribute(By locator, String attribute) {
        List<WebElement> webElements = baseFunc.getElements(locator);
        List<String> webElementsStrings = new ArrayList<String>();
        for (WebElement item : webElements) {
            webElementsStrings.add(item.getAttribute(attribute));
        }
        return webElementsStrings;
    }



    public DresesPopUp addToCartFirstItem() {
        baseFunc.getElement(FIRST_ITEM).click();
        baseFunc.waitTime();
        baseFunc.getElement(ADD_TO_CART).click();
        return new DresesPopUp(baseFunc);
    }

    public DresesPopUp addToCartSecondItem() {
        WebElement secondItem = baseFunc.getElement(SECOND_ITEM);
        baseFunc.moveToElement(secondItem).perform();
        baseFunc.waitTime();
        baseFunc.getElement(ADD_TO_CART_2).click();
        return new DresesPopUp(baseFunc);
    }

    public DressesPage checkColorBox() {
        baseFunc.getElement(FILTER_COLOR).click();
        baseFunc.waitForElementDisappear(LOADER);
        return new DressesPage(baseFunc);
    }

    public boolean isColorPresent(By locator, String orangeColor) {
        boolean isColorPresent = false;
        List<WebElement> items = baseFunc.getElements(locator);
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).findElement(COLOR_PICK).getAttribute("style").contains(orangeColor)) {
                isColorPresent = true;
                break;
            }
        }
        return isColorPresent;
    }

    /*public WebElement getProductByName(String name) {
        List<WebElement> products = baseFunc.getElements(FILTERED_ELEMENTS);
        for (WebElement we : products
        ) {
            if (we.findElement(ITEM_NAME).getText().contains(name)) {
                return we;
            }
        }
        return null;
    }*/

    public SummerDressesPage goSummerDressesPage() {
        baseFunc.waitForElementToBeClickable(SUMMER_DRESSES);
        baseFunc.getElement(SUMMER_DRESSES).click();
        return new SummerDressesPage(baseFunc);
    }
}
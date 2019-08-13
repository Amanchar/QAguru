package ThirdHomework.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SummerDressesPage {
    BaseFunc baseFunc;

    public final By PRODUCTS = By.xpath(".//div[@class='product-container']");
    public final By COLOR_PICK = By.xpath(".//a[@class='color_pick']");
    public final By LIST_VIEW = By.id("list");


    public SummerDressesPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public boolean getElementInfoTest() {
        List<WebElement> elParent = baseFunc.getElements(PRODUCTS);
        List<WebElement> el;
        List<String> webElementsStrings = new ArrayList<String>();
        int counter = 0;
        System.out.println("Elements contain color:\n");
        for (int i = 0; i < elParent.size(); i++) {
            el = elParent.get(i).findElements(COLOR_PICK);

            for (WebElement item : el
            ) {
                webElementsStrings.add(item.getAttribute("style"));
            }
            if (webElementsStrings.contains("background: rgb(241, 196, 15);")) {
                System.out.printf("Product: %d\nPicker size: %d\nColor: %s\n\n", i, el.size(), webElementsStrings);
                counter++;
            }
            webElementsStrings.clear();

            if (counter == elParent.size()) {
                return true;
            }
        }
        return false;
    }

}

package ThirdHomework.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductPage {
    private BaseFunc baseFunc;

    private final By COLOR_PICK_LIST = By.xpath(".//a[contains(@class,'color_pick')]");

    public ProductPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public boolean isColorPresent() {
        List<WebElement> items = baseFunc.getElements(COLOR_PICK_LIST);
        System.out.printf("Elements count:  %d ", items.size());

        for (WebElement item : items) {
            //String str = item.getAttribute("style");
            System.out.printf("Attributes:  %s ", item.getAttribute("style"));

            if (item.getAttribute("style").contains("background: rgb(241, 196, 15);")) {
                //isColorPresent = true;
                return true;
            }
        }
        return false;
    }
}

package ThirdHomework.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductPage {
    private BaseFunc baseFunc;

    private final By ORANGE_COLOR = By.id("color_13");
    private final By PRODUCT_DESCRIPTION = By.xpath(".//div[@class='box-info-product']");

    public ProductPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public boolean isColorPresent(String orangeColor) {
        boolean isColorPresent = false;
        List<WebElement> items = baseFunc.getElements(PRODUCT_DESCRIPTION);
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).findElement(ORANGE_COLOR).getAttribute("style").contains(orangeColor)) {
                isColorPresent = true;
                break;
            }
        }
        return isColorPresent;
    }
}

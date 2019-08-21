package ThirdHomework.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PopUp {
    private BaseFunc baseFunc;

    public static By POPUP_LAYER = By.id("layer_cart");
    public static By POPUP_LAYER_PRODUCT_PRICE = By.id("layer_cart_product_price");
    private static By POPUP_CLOSE = By.xpath(".//span[@class='cross']");


    PopUp(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public boolean checkLayerVisible(By locator) {
        List<WebElement> layerElement = baseFunc.getElements(locator);
        return layerElement.size() != 0;
    }

    public void closePopUpLayer() {
        baseFunc.getElement(POPUP_CLOSE).click();
    }
}

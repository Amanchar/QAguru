package ThirdHomework.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProductPage {
    private BaseFunc baseFunc;

    private final By COLOR_PICK_LIST = By.xpath(".//a[contains(@class,'color_pick')]");
    private final By DRESSES_PAGE_LINK = By.xpath("(.//a[contains(@title,'Summer Dresses')])[3]");
    public final By PRODUCT_PRICE = By.id("our_price_display");

    ProductPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public boolean isColorPresent(String colorToCheck) {
        List<WebElement> items = baseFunc.getElements(COLOR_PICK_LIST);
        List<String> itemStrings = new ArrayList<String>();
        for (WebElement item : items
        ) {
            itemStrings.add(item.getAttribute("style").substring(item.getAttribute("style").indexOf('('), item.getAttribute("style").length() - 1));
        }
        baseFunc.colorParser(itemStrings);
        return itemStrings.contains(colorToCheck);
    }

    public SummerDressesPage goToSummerDressesPage() {
        WebElement linkSummerDresses = baseFunc.getElement(DRESSES_PAGE_LINK);
        baseFunc.moveToElement(linkSummerDresses).click().perform();
        return new SummerDressesPage(baseFunc);
    }

}

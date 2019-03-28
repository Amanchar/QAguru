package ThirdHomework.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CheckoutPage {
    BaseFunc baseFunc;

    private final By ITEM_PRICES = By.xpath(".//*[contains(@id,'total_product_price')]");
    private final By TOTAL_SUM = By.id("total_product");


    public CheckoutPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public List<String> getSelectedProductPrices() {
        List<WebElement> priceElements = baseFunc.getElements(ITEM_PRICES);
        List<String> priceStrings = new ArrayList<String>();
        for (int i = 0; i < priceElements.size(); i++) {
            priceStrings.add(priceElements.get(i).getText().substring(1));
        }
        return priceStrings;
    }

    public List<Double> convertSelectedProductPricesToDouble() {
        List<Double> doubleList = new ArrayList<Double>();
        for (String str : getSelectedProductPrices()
        ) {
            doubleList.add(Double.valueOf(str));
        }
        return doubleList;
    }

    public double sumOfSelectedProducts() {
        double sum = 0;
        for (double i : convertSelectedProductPricesToDouble())
            sum = sum + i;
        double expSum = (double) Math.round(sum * 100) / 100;
        return expSum;
    }

    public double totalPrice() {
        WebElement totalPriceElement = baseFunc.getElement(TOTAL_SUM);
        String totalPriceString = totalPriceElement.getText().substring(1);
        Double totalSum = Double.valueOf(totalPriceString);
        double roundOfSum = (double) Math.round(totalSum * 100) / 100;
        return roundOfSum;
    }
}

package FourthHomework.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DavanasPage {
    private BaseFunc baseFunc;

    private final By NAMES_DAVANAS = By.xpath(".//*[contains(@class,'Today')]/div/span/a");

    public DavanasPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public List<String> getDavanasNames() {
        List<WebElement> namesDavanasElements = baseFunc.getElements(NAMES_DAVANAS);
        List<String> namesDavanasStrings = new ArrayList<String>();
        for (int i = 0; i < namesDavanasElements.size(); i++) {
            namesDavanasStrings.add(namesDavanasElements.get(i).getText());
        }

        Collections.sort(namesDavanasStrings);
        return namesDavanasStrings;
    }
}

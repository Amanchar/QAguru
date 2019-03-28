package FifthHomework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class FinalPage {
    BaseFunc baseFunc;

    private final By FINAL_TEXT = By.xpath(".//div[@class='finalTxt']");

    public FinalPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void checkFinalPage() {
        Assertions.assertEquals("Thank You for flying with us!", baseFunc.getElement(FINAL_TEXT), "NO REGISTRATION!!!!");
    }
}

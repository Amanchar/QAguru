package FifthHomework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FinalPage {
    private BaseFunc baseFunc;

    private final By FINAL_TEXT = By.xpath(".//div[contains(@class,'finalTxt')]");

    public FinalPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void checkFinalPage() {
        baseFunc.waitForElement(FINAL_TEXT);
        Assertions.assertEquals("Thank You for flying with us!", baseFunc.getElement(FINAL_TEXT).getText(), "NO REGISTRATION!!!!");
    }
}

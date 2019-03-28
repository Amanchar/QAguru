package ThirdHomework.Pages;

import org.openqa.selenium.By;

public class DresesPopUp {
    BaseFunc baseFunc;
    private final By CROSS = By.xpath(".//span[@class='cross']");
    private final By PROCEED = By.xpath("(.//*[contains(@class,'default button button-medium')]/span)[1]");

    public DresesPopUp(BaseFunc baseFunc){
        this.baseFunc = baseFunc;
    }

    public DresesPopUp closePopUp (){
        baseFunc.getElement(CROSS).click();
        return new DresesPopUp(baseFunc);
    }
    public CheckoutPage proceedToCheckout (){
        baseFunc.getElement(PROCEED).click();
        return new CheckoutPage(baseFunc);
    }
}

package FifthHomework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
    private BaseFunc baseFunc;

    private final By DEPARTURE = By.id("afrom");
    private final By ARRIVAL = By.id("bfrom");
    private final By GOGOGO = By.xpath(".//span[@class='gogogo']");

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void selectDepartureAirport(String departure) {
        Select select = new Select(baseFunc.getElement(DEPARTURE));
        select.selectByValue(departure);
    }

    public void selectArrivalAirport(String arrival) {
        Select select = new Select(baseFunc.getElement(ARRIVAL));
        select.selectByValue(arrival);
    }

    public RegistrationPage goToRegistrationPage() {
        baseFunc.getElement(GOGOGO).click();
        return new RegistrationPage(baseFunc);
    }

}

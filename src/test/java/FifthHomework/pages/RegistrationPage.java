package FifthHomework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RegistrationPage {
    BaseFunc baseFunc;

    private final By NAME = By.id("name");
    private final By SURNAME = By.id("surname");
    private final By DISCOUNT = By.id("discount");
    private final By PASSANGERS = By.id("adults");
    private final By CHILDRENS = By.id("children");
    private final By LUGGAGE = By.id("bags");
    private final By FLIGHT_DATE = By.id("flight");
    private final By GET_PRICE = By.xpath(".//span[text() = 'Get Price']");
    private final By RESPONSE = By.id("response");

    private final By BOOK_BUTTON = By.id("book2");



    public RegistrationPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public List<WebElement> checkRegistrationFrom(By REGISTRATION_FORM) {
        Assertions.assertFalse(baseFunc.getElements(REGISTRATION_FORM).isEmpty());
        return baseFunc.getElements(REGISTRATION_FORM);
    }

    public void fillNameField(String name) {
        baseFunc.getElement(NAME).sendKeys(name);

    }

    public void fillSurnameField(String surname) {
        baseFunc.getElement(SURNAME).sendKeys(surname);

    }

    public void fillDiscountField(String discount) {
        baseFunc.getElement(DISCOUNT).sendKeys(discount);

    }

    public void fillPassangersField(String passangers) {
        baseFunc.getElement(PASSANGERS).sendKeys(passangers);

    }

    public void fillChildrensField(String childrens) {
        baseFunc.getElement(CHILDRENS).sendKeys(childrens);

    }

    public void fillLuggageField(String luggage) {
        baseFunc.getElement(CHILDRENS).sendKeys(luggage);

    }


    public void selectFlightDate(String flightDate) {
        Select select = new Select(baseFunc.getElement(FLIGHT_DATE));
        select.selectByValue(flightDate);
    }

    public void clickGetPrice() {
        baseFunc.getElement(GET_PRICE).click();
    }

    public String getPrice() {
        WebElement finalPriceElement = baseFunc.getElement(RESPONSE);
        String finalPriceText = finalPriceElement.getText();
        finalPriceText.substring(finalPriceText.indexOf("for ") + 1, finalPriceText.indexOf(" EUR"));

        return finalPriceText;
    }

    public String getReservationNumber() {
        WebElement reservationNumberElement = baseFunc.getElement(RESPONSE);
        String reservationNumberText = reservationNumberElement.getText();
        reservationNumberText.substring(reservationNumberText.indexOf("is ") + 1, reservationNumberText.indexOf(" !"));

        return reservationNumberText;
    }

    public SeatPage clickBookButton() {
        baseFunc.getElement(BOOK_BUTTON).click();
        return new SeatPage(baseFunc);
    }


}

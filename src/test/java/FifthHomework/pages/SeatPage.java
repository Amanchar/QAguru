package FifthHomework.pages;

import org.openqa.selenium.By;

public class SeatPage {
    private BaseFunc baseFunc;
    private final By SEATS = By.id("seats");

    private final By SEAT = By.xpath(".//div[contains(@onclick,'seat(1)')]");
    private final By FINAL_BOOK_BUTTON = By.id("book3");


    public SeatPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void selectSeat() {
        baseFunc.waitForElement(SEATS);
        baseFunc.getElement(SEAT).click();
    }

    public FinalPage clickBook() {
        baseFunc.getElement(FINAL_BOOK_BUTTON).click();
        return new FinalPage(baseFunc);
    }

}

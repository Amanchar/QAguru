/*
package FifthHomework;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
//import model.Response;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
//import pages.*;

import java.util.Map;

public class reservationTicketStepDefs {

    public final By REGISTRATION_FORM = By.xpath(".//div[@class='fullForm']");
    private final By SEAT_SELECTOR = By.id("seats");

    //private BaseFunc baseFunc = new BaseFunc();
    private final String HOME_PAGE = "http://qaguru.lv:8090/tickets/";
    private String departure_city;
    private String destination_city;
    private Integer seatNumber;

    private UserData user = new UserData();
    //private HomePage homePage;

    String reservationNumber;

    //RegistrationPage registrationPage = new RegistrationPage(baseFunc);
    //SeatPage seatPage = new SeatPage(baseFunc);

    private ReservationRequester requester = new ReservationRequester();
    //private Response response;

    @Given("departure airport (.*)")
    public void set_departure_airport(String departure_city) {
        this.departure_city = departure_city;
    }


    @Given("destination airport (.*)")
    public void set_destination_airport(String destination_city) {
        this.destination_city = destination_city;
    }

    @Given("user data is:")
    public void set_user_data(Map<String, String> params) {
        user.setName(params.get("name"));
        user.setSurname(params.get("surname"));
        user.setDiscountCode(params.get("discountCode"));
        user.setTravellerCount(Integer.valueOf(params.get("travellerCount")));
        user.setChildrenCount(Integer.valueOf(params.get("childrenCount")));
        user.setLuggage(Integer.valueOf(params.get("luggage")));
        user.setNextFlight(params.get("nextFlight"));
    }

    @Given("seat number is (.*)")
    public void set_seat_number(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    */
/*@Given("we're on a home page")
    public void home_page() {
        baseFunc.goToPage(HOME_PAGE);
        homePage = new HomePage(baseFunc);
    }*//*


    */
/*@When("we're selecting airports")
    public void selecting_airport() {
        homePage.selectDepartureAirport("RIX");
        homePage.selectArrivalAirport("MEL");
    }*//*


    @When("we're pressing GoGoGo button")
    public void pressing_button() {
        homePage.goToRegistrationPage();
    }

    @Then("registration page appears")
    public void check_registration_page() {
        Assertions.assertFalse(baseFunc.getElements(REGISTRATION_FORM).isEmpty(), "NO REGISTRATION FROM");

    }


    @When("we're filling in registration form")
    public void filling_registration_form() {
        registrationPage.fillNameField(user.getName());
        registrationPage.fillSurnameField(user.getSurname());
        registrationPage.fillDiscountField(user.getDiscountCode());
        registrationPage.fillPassangersField(user.getTravellerCount());
        registrationPage.fillChildrensField(user.getChildrenCount());
        registrationPage.fillLuggageField(user.getLuggage());
        registrationPage.selectFlightDate(user.getNextFlight());
    }

    @When("we're pressing get price button")
    public void pressing_get_price_button() {
        registrationPage.clickGetPrice();
    }

    @Then("our price will be (.*) eur")
    public void price_check(Integer price) {
        reservationNumber = registrationPage.getReservationNumber();
        Assertions.assertEquals(Integer.valueOf(registrationPage.getPrice()), price, "No match!!!");
    }

    @When("press book button")
    public void pressing_book_button() {
        registrationPage.clickBookButton();
    }

    @Then("we are redirected to seat page")
    public void seat_page() {
        Assertions.assertFalse(baseFunc.getElements(SEAT_SELECTOR).isEmpty(), "NO SEAT SELECTOR");
    }

    @When("we are selecting seat number")
    public void selecting_seat_num() {
        seatPage.selectSeat();

    }

    @When("we are clicking Book button")
    public void clicking_book_button() {
        seatPage.clickBook();

    }

    @Then("successful registration page appears")
    public void registration_page_appears() {
        FinalPage finalPage = new FinalPage(baseFunc);
        finalPage.checkFinalPage();
    }

    @When("we're requesting reservation list")
    public void requesting_registration_list() {


    }

    @Then("we can see our reservation in the list")
    public void checking_registration() {
    }

    @When("we are deleting our reservation ticket")
    public void deleting_reservation_from_list() {
    }

    @When("we requesting reservation list again")
    public void requesting_list_again() {
    }

    @Then("we can see that our reservation in not in the list")
    public void checking_if_reservation_deleted() {
    }
}
*/

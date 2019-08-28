package FifthHomework;

public class UserData {

    private String name;
    private String surname;
    private String discountCode;
    private Integer travellerCount;
    private Integer childrenCount;
    private Integer luggage;
    private String nextFlight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public String getTravellerCount() {
        return travellerCount.toString();
    }

    public void setTravellerCount(Integer travellerCount) {
        this.travellerCount = travellerCount;
    }

    public String getChildrenCount() {
        return childrenCount.toString();
    }

    public void setChildrenCount(Integer childrenCount) {
        this.childrenCount = childrenCount;
    }

    public String getLuggage() {
        return luggage.toString();
    }

    public void setLuggage(Integer luggage) {
        this.luggage = luggage;
    }

    public String getNextFlight() {
        return nextFlight;
    }

    public void setNextFlight(String nextFlight) {
        this.nextFlight = nextFlight;
    }
}

package FifthHomework;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Response;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ReservationRequester {

    private final String url = "http://www.qaguru.lv:8090/tickets/getReservations.php";

    public List<Response> getReservasionData() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Response> myObjects = Arrays.asList(mapper.readValue(url,Response.class));
        return myObjects;
    }
}

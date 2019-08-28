package FifthHomework;

import FifthHomework.model.ReservationData;
import FifthHomework.model.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

public class ReservationRequester {

    private final String GET_RESERVATIONS = "http://www.qaguru.lv:8089/tickets/getReservations.php";

    RestTemplate restTemplate = new RestTemplate();

    public Response getReservationData() throws IOException {
        String response = restTemplate.getForEntity(GET_RESERVATIONS, String.class).getBody();
        System.out.println(response);
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(response, Response.class);
    }
}

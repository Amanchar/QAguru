package FifthHomework;

import org.springframework.web.client.RestTemplate;

import java.io.IOException;

public class ReservationRequester {

    private final String GET_RESERVATIONS = "http://www.qaguru.lv:8089/tickets/getReservations.php";

    RestTemplate restTemplate = new RestTemplate();

    String getReservationData() throws IOException {
        String response = restTemplate.getForEntity(GET_RESERVATIONS, String.class).getBody();
        System.out.println(response);
        /*ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response, Response.class);*/
        return response;
    }
}

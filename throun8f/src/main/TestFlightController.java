package main;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestFlightController {

    String departure = "AEK";
    String destination = "REK";
    String dateFrom = "06/07/22";
    String dateTo = "08/07/22";


    Flight[] f;

    {
        try {
            f = FlightController.search(departure, destination, dateFrom,  dateTo);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    Flight[] results = new Flight(470, "AYE", "REK", "07/07/2022", "07/07/2022", "10:05","10:47:32",80,25300);


    @Test
    public void testPrintMessage() {
        assertEquals(f,Flight);
    }
}
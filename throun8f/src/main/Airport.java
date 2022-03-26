package main;

import java.util.Date;

public class Airport extends FlightDetails {
    String name;
    Flight flight[];

    public Airport(String arrivalDate, String arrivalTime, String departureDate, String departureTime) {
        super(arrivalDate, arrivalTime, departureDate, departureTime);
    }

    public Flight[] getFlight(Date dateFrom, Date dateT){
        return null;
    }
}

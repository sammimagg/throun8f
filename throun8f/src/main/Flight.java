package main;

import java.util.Date;
import java.util.List;

public class Flight
{
    public List<FlightDetails> flightDetails;

    public Flight(List<FlightDetails> flightDetails)
    {
        this.flightDetails = flightDetails;
    }

    public List<FlightDetails> getFlights(String departure, String destination, Date date)
    {
        return flightDetails;
    }
}

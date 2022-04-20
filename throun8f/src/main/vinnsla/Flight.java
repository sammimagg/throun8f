package main.vinnsla;

import javafx.collections.ObservableList;

public class Flight
{
    static ObservableList<FlightDetails> flightDetails;

    public Flight(String departure, String destination, String date, int seats) throws ClassNotFoundException
    {
        flightDetails =  FlightController.search(departure, destination, date,seats);
    }
    public ObservableList<FlightDetails> getFlights()
    {
        return flightDetails;
    }
}

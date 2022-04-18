package main;


import javafx.collections.ObservableList;

public class FlightController {


    static ObservableList<FlightDetails> flightdatabaseUtility;

    public static ObservableList<FlightDetails> search(String departure, String destination, String dateFrom, String dateTo) throws ClassNotFoundException
    {
        flightdatabaseUtility = FlightDatabaseUtility.search(departure, destination, dateFrom, dateTo);
        return flightdatabaseUtility;
    }
    public static void add(Flight flight)
    {
        FlightDatabaseUtility.add(flight);
    }
    public static void remove(Flight flight)
    {

    }
    public static void book(Seat seat, int FlightID, Passenger passenger)
    {

    }
    public ObservableList<FlightDetails> getFlightdatabaseUtility()
    {
        return flightdatabaseUtility;
    }
}
package main.vinnsla;

import javafx.collections.ObservableList;

public class FlightController {
    static ObservableList<FlightDetails> flights;
    public static ObservableList<FlightDetails> search(String departure, String destination, String date, int seats) throws ClassNotFoundException
    {
        flights =  FlightDatabaseUtility.search(departure, destination, date,seats);
        return flights;
    }
    public static void book(Seat seat, FlightDetails flightDetails, Passenger passenger) throws ClassNotFoundException
    {
        FlightDatabaseUtility.update(flightDetails);
        BookController.book(passenger,seat.getId(),flightDetails);
    }
    public static int seatLeftOnFlight(int flightid) throws ClassNotFoundException
    {

        return FlightDatabaseUtility.numberOfSeatsLeft(flightid);
    }
}

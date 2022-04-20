package main.vinnsla;


public class BookController {
    private static UserDatabaseUtility databaseUtility;

    public static void book(Passenger passenger, int seatId, FlightDetails flightDetails) throws ClassNotFoundException
    {
        databaseUtility.add(passenger, seatId, flightDetails);
    }
}

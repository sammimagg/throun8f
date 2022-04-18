package main;


public class BookController {
    private static UserDatabaseUtility databaseUtility;

    public static void book(Passenger passenger, int seatId, int flightId) throws ClassNotFoundException
    {
        databaseUtility.add(passenger, seatId, flightId);
    }
}

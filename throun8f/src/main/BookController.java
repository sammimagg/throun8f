package main;


public class BookController {
    private static UserDatabaseUtility databaseUtility;

    public static void book(Passenger passenger) throws ClassNotFoundException
    {
        //find flightid and book seat and make one less seat available.

        databaseUtility.add(passenger);

    }
}

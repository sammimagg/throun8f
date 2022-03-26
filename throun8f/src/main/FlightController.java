package main;

public class FlightController {


    static Flight[] flightdatabaseUtility;

    public static Flight[] search(String departure, String destination, String dateFrom, String dateTo) throws ClassNotFoundException {

        flightdatabaseUtility = FlightDatabaseUtility.search(departure, destination, dateFrom, dateTo);
        //FlightDatabaseUtility.search(departure, destination,  dateFrom,  dateTo);
        return flightdatabaseUtility;
    }
    public static void add(Flight flight){

    }
    public static void remove(Flight flight){

    }
    public static void book(Seat seat, int FlightID, Passenger passenger){

    }
    public Flight[] getFlightdatabaseUtility() {
        return flightdatabaseUtility;
    }


}
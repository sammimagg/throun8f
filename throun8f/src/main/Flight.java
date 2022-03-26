package main;

public class Flight {
    FlightDetails flightDetails;

    public Flight(String arrivalDate, String arrivalTime, String departureDate, String departureTime) {
       flightDetails = new FlightDetails(arrivalDate, arrivalTime, departureDate, departureTime);
    }

    public  FlightDetails getFlights(){
        return flightDetails;
    }
}

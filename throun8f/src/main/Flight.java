package main;

public class Flight {
    FlightDetails flightDetails;

    public Flight(String arrivalDate, String arrivalTime, String departureDate, String departureTime, Seat seats) {
       flightDetails = new FlightDetails(arrivalDate, arrivalTime, departureDate, departureTime, seats);
    }

    public  FlightDetails getFlights(){
        return flightDetails;
    }
}

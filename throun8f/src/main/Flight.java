package main;

public class Flight {
    FlightDetails flightDetails;

    public Flight(String arrivalCity, String arrivalDate, String arrivalTime,String departureCity, String departureDate, String departureTime, Seat seats) {
       flightDetails = new FlightDetails(arrivalCity, arrivalDate, arrivalTime,departureCity, departureDate, departureTime, seats);
    }

    public  FlightDetails getFlights(){
        return flightDetails;
    }
}

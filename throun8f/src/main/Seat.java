package main;

public class Seat extends FlightDetails {
    int id;
    int number;
    String details;


    int price;
    boolean booked;


    public Seat(String arrivalDate, String arrivalTime, String departureDate, String departureTime) {
        super(arrivalDate, arrivalTime, departureDate, departureTime);
    }
    public int getPrice() {
        return price;
    }

}

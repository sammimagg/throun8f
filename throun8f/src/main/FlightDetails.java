package main;

public class FlightDetails {
    private int id;
    private String arrivalDate;
    private String arrivalTime;
    private String departureDate;
    private String departureTime;
    private Seat seats;
    private Plane[] plane;


    public FlightDetails(String arrivalDate, String arrivalTime, String departureDate, String departureTime,Seat seats)
    {
        this.arrivalDate = arrivalDate;
        this.arrivalTime = arrivalTime;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.seats = seats;
    }
    public Passenger getPassengers()
    {
        return null;
    }
    public Seat availableSeats()
    {
        return seats;
    }
    private void bookSeat(int id,Passenger passenger)
    {

    }
    private void cancelSeat(int id, Passenger passenger)
    {

    }
    public String getArrivalDate() {
        return arrivalDate;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }
}

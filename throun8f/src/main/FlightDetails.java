package main;

public class FlightDetails {
    private int id;
    private String arrivalCity;
    private String arrivalDate;
    private String arrivalTime;
    private String departureCity;
    private String departureDate;
    private String departureTime;
    private Seat seats;
    private Plane[] plane;


    public FlightDetails(String arrivalCity,String arrivalDate, String arrivalTime,String departureCity, String departureDate, String departureTime,Seat seats)
    {
        this.arrivalCity = arrivalCity;
        this.arrivalDate = arrivalDate;
        this.arrivalTime = arrivalTime;
        this.departureCity = departureCity;
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
    public String getArrivalCity() { return arrivalCity;}
    public String getDepartureCity() { return departureCity;}
}

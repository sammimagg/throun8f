package main;

public class FlightDetails {
    private int id;
    private String arrivalDate;
    private String arrivalTime;
    private String departureDate;
    private String departureTime;


    public FlightDetails(String arrivalDate, String arrivalTime, String departureDate, String departureTime)
    {
        this.arrivalDate = arrivalDate;
        this.arrivalTime = arrivalTime;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
    }
    public int getId() {
        return id;
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

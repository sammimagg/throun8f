package main.vinnsla;

import main.helper.City;

public class FlightDetails
{
    private int id;
    private Airport arrivalAirport;
    private Airport departureAirport;
    private Plane plane;
    private String arrivalDate;
    private String arrivalTime;
    private String departureDate;
    private String departureTime;
    private Seat[] seats;



    public FlightDetails(City arrivalCity, String  arrivalDate, String arrivalTime, City departureCity, String departureDate, String departureTime)
    {
        this.arrivalDate = arrivalDate;
        this.arrivalTime = arrivalTime;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.departureAirport = new Airport();
        this.arrivalAirport = new Airport();
        arrivalAirport.setCityName(arrivalCity);
        departureAirport.setCityName(departureCity);
        plane = new Plane("Boeing 747", 80);


    }
    public void setArrivalAirport(Airport airport)
    {
        this.arrivalAirport = airport;
    }
    public void setDepartureAirport(Airport airport)
    {
        this.departureAirport = airport;
    }


    public Passenger getPassengers()
    {
        return null;
    }
    public Seat[] availableSeats()
    {
        return this.seats;
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
    public City getArrivalCity() { return arrivalAirport.name;}
    public City getDepartureCity() { return departureAirport.name;}

    public int getID()
    {
        return id;
    }
    public void setID(int id){
        this.id = id;
    }
    public void setSeats(Seat[] seats){
        this.seats = seats;
    }
    public Seat[] getSeats()
    {
        return seats;
    }
    public Seat getAvailableSeat() throws ClassNotFoundException {
        for(int i = 0; i < seats.length; i++)
        {
            if(seats[i].booked == false)
            {
                seats[i].booked = true;
                return seats[getSeatCapacity()-seats.length];

            }
        }
        System.out.println("No seats");
        return null;
    }
    public int numberOfSeatsAvailable()
    {
        return seats.length;
    }
    public int getSeatCapacity(){
        return plane.getSeatCapacity();
    }



}

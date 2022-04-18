package main;

public class Seat  {



    int id;
    int number;
    String details;
    int price;
    boolean booked;
    public Seat(int id, int number, String details, int price, boolean booked)
    {
        this.id = id;
        this.number = number;
        this.details = details;
        this.price = price;
        this.booked = booked;
    }

    public void add(Passenger passenger)
    {

    }
    public void update(Passenger passenger)
    {

    }
    public int getPrice()
    {
        return price;
    }

    public int getId() {
        return id;
    }
}
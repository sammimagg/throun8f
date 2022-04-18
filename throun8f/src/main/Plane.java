package main;

public class Plane{
    private String model;
    private int seatCapacity;

    public Plane(String model, int seatCapacity)
    {

        this.seatCapacity = seatCapacity;
        this.model = "Boeing 747";
    }
    public int getSeatCapacity()
    {
        return seatCapacity;
    }

}

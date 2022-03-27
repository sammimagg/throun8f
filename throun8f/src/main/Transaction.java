package main;

import java.util.Date;

public class Transaction extends Seat{
    int id;
    String details;
    Date date;

    public Transaction(int id, int number, String details, int price, boolean booked) {
        super(id, number, details, price, booked);
    }

    private Transaction getTransaction(int id)
    {
        return null;
    }
}

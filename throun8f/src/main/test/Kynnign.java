package main.test;

import main.vinnsla.Flight;
import main.vinnsla.FlightController;
import main.vinnsla.FlightDetails;
import main.vinnsla.Passenger;

public class Kynnign {
        public static void test() throws ClassNotFoundException {


            Flight flight = new Flight("Reykjavík", "Akureyri", "21/04/2022",  1);


            for(FlightDetails f : flight.getFlights())
            {
                System.out.println("Airport from " + f.getDepartureCity() + " Airport to " + f.getArrivalCity() + " Date " + f.getDepartureDate() + ". Price per person " + f.getSeats()[0].getPrice() + " kr.");

            }
            Passenger pass = new Passenger("Matthías Garðarsson", "Laugarvegur 1", 101, "mag@hi.is", 5812345);

            FlightController.book(flight.getFlights().get(0).getAvailableSeat(),flight.getFlights().get(0),pass);

        }



}

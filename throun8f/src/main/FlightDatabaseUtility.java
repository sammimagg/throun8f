package main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.text.SimpleDateFormat;

public class FlightDatabaseUtility extends FlightController {
    public static void add(Flight flight){
        int id = 1;
//        String sql = "INSERT INTO Flights(id, departureAirport,arrivalAirport, departureDate, arrivalDate, departureTime, arrivalTime, seatsAvailable, ticketPrice) " +
//                "VALUES ('" +
//                id + "', '" +
//                flight.getFlights().getDepartureCity() + "', '" +
//                flight.getFlights().getArrivalCity() + "', '" +
//                flight.getFlights().getDepartureDate() + "', '" +
//                flight.getFlights().getArrivalDate() + "', '" +
//                flight.getFlights().getDepartureTime() + "','" +
//                flight.getFlights().getArrivalTime() + "','" +
//                flight.getFlights().getPassengers().



    }
    public static ObservableList<FlightDetails> search(String departure, String destination, String dateFrom, String dateTo) throws ClassNotFoundException
    {
        Class.forName("org.sqlite.JDBC");
        City arrivalAirport = CityTag.getCityTag(destination);     // Convert from Akureyri -> AEY
        City departureAirport = CityTag.getCityTag(departure);   // Convert from Akureyri -> AEY
        System.out.println("searching ....");
        Connection connection = null;
        try
        {
            connection = DriverManager.getConnection("jdbc:sqlite:.\\throun8f\\databases\\FlightsDB.db");
            Statement statement = connection.createStatement();
            String sql = "Select * from Flights WHERE departureDate = '" + dateFrom + "'" + " AND departureAirport = '" + departureAirport + "'  AND arrivalAirPort = '" + arrivalAirport + "'";
            ResultSet r = statement.executeQuery(sql);
            ResultSetMetaData rsmd = r.getMetaData();
            int count = rsmd.getColumnCount();
            int i = 0;
            ObservableList<FlightDetails> flight = FXCollections.observableArrayList();

            while (r.next() && i < count)
            {

                Seat[] seat = new Seat[r.getInt("seatsAvailable")];

               for (int j = 0; j < r.getInt("seatsAvailable"); j++)
               {
                    seat[j] = new Seat(1,2,"fsa",r.getInt("ticketPrice"),false);
               }
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
               String formatedArrivalTime = Hours.trimDate(r.getString("arrivalTime"));
               String formatedDepartureTime = Hours.trimDate(r.getString("departureTime"));


               City departureCity = CityTag.getCityTag(departure);
               City arrivalCity = CityTag.getCityTag(destination);
               FlightDetails f = new FlightDetails(
                                                    arrivalCity,
                                                    r.getString("arrivalDate"),
                                                    formatedArrivalTime,
                                                    departureCity,
                                                    r.getString("departureDate"),
                                                    formatedDepartureTime
                                                    );
               f.setSeats(seat);
               flight.add(f);
               i++;
            }

            r.close();
            connection.close();
            return flight;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }


}

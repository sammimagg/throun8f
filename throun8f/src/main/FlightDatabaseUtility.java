package main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.text.SimpleDateFormat;

public class FlightDatabaseUtility extends FlightController {

//    public static void book(FlightDetails flight) throws ClassNotFoundException {
//        Class.forName("org.sqlite.JDBC");
//        Connection connection = null;
//        int id = flight.getId();
//        int availableSeats = flight.availableSeats();
//        try {
//            connection = DriverManager.getConnection("jdbc:sqlite:.\\throun8f\\databases\\PassengerDB.db");
//            Statement statement = connection.createStatement();
//            String sql = "Update Flights set seatsAvailable = (address, email, name, phoneNumber, zipCode) values('" + passenger.address + "', '" + passenger.email + "', '" + passenger.name + "', " + passenger.phoneNum + ", " + passenger.zipCode + ");";
//            statement.executeUpdate(sql);
//            connection.close();
//        } catch (SQLException e) {
//            System.err.println(e.getMessage());
//        }
//    }

    public static ObservableList<FlightDetails> search(String departure, String destination, String date) throws ClassNotFoundException
    {
        Class.forName("org.sqlite.JDBC");
        City arrivalAirport = CityTag.getCityTag(destination);     // Convert from Akureyri -> AEY
        City departureAirport = CityTag.getCityTag(departure);   // Convert from Akureyri -> AEY
        Connection connection = null;
        try
        {
            connection = DriverManager.getConnection("jdbc:sqlite:.\\throun8f\\databases\\FlightsDB.db");
            Statement statement = connection.createStatement();
            String sql = "Select * from Flights WHERE departureDate = '" + date + "'" + " AND departureAirport = '" + departureAirport + "'  AND arrivalAirPort = '" + arrivalAirport + "'";
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
                    seat[j] = new Seat(j,j,"fsa",r.getInt("ticketPrice"),false);
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
               f.setID(r.getInt("id"));
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

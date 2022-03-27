package main;

import java.sql.*;

public class FlightDatabaseUtility extends FlightController {
    public static void add(){

    }
    public static Flight[] search(String departure, String destination, String dateFrom, String dateTo) throws ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        String arrivalAirport = CityTag.getCityTag(destination);     // Convert from Akureyri -> AEY
        String departureAirport = CityTag.getCityTag(departure);   // Convert from Akureyri -> AEY
        System.out.println("searching ....");

        // SELECT * FROM FLightDB WHERE departureDate = '16/05/2022' AND departureAirport = 'Egilsstadir' AND arrivalAirPort = 'Reykjavik';
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:.\\throun8f\\databases\\FlightsDB.db");
            Statement statement = connection.createStatement();
            String sql = "Select * from Flights WHERE departureDate = '" + dateFrom + "'" + " AND departureAirport = '" + departureAirport + "'  AND arrivalAirPort = '" + arrivalAirport + "'";
            ResultSet r = statement.executeQuery(sql);
            ResultSetMetaData rsmd = r.getMetaData();
            int count = rsmd.getColumnCount();
            int i = 0;
            Flight flight[] = new Flight[rsmd.getColumnCount()];


            while (r.next() && i < count){
                System.out.println(r.getString("arrivalDate"));
                Seat seat = new Seat(1,1,"detail", r.getInt("ticketPrice"),false);
                flight[i]=(new Flight(
                                     r.getString("arrivalDate"),
                                     r.getString("arrivalTime"),
                                     r.getString("departureDate"),
                                     r.getString("departureTime"),
                                    seat
                                    )
                        );
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

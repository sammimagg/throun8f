package main;

import java.sql.*;

public class FlightDatabaseUtility extends FlightController {
    public static void add(){

    }
    public static Flight[] search(String departure, String destination, String dateFrom, String dateTo) throws ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");


        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:.\\throun8f\\databases\\Flights.db");
            Statement statement = connection.createStatement();
            String sql = "Select * from FlightDB WHERE departureDate = '" + dateFrom + "'";
            ResultSet r = statement.executeQuery(sql);
            ResultSetMetaData rsmd = r.getMetaData();
            int count = rsmd.getColumnCount();
            int i = 0;
            Flight flight[] = new Flight[rsmd.getColumnCount()];

            while (r.next() && i < count){
                System.out.println(r.getString("arrivalDate"));
                flight[i]=(new Flight(r.getString("arrivalDate"),
                       r.getString("arrivalTime"),
                        r.getString("departureDate"),
                       r.getString("departureTime")));
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
    public static Flight[] searchAll() throws ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");


        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:.\\throun8f\\databases\\Flights.db");
            Statement statement = connection.createStatement();
            String sql = "Select * from FlightDB;";
            ResultSet r = statement.executeQuery(sql);
            ResultSetMetaData rsmd = r.getMetaData();
            int count = rsmd.getColumnCount();
            int i = 0;
            Flight flight[] = new Flight[rsmd.getColumnCount()];

            while (r.next() && i < count){
                System.out.println(r.getString("arrivalDate"));
                flight[i]=(new Flight(r.getString("arrivalDate"),
                        r.getString("arrivalTime"),
                        r.getString("departureDate"),
                        r.getString("departureTime")));
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

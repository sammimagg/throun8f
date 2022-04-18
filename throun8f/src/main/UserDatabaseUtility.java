package main;

import java.sql.*;

public class UserDatabaseUtility extends FlightController {
    public static void add(Passenger passenger, int seatId, int flightId) throws ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection connection = null;
        try
        {
            connection = DriverManager.getConnection("jdbc:sqlite:.\\throun8f\\databases\\PassengerDB.db");
            Statement statement = connection.createStatement();
            String sql = "Insert into passenger(address, email, flightId, name, phoneNumber, seatId, zipCode) values('" + passenger.address + "', '" + passenger.email + "', '" + flightId + ", " + passenger.name + "', " + passenger.phoneNum + ", " + seatId + " ," + passenger.zipCode + ");";
            statement.executeUpdate(sql);
            connection.close();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}

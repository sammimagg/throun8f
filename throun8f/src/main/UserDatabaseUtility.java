package main;

import java.sql.*;

public class UserDatabaseUtility extends FlightController {
    public static void add(Passenger passenger, int seatId, FlightDetails flightDetails) throws ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection connection = null;
        try
        {
            connection = DriverManager.getConnection("jdbc:sqlite:.\\throun8f\\databases\\PassengerDB.db");
            Statement statement = connection.createStatement();
            String sql = "Insert into passengers(address, email, flightId, name, phoneNum, seatId, zipCode) values('" +
                                                        passenger.address + "', " + "'" +
                                                            passenger.email + "', " +
                                                            flightDetails.getID() + ", '" +
                                                            passenger.name + "', " +
                                                            passenger.phoneNum + ", " +
                                                            seatId + " ," +
                                                            passenger.zipCode + ");";
            System.out.println(sql);
            statement.executeUpdate(sql);
            connection.close();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}

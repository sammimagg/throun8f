package main;

import java.sql.*;

public class FlightUtility {

    public static Connection connect(String url) {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:sqlite:Flights.db");
            System.out.println("Connected");
        } catch (SQLException e) {
            // TODO auto generated catch block
            System.out.println(e + "");
        }

        return con;
    }


}
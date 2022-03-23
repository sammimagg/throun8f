package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("mainUI.fxml"));
        primaryStage.setTitle("Flight search");
        Scene scene = new Scene(root, 1200, 800);
        scene.getStylesheets().add(getClass().getResource("/css/application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {

        launch(args);


    }
    public static void search() throws ClassNotFoundException {
       // Class.forName("org.sqlite.JDBC");
        String url = "jdbc:sqlite:Flights.db";
        Connection con = FlightUtility.connect(url);
        PreparedStatement ps = null;
        ResultSet rs = null;


        try {
            String sql = "Select * from FlightDB";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            String res = rs.getString(1);
            System.out.println(res);

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

}

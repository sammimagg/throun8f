package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("mainUI.fxml"));
        primaryStage.setTitle("Flight search");
        primaryStage.setScene(new Scene(root, 1200, 800));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}

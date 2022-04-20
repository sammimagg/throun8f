package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    Scene scene;
    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("fxml/mainUI.fxml"));
        primaryStage.setTitle("Flight search");
        scene = new Scene(root, 1200, 800);
        scene.getStylesheets().add(getClass().getResource("/css/application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
        Image icon = new Image("/img/8ficon.png");
        primaryStage.getIcons().add(icon);

    }

    public static void main(String[] args) throws ClassNotFoundException {
        launch(args);
    }

}

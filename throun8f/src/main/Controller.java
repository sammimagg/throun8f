package main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private ComboBox<String> comboBoxOneOrTwo;
    @FXML
    private ComboBox<String>  comboBoxFrom;
    @FXML
    private ComboBox<String> comboBoxTo;
    @FXML
    private ListView<FlightDetails> flightDetailsListView;
    ObservableList<FlightDetails> flightDetailsItems;

    ObservableList<String> oneWayOrRoundtrip = FXCollections.observableArrayList("One Way","Round trip");
    ObservableList<String> destinations = FXCollections.observableArrayList("Akureyri","Reykjarvík","Ísafjörður","Egilsstaðir");
    public Controller() {
        flightDetailsItems = FXCollections.observableArrayList();
        flightDetailsItems.addAll(
                new FlightDetails("12.12.22","11:00","12.12.22","11:30"),
                new FlightDetails("12.12.22","11:00","12.12.22","11:30")
        );

    }






    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

           // comboBoxOneOrTwo.setItems(oneWayOrRoundtrip);
            comboBoxFrom.setItems(destinations);
            comboBoxTo.setItems(destinations);
            flightDetailsListView.setItems(flightDetailsItems);
            flightDetailsListView.setCellFactory(FlightDetailsListView -> new FlightDetailsListViewCell());
            System.out.println(flightDetailsItems.get(1).getDepartureTime());

    }

}

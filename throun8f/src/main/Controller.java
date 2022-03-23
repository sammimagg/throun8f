package main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private DatePicker datePickerFrom;
    @FXML
    private DatePicker datePickerTo;
    @FXML
    private RadioButton radiobuttonOneWay;
    @FXML
    private RadioButton radioButtonRoundTrip;
    @FXML
    private ComboBox<String> comboBoxOneOrTwo;
    @FXML
    private ComboBox<String>  comboBoxFrom;
    @FXML
    private ComboBox<String> comboBoxTo;
    @FXML
    private ListView<FlightDetails> flightDetailsListView;
    @FXML
    private Button passengerMinusButton;
    @FXML
    private Button passengerPlusButton;
    @FXML
    private Label passangerLabel;
    @FXML
    private Label textDateTo;
    @FXML
    private Button searchButton;
    @FXML
    private Button bookButton;
    @FXML
    private Pane map;
    ObservableList<FlightDetails> flightDetailsItems;
    int passengerCount = 1;

    ObservableList<String> oneWayOrRoundtrip = FXCollections.observableArrayList("One Way","Round trip");
    ObservableList<String> destinations = FXCollections.observableArrayList("Akureyri","Reykjarvík","Ísafjörður","Egilsstaðir");
    ObservableList<String> arrivalFromReykjarvik = FXCollections.observableArrayList("Akureyri","Ísafjörður","Egilsstaðir");
    ObservableList<String> arrivalFromAkureyri = FXCollections.observableArrayList("Reykjarvík","Ísafjörður","Egilsstaðir");
    ObservableList<String> arrivalFromIsafjordur = FXCollections.observableArrayList("Akureyri","Reykjarvík","Egilsstaðir");
    ObservableList<String> arrivalFromEgilsstadir = FXCollections.observableArrayList("Akureyri","Ísafjörður","Reykjarvík");
    public Controller() {
        flightDetailsItems = FXCollections.observableArrayList();
        flightDetailsItems.addAll(
                new FlightDetails("12.12.22","11:00","12.12.22","11:30"),
                new FlightDetails("12.12.22","11:00","12.12.22","11:30")
        );


    }
    @FXML
    void OneWayHandler(ActionEvent event) {

        if (radiobuttonOneWay.isSelected()){
            radioButtonRoundTrip.setSelected(false);
            datePickerTo.setVisible(false);
            textDateTo.setText("");
        }
        else {
            textDateTo.setText("Date To");
            datePickerTo.setVisible(true);
        }
    }
    @FXML
    void RoundtripHandler(ActionEvent event) {
        if (radioButtonRoundTrip.isSelected()){
            radiobuttonOneWay.setSelected(false);
            datePickerTo.setVisible(true);
            textDateTo.setText("Date To");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

            comboBoxFrom.setItems(destinations);
            comboBoxTo.setItems(destinations);
            flightDetailsListView.setItems(flightDetailsItems);

            flightDetailsListView.setCellFactory(FlightDetailsListView -> new FlightDetailsListViewCell());
            System.out.println(flightDetailsItems.get(1).getDepartureTime());

    }
    @FXML
    public void trip(ActionEvent event){

    }
    @FXML
    public void search(ActionEvent event) throws ClassNotFoundException {
        String destination = comboBoxTo.getValue();
        String arrival = comboBoxFrom.getValue();
        String date = String.valueOf(datePickerFrom.getValue());
        String dateTo = String.valueOf(datePickerTo.getValue());
        System.out.println("destination " + destination + ", arrival " +arrival + ", date "+ date + ", date to " + dateTo );
        Main.search();
    }
    @FXML
    public void passengerCount(ActionEvent event)
    {
        if(event.getSource() == passengerMinusButton)
            passengerCount--;
        else
            passengerCount++;
        passangerLabel.setText(String.valueOf(passengerCount));
    }
}

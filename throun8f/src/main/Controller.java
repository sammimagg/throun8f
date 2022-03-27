package main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.time.format.DateTimeFormatter;
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
    private ListView<Flight> flightListView;
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
    ObservableList<Flight> flights =FXCollections.observableArrayList();
    static int passengerCount = 1;
    static String departure, destination;

    ObservableList<String> oneWayOrRoundtrip = FXCollections.observableArrayList("One Way","Round trip");
    ObservableList<String> destinations = FXCollections.observableArrayList("Akureyri","Reykjavík","Ísafjörður","Egilsstaðir");
    ObservableList<String> arrivalFromReykjarvik = FXCollections.observableArrayList("Akureyri","Ísafjörður","Egilsstaðir");
    ObservableList<String> arrivalFromAkureyri = FXCollections.observableArrayList("Reykjavík","Ísafjörður","Egilsstaðir");
    ObservableList<String> arrivalFromIsafjordur = FXCollections.observableArrayList("Akureyri","Reykjavík","Egilsstaðir");
    ObservableList<String> arrivalFromEgilsstadir = FXCollections.observableArrayList("Akureyri","Ísafjörður","Reykjavík");
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public Controller() {

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
            flightListView.setItems(flights);
            flightListView.setCellFactory(FlightDetailsListView -> new FlightListViewCell());
    }
    @FXML
    public void trip(ActionEvent event){

    }
    @FXML
    public void search(ActionEvent event) throws ClassNotFoundException {
        String destination = comboBoxTo.getValue();
        String departure = comboBoxFrom.getValue();
        String dateToString = formatter.format(datePickerTo.getValue()).toString();
        String dateFromString = formatter.format(datePickerFrom.getValue()).toString();
        flights.removeAll(flightListView.getItems());
        Flight f[] = FlightController.search(departure, destination,dateFromString,  dateToString);
        if(f != null)
            flights.addAll(f);
        else
            System.out.println("Empty");
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
    public static int getPassangerLabel() {
        return passengerCount;
    }

    public static String getDeparture() {
        return departure;
    }

    public static String getDestination() {
        return destination;
    }

}

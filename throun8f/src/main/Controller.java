package main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private DatePicker fromDatePicker;
    @FXML
    private DatePicker toDatePicker;
    @FXML
    private RadioButton oneWayTripRadioButton;
    @FXML
    private RadioButton roundTripRadioButton;

    @FXML
    private ComboBox<String>  fromComboBox;
    @FXML
    private ComboBox<String> toComboBox;
    @FXML
    private ListView<Flight> departureListView;
    @FXML
    private ListView<Flight> returnListView;
    @FXML
    private HBox returnFlightHBoxResult;
    @FXML
    private HBox returnFlightHBoxTag;

    @FXML
    private VBox VBoxSearch;


    @FXML
    private Label passangerLabel;
    @FXML
    private Label textDateTo;
    @FXML
    private Button searchButton;
    @FXML
    private Button bookButton;
    @FXML
    private Button passengerMinusButton;
    @FXML
    private Button passengerPlusButton;
    @FXML
    private Pane map;
    @FXML
    private Text departureFromText;
    @FXML
    private Text departureToText;
    @FXML
    private Text departureResultText;
    @FXML
    private Text returnFromText;
    @FXML
    private Text returnToText;
    @FXML
    private Text returnResultText;



    ObservableList<Flight> departureFlights = FXCollections.observableArrayList();
    ObservableList<Flight> returnFlights    = FXCollections.observableArrayList();

    static int passengerCount = 1;



    static String departure,destination;


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

        if (oneWayTripRadioButton.isSelected()){
            roundTripRadioButton.setSelected(false);
            toDatePicker.setVisible(false);
            textDateTo.setText("");
            returnListView.setVisible(false);
            returnFlightHBoxResult.setVisible(false);
            returnFlightHBoxTag.setVisible(false);
            returnFlightHBoxResult.setPrefHeight(0);
            System.out.println(Main.getWindowHeigh());
            departureListView.setPrefHeight(VBoxSearch.getHeight()+100);
            //
        }
        else {
            textDateTo.setText("Date To");
            toDatePicker.setVisible(true);
            returnListView.setVisible(true);
        }
    }
    @FXML
    void RoundtripHandler(ActionEvent event) {
        if (roundTripRadioButton.isSelected()){
            oneWayTripRadioButton.setSelected(false);
            toDatePicker.setVisible(true);
            textDateTo.setText("Date To");
            departureListView.setPrefHeight(VBoxSearch.getHeight()*0.5);
            returnListView.setVisible(true);
            returnFlightHBoxResult.setVisible(true);
            returnFlightHBoxTag.setVisible(true);

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

            fromComboBox.setItems(destinations);
            toComboBox.setItems(destinations);
            fromComboBox.setValue("Reykjavík");
            toComboBox.setValue("Akureyri");

            fromDatePicker.setValue(LocalDate.now());
            toDatePicker.setValue(LocalDate.now());
            roundTripRadioButton.setSelected(true);
            departureListView.setItems(departureFlights);
            departureListView.setCellFactory(FlightDetailsListView -> new FlightListViewCell());
            returnListView.setItems(returnFlights);
            returnListView.setCellFactory(FlightDetailsListView -> new FlightListViewCell());

    }
    @FXML
    public void trip(ActionEvent event){

    }
    @FXML
    public void bookHandler(ActionEvent event)
    {
        System.out.println("fds");
        //departureListView.getSelectedItem();
    }
    @FXML
    public void search(ActionEvent event) throws ClassNotFoundException {
        String destination = toComboBox.getValue();
        String departure = fromComboBox.getValue();

        String dateFromString = formatter.format(fromDatePicker.getValue()).toString();
        setDeparture(CityTag.getCityTag(fromComboBox.getValue()));
        setDestination(CityTag.getCityTag(toComboBox.getValue()));



        Flight departureFlightsResult[] = FlightController.search(departure, destination, dateFromString, dateFromString);
        if (roundTripRadioButton.isSelected() == true)
        {

            String dateToString = formatter.format(toDatePicker.getValue()).toString();
            departureFlights.removeAll(departureListView.getItems());
            returnFlights.removeAll(returnListView.getItems());

            Flight returnFlightsResult[] = FlightController.search(destination, departure, dateToString, dateToString);

            departureFromText.setText(CityTag.getCityTag(fromComboBox.getValue()));
            departureToText.setText(CityTag.getCityTag(toComboBox.getValue()));

            returnFromText.setText(CityTag.getCityTag(toComboBox.getValue()));
            returnToText.setText(CityTag.getCityTag(fromComboBox.getValue()));
            if (departureFlightsResult != null && returnFlightsResult != null)
            {
                departureFlights.addAll(departureFlightsResult);
                departureResultText.setText(String.valueOf(departureFlights.size()) + " results");
                returnFlights.addAll(returnFlightsResult);
                returnResultText.setText(String.valueOf(returnFlights.size()) + " results");
            }
            else
            {
                System.out.println("Empty");
            }
        }
        else
        {
            departureFlights.removeAll(departureListView.getItems());
            departureFromText.setText(CityTag.getCityTag(fromComboBox.getValue()));
            departureToText.setText(CityTag.getCityTag(toComboBox.getValue()));

            if (departureFlightsResult != null)
            {
                departureFlights.addAll(departureFlightsResult);
                departureResultText.setText(String.valueOf(departureFlights.size()) + " results");
            }
            else
            {
                System.out.println("Empty");
            }
        }
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
    public static void setDeparture(String departure) {
        Controller.departure = departure;
    }

    public static void setDestination(String destination) {
        Controller.destination = destination;
    }


}

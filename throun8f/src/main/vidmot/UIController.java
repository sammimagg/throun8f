package main.vidmot;

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
import main.helper.City;
import main.helper.CityTag;
import main.vinnsla.Flight;
import main.vinnsla.FlightController;
import main.vinnsla.FlightDetails;
import main.vinnsla.Passenger;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;

public class UIController implements Initializable {
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
    private ListView<FlightDetails> departureListView;
    @FXML
    private ListView<FlightDetails> returnListView;
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


    ObservableList<FlightDetails> departureFlights = FXCollections.observableArrayList();
    ObservableList<FlightDetails> returnFlights    = FXCollections.observableArrayList();

    static int passengerCount = 1;
    static City departure,destination;

    ObservableList<String> destinations = FXCollections.observableArrayList("Akureyri","Reykjavík","Ísafjörður","Egilsstaðir");
    ObservableList<String> arrivalFromReykjarvik = FXCollections.observableArrayList("Akureyri","Ísafjörður","Egilsstaðir");
    ObservableList<String> arrivalFromAkureyri = FXCollections.observableArrayList("Reykjavík","Ísafjörður","Egilsstaðir");
    ObservableList<String> arrivalFromIsafjordur = FXCollections.observableArrayList("Akureyri","Reykjavík","Egilsstaðir");
    ObservableList<String> arrivalFromEgilsstadir = FXCollections.observableArrayList("Akureyri","Ísafjörður","Reykjavík");
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public UIController()
    {

    }

    @FXML
    void OneWayHandler(ActionEvent event) {
        if (oneWayTripRadioButton.isSelected())
        {
            roundTripRadioButton.setSelected(false);
            toDatePicker.setVisible(false);
            textDateTo.setText("");
            returnListView.setVisible(false);
            returnFlightHBoxResult.setVisible(false);
            returnFlightHBoxTag.setVisible(false);


        }
        else
        {
            textDateTo.setText("Date To");
            toDatePicker.setVisible(true);
            returnListView.setVisible(true);
        }
    }
    @FXML
    void RoundtripHandler(ActionEvent event)
    {
        if (roundTripRadioButton.isSelected())
        {
            oneWayTripRadioButton.setSelected(false);
            toDatePicker.setVisible(true);
            textDateTo.setText("Date To");
            returnListView.setVisible(true);
            returnFlightHBoxResult.setVisible(true);
            returnFlightHBoxTag.setVisible(true);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
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
    public void trip(ActionEvent event)
    {
        if(fromComboBox.getValue() == "Akureyri" && toComboBox.getValue() == "Reykjavík")
        {
            map.getStyleClass().remove(0);
            map.getStylesheets().add("image_map_rvk_aku");
            System.out.println("virkar");
        }
        if(fromComboBox.getValue() == "Akureyri" && toComboBox.getValue() == "Ísafjörður")
        {
            map.getStyleClass().remove(0);
            map.getStyleClass().add("image_map_aku_isa");
        }
        if(fromComboBox.getValue() == "Akureyri" && toComboBox.getValue() == "Egilsstaðir")
        {
            map.getStyleClass().remove(0);
            map.getStyleClass().add("image_map_aku_egs");
        }
        if(fromComboBox.getValue() == "Akureyri" && toComboBox.getValue() == "Akureyri")
        {
            map.getStyleClass().remove(0);
            map.getStyleClass().add("image_map_none");
        }

        if(fromComboBox.getValue() == "Reykjavík" && toComboBox.getValue() == "Reykjarvík")
        {
            map.getStyleClass().remove(0);
            map.getStyleClass().add("image_map_none");
        }
        if(fromComboBox.getValue() == "Reykjavík" && toComboBox.getValue() == "Ísafjörður")
        {
            map.getStyleClass().remove(0);
            map.getStyleClass().add("image_map_rvk_isa");
        }
        if(fromComboBox.getValue() == "Reykjavík" && toComboBox.getValue() == "Egilsstaðir")
        {
            map.getStyleClass().remove(0);
            map.getStyleClass().add("image_map_rvk_egi");
        }
        if(fromComboBox.getValue() == "Reykjavík" && toComboBox.getValue() == "Akureyri")
        {
            map.getStyleClass().remove(0);
            map.getStyleClass().add("image_map_rvk_aku");
        }if(fromComboBox.getValue() == "Egilsstaðir" && toComboBox.getValue() == "Reykjavík")
        {
            map.getStyleClass().remove(0);
            map.getStyleClass().add("image_map_rvk_egi");
        }
        if(fromComboBox.getValue() == "Egilsstaðir" && toComboBox.getValue() == "Ísafjörður")
        {
            map.getStyleClass().remove(0);
            map.getStyleClass().add("image_map_isa_egs");
        }
        if(fromComboBox.getValue() == "Egilsstaðir" && toComboBox.getValue() == "Egilsstaðir")
        {
            map.getStyleClass().remove(0);
            map.getStyleClass().add("image_map_none");
        }
        if(fromComboBox.getValue() == "Egilsstaðir" && toComboBox.getValue() == "Akureyri")
        {
            map.getStyleClass().remove(0);
            map.getStyleClass().add("image_map_aku_egs");
        }
        if(fromComboBox.getValue() == "Ísafjörður" && toComboBox.getValue() == "Reykjavík")
        {
            map.getStyleClass().remove(0);
            map.getStyleClass().add("image_map_rvk_isa");
        }
        if(fromComboBox.getValue() == "Ísafjörður" && toComboBox.getValue() == "Ísafjörður")
        {
            map.getStyleClass().remove(0);
            map.getStyleClass().add("image_map_none");
        }
        if(fromComboBox.getValue() == "Ísafjörður" && toComboBox.getValue() == "Egilsstaðir")
        {
            map.getStyleClass().remove(0);
            map.getStyleClass().add("image_map_isa_egs");
        }
        if(fromComboBox.getValue() == "Ísafjörður" && toComboBox.getValue() == "Akureyri")
        {
            map.getStyleClass().remove(0);
            map.getStyleClass().add("image_map_aku_isa");
        }
    }
    @FXML
    public void bookHandler(ActionEvent event) throws ClassNotFoundException
    {

        for(int i = 0 ;i< passengerCount;i++)
        {
            // Round Trip
            if(roundTripRadioButton.isSelected() == true && returnListView.getSelectionModel().isEmpty() == false && returnListView.getSelectionModel().isEmpty() == false)
            {
                Passenger passenger = BookDialogController.getPassenger(i, false, toComboBox.getValue(), fromComboBox.getValue());

                // Booking for departure
                FlightController.book(
                        returnListView.getSelectionModel().getSelectedItem().getAvailableSeat(),
                        returnListView.getSelectionModel().getSelectedItem(),
                        passenger
                );
                //Booking for destination
                FlightController.book(
                        returnListView.getSelectionModel().getSelectedItem().getAvailableSeat(),
                        returnListView.getSelectionModel().getSelectedItem(),
                        passenger
                );

            }
            // OneWay trip
            if(oneWayTripRadioButton.isSelected() == true && departureListView.getSelectionModel().isEmpty() == false)
            {
                Passenger passenger =  BookDialogController.getPassenger(i, true, toComboBox.getValue(), fromComboBox.getValue());
                //Booking for destination

                FlightController.book(
                        departureListView.getSelectionModel().getSelectedItem().getAvailableSeat(),
                        departureListView.getSelectionModel().getSelectedItem(),
                        passenger
                );
            }
        }
    }
    @FXML
    public void search(ActionEvent event) throws ClassNotFoundException {
        if(VBoxSearch.isVisible() == false)
        {
            VBoxSearch.setVisible(true);
        }
        returnListView.disableProperty().unbind();
        departureListView.disableProperty().unbind();
        String destination = toComboBox.getValue();
        String departure = fromComboBox.getValue();

        String dateFromString = formatter.format(fromDatePicker.getValue()).toString();
        setDeparture(CityTag.getCityTag(fromComboBox.getValue()));
        setDestination(CityTag.getCityTag(toComboBox.getValue()));

        Flight flightDeparture = new Flight(departure, destination, dateFromString, passengerCount);
        ObservableList<FlightDetails> departureFlightsResult = FXCollections.observableArrayList(flightDeparture.getFlights());
        if (roundTripRadioButton.isSelected() == true)
        {

            String dateToString = formatter.format(toDatePicker.getValue()).toString();
            departureFlights.removeAll(departureListView.getItems());
            returnFlights.removeAll(returnListView.getItems());
            returnListView.refresh();
            departureListView.refresh();
            Flight flightReturn =  new Flight(destination, departure, dateToString, passengerCount);
            List<FlightDetails> returnFlightsResult = flightReturn.getFlights();

            departureFromText.setText(String.valueOf(CityTag.getCityTag(fromComboBox.getValue())));
            departureToText.setText(String.valueOf(CityTag.getCityTag(toComboBox.getValue())));

            returnFromText.setText(String.valueOf(CityTag.getCityTag(toComboBox.getValue())));
            returnToText.setText(String.valueOf(CityTag.getCityTag(fromComboBox.getValue())));
            if (departureFlightsResult != null && returnFlightsResult != null)
            {
                departureFlights.addAll(departureFlightsResult);
                departureListView.refresh();
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
            departureFromText.setText(String.valueOf(CityTag.getCityTag(fromComboBox.getValue())));
            departureToText.setText(String.valueOf(CityTag.getCityTag(toComboBox.getValue())));

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
    public void passengerCount(ActionEvent event) throws ClassNotFoundException {

        if(event.getSource() == passengerMinusButton)
            passengerCount--;
        else
            passengerCount++;
        passangerLabel.setText(String.valueOf(passengerCount));
    }

    public static int getPassangerLabel() {
        return passengerCount;
    }

    public static City getDeparture() {
        return departure;
    }

    public static City getDestination()
    {
        return destination;
    }
    public static void setDeparture(City departure)
    {
        UIController.departure = departure;
    }

    public static void setDestination(City destination)
    {
        UIController.destination = destination;
    }
}

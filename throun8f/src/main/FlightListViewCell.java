package main;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

public class FlightListViewCell extends ListCell<FlightDetails> {
    @FXML
    private Text textDestination;

    @FXML
    private Text textDepartureTime;

    @FXML
    private Text textDepartureDate;

    @FXML
    private Text textArrivalTime;

    @FXML
    private Text textArrivalDate;

    @FXML
    private Text textRoundOrOneWay;

    @FXML
    private Text textTotalFlightTime;

    @FXML
    private Text textPrice;

    @FXML
    private Text textPassengers;

    @FXML
    private GridPane gridPane;

    @FXML
    private Text textDeparture;
    @FXML
    private FXMLLoader mLLoader;

    @Override
    protected void updateItem(FlightDetails flightDetails, boolean empty)
    {
        super.updateItem(flightDetails,empty);

        if(empty || flightDetails == null)
        {
            setText(null);
            setGraphic(null);
        }
        else
        {
            if (mLLoader == null)
            {
                mLLoader = new FXMLLoader(getClass().getResource("ListCell.fxml"));
                mLLoader.setController(this);
                try
                {
                    mLLoader.load();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            textDeparture.setText(String.valueOf(flightDetails.getArrivalCity()));
            textDepartureTime.setText(String.valueOf(flightDetails.getDepartureTime()));
            textDepartureDate.setText(String.valueOf(flightDetails.getDepartureDate()));
            textDestination.setText(String.valueOf((flightDetails.getDepartureCity())));
            textArrivalTime.setText(String.valueOf(flightDetails.getArrivalTime()));
            textArrivalDate.setText(String.valueOf(flightDetails.getArrivalDate()));

            textTotalFlightTime.setText(Hours.tripTime(flightDetails.getDepartureTime(), flightDetails.getArrivalTime()));
            Locale icelandic = new Locale("is","IS");
            NumberFormat defaultFormat = NumberFormat.getCurrencyInstance(icelandic);

            textPrice.setText(defaultFormat.format(flightDetails.getSeats()[0].getPrice()));
            textPassengers.setText(String.valueOf("Passengers: "+ Controller.getPassangerLabel()));
        }
        setText(null);
        setGraphic(gridPane);
        setPrefHeight(Region.USE_COMPUTED_SIZE);

    }
}

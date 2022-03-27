package main;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;

import java.io.IOException;

public class FlightListViewCell extends ListCell<Flight> {
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

    private FXMLLoader mLLoader;

    @Override
    protected void updateItem(Flight flight, boolean empty)
    {
        super.updateItem(flight,empty);

        if(empty || flight == null)
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

            textDeparture.setText(Controller.getDeparture());
            textDepartureTime.setText(String.valueOf(flight.getFlights().getDepartureTime()));
            textDepartureDate.setText(String.valueOf(flight.getFlights().getDepartureDate()));
            textDestination.setText(Controller.getDestination());
            textArrivalTime.setText(String.valueOf(flight.getFlights().getArrivalTime()));
            textArrivalDate.setText(flight.getFlights().getArrivalDate());
            //textRoundOrOneWay;
            //textTotalFlightTime;
            textPrice.setText(String.valueOf(flight.flightDetails.availableSeats().getPrice()));
            textPassengers.setText(String.valueOf(Controller.getPassangerLabel()));
        }
        setText(null);
        setGraphic(gridPane);
        setPrefHeight(Region.USE_COMPUTED_SIZE);

    }
}

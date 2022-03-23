package main;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;

import java.io.IOException;

public class FlightDetailsListViewCell extends ListCell<FlightDetails> {
    @FXML
    private Text textDestination;

    @FXML
    private Text textDepartureTime;

    @FXML
    private Text textArrivalTime;

    @FXML
    private Text textPrice;

    @FXML
    private Text textPassengers;

    @FXML
    private GridPane gridPane;

    private FXMLLoader mLLoader;

    @Override
    protected void updateItem(FlightDetails flightDetails,boolean empty)
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
            //textDepartureTime.setText(String.valueOf(flightDetails.getDepartureTime()));
            //textArrivalTime.setText(String.valueOf(flightDetails.getArrivalTime()));
            //textPrice.setText("16.900 kr.");
            //textPassengers.setText("1");
        }
        setText(null);
        setGraphic(gridPane);
        setPrefHeight(Region.USE_COMPUTED_SIZE);

    }
}

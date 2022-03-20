package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

public class Controller implements Initializable {
    @FXML
    private ComboBox<String> comboBoxOneOrTwo;
    @FXML
    private ComboBox<String>  comboBoxFrom;
    @FXML
    private ComboBox<String> comboBoxTo;
    @FXML
    private ListView<String> fxListViewFlightResault;


    ObservableList<String> oneWayOrRoundtrip = FXCollections.observableArrayList("One Way","Round trip");
    ObservableList<String> destinations = FXCollections.observableArrayList("Akureyri","Reykjarvík","Ísafjörður","Egilsstaðir");
    ObservableList<String> listItems = FXCollections.observableArrayList("Add Items here","Add Items here","Add Items here","Add Items here","Add Items here","Add Items here","Add Items here","Add Items here","Add Items here",
            "Add Items here","Add Items here","Add Items here","Add Items here","Add Items here","Add Items here",
            "Add Items here","Add Items here","Add Items here","Add Items here","Add Items here","Add Items here","Add Items here","Add Items here","Add Items here");


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            comboBoxOneOrTwo.setItems(oneWayOrRoundtrip);
            comboBoxFrom.setItems(destinations);
            comboBoxTo.setItems(destinations);
            //fxListViewFlightResault.setItems(listItems);



    }

}

package main.vidmot;

import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;
import main.vinnsla.Passenger;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;


public class BookDialogController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public static Passenger getPassenger(int passengerNum, boolean oneway, String from, String to)
    {

        Dialog<Passenger> dialog = new Dialog<>();
        ButtonType buttonTypeOk = new ButtonType("Book", ButtonBar.ButtonData.OK_DONE);

        dialog.setResizable(true);
        Label nameLabel = new Label("Name: ");
        Label addressLabel = new Label("Address: ");
        Label zipCodeLabel = new Label("ZipCode");
        Label emailLabel = new Label("Email");
        Label phoneNumLabel = new Label("Phone number");

        TextField nameTextField = new TextField();
        TextField addressTextField = new TextField();
        TextField zipCodeTextField = new TextField();
        TextField emailTextField = new TextField();
        TextField phoneTextField = new TextField();

        GridPane grid = new GridPane();

        grid.add(nameLabel, 1, 1);
        grid.add(addressLabel, 1, 2);
        grid.add(zipCodeLabel, 1, 3);
        grid.add(emailLabel, 1, 4);
        grid.add(phoneNumLabel, 1, 5);

        grid.add(nameTextField, 2, 1);
        grid.add(addressTextField, 2, 2);
        grid.add(zipCodeTextField, 2, 3);
        grid.add(emailTextField, 2, 4);
        grid.add(phoneTextField, 2, 5);

        dialog.getDialogPane().setContent(grid);
        dialog.getDialogPane().getButtonTypes().add(buttonTypeOk);


        if(oneway == true)
        {
            dialog.setHeaderText("One way trip from " + to + " to " + from + ". Passenger " + (passengerNum+1));
        }
        else
        {
            dialog.setHeaderText("Round way trip from " + to + " to " + from + " and Back . Passenger " + (passengerNum+1));
        }

        dialog.setTitle("Book ticket");

        zipCodeTextField.setTextFormatter(new TextFormatter<>(c -> {
            if (!c.getControlNewText().matches("\\d*"))
                return null;
            else
                return c;
        }
        ));
        phoneTextField.setTextFormatter(new TextFormatter<>(c -> {
            if (!c.getControlNewText().matches("\\d*"))
                return null;
            else
                return c;
        }
        ));



        dialog.setResultConverter(new Callback<ButtonType, Passenger>() {
            @Override
            public Passenger call(ButtonType b)
            {
                if (b == buttonTypeOk)
                {
                    return new Passenger(
                                        nameTextField.getText(),
                                        addressTextField.getText(),
                                        Integer.parseInt(zipCodeTextField.getText()),
                                        emailTextField.getText(),
                                        Integer.parseInt(phoneTextField.getText())
                    );
                }
                return null;
            }
        });

            Optional<Passenger> result = dialog.showAndWait();
            if(result.isPresent())
            {
                return result.get();
            }
            return null;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccountui;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;

/**
 *
 * @author kmhasan
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField idField;
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private DatePicker dobDatePicker;
    @FXML
    private Label statusLabel;
    @FXML
    private Button resetButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("I'm first!");
    }

    @FXML
    private void handleAddClientAction(ActionEvent event) {
        int id = Integer.parseInt(idField.getText());
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        LocalDate dob = dobDatePicker.getValue();

        Name name = new Name(firstName, lastName);
        Client client = new Client(id, name, dob);

        try (RandomAccessFile output
                = new RandomAccessFile("client.txt", "rw")) {

            // delete everything and start fresh
            //output.setLength(0);
            
            // append lines to the file
            long fileLength = output.length();
            output.seek(fileLength);

            output.writeBytes(client.toString());

            clearForm();

            statusLabel.setText("Added client " + client.getId());
        } catch (IOException ex) {
            System.out.println("Some IOException occured!\n"
                    + ex.getMessage());
        }
    }

    private void clearForm() {
        idField.clear();
        firstNameField.clear();
        lastNameField.clear();
        dobDatePicker.setValue(null);
    }

    @FXML
    private void handleResetAction(ActionEvent event) {
        clearForm();
    }

}

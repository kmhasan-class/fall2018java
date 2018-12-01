/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.gui.application;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author kmhasan
 */
public class FXMLDocumentController implements Initializable {
    private Connection connection = null;
    
    @FXML
    private TextField sinField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField phoneField;
    @FXML
    private DatePicker hiringDatePicker;
    @FXML
    private Button resetButton;
    @FXML
    private Button addButton;
    @FXML
    private Label statusLabel;
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleResetAction(ActionEvent event) {
        clearForm();
    }

    private Connection getConnection() {
        final String USERNAME = "cse2015fall2018";
        final String PASSWORD = "rAnd0Mpa$$";
        final String DBNAME = "rentaldb";
        final String HOSTNAME = "172.17.10.52";
        final String URL = "jdbc:mysql://" + HOSTNAME + "/" + DBNAME;
        
        try {
            if (connection == null)
                connection = DriverManager.getConnection
                    (URL, USERNAME, PASSWORD);
        } catch (SQLException sqle) {
            System.err.println("Failed to connect");
            System.err.println(sqle);
        }
        
        return connection;
    }
    
    @FXML
    private void handleAddAction(ActionEvent event) {
        try {
            Connection connection = getConnection();
            
            String sin = sinField.getText();
            String name = nameField.getText();
            String phone = phoneField.getText();
            LocalDate hiringDate = hiringDatePicker.getValue();
            
            String query = String.format("insert into employee values('%s', '%s', '%s', '%s')",
                    sin, name, phone, hiringDate.toString());
            
            Statement statement = connection.createStatement();
            
            statement.executeUpdate(query);
            
            statusLabel.setText("Successfully added employee " + sin);
            
            clearForm();
        } catch (SQLException sqle) {
            System.err.println(sqle);
            
            // Home work
            // Add code here to show JavaFX Dialog
            // with proper error message
        }
        
    }

    private void clearForm() {
        sinField.clear();
        nameField.clear();
        phoneField.clear();
        hiringDatePicker.setValue(null);
    }
    
}

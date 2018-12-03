/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.gui.application;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

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
    @FXML
    private ListView<Employee> employeeListView;
    private ObservableList<Employee> employeeList;
    @FXML
    private ComboBox<Employee> employeeComboBox;
    @FXML
    private TableView<Employee> employeeTableView;
    @FXML
    private TableColumn<Employee, String> sinColumn;
    @FXML
    private TableColumn<Employee, String> nameColumn;
    @FXML
    private TableColumn<?, ?> phoneColumn;
    @FXML
    private TableColumn<?, ?> hiringDateColumn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        // Add your code to read all the employee
        // records from the database, create employee
        // objects, put them in a list
        // and eventually show them in a ListView

        employeeList = FXCollections.observableArrayList();
        employeeListView.setItems(employeeList);
        employeeComboBox.setItems(employeeList);
        employeeTableView.setItems(employeeList);
        
        sinColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getSin()));
        nameColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getName()));
        
        connection = getConnection();

        try {
            String query = "select * from employee";

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String sin = resultSet.getString("sin");
                String name = resultSet.getString("name");
                String phone = resultSet.getString("phone");
                LocalDate hiringDate = LocalDate.parse(resultSet.getString("hiringDate"));

                Employee employee = new Employee(sin, name, phone, hiringDate);

                employeeList.add(employee);
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
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
            if (connection == null) {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            }
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

            Employee employee = new Employee(sin, name, phone, hiringDate);
            employeeList.add(employee);
            
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

    @FXML
    private void handleListClickAction(MouseEvent event) {
        Employee selectedItem = employeeListView.getSelectionModel().getSelectedItem();
//        sinField.setDisable(true);
        if (selectedItem != null)
            showEmployee(selectedItem);
    }

    private void showEmployee(Employee employee) {
        sinField.setText(employee.getSin());
        nameField.setText(employee.getName());
        phoneField.setText(employee.getPhone());
        hiringDatePicker.setValue(employee.getHiringDate());
    }
}

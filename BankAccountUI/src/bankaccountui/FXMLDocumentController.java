/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccountui;

import java.io.FileNotFoundException;
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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

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

//    private Client clients[];
//    private int numClients;
//    private ArrayList<Client> clientList;
    private ObservableList<Client> clientList;
    @FXML
    private ListView<Client> clientListView;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        readFile();
        //printClients();
        accountDemo();
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
            
            clientList.add(client);
            output.writeBytes(client.toString() + "\n");
            
            clearForm();

            statusLabel.setText("A quick brown fox jumps over the lazy dog and we have added client " + client.getId());
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

    private void readFile() {
        // TODO read the input file
        // create client objects
        // add them to an array
        // initially the array can hold 100 clients
        
//        clients = new Client[3];
//        numClients = 0;
//        clientList = new ArrayList<>();
        clientList = FXCollections.observableArrayList();
        
        try (RandomAccessFile input = new RandomAccessFile("client.txt", "r")) {
            String line;
            
            while (true) {
                line = input.readLine();
                if (line == null)
                    break;
                String tokens[] = line.split("\\;");
                
                int id = Integer.parseInt(tokens[0]);
                String firstName = tokens[1];
                String lastName = tokens[2];
                LocalDate dob = LocalDate.parse(tokens[3]);
                
                Client client = new Client(id, 
                        new Name(firstName, lastName), dob);
                
//                clients[numClients] = client;
//                numClients = numClients + 1;
                
                clientList.add(client);
            }
            
            clientListView.setItems(clientList);
        } catch (FileNotFoundException fnfe) {
            System.err.println("File not found");
        } catch (IOException ioe) {
            System.err.println("IOException occured");
        }  
    }

    private void printClients() {
//        for (int i = 0; i < numClients; i++)
//            System.out.println(clients[i]);

//        for (int i = 0; i < clientList.size(); i++)
//            System.out.printf("%d %s\n", i + 1, clientList.get(i));
//        System.out.println("");
        
        // enhanced for loop
        for (Client x : clientList)
            System.out.println(x);
        System.out.println("");
        
        //clientList.forEach(System.out::println);
    }

    private void accountDemo() {
        BankAccount a = new BankAccount(111, clientList.get(0), 1000);
        CurrentAccount b = new CurrentAccount(112, clientList.get(0), 1000);
        CurrentAccount2 c = new CurrentAccount2(113, clientList.get(0), 1000);

        System.out.println("Before widthrawal");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        
        a.withdraw(500);
        b.withdraw(500);
        c.withdraw(500);
        
        System.out.println("After widthrawal");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        
    }

}

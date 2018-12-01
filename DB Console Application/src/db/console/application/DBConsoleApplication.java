/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.console.application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author kmhasan
 */
public class DBConsoleApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final String USERNAME = "cse2015fall2018";
        final String PASSWORD = "rAnd0Mpa$$";
        final String DBNAME = "rentaldb";
        final String HOSTNAME = "172.17.10.52";
        final String URL = "jdbc:mysql://" + HOSTNAME + "/" + DBNAME;
        
        try {
            Connection connection = DriverManager.getConnection
                (URL, USERNAME, PASSWORD);
            System.out.println("Connected to the database");
            
            String query = "insert into employee values('152333446', 'Shahriar Manzoor', '01711666788', '2017/12/05')";
            
            Statement statement = connection.createStatement();
            
            statement.executeUpdate(query);
        } catch (SQLException sqle) {
            System.err.println("Failed to connect");
            System.err.println(sqle);
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.console.application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
        /*
        // INSERT DATA
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
        */
        
        // RETRIEVE DATA
        try {
            Connection connection = DriverManager.getConnection
                (URL, USERNAME, PASSWORD);
            System.out.println("Connected to the database");
            
            String query = "select * from employee";
            
            Statement statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(query);
            
            List<Employee> employeeList = new ArrayList<>();
            
            while (resultSet.next()) {
                String sin = resultSet.getString("sin");
                String name = resultSet.getString("name");
                String phone = resultSet.getString("phone");
                LocalDate hiringDate = LocalDate.parse(resultSet.getString("hiringDate"));
                
                Employee employee = new Employee(sin, name, phone, hiringDate);
                
                employeeList.add(employee);
            }
            
            for (Employee employee : employeeList)
                System.out.println(employee);
            
        } catch (SQLException sqle) {
            System.err.println("Failed to connect");
            System.err.println(sqle);
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import java.io.*;

/**
 *
 * @author kmhasan
 */
public class Assignment1 {
    // demo data: https://docs.google.com/spreadsheets/d/1wEig2oahs2sjcXk93YUhHs92fqG7AXFucDw2kRK0S2I/edit?usp=sharing
    
    public Assignment1() {
        readDataFromFile("data.csv");
    }
    
    public void readDataFromFile(String filename) {
        // try with resource
        try (RandomAccessFile input = new RandomAccessFile(filename, "r")) {
            String line;
            
            // headers/metadata
            line = input.readLine();
            System.out.println(line);
            line = input.readLine();
            System.out.println(line);

            while (true) {
                line = input.readLine();
                if (line == null)
                    break;
                String tokens[] = line.split("\\,");
                
                int id = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                System.out.println(id + " " + name);
            }
        } catch (FileNotFoundException fnfe) {
            System.err.println("File not found");
        } catch (IOException ioe) {
            System.err.println("IOException occured");
        }
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Assignment1();
    }
    
}

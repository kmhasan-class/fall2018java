/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreading.demo;

/**
 *
 * @author kmhasan
 */
public class MultithreadingDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Printer printerA = new Printer("A", 1, 10);
        Printer printerB = new Printer("B", 1, 10);
        Printer printerC = new Printer("C", 1, 10);
        Printer printerD = new Printer("D", 1, 10);
        
        printerA.start();
        printerB.start();
        printerC.start();
        printerD.start();
    }
    
}

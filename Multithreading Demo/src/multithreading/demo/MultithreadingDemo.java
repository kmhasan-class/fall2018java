/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreading.demo;

import com.sun.media.jfxmediaimpl.platform.Platform;
import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kmhasan
 */
public class MultithreadingDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        Printer printerA = new Printer("A", 1, 10);
        Printer printerB = new Printer("B", 1, 10);
        Printer printerC = new Printer("C", 1, 10);
        Printer printerD = new Printer("D", 1, 10);
        
        printerA.start();
        printerB.start();
        printerC.start();
        printerD.start();
        */
        
        int cores = Runtime.getRuntime().availableProcessors();
        long n = 100000000l;
//        long n = 10000000000l;

        long startTime = System.currentTimeMillis();
        
        Adder adderA = new Adder(1, n / 2);
        Adder adderB = new Adder(n / 2 + 1, n);
//        adderA.start();
//        adderB.start();
        
        try {
            // wait for adder to finish its task
            adderA.join();
            adderB.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(MultithreadingDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(adderA.getSum());
        System.out.println(adderB.getSum());
        
        BigInteger finalResult = BigInteger.ZERO;
        finalResult = finalResult.add(adderA.getSum());
        finalResult = finalResult.add(adderB.getSum());

        long endTime = System.currentTimeMillis();
        System.out.printf("Time taken: %.3f\n", (endTime - startTime) / 1000.0);
        
        System.out.println("Final Result " + finalResult);
//        System.out.println("From main method: " + adderA.getSum());
//        System.out.println("From main method: " + adderB.getSum());
    }
    
}

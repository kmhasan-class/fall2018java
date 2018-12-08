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
public class Printer extends Thread {
    private String printerName;
    private int start;
    private int end;

    public Printer(String name, int start, int end) {
        this.printerName = name;
        this.start = start;
        this.end = end;
    }

    public String getPrinterName() {
        return printerName;
    }
    
    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
    
    public void print() {
        for (int i = start; i <= end; i++) {
            System.out.println(printerName + " " + i);
        }
    }
    
    public void run() {
        print();
    }
}

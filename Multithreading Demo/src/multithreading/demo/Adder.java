/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreading.demo;

import java.math.BigInteger;

/**
 *
 * @author kmhasan
 */
public class Adder extends Thread {
    private long start;
    private long end;
    private BigInteger sum;

    public Adder(long start, long end) {
        this.start = start;
        this.end = end;
        start();
    }
    
    private void add() {
        sum = BigInteger.ZERO;
        for (long i = start; i <= end; i++)
            sum = sum.add(new BigInteger("" + i));
//        System.out.println("From add method: " + sum);
    }
    
    public void run() {
        long startTime = System.currentTimeMillis();
        add();
        long endTime = System.currentTimeMillis();
        System.out.printf("Time taken: %.3f\n", (endTime - startTime) / 1000.0);
//        System.out.println("From run method: " + sum);
    }

    public BigInteger getSum() {
        return sum;
    }
}

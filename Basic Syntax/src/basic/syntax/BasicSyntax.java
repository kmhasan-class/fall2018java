/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic.syntax;

/**
 *
 * @author kmhasan
 */
public class BasicSyntax {
    int add(int x, int y) {
        return x + y;
    }
    
    int max(int x, int y) {
        if (x > y)
            return x;
        else return y;
    }
    /*
    int min(int x, int y) {
        return x < y ? x : y;
    }
    */
    int min(int data[]) {
        /*
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < data.length; i++)
            if (data[i] < minValue)
                minValue = data[i];
        return minValue;
        */
        int minValue = data[0];
        for (int i = 1; i < data.length; i++)
            minValue = Math.min(minValue, data[i]);
        // Homework: hava look at the Java
        // Math API (Application Programming Interface)
        return minValue;
    }
    
    int sum(int data[]) {
        int s = 0;
        for (int i = 0; i < data.length; i++)
            s = s + data[i];
        return s;
    }
    
    double average(int data[]) {
        int s = 0;
        for (int i = 0; i < data.length; i++)
            s = s + data[i];
        return (double) s / data.length;
    }
    
    // find the average of the best 4 quizzes out
    // of 5
    double best4average(int data[]) {
        // hint: you do not need to sort the array
        int totalSum = sum(data);
        int minimum = min(data);
        totalSum = totalSum - minimum;
        return totalSum / (data.length - 1.0);
    }
    
    public BasicSyntax() {
        int z = add(5, 10);
        int data[] = {5, 1, 2, 4, 9};
        
        System.out.printf("z=%d\n", z);
        System.out.printf("max(6, 3) = %d\n", max(6, 3));
        System.out.printf("min(6, 3) = %d\n", Math.min(6, 3));
        System.out.printf("sum=%d\n", sum(data));
        System.out.printf("average=%f\n", average(data));
        System.out.printf("best 4 avg=%f\n", best4average(data));
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new BasicSyntax();
    }
    
}

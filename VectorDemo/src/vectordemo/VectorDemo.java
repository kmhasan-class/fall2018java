/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vectordemo;

/**
 *
 * @author kmhasan
 */
public class VectorDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Vector a = new Vector(2);
        a.setComponent(0, 2);
        a.setComponent(1, -3);
        
        Vector b = new Vector(2);
        b.setComponent(0, 4.5);
        b.setComponent(1, 2);
        
        Vector r = a.add(b);
        double d = a.dot(b);
        
        a.print();
        b.print();
        r.print();
        
        System.out.printf("Dot product %.2f\n", d);
    }
    
}

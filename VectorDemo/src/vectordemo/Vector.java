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
public class Vector {
    public double[] components;
    
    public Vector(int dimension) {
        components = new double[dimension];
    }
    
    public void setComponent(int index, double component) {
        components[index] = component;
    }
    
    public Vector add(Vector that) {
        // HW: How will we handle cases where the user
        // tries to add a 2D vector with a 3D vector?
        Vector r = new Vector(this.components.length);
        for (int i = 0; i < this.components.length; i++)
            r.setComponent(i, this.components[i] + that.components[i]);
        return r;
    }
    
    public double dot(Vector that) {
        double sum = 0.0;
        
        for (int i = 0; i < this.components.length; i++)
            sum = sum + this.components[i] * that.components[i];
        
        return sum;
    }
    
    public void print() {
        System.out.print("(");
        for (int i = 0; i < components.length; i++)
            if (i == 0)
                System.out.printf("%.2f", components[i]);
            else System.out.printf(", %.2f", components[i]);
        System.out.print(")\n");
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rationalnumberdemo;

/**
 *
 * @author kmhasan
 */
public class RationalNumber {
    public int numerator;
    public int denominator;
    
    public RationalNumber(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }
    
    public RationalNumber add(RationalNumber that) {
        int n = this.numerator   * that.denominator 
              + this.denominator * that.numerator;
        int d = this.denominator * that.denominator;
        RationalNumber result = new RationalNumber(n, d);
        return result;
    }

    public RationalNumber subtract(RationalNumber that) {
        return null;
    }

    public RationalNumber multiply(RationalNumber that) {
        return null;
    }

    public RationalNumber divide(RationalNumber that) {
        return null;
    }
    
    public String toString() {
        return String.format("%d/%d\n", 
                numerator, 
                denominator
        );
    }
    
    public boolean equals(Object o) {
        RationalNumber that = (RationalNumber) o;
        if (this.numerator * that.denominator
                == this.denominator * that.numerator)
            return true;
        else return false;
    }
}

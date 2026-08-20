package org.example;

public class Fraction {
    public int numerator;
    public int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator==0){
            throw new IllegalArgumentException("Cant divide by zero");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }
    @Override
    public String toString(){
        return numerator+"/"+denominator;
    }
}

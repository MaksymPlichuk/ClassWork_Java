package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Fraction {
    private double numerator;
    private double denominator;

    public Fraction() {
        numerator = 1;
        denominator = 2;
    }

    @Override
    public String toString() {
        return "%.2f/%.2f".formatted(numerator, denominator);
    }
}

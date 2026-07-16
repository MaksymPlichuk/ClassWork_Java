package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction() {
        numerator = 1;
        denominator = 2;
    }

    @Override
    public String toString() {
        return "%d/%d".formatted(numerator, denominator);
    }
}

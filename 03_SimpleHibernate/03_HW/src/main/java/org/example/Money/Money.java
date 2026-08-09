package org.example.Money;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Money {
    private int wholeDollar;
    private int changeDollar;

    private int wholeEuro;
    private int changeEuro;

    private int wholeUah;
    private int changeUah;

    public Money(int wholeDollar) {
        this.wholeDollar = wholeDollar;
        this.changeDollar = wholeDollar * 100;

        double tempEur = wholeDollar * 1.16;
        int fraction = (int) (tempEur * 100);

        this.wholeEuro = (int) (wholeDollar * 1.16);
        this.changeEuro = fraction;

        this.wholeUah = (int) tempEur * 50;
        this.changeUah = fraction * 100;
    }

    @Override
    public String toString() {
        return "Price: USD:%d or %d cents\nOr EUR:%d or %d eurocents\nOr UAH: %d or %d coins".formatted(wholeDollar, changeDollar, wholeEuro, changeEuro, wholeUah, changeUah);
    }
}

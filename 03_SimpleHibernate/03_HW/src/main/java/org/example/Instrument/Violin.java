package org.example.Instrument;

import lombok.Data;

@Data
public class Violin extends Instrument {
    private int numberOfStrings;

    public Violin(String name, String description, int yearsOld, String history, int numberOfStrings) {
        super(name, description, yearsOld, history);
        this.numberOfStrings = numberOfStrings;
    }

    @Override
    public void Sound() {
        System.out.println("violin sound");
    }
}

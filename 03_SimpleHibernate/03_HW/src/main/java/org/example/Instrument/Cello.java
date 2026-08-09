package org.example.Instrument;

import lombok.Data;

@Data
public class Cello extends Instrument{
    private int range;

    public Cello(String name, String description, int yearsOld, String history, int range) {
        super(name, description, yearsOld, history);
        this.range = range;
    }

    @Override
    public void Sound() {
        System.out.println("cello sound");
    }
}

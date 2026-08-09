package org.example.Instrument;

import lombok.Data;

@Data
public class Ukulele extends Instrument{
    private String countryOrigin;

    public Ukulele(String name, String description, int yearsOld, String history, String countryOrigin) {
        super(name, description, yearsOld, history);
        this.countryOrigin = countryOrigin;
    }

    @Override
    public void Sound() {
        System.out.println("ukulele sound");
    }
}

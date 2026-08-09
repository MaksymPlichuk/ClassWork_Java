package org.example.Instrument;

import lombok.Data;

@Data
public class Trombone extends Instrument{
    private double soundVolume;

    public Trombone(String name, String description, int yearsOld, String history, int soundVolume) {
        super(name, description, yearsOld, history);
        this.soundVolume = soundVolume;
    }

    @Override
    public void Sound() {
        System.out.println("trombone sound");
    }
}

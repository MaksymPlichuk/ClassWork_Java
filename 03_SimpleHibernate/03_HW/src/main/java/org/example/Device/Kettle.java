package org.example.Device;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Kettle extends Device{
    private double volume;

    @Override
    public void Sound(){
        System.out.println("sttttttttt");
    }

    public Kettle(String desc, String model, String name, double volume) {
        super(desc, model, name);
        this.volume = volume;
    }
}

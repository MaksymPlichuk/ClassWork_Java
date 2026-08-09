package org.example.Device;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Microwave extends Device{
    private double wattage;

    @Override
    public void Sound(){
        System.out.println("bbp-beeep-beeep");
    }

    public Microwave(String desc, String model, String name, double wattage) {
        super(desc, model, name);
        this.wattage = wattage;
    }
}

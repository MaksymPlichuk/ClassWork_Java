package org.example.Device;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Auto extends Device{
    private int distanceTraveled;

    @Override
    public void Sound(){
        System.out.println("wrooom-wroom");
    }

    public Auto(String desc, String model, String name, int distanceTraveled) {
        super(desc, model, name);
        this.distanceTraveled = distanceTraveled;
    }
}

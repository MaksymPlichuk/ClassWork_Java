package org.example.Device;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SteamShip extends Device{
    private int seats;

    @Override
    public void Sound(){
        System.out.println("huuuuuuup-guuuup ship");
    }

    public SteamShip(String desc, String model, String name, int seats) {
        super(desc, model, name);
        this.seats = seats;
    }
}

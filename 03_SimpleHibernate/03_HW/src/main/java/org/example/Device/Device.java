package org.example.Device;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Device {
    private String desc;
    private String model;
    private String name;


    public void Sound() {
        System.out.println("sounddd");
    }

    public void Show() {
        System.out.printf("\nName: %s\t".formatted(name));
    }

    public void Desc() {
        System.out.printf("\nDescription: %s\t".formatted(desc));
    }

}

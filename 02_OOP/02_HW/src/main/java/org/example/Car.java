package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Car {
    private String name;
    private String manufacturer;
    private int year;
    private double volume;

    public Car(){
        this.name="Camry";
        this.manufacturer="Toyota";
        this.year=2015;
        this.volume=3.5;
    }

    @Override
    public String toString(){
        return "Name: %s, Manufacturer: %s, Year: %d, Volume:%.2f".formatted(name,manufacturer,year,volume);
    }
}

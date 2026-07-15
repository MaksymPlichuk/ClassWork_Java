package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class City {
    private String name;
    private int foundation_date;
    private int population;
    private double area;

    public City(){
        this.name="Lviv";
        this.foundation_date=1199;
        this.population=2000000;
        this.area=250000;
    }

    @Override
    public String toString(){
        return "City name: "+name+" Foundation date: "+foundation_date+" Population: "+population+" City area: "+area;
    }
}

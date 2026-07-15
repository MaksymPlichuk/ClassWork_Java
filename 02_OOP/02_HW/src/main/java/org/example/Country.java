package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Country {
    private int population;
    private String name;
    private double area;
    private String indepenceDay;

    public Country(){
        this.population=500000;
        this.name="Uganda";
        this.area=40004.59;
        this.indepenceDay="1950-07-17";
    }

    @Override
    public String toString(){
        return "Name: %s Population: %d Area: %.2f Independence: %s".formatted(name,population,area,indepenceDay);
    }

}

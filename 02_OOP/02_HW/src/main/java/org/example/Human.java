package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Human {
    private int age;
    private String name;

    public Human() {
        this.age = 0;
        this.name = "Name";
    }

    @Override
    public String toString() {
        return "Age: " + age + " Name: " + name;

    }
}

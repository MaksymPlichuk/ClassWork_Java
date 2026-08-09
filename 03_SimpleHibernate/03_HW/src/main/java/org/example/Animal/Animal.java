package org.example.Animal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Animal {
    private String name;
    private int weight;
    private int age;

    public void Sound() {
        System.out.println("sound");
    }

    @Override
    public String toString() {
        return "Name: %s, Age: %d, Weight: %dkg".formatted(name, age, weight);
    }
}

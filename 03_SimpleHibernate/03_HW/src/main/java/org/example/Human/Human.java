package org.example.Human;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Human {
    private int id;
    private int age;
    private String name;

    @Override
    public String toString() {
        return "Id: %d, Name: %s, Age: %d".formatted(id, name, age);
    }
}

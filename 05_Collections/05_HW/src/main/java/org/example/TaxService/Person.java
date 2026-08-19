package org.example.TaxService;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Person {
    private String id;
    private String fullName;
    private String city;

    public Person(String id, String fullName, String city) {
        this.id = id;
        this.fullName = fullName;
        this.city = city;
    }

    List<Fine> fines = new ArrayList<>();

    @Override
    public String toString() {
        return String.format("Id: %s | Full name: %s | City: %s | Fines: %s", id, fullName, city, fines);
    }
}

package org.example.Human;

import lombok.Data;

@Data
public class Sailor extends Human {
    private int distanceTraveled;

    public Sailor() {
        super();
    }

    public Sailor(int id, int age, String name, int distanceTraveled) {
        super(id, age, name);
        this.distanceTraveled = distanceTraveled;
    }

    @Override
    public String toString() {
        return "Id: %d, Name: %s, Age: %d, Distance: %dm".formatted(getId(), getName(), getAge(), distanceTraveled);
    }
}

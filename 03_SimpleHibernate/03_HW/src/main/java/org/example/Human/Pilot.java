package org.example.Human;

import lombok.Data;

@Data
public class Pilot extends Human {
    private String rank;

    public Pilot() {
        super();
    }

    public Pilot(int id, int age, String name, String rank) {
        super(id, age, name);
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Id: %d, Name: %s, Age: %d, Rank: %s".formatted(getId(), getName(), getAge(), rank);
    }
}

package org.example.Human;

import lombok.Data;

@Data
public class Builder extends Human {
    private int yearsOfexperience;
    private String position;

    public Builder() {
        super();
    }

    public Builder(int id, int age, String name, int yearsOfexperience) {
        super(id, age, name);
        this.yearsOfexperience = yearsOfexperience;
    }

    @Override
    public String toString() {
        return "Id: %d, Name: %s, Age: %d, Experience: %d, Position: %s".formatted(getId(), getName(), getAge(), yearsOfexperience, position);
    }
}

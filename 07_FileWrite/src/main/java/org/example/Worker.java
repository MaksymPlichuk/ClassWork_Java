package org.example;

import lombok.Data;

@Data
public class Worker {
    private String name;
    private String surName;
    private int age;

    public Worker(String name, String surName, int age) {
        this.name = name;
        this.surName = surName;
        this.age = age;
    }

    @Override
    public String toString(){
        return "Name: %s | Surname: %s | Age: %d".formatted(name,surName,age);
    }
}

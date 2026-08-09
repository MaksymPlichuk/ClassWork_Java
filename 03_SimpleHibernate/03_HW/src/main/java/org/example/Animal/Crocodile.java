package org.example.Animal;

import lombok.Data;

@Data
public class Crocodile extends Animal{
    private int teethNumber;

    public Crocodile() { super(); }

    public Crocodile(String name, int weight, int age, int teethNumber) {
        super(name, weight, age);
        this.teethNumber = teethNumber;
    }

    @Override
    public void Sound(){
        System.out.println("blup-blup");
    }

    @Override
    public String toString() {
        return "Name: %s, Age: %d, Weight: %dkg, TeethNumber: %d".formatted(getName(), getAge(), getWeight(), teethNumber);
    }
}

package org.example.Animal;

import lombok.Data;

@Data
public class Tiger extends Animal {
    private int furThickness;

    public Tiger() {
        super();
    }

    public Tiger(String name, int weight, int age, int furThickness) {
        super(name, weight, age);
        this.furThickness = furThickness;
    }

    @Override
    public void Sound(){
        System.out.println("rrrrrrrrr");
    }

    @Override
    public String toString() {
        return "Name: %s, Age: %d, Weight: %dkg, FurThickness: %dcm".formatted(getName(), getAge(), getWeight(), furThickness);
    }
}

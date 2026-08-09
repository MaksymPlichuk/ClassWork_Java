package org.example.Animal;

import lombok.Data;

@Data
public class Kangaroo extends Animal{
    private int jumpLength;

    public Kangaroo() {super();}

    public Kangaroo(String name, int weight, int age, int jumpLength) {
        super(name, weight, age);
        this.jumpLength = jumpLength;
    }

    @Override
    public void Sound(){
        System.out.println("ppp-ppp");
    }

    @Override
    public String toString() {
        return "Name: %s, Age: %d, Weight: %dkg, JumpLength: %d".formatted(getName(), getAge(), getWeight(), jumpLength);
    }
}

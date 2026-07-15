package org.example;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("-----Work with classes-----");
        Animal cat = new Animal();
        cat.setAge(5);
        cat.setName("Bobir");

        System.out.println(cat);
        Animal mary = new Animal("Mary",8);

        System.out.println(mary);

        Cat myCat = new Cat();
        System.out.println(myCat);

        Dog myDog = new Dog();
        System.out.println(myDog);

        ArrayList<Animal> list = new ArrayList<>();
        list.add(myDog);
        list.add(myCat);

    }
}
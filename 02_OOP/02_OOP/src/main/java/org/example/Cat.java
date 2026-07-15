package org.example;

import lombok.Data;

@Data
public class Cat extends Animal{
    private boolean indoorOnly;

    public Cat(){
        super("Кіт",2);
        this.indoorOnly = false;
    }
    public Cat(String name, int age, boolean indoorOnly){
        super(name,age);
        this.indoorOnly=indoorOnly;
    }

    @Override
    public String toString(){
        String str = super.toString();
        str += "\tLives indoor: "+indoorOnly;
        return str;
    }
}

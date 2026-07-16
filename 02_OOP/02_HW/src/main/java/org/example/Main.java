package org.example;


public class Main {
    public static void main(String[] args) {
        Human h1 = new Human();
        System.out.println(h1);

        City city = new City();
        System.out.println(city);

        Country country = new Country();
        System.out.println(country);

        Fraction fr = new Fraction();
        System.out.println(fr);

        Book book = new Book();
        System.out.println(book);
        //Book book2 = new Book("Test","Doyle",2002,"Hramota","Fiction",200);
        //System.out.println(book2);

        Car car = new Car();
        System.out.println(car);
    }
}
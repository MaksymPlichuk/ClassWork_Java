package org.example;

import org.example.utils.HibernateHelper;

public class Main {
    public static void main(String[] args) {

        try{
            System.out.println("Підключення до БД");
            var session = HibernateHelper.getSession();


            HibernateHelper.shutDown();
        }
        catch (Exception e){
            System.out.println("Something went wrong"+e.getMessage());
        }

    }
}
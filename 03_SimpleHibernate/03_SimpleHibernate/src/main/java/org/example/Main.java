package org.example;

import org.example.entities.CategoryEntity;
import utils.HibernateHelper;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hibernates");
        try (var session = HibernateHelper.getSession()) {
            session.beginTransaction();

//            CategoryEntity cat = new CategoryEntity("Морозиво");
//            session.persist(cat);

            var list = session.createQuery("from CategoryEntity", CategoryEntity.class).getResultList();
            for (var item : list) {
                System.out.printf("%d\t%s\n", item.getId(), item.getName());
            }

            session.getTransaction().commit(); //зберегти зміни
        } catch (Exception ex){
            System.out.println("Error"+ex.getMessage());
        }

    }
}
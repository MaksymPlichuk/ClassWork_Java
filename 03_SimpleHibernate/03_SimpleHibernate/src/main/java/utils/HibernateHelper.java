package utils;
import lombok.Getter;
import org.example.entities.CategoryEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateHelper {
    //Підключення до БД - в Java усе фабрики
    @Getter
    public static SessionFactory sessionFactory;

    //автоматичний виклик метод при використанні данного
    static {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().build(); ////читає конфігурацію hibernate.properties
        try {
            sessionFactory = new MetadataSources(registry)
                    .addAnnotatedClass(CategoryEntity.class) //вказали, що буде таблиця в БД
                    .buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            System.out.println("Error"+e);
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
//    public static SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }
    public static Session getSession() {
        return sessionFactory.openSession();
    }
    public static void shutDown(){
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}

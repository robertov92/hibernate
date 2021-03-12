package hibernateExamples;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import anotatedClass.User;

public class InsertMultipleRows {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();
        try{
            // use the session object to save Java objects
            // create 3 users
            System.out.println("Creating new objects...");
            User tempUser1 = new User("John", "password");
            User tempUser2 = new User("Peter", "password");
            User tempUser3 = new User("James", "password");

            // start transaction
            session.beginTransaction();

            // save the user objects
            System.out.println("Saving user...");
            session.save(tempUser1);
            session.save(tempUser2);
            session.save(tempUser3);

            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done!!!");

        }finally {
            factory.close();
        }
    }
}

package hibernateExamples;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import anotatedClass.User;

public class InsertOneRow {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();
        try{
            // use the session object to save Java object
            // create user object
            System.out.println("Creating new user object...");
            User tempUser = new User("Paco", "password");

            // start transaction
            session.beginTransaction();

            // save the user object
            System.out.println("Saving user...");
            session.save(tempUser);

            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done");

        }finally {
            factory.close();
        }
    }
}

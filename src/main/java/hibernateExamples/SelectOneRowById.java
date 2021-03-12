package hibernateExamples;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import anotatedClass.User;

public class SelectOneRowById {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

        // create session
        Session session;

        try{

            // get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            // retrieve user based on id
            System.out.println("Getting user with id: " + 1);
            User user = session.get(User.class, 1);
            System.out.println("Get completed: " + user);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done");

        }finally {
            factory.close();
        }
    }
}

package hibernateExamples;

import anotatedClass.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Delete {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

        // create session
        Session session;

        try{
            int userId = 2;

            session = factory.getCurrentSession();
            session.beginTransaction();

            // retrieve user based on id
            System.out.println("Getting user with id: " + userId);
            User user = session.get(User.class, userId);

            // delete user
            System.out.println("Deleting user with ID: " + userId);
            session.delete(user);

            // delete user id = 4
            System.out.println("Deleting user with id: 5");
            session.createQuery("delete from anotatedClass.User where userId=5").executeUpdate();

            // commit transaction
            session.getTransaction().commit();


            System.out.println("Done");

        }finally {
            factory.close();
        }
    }
}

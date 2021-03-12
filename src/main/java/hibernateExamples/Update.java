package hibernateExamples;

import anotatedClass.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Update {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

        // create session
        Session session;

        try{
            int userId = 1;
            String newPassword = "5uppeRPa55w@rd";

            session = factory.getCurrentSession();
            session.beginTransaction();

            // update all user
            System.out.println("Update password for all user");
            session.createQuery("update anotatedClass.User set userPassword = 1234").executeUpdate();

            session.getTransaction().commit();

            // get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            // retrieve user based on id
            System.out.println("Getting user with id: " + userId);
            User user = session.get(User.class, userId);

            // update user using setters
            System.out.println("Updating user password...");
            user.setUserPassword(newPassword);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done");

        }finally {
            factory.close();
        }
    }
}

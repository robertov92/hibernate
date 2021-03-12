package hibernateExamples;

import anotatedClass.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Query {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();
        try{
            // start transaction
            session.beginTransaction();

            // query user
            List<User> theUsers = session.createQuery("FROM anotatedClass.User").getResultList();

            // all users
            System.out.println("Displaying all users");
            displayUsers(theUsers);

            System.out.println("");

            // query users name = Paco
            theUsers = session.createQuery("FROM anotatedClass.User s WHERE s.userName='Paco'").getResultList();
            System.out.println("Displaying uses with name = Paco");
            displayUsers(theUsers);

            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done!!");

        }finally {
            factory.close();
        }
    }

    private static void displayUsers(List<User> theUsers) {
        // display user
        for (User tempUser : theUsers) {
            System.out.println(tempUser);
        }
    }
}

package hibernateExamples;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/hibernate";
        String user = "root";
        String pass = "";
        try{
            System.out.println("Connecting to database: " + url);
            Connection connection = DriverManager.getConnection(url, user, pass);
            System.out.println("Success!");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

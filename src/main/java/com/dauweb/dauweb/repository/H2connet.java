package src.main.java.com.dauweb.dauweb.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class H2connet {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:h2:tcp://localhost/~/dauweb";
        String user = "sa";
        String password = "";

        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("Connected to the H2 database.");
    }
}



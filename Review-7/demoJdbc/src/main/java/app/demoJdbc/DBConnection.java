package app.demoJdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    //jdbc url for mysql driver
    static String url = "jdbc:mysql://localhost:3306/jdbc_demo";
    static String user = "root";
    static String pass = "Pari1234**";

    //connection
    public static Connection getConnection() {

        try {
            return DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
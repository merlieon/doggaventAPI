package org.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {

    Connection con;
    String host = "jdbc:mysql://90.231.149.9:3306/";
    String dbName = "animalsproj";
    String user = "lernia";
    String pass = "password";

    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(host + dbName, user, pass);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return con;
    }
}

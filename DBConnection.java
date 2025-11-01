package com.portal;
import java.sql.*;

public class DBConnection {
    private static Connection conn = null;

    public static Connection getConnection() throws Exception {
        if (conn == null) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/portal_db", "root", "password");
        }
        return conn;
    }
}

package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/db_hvac";
    private static final String USER = "root";
    private static final String PASSWORD = ""; // Sesuaikan password MySQL Anda

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("⚠️ Koneksi Gagal: " + e.getMessage());
        }
        return conn;
    }
}
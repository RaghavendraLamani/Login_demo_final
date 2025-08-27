package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/ytproject?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "Raghu@#070";
    private static Connection connection = null;

    // Get connection
    public static Connection getConnection() throws SQLException {
        try {
            if (connection == null || connection.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("✅ Connection Successful!");
            }
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL Driver not found!", e);
        }
        return connection;
    }

    // Close connection
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
                System.out.println("🔒 Connection Closed.");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
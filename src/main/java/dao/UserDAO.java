package dao;

import db.MyConnection;
import model.User;  // ✅ Import your User model

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    // Check if a user exists by email
    public static boolean isExists(String email) throws SQLException {
        String query = "SELECT 1 FROM user WHERE email = ?";
        try (Connection connection = MyConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();  // ✅ true if a record is found
            }
        }
    }

    // Save new user
    public static int saveUser(User user) throws SQLException {
        String query = "INSERT INTO user (name, email) VALUES (?, ?)";
        try (Connection connection = MyConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            return ps.executeUpdate();  // ✅ returns 1 if inserted successfully
        }
    }
}

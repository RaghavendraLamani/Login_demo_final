package service;

import dao.UserDAO;
import model.User;

import java.sql.SQLException;

public class UserService {

    public static Integer saveUser(User user) {
        try {
            if (UserDAO.isExists(user.getEmail())) {
                return 0; // user already exists
            } else {
                UserDAO.saveUser(user);
                return 1; // user saved successfully
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1; // error occurred
        }
    }
}


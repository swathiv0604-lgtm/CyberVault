package dao;

import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import model.User;

public class UserDAO {

    Connection con;

    public UserDAO() {

        con = DBConnection.getConnection();
    }

    public boolean registerUser(User user) {

        try {

            if(con == null) {

                System.out.println("Connection is NULL");
                return false;
            }

            String query =
                    "INSERT INTO users(username,email,password) VALUES(?,?,?)";

            PreparedStatement pst =
                    con.prepareStatement(query);

            pst.setString(1, user.getUsername());
            pst.setString(2, user.getEmail());
            pst.setString(3, user.getPassword());

            int rows = pst.executeUpdate();

            System.out.println("Rows inserted: " + rows);

            return rows > 0;

        } catch (Exception e) {

            System.out.println("REGISTER ERROR:");
            e.printStackTrace();
        }

        return false;
    }
}
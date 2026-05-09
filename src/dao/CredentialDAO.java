package dao;

import db.DBConnection;
import model.Credential;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CredentialDAO {

    Connection con;

    public CredentialDAO() {

        con = DBConnection.getConnection();
    }

    public boolean addCredential(Credential credential) {

        try {

            String query = "INSERT INTO credentials(website,username,password) VALUES(?,?,?)";

            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, credential.getWebsite());
            pst.setString(2, credential.getUsername());
            pst.setString(3, credential.getPassword());

            int rows = pst.executeUpdate();

            return rows > 0;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }
}
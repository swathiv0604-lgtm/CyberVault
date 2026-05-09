package gui;

import db.DBConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddCredentialForm extends JFrame implements ActionListener {

    JLabel titleLabel;
    JLabel websiteLabel;
    JLabel usernameLabel;
    JLabel passwordLabel;

    JTextField websiteField;
    JTextField usernameField;
    JPasswordField passwordField;

    JButton saveButton;

    JPanel panel;

    public AddCredentialForm() {

        setTitle("Add Credentials");

        setSize(500, 400);

        setLocationRelativeTo(null);

        setResizable(false);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(18,18,18));

        titleLabel = new JLabel("Add Credentials");
        titleLabel.setForeground(new Color(0,255,170));
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
        titleLabel.setBounds(120, 30, 300, 40);
        panel.add(titleLabel);

        websiteLabel = new JLabel("Website");
        websiteLabel.setForeground(Color.WHITE);
        websiteLabel.setBounds(60, 100, 100, 30);
        panel.add(websiteLabel);

        websiteField = new JTextField();
        websiteField.setBounds(180, 100, 220, 35);
        panel.add(websiteField);

        usernameLabel = new JLabel("Username");
        usernameLabel.setForeground(Color.WHITE);
        usernameLabel.setBounds(60, 160, 100, 30);
        panel.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(180, 160, 220, 35);
        panel.add(usernameField);

        passwordLabel = new JLabel("Password");
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setBounds(60, 220, 100, 30);
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(180, 220, 220, 35);
        panel.add(passwordField);

        saveButton = new JButton("SAVE");
        saveButton.setBounds(170, 290, 140, 40);
        saveButton.setBackground(new Color(0,255,170));
        saveButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        saveButton.addActionListener(this);
        panel.add(saveButton);

        add(panel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String website = websiteField.getText();
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        try {

            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO credentials(website, username, password) VALUES (?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, website);
            ps.setString(2, username);
            ps.setString(3, password);

            int rows = ps.executeUpdate();

            if(rows > 0) {

                JOptionPane.showMessageDialog(this, "Credential Saved Successfully");

                websiteField.setText("");
                usernameField.setText("");
                passwordField.setText("");
            }

        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
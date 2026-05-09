package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginForm extends JFrame implements ActionListener {

    JPanel panel;

    JLabel titleLabel;
    JLabel userLabel;
    JLabel passLabel;

    JTextField userField;
    JPasswordField passField;

    JButton loginButton;
    JButton registerButton;

    public LoginForm() {

        setTitle("CyberVault Secure Login");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(18, 18, 18));

        titleLabel = new JLabel("CyberVault");
        titleLabel.setForeground(new Color(0, 255, 170));
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 32));
        titleLabel.setBounds(130, 30, 300, 40);
        panel.add(titleLabel);

        userLabel = new JLabel("Username");
        userLabel.setForeground(Color.WHITE);
        userLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
        userLabel.setBounds(70, 120, 100, 30);
        panel.add(userLabel);

        userField = new JTextField();
        userField.setBounds(180, 120, 220, 35);
        panel.add(userField);

        passLabel = new JLabel("Password");
        passLabel.setForeground(Color.WHITE);
        passLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
        passLabel.setBounds(70, 190, 100, 30);
        panel.add(passLabel);

        passField = new JPasswordField();
        passField.setBounds(180, 190, 220, 35);
        panel.add(passField);

        loginButton = new JButton("LOGIN");
        loginButton.setBounds(90, 280, 130, 40);
        loginButton.setBackground(new Color(0, 255, 170));
        loginButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        loginButton.addActionListener(this);
        panel.add(loginButton);

        registerButton = new JButton("REGISTER");
        registerButton.setBounds(260, 280, 130, 40);
        registerButton.setBackground(Color.DARK_GRAY);
        registerButton.setForeground(Color.WHITE);
        registerButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        registerButton.addActionListener(this);
        panel.add(registerButton);

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == registerButton) {
            new RegisterForm();
        }

        if (e.getSource() == loginButton) {

            String user = userField.getText();
            String pass = new String(passField.getPassword());

            try {

                Connection con = db.DBConnection.getConnection();

                String sql = "SELECT * FROM users WHERE username=? AND password=?";
                PreparedStatement ps = con.prepareStatement(sql);

                ps.setString(1, user);
                ps.setString(2, pass);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {

                    JOptionPane.showMessageDialog(this, "Login Successful");

                    // ✅ FORCE DASHBOARD OPEN
                    gui.Dashboard d = new gui.Dashboard();
                    d.setVisible(true);
                    d.toFront();

                    this.dispose();

                } else {
                    JOptionPane.showMessageDialog(this, "Invalid Credentials");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new LoginForm();
    }
}
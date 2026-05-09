package gui;

import dao.UserDAO;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterForm extends JFrame implements ActionListener {

    JPanel panel;

    JLabel titleLabel;
    JLabel userLabel;
    JLabel emailLabel;
    JLabel passLabel;

    JTextField userField;
    JTextField emailField;

    JPasswordField passField;

    JButton registerButton;

    public RegisterForm() {

        setTitle("CyberVault Register");

        setSize(500, 450);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setResizable(false);

        panel = new JPanel();

        panel.setLayout(null);

        panel.setBackground(new Color(18,18,18));

        titleLabel = new JLabel("Create Account");

        titleLabel.setForeground(new Color(0,255,170));

        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));

        titleLabel.setBounds(120, 30, 250, 40);

        panel.add(titleLabel);

        userLabel = new JLabel("Username");

        userLabel.setForeground(Color.WHITE);

        userLabel.setBounds(60, 110, 100, 30);

        panel.add(userLabel);

        userField = new JTextField();

        userField.setBounds(180, 110, 230, 35);

        panel.add(userField);

        emailLabel = new JLabel("Email");

        emailLabel.setForeground(Color.WHITE);

        emailLabel.setBounds(60, 170, 100, 30);

        panel.add(emailLabel);

        emailField = new JTextField();

        emailField.setBounds(180, 170, 230, 35);

        panel.add(emailField);

        passLabel = new JLabel("Password");

        passLabel.setForeground(Color.WHITE);

        passLabel.setBounds(60, 230, 100, 30);

        panel.add(passLabel);

        passField = new JPasswordField();

        passField.setBounds(180, 230, 230, 35);

        panel.add(passField);

        registerButton = new JButton("CREATE ACCOUNT");

        registerButton.setBounds(140, 320, 200, 45);

        registerButton.setBackground(new Color(0,255,170));

        registerButton.setFont(new Font("Segoe UI", Font.BOLD, 15));

        registerButton.addActionListener(this);

        panel.add(registerButton);

        add(panel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String username = userField.getText();

        String email = emailField.getText();

        String password = new String(passField.getPassword());

        User user = new User(username, email, password);

        UserDAO dao = new UserDAO();

        boolean success = dao.registerUser(user);

        if(success) {

            JOptionPane.showMessageDialog(this,
                    "Registration Successful");

        } else {

            JOptionPane.showMessageDialog(this,
                    "Registration Failed");
        }
    }
}
package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Dashboard extends JFrame implements ActionListener {

    JPanel panel;

    JLabel titleLabel;

    JButton addButton;
    JButton viewButton;
    JButton logoutButton;

    public Dashboard() {

        setTitle("CyberVault Dashboard");

        setSize(600, 450);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setResizable(false);

        panel = new JPanel();

        panel.setLayout(null);

        panel.setBackground(new Color(18,18,18));

        titleLabel = new JLabel("WELCOME TO CYBERVAULT");

        titleLabel.setForeground(new Color(0,255,170));

        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));

        titleLabel.setBounds(90, 40, 500, 40);

        panel.add(titleLabel);

        addButton = new JButton("ADD CREDENTIALS");

        addButton.setBounds(170, 120, 240, 50);

        addButton.setFont(new Font("Segoe UI", Font.BOLD, 15));

        addButton.setBackground(new Color(0,255,170));

        addButton.addActionListener(this);

        panel.add(addButton);

        viewButton = new JButton("VIEW VAULT");

        viewButton.setBounds(170, 210, 240, 50);

        viewButton.setFont(new Font("Segoe UI", Font.BOLD, 15));

        viewButton.setBackground(Color.DARK_GRAY);

        viewButton.setForeground(Color.WHITE);

        viewButton.addActionListener(this);

        panel.add(viewButton);

        logoutButton = new JButton("LOGOUT");

        logoutButton.setBounds(170, 300, 240, 50);

        logoutButton.setFont(new Font("Segoe UI", Font.BOLD, 15));

        logoutButton.setBackground(Color.RED);

        logoutButton.setForeground(Color.WHITE);

        logoutButton.addActionListener(this);

        panel.add(logoutButton);

        add(panel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == addButton) {

            new AddCredentialForm();
        }

        if(e.getSource() == viewButton) {

            JOptionPane.showMessageDialog(this,
                    "View Vault screen coming next");
        }

        if(e.getSource() == logoutButton) {

            new LoginForm();

            this.dispose();
        }
    }
}
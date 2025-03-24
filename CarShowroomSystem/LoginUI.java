import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginUI {
    public LoginUI() {
        JFrame frame = new JFrame("Car Showroom - Login");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 2));

        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField();
        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField();
        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");
        JLabel roleLabel = new JLabel("Role:");
        JComboBox<String> roleDropdown = new JComboBox<>(new String[]{"Customer", "Admin"});
        JLabel statusLabel = new JLabel("");

        frame.add(userLabel);
        frame.add(userField);
        frame.add(passLabel);
        frame.add(passField);
        frame.add(roleLabel);
        frame.add(roleDropdown);
        frame.add(registerButton);
        frame.add(loginButton);
        frame.add(statusLabel);

        // Login Action
        loginButton.addActionListener(e -> {
            String username = userField.getText().trim();
            String password = new String(passField.getPassword()).trim();
            String role = UserManager.authenticateUser(username, password);

            if (role != null) {
                statusLabel.setText("Login Successful! Role: " + role);
                frame.dispose();
                new CarShowroomUI(role);
            } else {
                statusLabel.setText("Invalid Credentials.");
            }
        });

        // Register Action
        registerButton.addActionListener(e -> {
            String username = userField.getText().trim();
            String password = new String(passField.getPassword()).trim();
            String role = (String) roleDropdown.getSelectedItem();

            if (username.isEmpty() || password.isEmpty()) {
                statusLabel.setText("Fields cannot be empty!");
                return;
            }

            if (UserManager.registerUser(username, password, role)) {
                statusLabel.setText("Registration Successful! Please login.");
            } else {
                statusLabel.setText("Registration Failed! User may already exist.");
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new LoginUI();
    }
}
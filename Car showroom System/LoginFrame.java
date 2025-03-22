package Car showroom System;

package view;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
public class LoginFrame extends JFrame {
private JTextField usernameField;
private JPasswordField passwordField;
private JButton loginButton;public LoginFrame() {
setTitle("Car Showroom - Login");
setSize(350, 200);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLayout(null);
JLabel userLabel = new JLabel("Username:");
userLabel.setBounds(20, 30, 80, 25);
add(userLabel);
usernameField = new JTextField();
usernameField.setBounds(100, 30, 200, 25);
add(usernameField);
JLabel passLabel = new JLabel("Password:");
passLabel.setBounds(20, 70, 80, 25);
add(passLabel);
passwordField = new JPasswordField();
passwordField.setBounds(100, 70, 200, 25);
add(passwordField);
loginButton = new JButton("Login");
loginButton.setBounds(120, 110, 100, 30);
add(loginButton);
loginButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
authenticateUser(usernameField.getText(), new
String(passwordField.getPassword()));
}
});
setVisible(true);
}
private void authenticateUser(String username, String password) {
try (BufferedReader br = new BufferedReader(new
FileReader("users.txt"))) {
String line;
while ((line = br.readLine()) != null) {
String[] userData = line.split(",");
if (userData[0].equals(username) &&
userData[1].equals(password)) {
JOptionPane.showMessageDialog(this, "Login Successful!");
new CarListFrame(); // Open the Car List after login
dispose();
return;
}
}
JOptionPane.showMessageDialog(this, "Invalid Credentials");
} catch (IOException ex) {
JOptionPane.showMessageDialog(this, "Error reading user file.");
}
}public static void main(String[] args) {
new LoginFrame();
}
}
package view; 
import controller.LoginController; 
import util.UIHelper; 
import javax.swing.*; 
public class LoginFrame extends JFrame { 
private JTextField usernameField; 
private JPasswordField passwordField; 
private JButton loginBtn; 
public LoginFrame() { 
setTitle("Car Showroom - Login"); 
setSize(350, 220); 
setDefaultCloseOperation(EXIT_ON_CLOSE); 
setLayout(null); 
setLocationRelativeTo(null); 
JLabel userLabel = new JLabel("Username:"); 
userLabel.setBounds(30, 30, 100, 25); 
add(userLabel); 
usernameField = new JTextField(); 
usernameField.setBounds(130, 30, 160, 25); 
add(usernameField); 
JLabel passLabel = new JLabel("Password:"); 
passLabel.setBounds(30, 70, 100, 25); 
add(passLabel); 
passwordField = new JPasswordField(); 
passwordField.setBounds(130, 70, 160, 25); 
add(passwordField); 
loginBtn = new JButton("Login"); 
loginBtn.setBounds(130, 110, 160, 30); 
add(loginBtn); 
loginBtn.addActionListener(e -> { 
String username = usernameField.getText().trim(); 
String password = new String(passwordField.getPassword()).trim(); 
LoginController.authenticate(username, password, this); 
}); 
UIHelper.setUIFont(this); 
} 
}
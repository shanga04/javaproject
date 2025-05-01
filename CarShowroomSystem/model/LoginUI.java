import javax.swing.*;
import java.awt.*;
public class LoginUI extends JFrame {
 public LoginUI() {
 setTitle("Login - Car Showroom");
 setSize(400, 230);
 setDefaultCloseOperation(EXIT_ON_CLOSE);
 setLocationRelativeTo(null);
 JTextField userField = new JTextField();
 JPasswordField passField = new JPasswordField();
 JButton loginBtn = new JButton("Login");
 JButton registerBtn = new JButton("Register");
 JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
 panel.setBackground(new Color(240, 248, 255));
 panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
 panel.add(new JLabel("Username:"));
 panel.add(userField);
 panel.add(new JLabel("Password:"));
 panel.add(passField);
 panel.add(registerBtn);
 panel.add(loginBtn);
 loginBtn.setBackground(Color.GREEN);
 registerBtn.setBackground(Color.CYAN);
 loginBtn.addActionListener(e -> {
 String username = userField.getText().trim();
 String password = new String(passField.getPassword()).trim();
 User user = UserManager.login(username, password);
 if (user != null) {
 dispose();
new DashboardUI(user);
 } else {
 JOptionPane.showMessageDialog(this, "Invalid credentials.");
 }
 });
 registerBtn.addActionListener(e -> {
 dispose();
 new RegisterUI();
 });
 add(panel);
 setVisible(true);
 }
}
import javax.swing.*;
import java.awt.*;
public class RegisterUI extends JFrame {
 public RegisterUI() {
 setTitle("Register - Car Showroom");
 setSize(400, 270);
 setDefaultCloseOperation(EXIT_ON_CLOSE);
 setLocationRelativeTo(null);
 JTextField userField = new JTextField();
 JPasswordField passField = new JPasswordField();
 JComboBox<String> roleBox = new JComboBox<>(new String[]{"Customer", 
"Admin"});
 JButton registerBtn = new JButton("Register");
 JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
 panel.setBackground(new Color(245, 255, 250));
 panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
 panel.add(new JLabel("Username:"));
 panel.add(userField);
 panel.add(new JLabel("Password:"));
 panel.add(passField);
 panel.add(new JLabel("Role:"));
 panel.add(roleBox);
 panel.add(new JLabel());
 panel.add(registerBtn);
 registerBtn.setBackground(Color.ORANGE);
 registerBtn.addActionListener(e -> {
 String username = userField.getText().trim();
 String password = new String(passField.getPassword()).trim();
 String role = roleBox.getSelectedItem().toString();
 if (UserManager.register(username, password, role)) {
 JOptionPane.showMessageDialog(this, "Registration 
successful!");
 dispose();
 new LoginUI();
 } else {
 JOptionPane.showMessageDialog(this, "User already exists.");
 }
 });
 add(panel);
 setVisible(true);
 }
}


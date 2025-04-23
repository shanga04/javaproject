package view; 
import dao.UserDAO; 
import model.User; 
import util.UIHelper; 
import javax.swing.*; 
public class RegisterFrame extends JFrame { 
private JTextField usernameField; 
private JPasswordField passwordField; 
private JComboBox<String> roleCombo; 
private JButton registerBtn; 
public RegisterFrame() { 
setTitle("Register New User"); 
setSize(350, 250); 
setLayout(null); 
setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
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
JLabel roleLabel = new JLabel("Role:"); 
roleLabel.setBounds(30, 110, 100, 25); 
add(roleLabel); 
roleCombo = new JComboBox<>(new String[]{"customer", "admin"}); 
roleCombo.setBounds(130, 110, 160, 25); 
add(roleCombo); 
registerBtn = new JButton("Register"); 
registerBtn.setBounds(130, 150, 160, 30); 
add(registerBtn); 
registerBtn.addActionListener(e -> { 
String username = usernameField.getText().trim(); 
String password = new String(passwordField.getPassword()).trim(); 
String role = (String) roleCombo.getSelectedItem(); 
if (username.isEmpty() || password.isEmpty()) { 
JOptionPane.showMessageDialog(this, "Please fill in all 
fields."); 
return; 
} 
User newUser = new User(0, username, password, role); 
boolean success = UserDAO.register(newUser); 
JOptionPane.showMessageDialog(this, success ? "User registered!" 
: "Registration failed."); 
if (success) dispose(); 
}); 
UIHelper.setUIFont(this); 
} 
} 
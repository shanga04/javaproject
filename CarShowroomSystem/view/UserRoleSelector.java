package view; 
import javax.swing.*; 
public class UserRoleSelector extends JFrame { 
public UserRoleSelector() { 
setTitle("Select Role to Continue"); 
setSize(300, 150); 
setLayout(null); 
setLocationRelativeTo(null); 
setDefaultCloseOperation(EXIT_ON_CLOSE); 
JButton adminBtn = new JButton("Login as Admin"); 
adminBtn.setBounds(50, 20, 200, 30); 
add(adminBtn); 
JButton customerBtn = new JButton("Login as Customer"); 
customerBtn.setBounds(50, 60, 200, 30); 
add(customerBtn); 
adminBtn.addActionListener(e -> { 
dispose(); 
new LoginFrame().setVisible(true); // simulate admin login 
}); 
customerBtn.addActionListener(e -> { 
dispose(); 
new LoginFrame().setVisible(true); // simulate customer login 
}); 
} 
}
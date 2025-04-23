package controller; 
import dao.UserDAO; 
import model.User; 
import view.AdminDashboard; 
import view.CustomerDashboard; 
import javax.swing.*; 
public class LoginController { 
public static void authenticate(String username, String password, JFrame 
frame) { 
User user = UserDAO.login(username, password); 
if (user != null) { 
JOptionPane.showMessageDialog(frame, "Login successful!"); 
frame.dispose(); 
if (user.getRole().equals("admin")) { 
new AdminDashboard(user).setVisible(true); 
} else { 
new CustomerDashboard(user).setVisible(true); 
} 
} else { 
JOptionPane.showMessageDialog(frame, "Invalid credentials!", 
"Error", JOptionPane.ERROR_MESSAGE); 
} 
} 
}
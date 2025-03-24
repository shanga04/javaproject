package CarShowroomSystem;

import javax.swing.*; 
import java.awt.*; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
 
public class LoginUI { 
    /**
     * @param args
     */
    public static void main(String[] args) { 
        JFrame frame = new JFrame("Car Showroom - Login"); 
        frame.setSize(400, 250); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setLayout(new GridLayout(4, 2)); 
 
        JLabel userLabel = new JLabel("Username:"); 
        JTextField userField = new JTextField(); 
        JLabel passLabel = new JLabel("Password:"); 
        JPasswordField passField = new JPasswordField(); 
        JButton loginButton = new JButton("Login"); 
        JLabel statusLabel = new JLabel(""); 
 
        frame.add(userLabel); 
        frame.add(userField); 
        frame.add(passLabel); 
        frame.add(passField); 
        frame.add(new JLabel("")); 
        frame.add(loginButton); 
        frame.add(statusLabel); 
 
        loginButton.addActionListener(new ActionListener() { 
            @Override 
            public void actionPerformed(ActionEvent e) { 
                String username = userField.getText(); 
                String password = new String(passField.getPassword()); 
 
                String role = UserManager.authenticateUser(username, 
password); 
                if (role != null) { 
                    statusLabel.setText("Login Successful! Role: " + role); 
                    frame.dispose(); 
                    new CarShowroomUI(role); // Open Car Showroom if login 
succeeds 
                } else { 
                    statusLabel.setText("Invalid Credentials."); 
                } 
            } 
        }); 
 
        frame.setVisible(true); 
    } 
}
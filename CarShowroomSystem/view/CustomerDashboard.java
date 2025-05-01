package view; 
import model.User; 
import util.UIHelper; 
import javax.swing.*; 
public class CustomerDashboard extends JFrame { 
private final User customerUser; 
public CustomerDashboard(User customerUser) { 
this.customerUser = customerUser; 
setTitle("Customer Dashboard - " + customerUser.getUsername()); 
setSize(400, 250); 
setLayout(null); 
setLocationRelativeTo(null); 
setDefaultCloseOperation(EXIT_ON_CLOSE); 
JButton viewCarsBtn = new JButton("Browse Cars"); 
viewCarsBtn.setBounds(100, 30, 200, 30); 
add(viewCarsBtn); 
JButton bookBtn = new JButton("Search & Book"); 
bookBtn.setBounds(100, 70, 200, 30); 
add(bookBtn); 
JButton myBookingsBtn = new JButton("My Bookings"); 
myBookingsBtn.setBounds(100, 110, 200, 30); 
add(myBookingsBtn); 
JButton logoutBtn = new JButton("Logout"); 
logoutBtn.setBounds(100, 150, 200, 30); 
add(logoutBtn); 
viewCarsBtn.addActionListener(e -> new 
CarListFrame(false).setVisible(true)); 
bookBtn.addActionListener(e -> new 
CarSearchAndBookForm(customerUser.getId()).setVisible(true)); 
myBookingsBtn.addActionListener(e -> new 
MyBookingsFrame(customerUser.getId()).setVisible(true)); 
logoutBtn.addActionListener(e -> { 
dispose(); 
new LoginFrame().setVisible(true); 
}); 
UIHelper.setUIFont(this); 
} 
}
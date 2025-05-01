package view; 
import model.User; 
import util.UIHelper; 
import javax.swing.*; 
public class AdminDashboard extends JFrame { 
private final User adminUser; 
public AdminDashboard(User adminUser) { 
this.adminUser = adminUser; 
setTitle("Admin Dashboard - " + adminUser.getUsername()); 
setSize(400, 300); 
setLayout(null); 
setLocationRelativeTo(null); 
setDefaultCloseOperation(EXIT_ON_CLOSE); 
JButton addCarBtn = new JButton("Add New Car"); 
addCarBtn.setBounds(100, 30, 200, 30); 
add(addCarBtn); 
JButton viewCarsBtn = new JButton("View Cars"); 
viewCarsBtn.setBounds(100, 70, 200, 30); 
add(viewCarsBtn); 
JButton manageBookingsBtn = new JButton("Manage Bookings"); 
manageBookingsBtn.setBounds(100, 110, 200, 30); 
add(manageBookingsBtn); 
JButton salesReportBtn = new JButton("View Sales Report"); 
salesReportBtn.setBounds(100, 150, 200, 30); 
add(salesReportBtn); 
JButton logoutBtn = new JButton("Logout"); 
logoutBtn.setBounds(100, 190, 200, 30); 
add(logoutBtn); 
addCarBtn.addActionListener(e -> new AddCarForm().setVisible(true)); 
viewCarsBtn.addActionListener(e -> new 
CarListFrame(true).setVisible(true)); 
manageBookingsBtn.addActionListener(e -> new 
AdminBookingManager().setVisible(true)); 
salesReportBtn.addActionListener(e -> new 
SalesReportFrame().setVisible(true)); 
logoutBtn.addActionListener(e -> { 
dispose(); 
new LoginFrame().setVisible(true); 
}); 
UIHelper.setUIFont(this); 
} 
} 
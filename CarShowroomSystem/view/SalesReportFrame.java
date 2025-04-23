package view; 
import controller.BookingController; 
import util.UIHelper; 
import javax.swing.*; 
public class SalesReportFrame extends JFrame { 
public SalesReportFrame() { 
setTitle("Sales Report"); 
setSize(400, 200); 
setLocationRelativeTo(null); 
setLayout(null); 
setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
int totalApprovedBookings = BookingController.getSalesCount(); 
JLabel reportLabel = new JLabel("Total Approved Bookings: " + 
totalApprovedBookings); 
reportLabel.setBounds(50, 50, 300, 40); 
add(reportLabel); 
UIHelper.setUIFont(this); 
} 
}
package view; 
import controller.BookingController;
import java.awt.*; 
import java.util.ArrayList;
import javax.swing.*;
import model.Booking;
import util.UIHelper; 
public class AdminBookingManager extends JFrame { 
public AdminBookingManager() { 
setTitle("Manage Bookings"); 
setSize(600, 400); 
setLocationRelativeTo(null); 
setLayout(new BorderLayout()); 
setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
ArrayList<Booking> bookings = BookingController.getAllBookings(); 
JPanel bookingPanel = new JPanel(new GridLayout(0, 1)); 
JScrollPane scrollPane = new JScrollPane(bookingPanel); 
for (Booking booking : bookings) { 
JPanel p = new JPanel(new FlowLayout()); 
JLabel label = new JLabel(
    "Booking #" + booking.getId()
    + " | Car ID: " + booking.getCarId()
    + " | User ID: " + booking.getUserId()
    + " | Status: " + booking.getStatus()
);

JButton approveBtn = new JButton("Approve"); 
JButton rejectBtn = new JButton("Reject"); 
approveBtn.addActionListener(e -> { 
boolean updated = 
BookingController.updateBookingStatus(booking.getId(), "approved"); 
JOptionPane.showMessageDialog(this, updated ? "Booking approved." : "Approval failed."); 
dispose(); 
new AdminBookingManager().setVisible(true); 
}); 
rejectBtn.addActionListener(e -> { 
boolean updated = 
BookingController.updateBookingStatus(booking.getId(), "rejected"); 
JOptionPane.showMessageDialog(this, updated ? "Booking rejected." : "Rejection failed."); 
dispose(); 
new AdminBookingManager().setVisible(true); 
}); 
p.add(label); 
p.add(approveBtn); 
p.add(rejectBtn); 
bookingPanel.add(p); 
} 
add(scrollPane, BorderLayout.CENTER); 
UIHelper.setUIFont(this); 
} 
}
package view; 
import controller.BookingController; 
import model.Booking; 
import util.UIHelper; 
import javax.swing.*; 
import java.awt.*; 
import java.util.ArrayList; 
public class MyBookingsFrame extends JFrame { 
private final int userId; 
public MyBookingsFrame(int userId) { 
this.userId = userId; 
setTitle("My Bookings"); 
setSize(500, 400); 
setLocationRelativeTo(null); 
setLayout(new BorderLayout()); 
setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
ArrayList<Booking> bookings = 
BookingController.getBookingsByUser(userId); 
JPanel bookingPanel = new JPanel(new GridLayout(0, 1)); 
JScrollPane scrollPane = new JScrollPane(bookingPanel); 
for (Booking booking : bookings) { 
JPanel p = new JPanel(new GridLayout(1, 4)); 
p.add(new JLabel("Booking ID: " + booking.getId())); 
p.add(new JLabel("Car ID: " + booking.getCarId())); 
p.add(new JLabel("Status: " + booking.getStatus())); 
p.add(new JLabel("Date: " + booking.getDate())); 
bookingPanel.add(p); 
} 
add(scrollPane, BorderLayout.CENTER); 
UIHelper.setUIFont(this); 
} 
}
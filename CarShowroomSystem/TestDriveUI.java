import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TestDriveUI {
    private JTextArea bookingListArea;
    
    public TestDriveUI() {
        JFrame frame = new JFrame("Test Drivee Booking");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        
    
        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        JLabel nameLabel = new JLabel("Your Name:");
        JTextField nameField = new JTextField();
        JLabel carLabel = new JLabel("Car Model:");
        JTextField carField = new JTextField();
        JLabel dateLabel = new JLabel("Date (YYYY-MM-DD):");
        JTextField dateField = new JTextField();
        JButton bookButton = new JButton("Book Test Drive");
         
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(carLabel);
        inputPanel.add(carField);
        inputPanel.add(dateLabel);
        inputPanel.add(dateField);
        inputPanel.add(new JLabel(""));
        inputPanel.add(bookButton);
       
        bookingListArea = new JTextArea();
        bookingListArea.setEditable(false);
        updateBookingList();
        
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(bookingListArea), BorderLayout.CENTER);
        
      
        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String customerName = nameField.getText().trim();
                String carModel = carField.getText().trim();
                String date = dateField.getText().trim();
                
                if (customerName.isEmpty() || carModel.isEmpty() || date.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill all fields.");
                    return;
                }
                
                boolean success = TestDriveManager.bookTestDrive(customerName, carModel, date);
                if (success) {
                    JOptionPane.showMessageDialog(frame, "Booking Confirmed!");
                    updateBookingList();
                } else {
                    JOptionPane.showMessageDialog(frame, "Booking Failed! Test drive already exists.");
                }
            }
        });
        
        frame.setVisible(true);
    }
    
    
    private void updateBookingList() {
        bookingListArea.setText("Test Drive Bookings:\n");
        List<String> bookings = TestDriveManager.getBookings();
        if (bookings.isEmpty()) {
            bookingListArea.append("No bookings available.\n");
        } else {
            for (String booking : bookings) {
                bookingListArea.append(booking + "\n");
            }
        }
    }
    
    public static void main(String[] args) {
        new TestDriveUI();
    }
}
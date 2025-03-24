import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestUI {
    public TestUI() {
        JFrame frame = new JFrame("Test Drive Booking");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 2));

        JLabel nameLabel = new JLabel("Your Name:");
        JTextField nameField = new JTextField();
        JLabel carLabel = new JLabel("Car Model:");
        JTextField carField = new JTextField();
        JLabel dateLabel = new JLabel("Date (YYYY-MM-DD):");
        JTextField dateField = new JTextField();
        JButton bookButton = new JButton("Book Test Drive");
        JLabel statusLabel = new JLabel("");

        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(carLabel);
        frame.add(carField);
        frame.add(dateLabel);
        frame.add(dateField);
        frame.add(bookButton);
        frame.add(statusLabel);

        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String customerName = nameField.getText();
                String carModel = carField.getText();
                String date = dateField.getText();
                
                if (!customerName.isEmpty() && !carModel.isEmpty() && !date.isEmpty()) {
                    // Using direct logic instead of TestDriveManager
                    System.out.println("Test drive booked for " + customerName + 
                                      " with car model " + carModel + 
                                      " on " + date);
                    statusLabel.setText("Booking Confirmed!");
                } else {
                    statusLabel.setText("Please fill all fields.");
                }
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TestUI();
            }
        });
    }
}
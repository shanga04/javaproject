import javax.swing.*;
import java.awt.*;
public class BookingUI extends JFrame {
 public BookingUI(String username) {
 setTitle("Book Test Drive");
 setSize(400, 250);
 setDefaultCloseOperation(EXIT_ON_CLOSE);
 setLocationRelativeTo(null);
 JComboBox<String> carBox = new JComboBox<>();
 for (Car car : CarManager.getAllCars()) {
 if (car.isAvailable()) carBox.addItem(car.getModel());
 }
 JTextField dateField = new JTextField("2025-05-01");
 JButton bookBtn = new JButton("Book Now");
 JPanel panel = new JPanel(new GridLayout(3, 2, 11, 10));
 panel.setBackground(new Color(255, 255, 240));
 panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
 panel.add(new JLabel("Select Car:"));
 panel.add(carBox);
 panel.add(new JLabel("Date (YYYY-MM-DD):"));
 panel.add(dateField);
 panel.add(new JLabel());
 panel.add(bookBtn);
 bookBtn.setBackground(new Color(135, 206, 250));
 bookBtn.addActionListener(e -> {
 String car = (String) carBox.getSelectedItem();
 String date = dateField.getText().trim();
 if (!car.isEmpty() && !date.isEmpty()) {
 BookingManager.addBooking(new Booking(username, car, date));
 JOptionPane.showMessageDialog(this, "Test drive booked 
successfully!");
 }
 });
 add(panel);
 setVisible(true);
 }
}

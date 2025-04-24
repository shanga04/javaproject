import javax.swing.*;
import java.awt.*;
public class AdminPanelUI extends JFrame {
 public AdminPanelUI() {
 setTitle("Admin Panel - Add Car");
 setSize(400, 300);
 setDefaultCloseOperation(EXIT_ON_CLOSE);
 setLocationRelativeTo(null);
 JTextField modelField = new JTextField();
 JTextField priceField = new JTextField();
 JTextField fuelField = new JTextField();
 JCheckBox availableBox = new JCheckBox("Available", true);
 JButton addBtn = new JButton("Add Car");
 JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
 panel.setBackground(new Color(250, 240, 230));
 panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
 panel.add(new JLabel("Model:"));
 panel.add(modelField);
 panel.add(new JLabel("Price:"));
 panel.add(priceField);
 panel.add(new JLabel("Fuel Type:"));
 panel.add(fuelField);
 panel.add(new JLabel("Available:"));
 panel.add(availableBox);
 panel.add(new JLabel());
 panel.add(addBtn);
 addBtn.setBackground(Color.MAGENTA);
 addBtn.addActionListener(e -> {
 String model = modelField.getText().trim();
 double price = Double.parseDouble(priceField.getText().trim());
 String fuel = fuelField.getText().trim();
 boolean available = availableBox.isSelected();
 CarManager.addCar(new Car(model, price, fuel, available));
 JOptionPane.showMessageDialog(this, "Car added successfully!");
 });
 add(panel);
 setVisible(true);
 }
}

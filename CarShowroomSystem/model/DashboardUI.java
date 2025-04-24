import javax.swing.*;
import java.awt.*;
import java.util.List;
public class DashboardUI extends JFrame {
 public DashboardUI(User user) {
 setTitle("Dashboard - Welcome " + user.getUsername());
 setSize(600, 400);
 setDefaultCloseOperation(EXIT_ON_CLOSE);
 setLocationRelativeTo(null);
 JTextArea area = new JTextArea();
 area.setEditable(false);
 area.setFont(new Font("Monospaced", Font.PLAIN, 14));
 area.setBackground(new Color(250, 250, 240));
 List<Car> cars = CarManager.getAllCars();
 for (Car car : cars) {
 area.append(car.toString() + "\n");
 }
 JButton bookBtn = new JButton("Book Test Drive");
 JButton adminBtn = new JButton("Admin Panel");
 JButton logoutBtn = new JButton("Logout");
 JPanel buttons = new JPanel();
 bookBtn.setBackground(Color.YELLOW);
 logoutBtn.setBackground(Color.PINK);
 buttons.add(bookBtn);
 if (user instanceof Admin) {
 adminBtn.setBackground(Color.LIGHT_GRAY);
 buttons.add(adminBtn);
 }
 buttons.add(logoutBtn);
 bookBtn.addActionListener(e -> {
 dispose();
 new BookingUI(user.getUsername());
 });
 adminBtn.addActionListener(e -> {
 dispose();
 new AdminPanelUI();
 });
 logoutBtn.addActionListener(e -> {
 dispose();
 new LoginUI();
 });
 add(new JScrollPane(area), BorderLayout.CENTER);
 add(buttons, BorderLayout.SOUTH);
 setVisible(true);
 }
}

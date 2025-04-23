package view; 
import controller.CarController; 
import model.Car; 
import util.UIHelper; 
import javax.swing.*; 
import java.awt.*; 
import java.util.ArrayList; 
public class CarListFrame extends JFrame { 
public CarListFrame(boolean isAdmin) { 
setTitle(isAdmin ? "Car Inventory" : "Available Cars"); 
setSize(600, 400); 
setLocationRelativeTo(null); 
setLayout(new BorderLayout()); 
setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
ArrayList<Car> cars = CarController.getAllCars(); 
JPanel carPanel = new JPanel(new GridLayout(0, 1)); 
JScrollPane scrollPane = new JScrollPane(carPanel); 
for (Car car : cars) { 
JPanel p = new JPanel(new GridLayout(1, 4)); 
p.add(new JLabel("Make: " + car.getMake())); 
p.add(new JLabel("Model: " + car.getModel())); 
p.add(new JLabel("Fuel: " + car.getFuelType())); 
p.add(new JLabel("Price: $" + car.getPrice())); 
carPanel.add(p); 
} 
add(scrollPane, BorderLayout.CENTER); 
UIHelper.setUIFont(this); 
} 
}
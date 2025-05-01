package view; 
import controller.BookingController;
import controller.CarController;
import java.util.ArrayList; 
import javax.swing.*;
import model.Car;
import util.UIHelper; 
public class CarSearchAndBookForm extends JFrame { 
    private JTextField makeField, fuelField; 
    private final int userId; 
 
    public CarSearchAndBookForm(int userId) { 
        this.userId = userId; 
        setTitle("Search & Book Test Drive"); 
        setSize(400, 300); 
        setLayout(null); 
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
 
        JLabel makeLabel = new JLabel("Make:"); 
        makeLabel.setBounds(30, 30, 80, 25); 
        add(makeLabel); 
        makeField = new JTextField(); 
        makeField.setBounds(130, 30, 200, 25); 
        add(makeField); 
 
        JLabel fuelLabel = new JLabel("Fuel Type:"); 
        fuelLabel.setBounds(30, 70, 80, 25); 
        add(fuelLabel); 
        fuelField = new JTextField(); 
        fuelField.setBounds(130, 70, 200, 25); 
        add(fuelField); 
 
        JButton searchBtn = new JButton("Search & Book"); 
        searchBtn.setBounds(130, 110, 140, 30); 
        add(searchBtn); 
 
        searchBtn.addActionListener(e -> { 
            ArrayList<Car> matches = 
CarController.searchCars(makeField.getText(), fuelField.getText()); 
            if (matches.isEmpty()) { 
                JOptionPane.showMessageDialog(this, "No matching cars found."); 
            } else { 
                for (Car car : matches) { 
                    int choice = JOptionPane.showConfirmDialog(this, 
                            "Book test drive for " + car.getMake() + " " + 
car.getModel() + 
                                    " - $" + car.getPrice() + "?", 
                            "Book Confirmation", JOptionPane.YES_NO_OPTION); 
                    if (choice == JOptionPane.YES_OPTION) { 
                        boolean booked = 
BookingController.bookCar(car.getId(), userId); 
                        JOptionPane.showMessageDialog(this,  booked ? "Booked successfully!" : "Booking failed."); 
                    } 
                } 
            } 
        }); 
 
        UIHelper.setUIFont(this); 
    } 
}
package view; 
import controller.CarController; 
import model.Car; 
import util.UIHelper; 
import javax.swing.*; 
public class AddCarForm extends JFrame { 
private JTextField makeField, modelField, priceField, fuelField, 
imagePathField; 
public AddCarForm() { 
setTitle("Add New Car"); 
setSize(400, 350); 
setLayout(null); 
setLocationRelativeTo(null); 
setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
JLabel makeLabel = new JLabel("Make:"); 
makeLabel.setBounds(30, 30, 100, 25); 
add(makeLabel); 
makeField = new JTextField(); 
makeField.setBounds(130, 30, 200, 25); 
add(makeField); 
        JLabel modelLabel = new JLabel("Model:"); 
        modelLabel.setBounds(30, 70, 100, 25); 
        add(modelLabel); 
        modelField = new JTextField(); 
        modelField.setBounds(130, 70, 200, 25); 
        add(modelField); 
 
        JLabel priceLabel = new JLabel("Price:"); 
        priceLabel.setBounds(30, 110, 100, 25); 
        add(priceLabel); 
        priceField = new JTextField(); 
        priceField.setBounds(130, 110, 200, 25); 
        add(priceField); 
 
        JLabel fuelLabel = new JLabel("Fuel Type:"); 
        fuelLabel.setBounds(30, 150, 100, 25); 
        add(fuelLabel); 
        fuelField = new JTextField(); 
        fuelField.setBounds(130, 150, 200, 25); 
        add(fuelField); 
 
        JLabel imgLabel = new JLabel("Image Path:"); 
        imgLabel.setBounds(30, 190, 100, 25); 
        add(imgLabel); 
        imagePathField = new JTextField(); 
        imagePathField.setBounds(130, 190, 200, 25); 
        add(imagePathField); 
 
        JButton saveBtn = new JButton("Save"); 
        saveBtn.setBounds(130, 240, 100, 30); 
        add(saveBtn); 
 
        saveBtn.addActionListener(e -> { 
            try { 
                Car car = new Car( 
                        0, 
                        makeField.getText(), 
                        modelField.getText(), 
                        Double.parseDouble(priceField.getText()), 
                        fuelField.getText(), 
                        imagePathField.getText() 
                ); 
                boolean success = CarController.addNewCar(car); 
                if (success) { 
                    JOptionPane.showMessageDialog(this, "Car added 
successfully."); 
                    dispose(); 
                } else { 
                    JOptionPane.showMessageDialog(this, "Failed to add 
car."); 
                } 
            } catch (Exception ex) { 
                JOptionPane.showMessageDialog(this, "Invalid input."); 
            } 
        }); 
 
        UIHelper.setUIFont(this); 
} 
} 
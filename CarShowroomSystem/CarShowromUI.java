import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CarShowroomUI {
    private JTextArea carListArea;

    public CarShowroomUI(String role) {
        JFrame frame = new JFrame("Car Showroom");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Text Area for Car Listings
        carListArea = new JTextArea();
        carListArea.setEditable(false);
        updateCarList(CarManager.getCars()); // Load all cars initially

        // Search Panel
        JPanel searchPanel = new JPanel(new FlowLayout());

        // Search by Make
        JTextField makeField = new JTextField(10);
        JButton searchMakeBtn = new JButton("Search by Make");

        // Search by Price
        JTextField minPriceField = new JTextField(5);
        JTextField maxPriceField = new JTextField(5);
        JButton searchPriceBtn = new JButton("Search by Price");

        // Search by Fuel Type
        JTextField fuelField = new JTextField(10);
        JButton searchFuelBtn = new JButton("Search by Fuel Type");

        // Add components to the search panel
        searchPanel.add(new JLabel("Make:"));
        searchPanel.add(makeField);
        searchPanel.add(searchMakeBtn);

        searchPanel.add(new JLabel("Min Price:"));
        searchPanel.add(minPriceField);
        searchPanel.add(new JLabel("Max Price:"));
        searchPanel.add(maxPriceField);
        searchPanel.add(searchPriceBtn);

        searchPanel.add(new JLabel("Fuel Type:"));
        searchPanel.add(fuelField);
        searchPanel.add(searchFuelBtn);

        // Scrollable car list area
        frame.add(new JScrollPane(carListArea), BorderLayout.CENTER);
        frame.add(searchPanel, BorderLayout.NORTH);

        // Admin feature: Add Car Button
        if ("Admin".equals(role)) {
            JButton addCarButton = new JButton("Add New Car");
            frame.add(addCarButton, BorderLayout.SOUTH);
            addCarButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Feature coming soon!"));
        }

        // Search actions
        searchMakeBtn.addActionListener(e -> {
            List<CarManager.Car> filteredCars = CarManager.filterByMake(makeField.getText().trim());
            updateCarList(filteredCars);
        });

        searchPriceBtn.addActionListener(e -> {
            try {
                double minPrice = Double.parseDouble(minPriceField.getText().trim());
                double maxPrice = Double.parseDouble(maxPriceField.getText().trim());
                List<CarManager.Car> filteredCars = CarManager.filterByPrice(minPrice, maxPrice);
                updateCarList(filteredCars);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid price values!");
            }
        });

        searchFuelBtn.addActionListener(e -> {
            List<CarManager.Car> filteredCars = CarManager.filterByFuelType(fuelField.getText().trim());
            updateCarList(filteredCars);
        });

        frame.setVisible(true);
    }

    // Method to update car listings
    private void updateCarList(List<CarManager.Car> cars) {
        carListArea.setText(""); // Clear existing text
        if (cars.isEmpty()) {
            carListArea.append("No cars found.\n");
        } else {
            for (CarManager.Car car : cars) {
                carListArea.append(car + "\n");
            }
        }
    }

    public static void main(String[] args) {
        new CarShowroomUI("Customer"); // Run as a Customer for testing
    }
}

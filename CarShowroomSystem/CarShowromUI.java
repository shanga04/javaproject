import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CarShowroomUI {
    public CarShowroomUI(String role) {
        JFrame frame = new JFrame("Car Showroom");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JTextArea carListArea = new JTextArea();
        carListArea.setEditable(false);

        // Fetch car data from CarManager
        List<String> cars = CarManager.getCars();
        for (String car : cars) {
            carListArea.append(car + "\n"); // Display each car
        }

        frame.add(new JScrollPane(carListArea), BorderLayout.CENTER);

        // If admin, add a button to manage cars
        if ("Admin".equals(role)) {
            JButton addCarButton = new JButton("Add New Car");
            frame.add(addCarButton, BorderLayout.SOUTH);
        }

        frame.setVisible(true);
    }
}

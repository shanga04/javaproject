import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CarManager {
    private static final String FILE_PATH = "src/cars.txt"; // File path for car data

    // Method to load cars from file
    public static List<String> getCars() {
        List<String> cars = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                cars.add(line); // Add each car detail to the list
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cars;
    }
}
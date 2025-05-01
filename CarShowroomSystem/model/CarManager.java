import java.io.*;
import java.util.*;
public class CarManager {
 private static final String FILE = "src/data/cars.txt";
 private static List<Car> cars = new ArrayList<>();
 public static List<Car> getAllCars() {
 if (cars.isEmpty()) {
 try (BufferedReader reader = new BufferedReader(new 
FileReader(FILE))) {
 String line;
 while ((line = reader.readLine()) != null) {
 cars.add(Car.fromString(line));
 }
 } catch (IOException e) {
 e.printStackTrace();
 }
 }
 return cars;
 }
 public static void addCar(Car car) {
 cars.add(car);
 saveCars();
 }
 public static void saveCars() {
 try (BufferedWriter writer = new BufferedWriter(new 
FileWriter(FILE))) {
 for (Car car : cars) {
 writer.write(car.toString());
 writer.newLine();
 }
 } catch (IOException e) {
 e.printStackTrace();
 }
 }
}

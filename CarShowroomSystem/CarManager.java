import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CarManager {
    private static final String FILE_PATH = "src/cars.txt"; // File path for car data

    // Car class to store car details
    static class Car {
        String make;
        String model;
        int year;
        double price;
        String fuelType;

        public Car(String make, String model, int year, double price, String fuelType) {
            this.make = make;
            this.model = model;
            this.year = year;
            this.price = price;
            this.fuelType = fuelType;
        }

        @Override
        public String toString() {
            return make + " " + model + " (" + year + ") - $" + price + " [" + fuelType + "]";
        }
    }

    // Method to load cars from file
    public static List<Car> getCars() {
        List<Car> cars = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] details = line.split(",");
                if (details.length == 5) {
                    String make = details[0].trim();
                    String model = details[1].trim();
                    int year = Integer.parseInt(details[2].trim());
                    double price = Double.parseDouble(details[3].trim().replace("$", ""));
                    String fuelType = details[4].trim();
                    cars.add(new Car(make, model, year, price, fuelType));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: cars.txt not found!");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid data format in cars.txt");
        }
        return cars;
    }

    // Method to filter cars by make
    public static List<Car> filterByMake(String make) {
        List<Car> cars = getCars();
        List<Car> filteredCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.make.equalsIgnoreCase(make)) {
                filteredCars.add(car);
            }
        }
        return filteredCars;
    }

    // Method to filter cars by price range
    public static List<Car> filterByPrice(double minPrice, double maxPrice) {
        List<Car> cars = getCars();
        List<Car> filteredCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.price >= minPrice && car.price <= maxPrice) {
                filteredCars.add(car);
            }
        }
        return filteredCars;
    }

    // Method to filter cars by fuel type
    public static List<Car> filterByFuelType(String fuelType) {
        List<Car> cars = getCars();
        List<Car> filteredCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.fuelType.equalsIgnoreCase(fuelType)) {
                filteredCars.add(car);
            }
        }
        return filteredCars;
    }

    // Main method for testing
    public static void main(String[] args) {
        List<Car> allCars = getCars();
        System.out.println("All Cars:");
        for (Car car : allCars) {
            System.out.println(car);
        }

        System.out.println("\nFilter by Make (Toyota):");
        for (Car car : filterByMake("Toyota")) {
            System.out.println(car);
        }

        System.out.println("\nFilter by Price ($20,000 - $40,000):");
        for (Car car : filterByPrice(20000, 40000)) {
            System.out.println(car);
        }

        System.out.println("\nFilter by Fuel Type (Electric):");
        for (Car car : filterByFuelType("Electric")) {
            System.out.println(car);
        }
    }
}

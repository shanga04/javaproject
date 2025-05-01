package controller; 
import dao.CarDAO; 
import model.Car; 
import javax.swing.*; 
import java.util.ArrayList; 
public class CarController { 
public static boolean addNewCar(Car car) { 
return CarDAO.addCar(car); 
} 
public static ArrayList<Car> getAllCars() { 
return CarDAO.getAllCars(); 
} 
public static ArrayList<Car> searchCars(String make, String fuelType) { 
return CarDAO.searchCars(make, fuelType); 
} 
} 

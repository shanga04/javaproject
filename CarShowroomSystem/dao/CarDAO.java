package dao; 
 
import java.sql.*;
import java.util.ArrayList;
import model.Car; 
 
public class CarDAO { 
    public static boolean addCar(Car car) { 
        try (Connection con = DBConnection.getConnection()) { 
            String sql = "INSERT INTO cars (make, model, price, fuel_type, image_path) VALUES (?, ?, ?, ?, ?)"; 
            PreparedStatement ps = con.prepareStatement(sql); 
            ps.setString(1, car.getMake()); 
            ps.setString(2, car.getModel()); 
            ps.setDouble(3, car.getPrice()); 
            ps.setString(4, car.getFuelType()); 
            ps.setString(5, car.getImagePath()); 
            return ps.executeUpdate() > 0; 
        } catch (Exception e) { 
            e.printStackTrace(); 
            return false; 
        } 
    } 
 
    public static ArrayList<Car> getAllCars() { 
        ArrayList<Car> list = new ArrayList<>(); 
        try (Connection con = DBConnection.getConnection()) { 
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM cars"); 
            while (rs.next()) { 
                list.add(new Car( 
                        rs.getInt("id"), 
                        rs.getString("make"), 
                        rs.getString("model"), 
                        rs.getDouble("price"), 
                        rs.getString("fuel_type"), 
                        rs.getString("image_path") 
                )); 
            } 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
        return list; 
    } 
 
    public static ArrayList<Car> searchCars(String make, String fuelType) { 
        ArrayList<Car> list = new ArrayList<>(); 
        try (Connection con = DBConnection.getConnection()) { 
            String sql = "SELECT * FROM cars WHERE make LIKE ? AND fuel_type LIKE ?"; 
            PreparedStatement ps = con.prepareStatement(sql); 
            ps.setString(1, "%" + make + "%"); 
            ps.setString(2, "%" + fuelType + "%"); 
            ResultSet rs = ps.executeQuery(); 
            while (rs.next()) { 
                list.add(new Car( 
                        rs.getInt("id"), 
                        rs.getString("make"), 
                        rs.getString("model"), 
                        rs.getDouble("price"), 
                        rs.getString("fuel_type"), 
                        rs.getString("image_path") 
                )); 
            } 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
        return list; 
    } 
}
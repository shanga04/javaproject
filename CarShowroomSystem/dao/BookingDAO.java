package dao; 
import java.sql.*;
import java.util.ArrayList;
import model.Booking; 
public class BookingDAO { 
public static boolean bookTestDrive(int carId, int userId) { 
try (Connection con = DBConnection.getConnection()) { 
String sql = "INSERT INTO bookings (user_id, car_id, status, date) VALUES (?, ?, 'pending', CURDATE())"; 
PreparedStatement ps = con.prepareStatement(sql); 
ps.setInt(1, userId); 
ps.setInt(2, carId); 
return ps.executeUpdate() > 0; 
} catch (Exception e) { 
e.printStackTrace(); 
return false; 
} 
} 
public static ArrayList<Booking> getBookingsByUser(int userId) { 
ArrayList<Booking> list = new ArrayList<>(); 
try (Connection con = DBConnection.getConnection()) { 
String sql = "SELECT * FROM bookings WHERE user_id = ?"; 
PreparedStatement ps = con.prepareStatement(sql); 
ps.setInt(1, userId); 
ResultSet rs = ps.executeQuery(); 
while (rs.next()) { 
list.add(new Booking( 
rs.getInt("id"), 
rs.getInt("user_id"), 
rs.getInt("car_id"), 
rs.getString("status"), 
rs.getDate("date") 
)); 
} 
} catch (Exception e) { 
e.printStackTrace(); 
} 
return list; 
} 
public static ArrayList<Booking> getAllBookings() { 
ArrayList<Booking> list = new ArrayList<>(); 
try (Connection con = DBConnection.getConnection()) { 
ResultSet rs = con.createStatement().executeQuery("SELECT * FROMbookings"); 
while (rs.next()) { 
list.add(new Booking( 
rs.getInt("id"), 
rs.getInt("user_id"), 
rs.getInt("car_id"), 
rs.getString("status"), 
rs.getDate("date") 
)); 
} 
} catch (Exception e) { 
e.printStackTrace(); 
} 
return list; 
} 
public static boolean updateStatus(int bookingId, String status) { 
try (Connection con = DBConnection.getConnection()) { 
String sql = "UPDATE bookings SET status = ? WHERE id = ?"; 
PreparedStatement ps = con.prepareStatement(sql); 
ps.setString(1, status); 
ps.setInt(2, bookingId); 
return ps.executeUpdate() > 0; 
} catch (Exception e) { 
e.printStackTrace(); 
return false; 
} 
} 
public static int countApprovedBookings() { 
try (Connection con = DBConnection.getConnection()) { 
ResultSet rs = con.createStatement().executeQuery("SELECT COUNT(*) FROM bookings WHERE status='approved'"); 
if (rs.next()) return rs.getInt(1); 
} catch (Exception e) { 
e.printStackTrace(); 
} 
return 0; 
} 
}
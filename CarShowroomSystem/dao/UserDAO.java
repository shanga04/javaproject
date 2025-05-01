package dao; 
import java.sql.*;
import model.User; 
public class UserDAO { 
public static User login(String username, String password) { 
        try (Connection con = DBConnection.getConnection()) { 
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?"; 
            PreparedStatement ps = con.prepareStatement(sql); 
            ps.setString(1, username); 
            ps.setString(2, password); 
            ResultSet rs = ps.executeQuery(); 
 
            if (rs.next()) { 
                return new User( 
                        rs.getInt("id"), 
                        rs.getString("username"), 
                        rs.getString("password"), 
                        rs.getString("role") 
                ); 
            } 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
        return null; 
    } 
 
    public static boolean register(User user) { 
        try (Connection con = DBConnection.getConnection()) { 
            String sql = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)"; 
            PreparedStatement ps = con.prepareStatement(sql); 
            ps.setString(1, user.getUsername()); 
            ps.setString(2, user.getPassword()); 
            ps.setString(3, user.getRole()); 
            return ps.executeUpdate() > 0; 
        } catch (Exception e) { 
            e.printStackTrace(); 
            return false; 
        } 
    } 
} 
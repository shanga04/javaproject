package dao; 
import java.sql.Connection; 
import java.sql.DriverManager; 
public class DBConnection { 
private static final String URL = 
"jdbc:mysql://localhost:3306/car_showroom"; 
private static final String USER = "root"; 
private static final String PASSWORD = "your_password"; // Change this! 
public static Connection getConnection() { 
try { 
Class.forName("com.mysql.cj.jdbc.Driver"); 
return DriverManager.getConnection(URL, USER, PASSWORD); 
} catch (Exception e) { 
e.printStackTrace(); 
return null; 
} 
} 
} 
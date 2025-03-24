package CarShowroomSystem;
import java.io.BufferedReader; 
import java.io.FileReader; 
import java.io.IOException; 
public class UserManager { 
private static final String FILE_PATH = "src/users.txt"; // File storing 
/**
 *
 */
user credentials 
// Method to authenticate user login 
public static String authenticateUser(String username, String password) { 
try (BufferedReader br = new BufferedReader(new 
FileReader(FILE_PATH))) { 
String line; 
while ((line = br.readLine()) != null) { 
String[] userDetails = line.split(","); 
if (userDetails.length == 3) { 
String storedUsername = userDetails[0]; 
String storedPassword = userDetails[1]; 
String role = userDetails[2]; 
if (storedUsername.equals(username) && 
storedPassword.equals(password)) { 
return role; // Returns "Admin" or "Customer" 
} 
} 
} 
} catch (IOException e) { 
e.printStackTrace(); 
} 
return null; // Login failed 
} 
} 


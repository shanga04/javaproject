import java.io.*;
public class UserManager {
 private static final String FILE = "src/data/users.txt";
 public static boolean register(String username, String password, String 
role) {
 if (userExists(username)) return false;
 try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE, 
true))) {
 writer.write(username + "," + password + "," + role);
 writer.newLine();
 return true;
 } catch (IOException e) {
 return false;
 }
 }
 public static User login(String username, String password) {
 try (BufferedReader reader = new BufferedReader(new 
FileReader(FILE))) {
 String line;
 while ((line = reader.readLine()) != null) {
 String[] parts = line.split(",");
 if (parts[0].equals(username) && parts[1].equals(password)) {
 return parts[2].equals("Admin") ? new Admin(username, 
password) : new Customer(username, password);
 }
 }
 } catch (IOException e) {
 e.printStackTrace();
 }
 return null;
 }
 private static boolean userExists(String username) {
 try (BufferedReader reader = new BufferedReader(new 
FileReader(FILE))) {
 String line;
 while ((line = reader.readLine()) != null) {
 if (line.split(",")[0].equals(username)) return true;
 }
 } catch (IOException e) {
 e.printStackTrace();
 }
 return false;
 }
}


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserManager {
    private static final String FILE_PATH = "src/users.txt"; // File storing user credentials

    // Hash password using SHA-256
    private static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Method to authenticate user login
    public static String authenticateUser(String username, String password) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] userDetails = line.split(",");
                if (userDetails.length == 3) {
                    String storedUsername = userDetails[0].trim();
                    String storedPasswordHash = userDetails[1].trim();
                    String role = userDetails[2].trim();

                    if (storedUsername.equals(username) && storedPasswordHash.equals(hashPassword(password))) {
                        return role; // Returns "Admin" or "Customer"
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: users.txt not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; // Login failed
    }

    // Method to register a new user
    public static boolean registerUser(String username, String password, String role) {
        if (isUserExists(username)) {
            System.out.println("User already exists!");
            return false;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(username + "," + hashPassword(password) + "," + role);
            writer.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Check if user already exists
    private static boolean isUserExists(String username) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] userDetails = line.split(",");
                if (userDetails.length >= 1 && userDetails[0].trim().equals(username)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
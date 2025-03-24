import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TestDriveManager {
    private static final String FILE_PATH = "src/bookings.txt"; // File to store bookings
    
    // Method to book a test drive
    public static boolean bookTestDrive(String customerName, String carModel, String date) {
        try {
            // Check if booking already exists
            if (isDuplicateBooking(customerName, carModel, date)) {
                System.out.println("Error: Test drive already booked for this car on this date.");
                return false;
            }
            
            // Write new booking to file
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true));
            writer.write(customerName + "," + carModel + "," + date);
            writer.newLine();
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    // Method to check if a booking already exists
    private static boolean isDuplicateBooking(String customerName, String carModel, String date) {
        List<String> bookings = getBookings();
        for (String booking : bookings) {
            if (booking.equals(customerName + "," + carModel + "," + date)) {
                return true;
            }
        }
        return false;
    }
    
    // Method to retrieve all bookings
    public static List<String> getBookings() {
        List<String> bookings = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                bookings.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No previous bookings found.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bookings;
    }
}
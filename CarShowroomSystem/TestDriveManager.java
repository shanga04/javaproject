package CarShowroomSystem;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TestDriveManager {

    private static final String FILE_PATH = "src/bookings.txt"; 

    public static void bookTestDrive(String customerName, String carModel, String date) { 
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) { 
            writer.write(customerName + "," + carModel + "," + date);
            writer.newLine();
            System.out.println("Test drive booked successfully!");
        } catch (IOException e) { 
            e.printStackTrace(); 
        } 
    }
}


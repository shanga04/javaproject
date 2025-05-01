import java.io.*;
import java.util.*;
public class BookingManager {
 private static final String FILE = "src/data/bookings.txt";
 private static List<Booking> bookings = new ArrayList<>();
 public static void loadBookings() {
 bookings.clear();
 try (BufferedReader reader = new BufferedReader(new 
FileReader(FILE))) {
 String line;
 while ((line = reader.readLine()) != null) {
 bookings.add(Booking.fromString(line));
 }
 } catch (IOException e) {
 e.printStackTrace();
 }
 }
 public static void addBooking(Booking booking) {
 bookings.add(booking);
 try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE, 
true))) {
 writer.write(booking.toString());
 writer.newLine();
 } catch (IOException e) {
 e.printStackTrace();
 }
 }
 public static List<Booking> getAllBookings() {
 return bookings;
 }
}
package controller; 
import dao.BookingDAO; 
import model.Booking; 
import java.util.ArrayList; 
public class BookingController { 
public static boolean bookCar(int carId, int userId) { 
return BookingDAO.bookTestDrive(carId, userId); 
} 
public static ArrayList<Booking> getBookingsByUser(int userId) { 
return BookingDAO.getBookingsByUser(userId); 
} 
public static ArrayList<Booking> getAllBookings() { 
return BookingDAO.getAllBookings(); 
} 
public static boolean updateBookingStatus(int bookingId, String status) { 
return BookingDAO.updateStatus(bookingId, status); 
} 
public static int getSalesCount() { 
return BookingDAO.countApprovedBookings(); 
} 
}
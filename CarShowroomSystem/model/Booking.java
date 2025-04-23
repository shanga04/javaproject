package model; 
import java.sql.Date; 
public class Booking { 
private int id; 
private int userId; 
private int carId; 
private String status; 
private Date date; 
public Booking(int id, int userId, int carId, String status, Date date) { 
this.id = id; 
this.userId = userId; 
this.carId = carId; 
this.status = status; 
this.date = date; 
} 
public int getId() { return id; } 
public int getUserId() { return userId; } 
public int getCarId() { return carId; } 
public String getStatus() { return status; } 
public Date getDate() { return date; } 
public void setStatus(String status) { this.status = status; } 
} 
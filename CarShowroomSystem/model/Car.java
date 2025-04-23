package model; 
public class Car { 
private int id; 
private String make; 
private String model; 
private double price; 
private String fuelType; 
private String imagePath; 
public Car(int id, String make, String model, double price, String 
fuelType, String imagePath) { 
this.id = id; 
this.make = make; 
this.model = model; 
this.price = price; 
this.fuelType = fuelType; 
this.imagePath = imagePath; 
} 
public int getId() { return id; } 
public String getMake() { return make; } 
public String getModel() { return model; } 
public double getPrice() { return price; } 
public String getFuelType() { return fuelType; } 
public String getImagePath() { return imagePath; } 
public void setMake(String make) { this.make = make; } 
public void setModel(String model) { this.model = model; } 
public void setPrice(double price) { this.price = price; } 
public void setFuelType(String fuelType) { this.fuelType = fuelType; } 
public void setImagePath(String imagePath) { this.imagePath = imagePath; 
} 
}
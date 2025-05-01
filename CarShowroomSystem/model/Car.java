public class Car {
    private String model;
    private double price;
    private String fuelType;
    private boolean available;
    public Car(String model, double price, String fuelType, boolean 
   available) {
    this.model = model;
    this.price = price;
    this.fuelType = fuelType;
    this.available = available;
    }
    public String getModel() { return model; }
    public double getPrice() { return price; }
    public String getFuelType() { return fuelType; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; 
   }
    @Override
    public String toString() {
    return model + "," + price + "," + fuelType + "," + (available ? 
   "Available" : "Unavailable");
    }
    public static Car fromString(String line) {
    String[] parts = line.split(",");
    return new Car(parts[0], Double.parseDouble(parts[1]), parts[2], 
   parts[3].equalsIgnoreCase("Available"));
    }
   }
   
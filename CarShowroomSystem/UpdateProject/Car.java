public class Car {
    private int carId;
    private String make;
    private String model;
    private int year;
    private double price;
    private boolean isSold;

    private static int nextId = 1;

    public Car(String make, String model, int year, double price) {
        this.carId = nextId++;
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
        this.isSold = false;
    }

    // Getters
    public int getCarId() {
        return carId;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public boolean isSold() {
        return isSold;
    }

    // Setters
    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSold(boolean sold) {
        this.isSold = sold;
    }

    @Override
    public String toString() {
        return String.format("%s %s (%d) - $%.2f %s", make, model, year, price, isSold ? "[SOLD]" : "");
    }
}

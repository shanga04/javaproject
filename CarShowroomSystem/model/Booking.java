public class Booking {
    private String customer;
    private String carModel;
    private String date;
    public Booking(String customer, String carModel, String date) {
    this.customer = customer;
    this.carModel = carModel;
    this.date = date;
    }
    @Override
    public String toString() {
    return customer + "," + carModel + "," + date;
    }
    public static Booking fromString(String line) {
    String[] parts = line.split(",");
    return new Booking(parts[0], parts[1], parts[2]);
    }
   }
   
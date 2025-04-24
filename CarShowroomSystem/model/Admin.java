public class Admin extends User {
    public Admin(String username, String password) {
    super(username, password);
    }
    
    @Override
    public String getRole() {
    return "Admin";
    }
   }
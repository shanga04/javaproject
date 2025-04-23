import util.MessageBox;
import view.LoginFrame; 
public class Main { 
public static void main(String[] args) {
     
javax.swing.SwingUtilities.invokeLater(() -> { new UserRoleSelector().setVisible(true);
new LoginFrame().setVisible(true); 
}); 
} 
} 
import util.MessageBox;
import view.LoginFrame; 
public class Main { 
public static void main(String[] args) { 
    MessageBox.info(this, "Action completed!");
javax.swing.SwingUtilities.invokeLater(() -> { 
    new UserRoleSelector().setVisible(true);
new LoginFrame().setVisible(true); 
}); 
} 
} 
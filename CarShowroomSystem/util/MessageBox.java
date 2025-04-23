package util; 
import javax.swing.*; 
public class MessageBox { 
public static void info(JFrame parent, String msg) { 
JOptionPane.showMessageDialog(parent, msg, "Information", 
JOptionPane.INFORMATION_MESSAGE); 
} 
public static void error(JFrame parent, String msg) { 
JOptionPane.showMessageDialog(parent, msg, "Error", 
JOptionPane.ERROR_MESSAGE); 
} 
public static boolean confirm(JFrame parent, String msg) { 
int result = JOptionPane.showConfirmDialog(parent, msg, "Confirm", 
JOptionPane.YES_NO_OPTION); 
return result == JOptionPane.YES_OPTION; 
} 
}
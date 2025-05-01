package util; 
import java.awt.*;
import javax.swing.*; 
public class UIHelper { 
public static void setUIFont(Component comp) { 
Font font = new Font("Segoe UI", Font.PLAIN, 14); 
setFontRecursively(comp, font); 
} 
private static void setFontRecursively(Component comp, Font font) { 
comp.setFont(font); 
if (comp instanceof Container) { 
for (Component child : ((Container) comp).getComponents()) { 
setFontRecursively(child, font); 
} 
} 
} 
public static JButton createStyledButton(String text) { 
JButton btn = new JButton(text); 
btn.setBackground(new Color(51, 153, 255)); 
btn.setForeground(Color.WHITE); 
btn.setFocusPainted(false); 
btn.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15)); 
return btn; 
} 
}
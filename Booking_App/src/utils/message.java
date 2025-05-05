package utils;

/**
 *
 * @author Admin
 */


import java.awt.Component;
import javax.swing.JOptionPane;

public class message {
     public static void alert(Component parent, String message){
        JOptionPane.showMessageDialog(parent, message, "Booking App", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static boolean comfirm(Component parent, String message){
        int result = JOptionPane.showConfirmDialog(parent, message, "Booking App", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE);
        return result == JOptionPane.YES_OPTION;
    }
    
    public static String prompt(Component parent, String message){
        return JOptionPane.showInputDialog(parent, message, "Hệ thống quản lý giày", JOptionPane.INFORMATION_MESSAGE);
    }
}

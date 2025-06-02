package utils;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Admin
 */
public class handleIcon {
    public void setIcon(JButton button, String path){
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        button.setIcon(icon);
    }
}

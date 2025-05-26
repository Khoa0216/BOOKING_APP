package GUI.Component;

/**
 *
 * @author Admin
 */
import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
public class CustomScrollBar extends BasicScrollBarUI{
    private static final int ARC = 10;

    @Override
    protected void configureScrollBarColors() {
        this.thumbColor   = new Color(120,120,120,200);
        this.trackColor   = new Color(200,200,200,100);
    }

    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle r) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(trackColor);
        g2.fillRoundRect(r.x, r.y, r.width, r.height, ARC, ARC);
    }

    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle r) {
        if (r.width > ARC && r.height > ARC) {
            Graphics2D g2 = (Graphics2D)g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(thumbColor);
            g2.fillRoundRect(r.x, r.y, r.width, r.height, ARC, ARC);
        }
    }

    // Ẩn nút lên/xuống mặc định
    @Override protected JButton createDecreaseButton(int orientation) { return zeroButton(); }
    @Override protected JButton createIncreaseButton(int orientation) { return zeroButton(); }
    private JButton zeroButton() {
        JButton btn = new JButton();
        btn.setPreferredSize(new Dimension(0,0));
        return btn;
    }
}

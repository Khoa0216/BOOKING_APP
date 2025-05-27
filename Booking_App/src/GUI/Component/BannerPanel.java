package GUI.Component;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class BannerPanel extends JPanel {
    private BufferedImage img;
    // chiều cao banner cố định (ví dụ 200px)
    private final int fixedHeight = 200;

    public BannerPanel(String resourcePath) {
        try {
            img = ImageIO.read(getClass().getResource(resourcePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setPreferredSize(new Dimension(0, fixedHeight));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (img != null) {
            int w = getWidth();
            // tính height theo tỷ lệ gốc
            int h = (int)(img.getHeight() * (w / (double)img.getWidth()));
            g.drawImage(img, 0, 0, w, h, this);
        }
    }
}

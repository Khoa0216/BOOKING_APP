package GUI.JFRAME;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class CardDemo extends JFrame {
    public CardDemo() {
        setTitle("Card Booking Demo");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 400);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(245,245,245));
        initUI();
    }

    private void initUI() {
        JPanel container = new JPanel();
        container.setOpaque(false);
        container.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        // Tạo 3 card mẫu
        container.add(createCard("Mumbai",   "/image/delete.png",   "Lorem ipsum dolor sit amet consectetur.", 4, 90, 120));
        container.add(createCard("Hawaii",   "/image/delete.png",   "Lorem ipsum dolor sit amet consectetur.", 4, 90, 120));
        container.add(createCard("Sydney",   "/image/delete.png",   "Lorem ipsum dolor sit amet consectetur.", 4, 90, 120));

        add(new JScrollPane(container,
               JScrollPane.VERTICAL_SCROLLBAR_NEVER,
               JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),
            BorderLayout.CENTER);
    }

    private JPanel createCard(String title, String imagePath, String desc,
                              int stars, int price, int oldPrice) {
        // panel chính có viền bo tròn
        JPanel card = new JPanel();
        card.setPreferredSize(new Dimension(280, 340));
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(Color.WHITE);
        card.setBorder(new CompoundBorder(
            new LineBorder(new Color(200,200,200), 1, true),
            new EmptyBorder(10,10,10,10)
        ));

        // 1. Ảnh
        JLabel img = new JLabel(new ImageIcon(getClass().getResource(imagePath)));
        img.setAlignmentX(Component.CENTER_ALIGNMENT);
        img.setPreferredSize(new Dimension(260, 160));
        img.setMaximumSize(new Dimension(260, 160));
        card.add(img);

        card.add(Box.createRigidArea(new Dimension(0,10)));

        // 2. Tiêu đề với icon
        JLabel lblTitle = new JLabel(title, new ImageIcon(getClass().getResource("/image/delete.png")), JLabel.LEFT);
        lblTitle.setFont(lblTitle.getFont().deriveFont(Font.BOLD, 16f));
        lblTitle.setAlignmentX(Component.LEFT_ALIGNMENT);
        card.add(lblTitle);

        card.add(Box.createRigidArea(new Dimension(0,8)));

        // 3. Mô tả
        JLabel lblDesc = new JLabel("<html><font color='#666666'>" + desc + "</font></html>");
        lblDesc.setFont(lblDesc.getFont().deriveFont(12f));
        lblDesc.setAlignmentX(Component.LEFT_ALIGNMENT);
        card.add(lblDesc);

        card.add(Box.createRigidArea(new Dimension(0,12)));

        // 4. Rating
        JPanel pnlStars = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 0));
        pnlStars.setOpaque(false);
        for (int i = 1; i <= 5; i++) {
            String icon = i <= stars ? "/image/delete.png" : "/image/delete.png";
            pnlStars.add(new JLabel(new ImageIcon(getClass().getResource(icon))));
        }
        pnlStars.setAlignmentX(Component.LEFT_ALIGNMENT);
        card.add(pnlStars);

        card.add(Box.createRigidArea(new Dimension(0,12)));

        // 5. Giá
        JLabel lblPrice = new JLabel(String.format(
            "<html><b>$%d.00</b> <span style='color:gray; text-decoration:line-through;'>$%d.00</span></html>",
            price, oldPrice
        ));
        lblPrice.setFont(lblPrice.getFont().deriveFont(14f));
        lblPrice.setAlignmentX(Component.LEFT_ALIGNMENT);
        card.add(lblPrice);

        card.add(Box.createVerticalGlue());

        // 6. Nút Book Now
        JButton btn = new JButton("Book Now");
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn.setBackground(new Color(244,164,  6)); // vàng cam
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorder(new EmptyBorder(8,20,8,20));
        card.add(btn);

        return card;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CardDemo().setVisible(true));
    }
}

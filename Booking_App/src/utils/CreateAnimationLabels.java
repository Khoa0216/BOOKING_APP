package utils;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Admin
 */
public class CreateAnimationLabels {
    public static JLabel createInteractiveLabel(JLabel lbl) {

        lbl.setOpaque(true);
        lbl.setBackground(new Color(0xF2F2F2));      // nền mặc định
        lbl.setBorder(BorderFactory.createLineBorder(Color.GRAY)); // viền mặc định

        // Viền khi được chọn (click)
        Border selectedBorder = BorderFactory.createLineBorder(new Color(0x1E88E5), 2);
        // Viền khi hover (chuột rê qua) - ví dụ viền xám đậm
        Border hoverBorder    = BorderFactory.createLineBorder(new Color(0x757575), 1);

        // Lưu lại viền mặc định để khi mouseExited có thể trả về
        Border originalBorder = lbl.getBorder();

        lbl.addMouseListener(new MouseAdapter() {
            boolean isSelected = false;

            @Override
            public void mouseEntered(MouseEvent e) {
                // Nếu chưa được chọn, khi hover đổi viền
                if (!isSelected) {
                    lbl.setBorder(hoverBorder);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Khi rê chuột ra, nếu chưa được chọn, trả về viền gốc
                if (!isSelected) {
                    lbl.setBorder(originalBorder);
                }
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                // Khi click vào JLabel này: 
                // - đánh dấu isSelected = true, đổi viền thành selectedBorder
                // - nếu muốn bỏ chọn các label khác, phải quản lý ở cấp cao hơn.
//                isSelected = true;
//                lbl.setBorder(selectedBorder);
//                // Ví dụ: Hiển thị thông báo, sau đó có thể dùng đường dẫn tệp ảnh...
//                System.out.println("Bạn đã chọn ô JLabel này");

                // Để bỏ chọn khi click lại (toggle), bạn có thể làm:
                 isSelected = !isSelected;
                 if (isSelected) lbl.setBorder(selectedBorder);
                 else lbl.setBorder(originalBorder);
            }
        });

        return lbl;
    }
}

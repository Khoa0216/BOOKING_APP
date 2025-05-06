package Screen_After_Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Screen_After_Login {
    public static void main(String[] args){
        Menu_KhachHang LGFrame = new Menu_KhachHang();
        LGFrame.pack();
        LGFrame.setLocationRelativeTo(null);//Hiện ở giữa màn hình
        LGFrame.setVisible(true);//Cho phép hiện KhachHangJFrame
    }
}

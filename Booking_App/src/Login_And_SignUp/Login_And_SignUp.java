package Login_And_SignUp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login_And_SignUp {

    public static void main(String[] args) {
        Login LGFrame = new Login();
        LGFrame.pack();
        LGFrame.setLocationRelativeTo(null);//Hiện ở giữa màn hình
        LGFrame.setVisible(true);//Cho phép hiện JFrame
    }
    
    public static String checkLogin(String username, String password) {
        String query = "SELECT LOAITK FROM BOOKING_APP.NGUOIDUNG WHERE EMAIL = ? AND MATKHAU = ?"; //câu lệnh query SQL, ? là nơi sẽ thay thế giá trị vào. (*)

        
        // cấu trúc try-with-resources
        /*
            try (resource res=...; resource res2=...){
            // sử dụng tài nguyên.
            }
            Lợi ích: không cần phải gọi close() tài nguyên thủ công sau khi sử dụng (dù lỗi hay không).
        */
        try (Connection conn = OracleDataBase_Connection.getConnection("nguoidung_user", "12345678");
             PreparedStatement stmt = conn.prepareStatement(query)) {

            // thiết lập các tham số trong câu lệnh SQL (*)
            stmt.setString(1, username);
            stmt.setString(2, password);

            // thực thi câu lệnh và lấy kết quả
            ResultSet rs = stmt.executeQuery();

            // nếu có kết quả trả về, lấy loại tài khoản
            if (rs.next()) { // .next() giống như con trỏ, trỏ đến từng dòng của câu lệnh query, khi còn kết quả trỏ sẽ trả về true, ngược lại là false.
                return rs.getString("LOAITK");
            } else {
                return null; // nếu không có kết quả, nghĩa là đăng nhập thất bại
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static String getUserName(String email ) {
        System.out.println(email);
        String query = "SELECT HOTEN FROM BOOKING_APP.NGUOIDUNG WHERE EMAIL = ?";
        
        try (Connection conn = OracleDataBase_Connection.getConnection("nguoidung_user", "12345678");
             PreparedStatement stmt = conn.prepareStatement(query)) {
    
            stmt.setString(1, email);
    
            ResultSet rs = stmt.executeQuery();
    
            if (rs.next()) {
                return rs.getString("HOTEN"); 
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static String getDOB(String email){
        String query = "SELECT TO_CHAR(NGAYSINH, 'DD/MM/YYYY') AS NGAYSINH "
             + "FROM BOOKING_APP.NGUOIDUNG ND "
             + "JOIN BOOKING_APP.KHACHHANG KH ON ND.ID = KH.ID "
             + "WHERE EMAIL = ?";
    
        try (Connection conn = OracleDataBase_Connection.getConnection("nguoidung_user", "12345678");
             PreparedStatement stmt = conn.prepareStatement(query)) {
    
            stmt.setString(1, email);
    
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return rs.getString("NGAYSINH"); 
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static String getCCCD(String email){
        String query = "SELECT KH.CCCD "
                + " FROM BOOKING_APP.NGUOIDUNG ND JOIN BOOKING_APP.KHACHHANG KH "
                + " ON ND.ID = KH.ID"
                + " WHERE EMAIL =  ?";
    
        try (Connection conn = OracleDataBase_Connection.getConnection("nguoidung_user", "12345678");
             PreparedStatement stmt = conn.prepareStatement(query)) {
    
            stmt.setString(1, email);
    
            ResultSet rs = stmt.executeQuery();
    
            if (rs.next()) {
                return rs.getString("CCCD"); 
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
    public static String checkLoaiDN(String username, String password) {
        String query = "SELECT BOOKING_APP.DOANHNGHIEP.LOAIDN "
                    + " FROM BOOKING_APP.NGUOIDUNG JOIN BOOKING_APP.DOANHNGHIEP "
                    + " ON BOOKING_APP.NGUOIDUNG.ID=BOOKING_APP.DOANHNGHIEP.ID "
                    + " WHERE EMAIL = ? AND MATKHAU = ?"; //câu lệnh query SQL, ? là nơi sẽ thay thế giá trị vào. (*)

        
        // cấu trúc try-with-resources
        /*
            try (resource res=...; resource res2=...){
            // sử dụng tài nguyên.
            }
            Lợi ích: không cần phải gọi close() tài nguyên thủ công sau khi sử dụng (dù lỗi hay không).
        */
        try (Connection conn = OracleDataBase_Connection.getConnection("nguoidung_user", "12345678");
             PreparedStatement stmt = conn.prepareStatement(query)) {

            // thiết lập các tham số trong câu lệnh SQL (*)
            stmt.setString(1, username);
            stmt.setString(2, password);

            // thực thi câu lệnh và lấy kết quả
            ResultSet rs = stmt.executeQuery();

            // nếu có kết quả trả về, lấy loại tài khoản
            if (rs.next()) { // .next() giống như con trỏ, trỏ đến từng dòng của câu lệnh query, khi còn kết quả trỏ sẽ trả về true, ngược lại là false.
                return rs.getString("LOAIDN");
            } else {
                return null; // nếu không có kết quả, nghĩa là đăng nhập thất bại
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static void setHoTen(String name){
        
    }
    
    
    
}
package DAO;

import database.Oracle_connection;
import database.QueryHelper;
import MODEL.KHACHSAN;
import MODEL.KHACHHANG;
import MODEL.NGUOIDUNG;
import MODEL.ThanhToan_model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Login_SignUp_Check {
    public static String checkLogin(String username, String password) {
        String query = "SELECT LOAITK FROM BOOKING_APP.NGUOIDUNG WHERE EMAIL = ? AND MATKHAU = ?"; //câu lệnh query SQL, ? là nơi sẽ thay thế giá trị vào. (*)

        // cấu trúc try-with-resources
        /*
            try (resource res=...; resource res2=...){
            // sử dụng tài nguyên.
            }
            Lợi ích: không cần phải gọi close() tài nguyên thủ công sau khi sử dụng (dù lỗi hay không).
        */
        try (Connection conn = Oracle_connection.getConnection("nguoidung_user", "12345678");
             PreparedStatement stmt = conn.prepareStatement(query)) {
            // thiết lập các tham số trong câu lệnh SQL (*)
            
            stmt.setString(1, username);
            stmt.setString(2, password);

            // thực thi câu lệnh và lấy kết quả
            ResultSet rs = stmt.executeQuery();

            // nếu có kết quả trả về, lấy loại tài khoản
            if (rs.next()) { // .next() giống như con trỏ, trỏ đến từng dòng của câu lệnh query, khi còn kết quả trỏ sẽ trả về true, ngược lại là false.
                System.out.println(rs.getString("LOAITK"));
                return rs.getString("LOAITK");
            } else {
                return null; // nếu không có kết quả, nghĩa là đăng nhập thất bại
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
       
    public static void InsertKHACHHANG(KHACHHANG khachhang){
        // Parse ngày sinh từ String sang java.sql.Date
        java.sql.Date NgaySinh;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date utilDate = sdf.parse(khachhang.getNGAYSINH());
            NgaySinh = new java.sql.Date(utilDate.getTime());
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập ngày sinh đúng định dạng dd/MM/yyyy", "Lỗi định dạng", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String sqlNguoiDung = "INSERT INTO booking_app.NGUOIDUNG (MATKHAU, HOTEN, EMAIL, LOAITK) VALUES (?, ?, ?, 'KHACHHANG')";
        String sqlKhach = "INSERT INTO booking_app.KHACHHANG (ID, CCCD, NGAYSINH) VALUES (?, ?, ?)";
        
        Connection conn = null;
        try {
            conn = Oracle_connection.getConnection("nguoidung_user", "12345678");
            conn.setAutoCommit(false);

            // 1. Insert NGUOIDUNG và lấy ID sinh tự động
            int newId;
            try (PreparedStatement stmt1 = conn.prepareStatement(sqlNguoiDung, new String[]{"ID"})) {
                stmt1.setString(1, khachhang.getMATKHAU());
                stmt1.setString(2, khachhang.getHOTEN());
                stmt1.setString(3, khachhang.getEMAIL());
                stmt1.executeUpdate();

                try (ResultSet rs = stmt1.getGeneratedKeys()) {
                    if (rs.next()) {
                        newId = rs.getInt(1);
                    } else {
                        throw new SQLException("Không lấy được ID từ NGUOIDUNG");
                    }
                }
            }

            // 2. Insert KHACHHANG với ID vừa lấy được
            try (PreparedStatement stmt2 = conn.prepareStatement(sqlKhach)) {
                stmt2.setInt(1, newId);
                stmt2.setString(2, khachhang.getCCCD());
                stmt2.setDate(3, NgaySinh);
                stmt2.executeUpdate();
            }

            conn.commit();
            JOptionPane.showMessageDialog(null, "Đăng ký thành công!", "Thành công",
                JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
            }
            if (e.getErrorCode() == 1) { // ORA-00001
                JOptionPane.showMessageDialog(null, "Email đã được đăng ký!", "Lỗi trùng email", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Đăng ký thất bại: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException ex) {
            }
        }
    }
            
    public static void InsertDOANHNGHIEP(KHACHSAN doanhnghiep){
        String sqlNguoiDung = "INSERT INTO booking_app.NGUOIDUNG (MATKHAU, HOTEN, EMAIL, LOAITK) VALUES (?, ?, ?, 'KHACHSAN')";
        String sqlDoanhNghiep = "INSERT INTO booking_app.KHACHSAN (ID, TENDN, DIACHI,TINH, MOTA, BANK , STK) VALUES (?, ?, ?, ? ,?,?, ?)";

        Connection conn = null;
        try {
            conn = Oracle_connection.getConnection("nguoidung_user", "12345678");
            conn.setAutoCommit(false);

            // 1. Insert NGUOIDUNG và lấy ID sinh tự động
            int newId;
            try (PreparedStatement stmt1 = conn.prepareStatement(sqlNguoiDung, new String[]{"ID"})) {
                stmt1.setString(1, doanhnghiep.getMATKHAU());
                stmt1.setString(2, doanhnghiep.getHOTEN());
                stmt1.setString(3, doanhnghiep.getEMAIL());
                
                
                stmt1.executeUpdate();

                try (ResultSet rs = stmt1.getGeneratedKeys()) {
                    if (rs.next()) {
                        newId = rs.getInt(1);
                    } else {
                        throw new SQLException("Không lấy được ID từ NGUOIDUNG");
                    }
                }
            }

            // 2. Insert KHACHSAN với ID vừa lấy được
            try (PreparedStatement stmt2 = conn.prepareStatement(sqlDoanhNghiep)) {
                stmt2.setInt(1, newId);
                stmt2.setString(2, doanhnghiep.getTENDN());
                stmt2.setString(3, doanhnghiep.getDIACHI());
                stmt2.setString(4, doanhnghiep.getTINH());
                stmt2.setString(5, doanhnghiep.getMOTA());
                stmt2.setString(6, doanhnghiep.getBANK());
                stmt2.setString(7, doanhnghiep.getSTK());
                stmt2.executeUpdate();
            }

            conn.commit();
            JOptionPane.showMessageDialog(null, "Đăng ký thành công!", "Thành công", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
            }
            if (e.getErrorCode() == 1) { // ORA-00001: unique constraint violated
                JOptionPane.showMessageDialog(null, "Email đã được đăng ký!", "Lỗi trùng email", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Đăng ký thất bại: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException ex) {
            }
        }
    }
    
    public static NGUOIDUNG getNguoiDung(String email){
        
        String sql="SELECT * FROM BOOKING_APP.NGUOIDUNG WHERE EMAIL=?";
        ResultSet rs=QueryHelper.executeSelect(sql, email);
        NGUOIDUNG nguoidung=new NGUOIDUNG();
            
        try {
            if (rs.next()){
                nguoidung.setID(rs.getInt("ID"));
                nguoidung.setEMAIL(rs.getString("EMAIL"));
                nguoidung.setMATKHAU(rs.getString("MATKHAU"));
                nguoidung.setHOTEN(rs.getString("HOTEN"));
                nguoidung.setLOAITK(rs.getString("LOAITK"));
            } else {
                return null;
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return nguoidung;
        
    }
    
    public static void InsertThanhToan (ThanhToan_model tt) throws ParseException, SQLException{
        
        String sqlThanhToan = "INSERT INTO THANHTOAN (ID,SOTIEN,SOTHE,TEN_CHUTHE,TENTHE) VALUES (?,?,?,?,?,?)";
        
        Connection conn = null;
        try {
            conn = Oracle_connection.getConnection("booking_app", "12345678");
            conn.setAutoCommit(false);

            try (PreparedStatement stmt = conn.prepareStatement(sqlThanhToan)) {
                stmt.setInt(1, tt.getId());
                stmt.setDouble(2, tt.getSotien());
                stmt.setString(3, tt.getSothe());
                stmt.setString(4, tt.getChuthe());
                stmt.setString(5, tt.getTenthe());
                stmt.executeUpdate();
            }
            
                conn.commit();
                JOptionPane.showMessageDialog(null, "Xác nhận thanh toán thành công!", "Thành công", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException e) {
                try {
                    if (conn != null) conn.rollback();
                } catch (SQLException ex) {
                }
                    JOptionPane.showMessageDialog(null, "Thanh toán thất bại: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            } finally {
                try {
                    if (conn != null) conn.close();
                } catch (SQLException ex) {
                }
            }
    }
}
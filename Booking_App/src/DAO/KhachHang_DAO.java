package DAO;
import Interface.IKhachHang;
import database.Oracle_connection;
import MODEL.KHACHHANG;
import database.jdbcHelper;
import java.lang.Integer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KhachHang_DAO implements IKhachHang<KHACHHANG, String>{
    private jdbcHelper jdbc = new jdbcHelper("nguoidung_user","12345678");
    
    @Override
    public KHACHHANG select(String email) {
        String sql = "SELECT ND.HOTEN, KH.CCCD, KH.NGAYSINH, ND.MATKHAU "
                + " FROM BOOKING_APP.NGUOIDUNG ND JOIN BOOKING_APP.KHACHHANG KH"
                + " ON ND.ID = KH.ID "
                + " WHERE EMAIL = ?";
        ResultSet rs;
        try {
            rs = this.jdbc.query(sql, email);
        if (rs.next()) {
            String name = rs.getString("HOTEN");
            String cccd = rs.getString("CCCD");
            String date = rs.getString("NGAYSINH");
            String pass = rs.getString("MATKHAU");

            return new KHACHHANG(name, email, cccd, date, pass);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHang_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return null;
    }
    
    
}
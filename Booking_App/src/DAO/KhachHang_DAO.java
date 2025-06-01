package DAO;
import Interface.IKhachHang;
import database.Oracle_connection;
import MODEL.KHACHHANG;
import database.jdbcHelper;
import java.awt.HeadlessException;
import java.lang.Integer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.message;
import java.text.SimpleDateFormat;
import java.util.Date;


public class KhachHang_DAO implements IKhachHang<KHACHHANG, String>{
    private jdbcHelper jdbc = new jdbcHelper("nguoidung_user","12345678");
    
    @Override
    public KHACHHANG select(String email) {
        String sql = "SELECT ND.ID,ND.HOTEN, KH.CCCD, TO_CHAR(KH.NGAYSINH, 'DD/MM/YYYY') AS NGAYSINH, ND.MATKHAU "
                + " FROM BOOKING_APP.NGUOIDUNG ND JOIN BOOKING_APP.KHACHHANG KH"
                + " ON ND.ID = KH.ID "
                + " WHERE EMAIL = ?";
        ResultSet rs;
        try {
            rs = this.jdbc.query(sql, email);
        if (rs.next()) {
            int id = rs.getInt("ID");
            String name = rs.getString("HOTEN");
            String cccd = rs.getString("CCCD");
            String date = rs.getString("NGAYSINH");
            String pass = rs.getString("MATKHAU");

            return new KHACHHANG(id,name, email, cccd, date, pass);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHang_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return null;
    }
    
    public void update(KHACHHANG n) {
        try {
        // Update NGUOIDUNG
            String sqlND = "UPDATE BOOKING_APP.NGUOIDUNG SET HOTEN = ?, MATKHAU = ? WHERE EMAIL = ?";
            jdbc.update(sqlND, n.getHOTEN(), n.getMATKHAU(), n.getEMAIL());

        // Update KHACHHANG
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date utilDate = sdf.parse(n.getNGAYSINH()); // n.getNGAYSINH() là String
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            String sqlKH = "UPDATE BOOKING_APP.KHACHHANG SET CCCD = ?, NGAYSINH = ? "
                            + "WHERE ID = (SELECT ID FROM BOOKING_APP.NGUOIDUNG WHERE EMAIL = ? and LOAITK = ?)";
            jdbc.update(sqlKH, n.getCCCD(), sqlDate, n.getEMAIL(), n.getLOAITK());
            

            message.alert(null, "Cập nhật thành công");
        } catch (Exception ex) {
            ex.printStackTrace(); // <--- QUAN TRỌNG để biết lỗi gì
            System.out.println("Lỗi: " + ex.getMessage());
            Logger.getLogger(KhachHang_DAO.class.getName()).log(Level.SEVERE, null, ex);
            message.alert(null, "Lỗi khi cập nhật");
        }
        
  
    }

    
}
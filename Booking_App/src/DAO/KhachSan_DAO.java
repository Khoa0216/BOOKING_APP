/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODEL.KHACHHANG;
import MODEL.KHACHSAN;
import database.jdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.message;

/**
 *
 * @author bobui
 */
public class KhachSan_DAO {
    private jdbcHelper jdbc = new jdbcHelper("booking_app","12345678");
    public KHACHSAN select(String email) {
        String sql = "SELECT ND.ID,ND.HOTEN, KS.TENDN,  KS.DIACHI, KS.TINH, KS.MOTA ,KS.BANK, KS.STK" +
                        " FROM BOOKING_APP.NGUOIDUNG ND JOIN BOOKING_APP.KHACHSAN KS " +
                        " ON ND.ID = KS.ID " +
                        " WHERE ND.EMAIL = ? ";
        ResultSet rs;
        try {
            rs = this.jdbc.query(sql, email);
        if (rs.next()) {
            int id = rs.getInt("ID");
            String name = rs.getString("HOTEN");
            String tenDN = rs.getString("TENDN");
            String diachi = rs.getString("DIACHI");
            String tinh = rs.getString("TINH");
            String mota = rs.getString("MOTA");
            String bank = rs.getString("BANK");
            String stk = rs.getString("STK");

            return new KHACHSAN(id,name,email, tenDN, diachi, tinh, mota,bank,stk);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHang_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return null;
    }
    public void update(KHACHSAN n) {
        try {
            // Update NGUOIDUNG
            String sqlND = "UPDATE BOOKING_APP.NGUOIDUNG SET HOTEN = ?, MATKHAU = ? WHERE EMAIL = ?";
            jdbc.update(sqlND, n.getHOTEN(), n.getMATKHAU(), n.getEMAIL());

            // Update KHACHSAN
            String sqlKS = "UPDATE BOOKING_APP.KHACHSAN SET TENDN = ?, MOTA = ?, BANK = ? , STK = ? " +
                           " WHERE ID = (SELECT ID FROM BOOKING_APP.NGUOIDUNG WHERE EMAIL = ?)";
            jdbc.update(sqlKS, n.getTENDN(), n.getMOTA(), n.getBANK(), n.getSTK(), n.getEMAIL());

            message.alert(null, "Cập nhật thành công");
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(KhachSan_DAO.class.getName()).log(Level.SEVERE, null, ex);
            message.alert(null, "Lỗi khi cập nhật");
        }
        
    }
}

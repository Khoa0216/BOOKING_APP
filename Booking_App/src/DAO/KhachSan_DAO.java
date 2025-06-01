/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODEL.KHACHSAN;
import database.jdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bobui
 */
public class KhachSan_DAO {
    private jdbcHelper jdbc = new jdbcHelper("nguoidung_user","12345678");
    public KHACHSAN select(String email) {
        String sql = "SELECT ND.ID,ND.HOTEN, KS.TENDN,  KS.DIACHI, KS.TINH, KS.MOTA " +
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
            

            return new KHACHSAN(id,name,email, tenDN, diachi, tinh, mota);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHang_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return null;
    }
}

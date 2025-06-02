package DAO;

/**
 *
 * @author Admin
 */

import java.lang.*;
import java.sql.*;
import MODEL.DonDat;
import java.util.Vector;
import database.jdbcHelper;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.message;
import java.time.*;
import MODEL.ThanhToan_model;

public class ThanhToan_Dao {
    static public void insert(ThanhToan_model thanhToan){
        String sqlInsert = "insert into booking_app.ThanhToan\n"
                + "(ID, SoThe, Ten_ChuThe, TenThe, Sotien)\n"
                + "values(?, ?, ?, ?, ?)";
        jdbcHelper.update(sqlInsert, thanhToan.getId(),thanhToan.getSothe(), thanhToan.getChuthe(), thanhToan.getTenthe(), thanhToan.getSotien());
        message.alert(null, "Thanh toán thành công");
    }
    
    static public void update(ThanhToan_model thanhToan){
        String sqlUPDATE = "UPDATE THANHTOAN SET SOTIEN=?, SOTHE=?, TEN_CHUTHE=?, TENTHE=? WHERE ID=?";
        jdbcHelper.update(sqlUPDATE, thanhToan.getSotien(), thanhToan.getSothe(), thanhToan.getChuthe(), thanhToan.getTenthe(), thanhToan.getId());
        message.alert(null, "Thanh toán thành công");
    }
    
    public static void UpdateTT(Long sotien, int idDP){
        jdbcHelper jdbc = new jdbcHelper("booking_app","12345678");
        
        try {
            String sql = "UPDATE THANHTOAN SET SOTIEN=? WHERE ID=?";
            jdbc.update(sql, sotien, idDP);
            return;
        } catch (Exception e) {
            message.alert(null, "Lỗi Cập Nhật Thông Tin Đơn.");
        }
         return;
    }
}

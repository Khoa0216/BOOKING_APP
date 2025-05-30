package DAO;

/**
 *
 * @author Admin
 */

import java.lang.*;
import java.sql.*;
import model.DonDat;
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
                + "(ID, Ngay_giaoDich, SoThe, Ten_ChuThe, TenThe)\n"
                + "values(?, ?, ?, ?, ?)";
        jdbcHelper.update(sqlInsert, thanhToan.getId(), thanhToan.getNgayGiaoDich(),
                thanhToan.getSothe(), thanhToan.getChuthe(), thanhToan.getTenthe());
        message.alert(null, "Đã đặt phòng thành công");
    }
}

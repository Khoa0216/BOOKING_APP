package DAO;

/**
 *
 * @author Admin
 */
import utils.*;
import database.jdbcHelper;
import java.util.Vector;
import MODEL.NGUOIDUNG;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class NguoiDung_Dao {
    public static Vector<NGUOIDUNG> selectAll(){
        String sql = "select * from booking_app.nguoidung";
        
        Vector<NGUOIDUNG> listNguoiDung = new Vector<>();
        try {
            ResultSet rs = jdbcHelper.query(sql);
            while(rs.next()){
                Integer id = rs.getInt("id");
                String email = rs.getString("Email");
                String hoTen = rs.getString("Hoten");
                String pass = rs.getString("MatKhau");
                String loaiTK = rs.getString("LoaiTK");
                
                NGUOIDUNG user = new NGUOIDUNG(id, email, pass, hoTen, loaiTK);
                listNguoiDung.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NguoiDung_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listNguoiDung;
    }
    
    public static void delete(Integer id){
        String sql = "delete from booking_app.nguoidung\n"
                    + "where id = ?";
        jdbcHelper.update(sql, id);
        message.alert(null, "Xóa tài khoản thành công");
    }
    
    public static Vector<NGUOIDUNG> selectByKey(String key){
        String sql = "select * from booking_app.nguoidung\n"
                + "where hoten like ?";
        
        Vector<NGUOIDUNG> listNguoiDung = new Vector<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, "%" + key + "%");
            while(rs.next()){
                Integer id = rs.getInt("id");
                String email = rs.getString("Email");
                String hoTen = rs.getString("Hoten");
                String pass = rs.getString("MatKhau");
                String loaiTK = rs.getString("LoaiTK");
                
                NGUOIDUNG user = new NGUOIDUNG(id, email, pass, hoTen, loaiTK);
                listNguoiDung.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NguoiDung_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listNguoiDung;
    }
}

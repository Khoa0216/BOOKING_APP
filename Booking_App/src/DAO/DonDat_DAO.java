package DAO;

/**
 *
 * @author Admin
 */
import database.Oracle_connection;
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
import java.sql.Date;

public class DonDat_DAO {
    static public Vector<DonDat> selectAll(){
        Vector<DonDat> donDatList = new Vector<>();
        String querySelect = "select dp.id, dp.khachhang_id,  hoten, p.id as phong_id,  p.khachsan_id,"
                            +" tendn, gia, ngay_dat\n" +
                            "from datphong dp\n" +
                            "join nguoidung kh on dp.khachhang_id = kh.id\n" +
                            "join phong p on dp.phong_id = p.id\n" +
                            "join khachsan ks on p.khachsan_id = ks.id";
        
        try {
            ResultSet rs = jdbcHelper.query(querySelect);
            ResultSetMetaData metaData = rs.getMetaData();
            while(rs.next()){
                Integer id = rs.getInt("id");
                Integer idKH = rs.getInt("khachhang_id");
                Integer idKS = rs.getInt("khachsan_id");
                Integer idP = rs.getInt("phong_id");
                String tenKH = rs.getString("hoten");
                String tenKS = rs.getString("tendn");
                Long gia = rs.getLong("gia");
                LocalDateTime ngayDat = rs.getObject("ngay_dat", LocalDateTime.class);
                
                DonDat data = new DonDat(id, idKH, idKS, idP, tenKH, tenKS, gia, ngayDat);
                donDatList.add(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DonDat_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return donDatList;
    }
    
    static public void delete(Integer id){
        String query = "delete from booking_app.datphong where id=?";
        Integer row = jdbcHelper.update(query, id);
        if (row > 0){
            message.alert(null, "Xóa thành công");
        }
        else{
            message.alert(null, "Xóa thất bại, vui lòng thử lại");
        }
    }
    
    static public void update(DonDat d){
        
    }
    
    static public Integer countOrderWithDate(String date){
        String query = "SELECT count(*) \n" +
                        "FROM DATPHONG \n" +
                        "WHERE TRUNC(ngay_dat) = TO_DATE(?,'YYYY-MM-DD')";
        BigDecimal cnt = (BigDecimal) jdbcHelper.value(query, date);
        return cnt.intValue();
    }
    
    static public int insert(DonDat d){
        //insert xong sẽ trả về id vừa đc sinh ra
        
        String sqlInsert = "insert into booking_app.datphong\n"
                + "(KhachHang_id, Phong_id, Ngay_dat, NgayNhan, Ngay_tra, SL)\n"
                + "values (?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        
        try {
            int newId = 0;
            conn = Oracle_connection.getConnection("nguoidung_user", "12345678");
            conn.setAutoCommit(false);

            // 1. Insert DonDat và lấy ID sinh tự động
            
            try (PreparedStatement stmt1 = conn.prepareStatement(sqlInsert, new String[]{"ID"})) {
                stmt1.setInt(1, d.getIdKH());
                stmt1.setInt(2, d.getIdP());
                stmt1.setDate(3, Date.valueOf(d.getNgayDat().toLocalDate()));
                stmt1.setDate(4, Date.valueOf(d.getNgayNhan()));
                stmt1.setDate(5, Date.valueOf(d.getNgayTra()));
                stmt1.setInt(6, d.getSl());
                stmt1.executeUpdate();

                try (ResultSet rs = stmt1.getGeneratedKeys()) {
                    if (rs.next()) {
                        newId = rs.getInt(1);
                    } else {
                        throw new SQLException("Không lấy được ID đon đặt vừa sinh ra");
                    }
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
            if (newId == 0){
                message.alert(null, "Không lấy được ID đon đặt vừa sinh ra");
            }
            
            conn.commit();
            return newId;
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return 0;
    }
    
    static public Long tongTien(DonDat d){
        String sql = "select gia\n"
                + "from booking_app.phong\n"
                + "where id = ?";
        BigDecimal bd = (BigDecimal) jdbcHelper.value(sql, d.getIdP());
        if (bd == null) return 0L;
        BigDecimal total = bd.multiply(BigDecimal.valueOf(d.getSl()));
        return total.longValue();
    }
}

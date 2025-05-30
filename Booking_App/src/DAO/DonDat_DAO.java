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
}

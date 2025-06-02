package DAO;

/**
 *
 * @author Admin
 */
import MODEL.DonChinhSua;
import database.Oracle_connection;
import java.lang.*;
import java.sql.*;
import MODEL.DonDat;
import java.util.Vector;
import database.jdbcHelper;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.time.LocalDateTime;
import utils.message;
import java.time.*;
import java.sql.Date;

public class DonDat_DAO {
    public Vector<DonDat> selectByIDKH(Integer makh){
        Vector<DonDat> donDatList = new Vector<>();
        String querySelect = """
                             SELECT DP.ID AS ID_DP, P.ID AS ID_PHONG, P.LOAIPHONG, DP.KHACHHANG_ID,DP.NGAYNHAN, DP.NGAY_TRA, DP.SL , TT.SOTIEN, DP.NGAY_DAT
                              FROM (BOOKING_APP.DATPHONG DP JOIN BOOKING_APP.THANHTOAN TT ON DP.ID = TT.ID) 
                              JOIN BOOKING_APP.PHONG P ON P.ID = DP.PHONG_ID WHERE DP.KHACHHANG_ID = ?""" ;
        try {
            ResultSet rs = jdbcHelper.query(querySelect,makh);
            ResultSetMetaData metaData = rs.getMetaData();
            
            while(rs.next()){
                Integer id_dp = rs.getInt("ID_DP");
                Integer id_phong = rs.getInt("ID_PHONG");
                String tenPhong = rs.getString("LOAIPHONG");
                Integer idKH = rs.getInt("KHACHHANG_ID");
                Long gia = rs.getLong("SOTIEN");
                Date ngaydat = rs.getObject("NGAY_DAT",Date.class);
                Date ngaynhan = rs.getObject("NGAYNHAN", Date.class);
                Date ngaytra = rs.getObject("NGAY_TRA", Date.class);
                Integer sl = rs.getInt("SL");

                DonDat data = new DonDat(id_dp, id_phong, tenPhong, idKH, ngaynhan, ngaytra, sl , ngaydat, gia);
                donDatList.add(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DonDat_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }              

        return donDatList;
    }
    
    public DonDat selectByIDD(Integer madondat){
        String querySelect = " SELECT PHONG_ID, NGAYNHAN, NGAY_TRA, SL "
                + " FROM BOOKING_APP.DATPHONG WHERE ID = ? " ;
        DonDat dd=null;
        
        try {
            ResultSet rs = jdbcHelper.query(querySelect,madondat);
            
            while(rs.next()){
                Integer id_phong = rs.getInt("PHONG_ID");
                Date ngaynhan = rs.getObject("NGAYNHAN", Date.class);
                Date ngaytra = rs.getObject("NGAY_TRA", Date.class);
                Integer sl = rs.getInt("SL");

                dd = new DonDat(ngaynhan,ngaytra,sl,id_phong);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DonDat_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }              

        return dd;
    }
    
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
                Date ngayDat = rs.getObject("ngay_dat", Date.class);
                
                DonDat data = new DonDat(id, idKH, idKS, idP, tenKH, tenKS, gia, ngayDat);
                donDatList.add(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DonDat_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return donDatList;
    }
    
    static public int delete(Integer id){
        try {
        // Xóa các bản ghi liên quan ở DON_CHINHSUA (nếu có)
        String sql1 = "DELETE FROM BOOKING_APP.DON_CHINHSUA WHERE DATPHONG_ID = ?";
        jdbcHelper.update(sql1, id);

        // Xóa các bản ghi liên quan ở THANHTOAN (nếu có)
        String sql2 = "DELETE FROM BOOKING_APP.THANHTOAN WHERE ID = ?";
        jdbcHelper.update(sql2, id);

        // Xóa bản ghi ở DATPHONG
        String sql3 = "DELETE FROM BOOKING_APP.DATPHONG WHERE ID = ?";
        int row = jdbcHelper.update(sql3, id);

        return row;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
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
                stmt1.setDate(3, new java.sql.Date(d.getNgayDat().getTime()));
                stmt1.setDate(4, new java.sql.Date(d.getNgayNhan().getTime()));
                stmt1.setDate(5, new java.sql.Date(d.getNgayTra().getTime()));
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
    public DonDat select(Integer id) {
            String query = "SELECT DP.ID, DP.KHACHHANG_ID, DP.NGAYNHAN, DP.NGAY_TRA, DP.SL, DP.NGAY_DAT, TT.SOTIEN " +
                           "FROM BOOKING_APP.DATPHONG DP " +
                           "LEFT JOIN BOOKING_APP.THANHTOAN TT ON DP.ID = TT.ID " +
                           "WHERE DP.ID = ?";
            try {
                ResultSet rs = jdbcHelper.query(query, id);
                if (rs.next()) {
                    Integer iddon = rs.getInt("ID");
                    Integer idKH = rs.getInt("KHACHHANG_ID");
                    Date ngaydat = rs.getObject("NGAY_DAT",Date.class);
                    Date ngaynhan = rs.getObject("NGAYNHAN", Date.class);
                    Date ngaytra = rs.getObject("NGAY_TRA", Date.class);
                    Integer sl = rs.getInt("SL");
                    Long gia = rs.getLong("SOTIEN");
                    return new DonDat(iddon , idKH, ngaynhan, ngaytra, sl, ngaydat, gia);  
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return null;
    }
    
    
    public static int checkSLC (int phongId, String ngayNhan, String ngayTra){
        String sql = "{ ? = call SO_PHONG_TRONG(?, ?, ?)}";
        
        try (Connection conn = Oracle_connection.getConnection("booking_app", "12345678");
             CallableStatement cs=conn.prepareCall(sql)) {
            
            // đăng ký biến trả về
            cs.registerOutParameter(1, Types.INTEGER);

            // set các tham số đầu vào
            cs.setInt(2, phongId);
            cs.setDate(3, Date.valueOf(ngayNhan));
            cs.setDate(4, Date.valueOf(ngayTra));
            
            //thực hiện gọi hàm
            cs.execute();

            // lấy kq trả về
            return cs.getInt(1);
            
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
    
    public static Long GiaDon (int idD){
        String query = "SELECT SOTIEN FROM THANHTOAN TT JOIN DATPHONG DP ON TT.ID=DP.ID "
                + "WHERE DP.ID=?";
            try {
                ResultSet rs = jdbcHelper.query(query, idD);
                if (rs.next()) {
                    return rs.getLong("SOTIEN");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return null;
    }
    
    public static long GiaPhong(int idP){
        jdbcHelper jdbc = new jdbcHelper("booking_app","12345678");
        
        try {
            String sql = "SELECT GIA FROM PHONG WHERE ID = ?";
            ResultSet rs = jdbc.query(sql, idP);
            if (rs.next()) {
                return rs.getLong("GIA");
            }
        } catch (Exception e) {
            message.alert(null, "Lỗi truy vấn giá phòng.");
            e.printStackTrace();
        }
        return -1;
    }
    
    public static void UpdateDP(DonChinhSua dcs){
        jdbcHelper jdbc = new jdbcHelper("booking_app","12345678");
        
        try {
            String sql = "UPDATE DATPHONG SET NGAYNHAN=?, NGAY_TRA=?, SL=? WHERE ID=?";
            jdbc.update(sql, dcs.getNgayNhanMoi(), dcs.getNgayTraMoi(), dcs.getSlMoi(), dcs.getDatPhongId());
            return;
        } catch (Exception e) {
            message.alert(null, "Lỗi Cập Nhật Thông Tin Đơn.");
        }
         return;
    }
    
    public static void DeleteDP(int iddd){
        jdbcHelper jdbc = new jdbcHelper("booking_app","12345678");
        
        try {
            String sql = "DELETE FROM DATPHONG WHERE ID=?";
            jdbc.update(sql, iddd);
            return;
        } catch (Exception e) {
            message.alert(null, "Lỗi khi Xóa Đơn Đặt.");
        }
         return;
    }
}

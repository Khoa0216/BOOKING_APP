package DAO;

/**
 *
 * @author Admin
 */
import MODEL.Phong_KS;
import database.jdbcHelper;
import Interface.IPhongKS;
import MODEL.DonDat;
import database.Oracle_connection;
import java.awt.HeadlessException;
import java.util.Vector;
import java.lang.Integer;
import java.sql.*;
import javax.swing.*;
import utils.message;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PhongKS_DAO implements IPhongKS<Phong_KS, Integer>{
    @Override
    public void insert(Phong_KS phong){
        
        String queryInsert = "Insert into booking_app.PHONG\n"
                + "(KHACHSAN_ID, LOAIPHONG, GIA, MOTA , TONGSOLUONG, NGAY_DANG) \n" 
                + "values (?, ?, ?, ?, ?, ?)";
        
        jdbcHelper.update(queryInsert, phong.getIdKS(), phong.getLoaiPhong(),
                phong.getGia(),
                phong.getMoTa(), 
                phong.getTongSoluong(), phong.getNgayDang());
        
        message.alert(null, "Đã thêm thành công");
    }

    @Override
    public void update(Phong_KS e) {
       try{
           String sql = "update booking_app.PHONG set LOAIPHONG=?,"
                   + " GIA=?, MOTA=?, TONGSOLUONG=?, NGAY_DANG=?"
                   + " where ID=?";
           int row = jdbcHelper.update(sql, e.getLoaiPhong(), e.getGia(),
                   e.getMoTa(), e.getTongSoluong(),
                   e.getNgayDang(), e.getId());
           if (row > 0) {
                message.alert(null, "Cập nhật phòng thành công");
            }
       }catch(HeadlessException headlessException){
       }
    }

    @Override
    public void delete(Integer ID) {
          try {
            String sql = "Delete from booking_app.PHONG where ID=?";
            int row = jdbcHelper.update(sql, ID);
            if (row > 0) {
//                ImageIcon icon = new ImageIcon("src/icons/Accept.png");
                message.alert(null, "Xóa phòng thành công");
            }
        } catch (HeadlessException headlessException) {
        }
    }

    @Override
    public Vector<Phong_KS> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Phong_KS selectByID(Integer ID) {
        try{
            String sql = "select * from booking_app.PHONG where ID=?";
            ResultSet rs = jdbcHelper.query(sql, ID);
            ResultSetMetaData metadata = rs.getMetaData();
            int num_col = metadata.getColumnCount();
            while (rs.next()) {
                Integer Id = Integer.valueOf(rs.getString("ID"));
                Integer idKS = Integer.valueOf(rs.getString("KHACHSAN_ID"));
                String loaiP = rs.getString("LOAIPHONG");
                Long gia = Long.valueOf(rs.getString("GIA"));
                String moTa = rs.getString("MOTA");
                
                Long tongSoLuong = Long.valueOf(rs.getString("TONGSOLUONG"));
                Date ngayDang = rs.getDate("NGAY_DANG");
                return new Phong_KS(Id, idKS, loaiP, 
                        moTa, gia, tongSoLuong, ngayDang.toLocalDate(),
                        "null", 10, 10);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public Vector<Phong_KS> showOnCard(){
        Vector<Phong_KS> listPhong = new Vector<Phong_KS>();
        String sql = "select p.ID, p.KHACHSAN_ID, p.LOAIPHONG, p.GIA, p.MOTA, p.TONGSOLUONG, p.NGAY_DANG, "
               + "p.ANH1, p.ANH2, p.ANH3, ks.DIACHI, ks.TENDN "
               + "from booking_app.PHONG p "
               + "left join booking_app.KHACHSAN ks on ks.ID = p.KHACHSAN_ID ";

        try {
            ResultSet rs = jdbcHelper.query(sql);
            while(rs.next()){
                //System.out.println("ID: " + rs.getInt("ID") + ", KHACHSAN_ID: " + rs.getInt("KHACHSAN_ID") + ", TENDN: " + rs.getString("TENDN"));
                //System.out.println("ID: " + rs.getInt("ID") + ", KHACHSAN_ID: " + rs.getInt("KHACHSAN_ID"));
                Integer id = rs.getInt("ID");
                Integer idKS = rs.getInt("KHACHSAN_ID");
                String loaiP = rs.getString("LOAIPHONG");
                Long gia = rs.getLong("GIA");
                String mota = rs.getString("MOTA");

                Long tongSoLuong = rs.getLong("TONGSOLUONG");
                Date ngayDang = rs.getDate("NGAY_DANG");
                String location = rs.getString("DIACHI"); 
                String tenKS = rs.getString("TENDN");
                Phong_KS phong = new Phong_KS(id, idKS, loaiP, mota, gia, tongSoLuong, ngayDang.toLocalDate(), location, 5, 10);
                phong.setImage(0, rs.getBlob("ANH1"));
                phong.setImage(1, rs.getBlob("ANH2"));
                phong.setImage(2, rs.getBlob("ANH3"));
                phong.setTenKS(tenKS);
                listPhong.add(phong);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhongKS_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listPhong;
    }
    
    public Vector<Phong_KS> selectByDiaDiem(String diaDiem) {
        Vector<Phong_KS> listPhong = new Vector<>();
        String sql = "SELECT p.ID, p.KHACHSAN_ID, p.LOAIPHONG, p.GIA, p.MOTA, p.TONGSOLUONG, p.NGAY_DANG, "
                   + "p.ANH1, p.ANH2, p.ANH3, ks.DIACHI, ks.TENDN "
                   + "FROM booking_app.PHONG p "
                   + "JOIN booking_app.KHACHSAN ks ON ks.ID = p.KHACHSAN_ID "
                   + "WHERE ks.DIACHI LIKE ?";
        try {
            ResultSet rs = jdbcHelper.query(sql, "%" + diaDiem + "%");
            while (rs.next()) {
                //System.out.println("ID: " + rs.getInt("ID") + ", KHACHSAN_ID: " + rs.getInt("KHACHSAN_ID"));
                Integer id = rs.getInt("ID");
                Integer idKS = rs.getInt("KHACHSAN_ID");
                String loaiP = rs.getString("LOAIPHONG");
                Long gia = rs.getLong("GIA");
                String mota = rs.getString("MOTA");

                Long tongSoLuong = rs.getLong("TONGSOLUONG");
                Date ngayDang = rs.getDate("NGAY_DANG");
                String location = rs.getString("DIACHI"); 
                String tenKS = rs.getString("TENDN");
                Phong_KS phong = new Phong_KS(id, idKS, loaiP, mota, gia, tongSoLuong, ngayDang.toLocalDate(), location, 5, 10);
                phong.setImage(0, rs.getBlob("ANH1"));
                phong.setImage(1, rs.getBlob("ANH2"));
                phong.setImage(2, rs.getBlob("ANH3"));
                phong.setTenKS(tenKS);
                listPhong.add(phong);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhongKS_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listPhong;
    }
    
    
    public Vector<Phong_KS> selectByTenKS(String tenKS) {
        Vector<Phong_KS> listPhong = new Vector<>();
        String sql = "SELECT p.ID, p.KHACHSAN_ID, p.LOAIPHONG, p.GIA, p.MOTA, p.TONGSOLUONG, p.NGAY_DANG, "
                   + "p.ANH1, p.ANH2, p.ANH3, ks.DIACHI, ks.TENDN "
                   + "FROM booking_app.PHONG p "
                   + "JOIN booking_app.KHACHSAN ks ON ks.ID = p.KHACHSAN_ID "
                   + "WHERE LOWER(ks.TENDN) LIKE ?";
        try {
            ResultSet rs = jdbcHelper.query(sql, "%" + tenKS.toLowerCase() + "%");
            while (rs.next()) {
                Integer id = rs.getInt("ID");
                Integer idKS = rs.getInt("KHACHSAN_ID");
                String loaiP = rs.getString("LOAIPHONG");
                Long gia = rs.getLong("GIA");
                String mota = rs.getString("MOTA");
                Long tongSoLuong = rs.getLong("TONGSOLUONG");
                Date ngayDang = rs.getDate("NGAY_DANG");
                String location = rs.getString("DIACHI"); 
                String tenKSResult = rs.getString("TENDN");
                Phong_KS phong = new Phong_KS(id, idKS, loaiP, mota, gia, tongSoLuong, ngayDang.toLocalDate(), location, 5, 10);
                phong.setImage(0, rs.getBlob("ANH1"));
                phong.setImage(1, rs.getBlob("ANH2"));
                phong.setImage(2, rs.getBlob("ANH3"));
                phong.setTenKS(tenKSResult);
                listPhong.add(phong);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhongKS_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listPhong;
    }
    
    
    
    public Vector<Phong_KS> selectByDanhGia(double min, double max) {
        Vector<Phong_KS> listPhong = new Vector<>();
        String sql = "SELECT p.ID, p.KHACHSAN_ID, p.LOAIPHONG, p.GIA, p.MOTA, p.TONGSOLUONG, p.NGAY_DANG, "
                   + "p.ANH1, p.ANH2, p.ANH3, ks.DIACHI, ks.TENDN, ks.DANHGIA "
                   + "FROM booking_app.PHONG p "
                   + "JOIN booking_app.KHACHSAN ks ON ks.ID = p.KHACHSAN_ID "
                   + "WHERE ks.DANHGIA >= ? AND ks.DANHGIA < ?";
        try {
            ResultSet rs = jdbcHelper.query(sql, min, max);
            while (rs.next()) {
                Integer id = rs.getInt("ID");
                Integer idKS = rs.getInt("KHACHSAN_ID");
                String loaiP = rs.getString("LOAIPHONG");
                Long gia = rs.getLong("GIA");
                String mota = rs.getString("MOTA");
                Long tongSoLuong = rs.getLong("TONGSOLUONG");
                Date ngayDang = rs.getDate("NGAY_DANG");
                String location = rs.getString("DIACHI"); 
                String tenKS = rs.getString("TENDN");
                Phong_KS phong = new Phong_KS(id, idKS, loaiP, mota, gia, tongSoLuong, ngayDang.toLocalDate(), location, 5, 10);
                phong.setImage(0, rs.getBlob("ANH1"));
                phong.setImage(1, rs.getBlob("ANH2"));
                phong.setImage(2, rs.getBlob("ANH3"));
                phong.setTenKS(tenKS);
                listPhong.add(phong);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhongKS_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listPhong;
    }
    
    public static String getTenPhong (int idP){
        String sql = "SELECT LOAIPHONG FROM PHONG WHERE ID=?";
        
        try (Connection conn = Oracle_connection.getConnection("booking_app", "12345678");
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, idP);

            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return rs.getString("LOAIPHONG");
            } else {
                return null;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static String getTenKH (int idKH){
        String sql = "SELECT HOTEN FROM NGUOIDUNG WHERE ID=?";
        
        try (Connection conn = Oracle_connection.getConnection("booking_app", "12345678");
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, idKH);

            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return rs.getString("HOTEN");
            } else {
                return null;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static void getKS(int idP, DonDat d) {
        String sql = "SELECT KS.ID AS KS_ID, KS.TENDN AS KS_TENDN " +
                     "FROM KHACHSAN KS " +
                     "JOIN PHONG P ON KS.ID = P.KHACHSAN_ID " +
                     "WHERE P.ID = ?";

        try (Connection conn = Oracle_connection.getConnection("booking_app", "12345678");
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idP);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                d.setIdKS(rs.getInt("KS_ID"));
                d.setTenKS(rs.getString("KS_TENDN"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

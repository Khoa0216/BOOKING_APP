package DAO;

/**
 *
 * @author Admin
 */
import model.Phong_KS;
import database.jdbcHelper;
import Interface.IPhongKS;
import java.awt.HeadlessException;
import java.util.List;
import java.lang.Integer;
import java.sql.*;
import javax.swing.*;
import utils.message;
import java.time.LocalDate;

public class PhongKS_DAO implements IPhongKS<Phong_KS, Integer>{
    @Override
    public void insert(Phong_KS phong){
        
        String queryInsert = "Insert into booking_app.phong\n"
                + "(KhachSan_ID, LoaiPhong, Gia, MoTa, SoLuongConLai, TongSoLuong, Ngay_Dang) \n" 
                + "values (?, ?, ?, ?, ?, ?, ?)";
        
        jdbcHelper.update(queryInsert, phong.getIdKS(), phong.getLoaiPhong(),
                phong.getGia(),
                phong.getMoTa(), phong.getSoluongConLai(), 
                phong.getTongSoluong(), phong.getNgayDang());
        
        message.alert(null, "Đã thêm thành công");
    }

    @Override
    public void update(Phong_KS e) {
       try{
           String sql = "update booking_app.phong set LoaiPhong=?,"
                   + " Gia=?, MoTa=?, SoLuongConLai=?, TongSoLuong=?, Ngay_Dang=?"
                   + " where ID=?";
           int row = jdbcHelper.update(sql, e.getLoaiPhong(), e.getGia(),
                   e.getMoTa(), e.getSoluongConLai(), e.getTongSoluong(),
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
            String sql = "Delete from booking_app.phong where ID=?";
            int row = jdbcHelper.update(sql, ID);
            if (row > 0) {
//                ImageIcon icon = new ImageIcon("src/icons/Accept.png");
                message.alert(null, "Xóa phòng thành công");
            }
        } catch (HeadlessException headlessException) {
        }
    }

    @Override
    public List<Phong_KS> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Phong_KS selectByID(Integer ID) {
        try{
            String sql = "select * from booking_app.phong where ID=?";
            ResultSet rs = jdbcHelper.query(sql, ID);
            ResultSetMetaData metadata = rs.getMetaData();
            int num_col = metadata.getColumnCount();
            while (rs.next()) {
                Integer Id = Integer.valueOf(rs.getString("ID"));
                Integer idKS = Integer.valueOf(rs.getString("KhachSan_ID"));
                String loaiP = rs.getString("LoaiPhong");
                Long gia = Long.valueOf(rs.getString("Gia"));
                String moTa = rs.getString("MoTa");
                Long soLuongConLai = Long.valueOf(rs.getString("SoLuongConLai"));
                Long tongSoLuong = Long.valueOf(rs.getString("TongSoLuong"));
                Date ngayDang = rs.getDate("Ngay_Dang");
                return new Phong_KS(ID, idKS, loaiP, 
                        moTa, gia, tongSoLuong, soLuongConLai, ngayDang.toLocalDate());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

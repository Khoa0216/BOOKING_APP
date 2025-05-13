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

public class PhongKS_DAO implements IPhongKS<Phong_KS, Integer>{
    @Override
    public void insert(Phong_KS phong){
        Integer Id = phong.getId();
        try{
            String sql = "Select Id from booking_app.Phong_Dangtai";
            ResultSet rs = jdbcHelper.query(sql);
            while (rs.next()) {
                if (rs.getString(1).equals(String.valueOf(Id))) {
                    JOptionPane.showMessageDialog(null, "Đã trùng mã phong!!!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        String queryInsert = "Insert into booking_app.phong_dangtai\n"
                + "(ID, DoanhNghiep_ID, TenPhong, LoaiPhong, Gia, SoLuongConLai, TongSoLuong) \n" 
                + "values (?, ?, ?, ?, ?, ?, ?)";
        
        jdbcHelper.update(queryInsert, phong.getId(), phong.getDoanhnghie_id(),
                phong.getTenPhong(),
                phong.getLoaiPhong(), phong.getGia(), 
                phong.getSoluongConLai(), phong.getTongSoluong());
        
        message.alert(null, "Đã thêm thành công");
    }

    @Override
    public void update(Phong_KS e) {
       try{
           String sql = "update booking_app.Phong_DangTai set TenPhong=?, LoaiPhong=?,"
                   + " Gia=?, MoTa=?, SoLuongConLai=?, TongSoLuong=?"
                   + " where ID=?";
           int row = jdbcHelper.update(sql, e.getTenPhong(), e.getLoaiPhong(), e.getGia(),
                   e.getMoTa(), e.getSoluongConLai(), e.getTongSoluong(), e.getId());
           if (row > 0) {
                message.alert(null, "Cập nhật phòng thành công");
            }
       }catch(HeadlessException headlessException){
       }
    }

    @Override
    public void delete(Integer k) {
          try {
            String sql = "Delete from booking_app.Phong_DangTai where ID=?";
            int row = jdbcHelper.update(sql, k);
            if (row > 0) {
//                ImageIcon icon = new ImageIcon("src/icons/Accept.png");
                message.alert(null, "Xóa phòng thành công");
            }
        } catch (HeadlessException headlessException) {
        }// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Phong_KS> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Phong_KS selectByID(Integer k) {
        try{
            String sql = "select * from booking_app.Phong_DangTai where ID=?";
            ResultSet rs = jdbcHelper.query(sql, k);
            ResultSetMetaData metadata = rs.getMetaData();
            int num_col = metadata.getColumnCount();
            while (rs.next()) {
                Integer ID = Integer.valueOf(rs.getString(1));
                Integer ID_dn = Integer.valueOf(rs.getString(2));
                String tenPhong = rs.getString(3);
                String loaiPhong = rs.getString(4);
                Long gia = Long.valueOf(rs.getString(5));
                String moTa = rs.getString(6);
                Long soLuongConLai = Long.valueOf(rs.getString(7));
                Long tongSoLuong = Long.valueOf(rs.getString(8));
                return new Phong_KS(ID, ID_dn, tenPhong, loaiPhong, gia, 
                        moTa, tongSoLuong, soLuongConLai);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

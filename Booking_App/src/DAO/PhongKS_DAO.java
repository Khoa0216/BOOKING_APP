package DAO;

/**
 *
 * @author Admin
 */
import model.Phong_KS;
import database.jdbcHelper;
import Interface.IPhongKS;
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
            String sql = "Select Id form Phong_Dangtai";
            ResultSet rs = jdbcHelper.query(sql);
            while (rs.next()) {
                if (rs.getString(1).equals(Id)) {
                    JOptionPane.showMessageDialog(null, "Đã trùng mã phong!!!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        String queryInsert = "Insert into phong_dangtai\n"
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer k) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Phong_KS> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Phong_KS selectByID(Integer k) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

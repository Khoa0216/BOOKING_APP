package DAO;

import MODEL.Chuyen_DangTai;
import Interface.loaiPhuongTien;
import database.jdbcHelper;
import utils.message;
import java.awt.HeadlessException;
import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Chuyen_DangTaiDAO implements loaiPhuongTien<Chuyen_DangTai, Integer> {

    @Override
    public void insert(Chuyen_DangTai e) {
        try {
            String check = "SELECT ID FROM CHUYEN_DANGTAI WHERE ID = ?";
            ResultSet rs = jdbcHelper.query(check, e.getId());
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Trùng mã chuyến!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String sql = "INSERT INTO CHUYEN_DANGTAI (ID, DOANHNGHIEP_ID, LOAIPHUONGTIEN, DIEMDI, DIEMDEN, NGAYGIOKHOIHANH, GIA, MOTA, TONGSOLUONG, SOLUONGCONLAI) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            jdbcHelper.update(sql, e.getId(), e.getDoanhnghiepPT_id(), e.getLoaiPhuongTien(), e.getDiemDi(), e.getDiemDen(),
                              e.getNgayGioKhoiHanh(), e.getGia(), e.getMoTa(), e.getTongSoluong(), e.getSoLuongConLai());
            message.alert(null, "Thêm chuyến vận tải thành công!");

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi thêm chuyến: " + ex.getMessage());
        }
    }

    @Override
    public void update(Chuyen_DangTai e) {
        try {
            String sql = "UPDATE CHUYEN_DANGTAI SET LOAIPHUONGTIEN=?, DIEMDI=?, DIEMDEN=?, NGAYGIOKHOIHANH=?, " +
                         "GIA=?, MOTA=?, SOLUONGCONLAI=? WHERE ID=?";
            int row = jdbcHelper.update(sql, e.getLoaiPhuongTien(), e.getDiemDi(), e.getDiemDen(),
                                        e.getNgayGioKhoiHanh(), e.getGia(), e.getMoTa(), e.getSoLuongConLai(), e.getId());
            if (row > 0) {
                message.alert(null, "Cập nhật chuyến vận tải thành công!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi cập nhật: " + ex.getMessage());
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            String sql = "DELETE FROM CHUYEN_DANGTAI WHERE ID = ?";
            int row = jdbcHelper.update(sql, id);
            if (row > 0) {
                message.alert(null, "Xóa chuyến vận tải thành công!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi xóa chuyến: " + ex.getMessage());
        }
    }

    @Override
    public List<Chuyen_DangTai> selectAll() {
        List<Chuyen_DangTai> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM CHUYEN_DANGTAI";
            ResultSet rs = jdbcHelper.query(sql);
            while (rs.next()) {
                list.add(readFromResultSet(rs));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public Chuyen_DangTai selectByID(Integer id) {
        try {
            String sql = "SELECT * FROM CHUYEN_DANGTAI WHERE ID = ?";
            ResultSet rs = jdbcHelper.query(sql, id);
            if (rs.next()) {
                return readFromResultSet(rs);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private Chuyen_DangTai readFromResultSet(ResultSet rs) throws SQLException {
        return new Chuyen_DangTai(
                rs.getInt("ID"),
                rs.getInt("DOANHNGHIEP_ID"),
                rs.getString("LOAIPHUONGTIEN"),
                rs.getString("DIEMDI"),
                rs.getString("DIEMDEN"),
                rs.getString("NGAYGIOKHOIHANH"),
                rs.getLong("GIA"),
                rs.getString("MOTA"),
                rs.getLong("TONGSOLUONG"),
                rs.getLong("SOLUONGCONLAI")
        );
    }
}

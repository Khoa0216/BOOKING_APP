/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import database.jdbcHelper;
import MODEL.DonChinhSua;
import java.sql.ResultSet;
/**
 *
 * @author bobui
 */
public class DonChinhSua_DAO {
    public void insertDonChinhSua(DonChinhSua model) {
        String sql = "INSERT INTO BOOKING_APP.DON_CHINHSUA (DATPHONG_ID, NGAYNHAN_MOI, NGAY_TRA_MOI, SL_MOI, TRANGTHAI_DUYET, TRANGTHAI_THANHTOAN)VALUES ( ?, ?, ?, ?, ?, ?)";

        try {
            jdbcHelper.update(sql,
                model.getDatPhongId(),
                new java.sql.Date(model.getNgayNhanMoi().getTime()),
                new java.sql.Date(model.getNgayTraMoi().getTime()),
                model.getSlMoi(),
                model.getTrangThaiDuyet(),
                model.getTrangThaiThanhToan()
            );
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Lỗi khi thêm đơn chỉnh sửa: " + e.getMessage());
        }
    }
    public DonChinhSua select(Integer idkh){
        String sql = "SELECT TRANGTHAI_DUYET, TRANGTHAI_THANHTOAN "
                + " FROM BOOKING_APP.DON_CHINHSUA "
                + " WHERE ID = ?";
        try {
            ResultSet rs = jdbcHelper.query(sql, idkh);
            if (rs.next()) {

                String ttd = rs.getString("TRANGTHAI_DUYET");
                String tttt = rs.getString("TRANGTHAI_THANHTOAN");
                DonChinhSua model = new DonChinhSua(ttd, tttt);

                return model;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Lỗi khi lấy thông tin đơn chỉnh sửa: " + e.getMessage());
        }
        return null;
    }
    public DonChinhSua selectDonChinhSuaById(Integer idDon) {
        String sql = "SELECT * FROM BOOKING_APP.DON_CHINHSUA WHERE ID = ?";
        try {
            ResultSet rs = jdbcHelper.query(sql, idDon);
            if (rs.next()) {
                Integer id = rs.getInt("ID");
                Integer datPhongId = rs.getInt("DATPHONG_ID");
                java.util.Date ngayNhanMoi = rs.getDate("NGAYNHAN_MOI");
                java.util.Date ngayTraMoi = rs.getDate("NGAY_TRA_MOI");
                Integer slMoi = rs.getInt("SL_MOI");
                String trangThaiDuyet = rs.getString("TRANGTHAI_DUYET");
                String trangThaiThanhToan = rs.getString("TRANGTHAI_THANHTOAN");
                DonChinhSua model = new DonChinhSua(id, datPhongId, ngayNhanMoi, ngayTraMoi, slMoi, trangThaiDuyet, trangThaiThanhToan);
                return model;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Lỗi khi lấy đơn chỉnh sửa theo ID: " + e.getMessage());
        }
        return null;
    }


}

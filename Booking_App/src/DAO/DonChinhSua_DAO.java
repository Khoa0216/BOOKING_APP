/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import database.jdbcHelper;
import MODEL.DonChinhSua;
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

    
}

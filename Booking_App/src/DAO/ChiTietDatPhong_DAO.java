/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import MODEL.ChiTietDatPhong;
import Interface.IChiTietDatPhong;
import database.jdbcHelper;
/**
 *
 * @author bobui
 */
public class ChiTietDatPhong_DAO implements IChiTietDatPhong<ChiTietDatPhong,String >{
    private jdbcHelper jdbc = new jdbcHelper("nguoidung_user", "12345678");

    public void insert(ChiTietDatPhong chiTiet) {
        String sql = "INSERT INTO BOOKING_APP.CHITIET_DATPHONG ( DATPHONG_ID, PHONG_ID, GIATIEN, GHICHU) VALUES ( ?, ?, ?, ?)";
        try {
            this.jdbc.update(sql, 
            chiTiet.getDatPhongId(), 
            chiTiet.getPhongId(), 
            chiTiet.getGiaTien(), 
            chiTiet.getGhiChu()
            );
        } catch (Exception e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(null, "Lỗi khi tải dữ liệu lên CHITIET_DATPHONG");
        }
    }
}

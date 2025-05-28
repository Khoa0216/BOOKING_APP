/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Interface.IDatPhong;
import MODEL.DatPhong;
import database.jdbcHelper;
import java.sql.ResultSet;


/**
 *
 * @author bobui
 */
public class DatPhong_DAO implements IDatPhong<DatPhong,String> {
    private jdbcHelper jdbc = new jdbcHelper("nguoidung_user","12345678");
    @Override
    public void insert(DatPhong datPhong){
    String sqlInsert = "INSERT INTO BOOKING_APP.DATPHONG (KHACHHANG_ID, NGAYNHAN, SONGAY, TRANGTHAI, NGAY_DAT) VALUES (?, ?, ?, ?, ?)";
    
    try {
        jdbc.update(sqlInsert,
            datPhong.getIdKhachHang(),
            new java.sql.Date(datPhong.getNgayNhan().getTime()),
            datPhong.getSoNgay(),
            datPhong.getTrangThai(),
            new java.sql.Date(datPhong.getNgayDat().getTime())
        );

        // Lấy lại ID vừa được insert dựa trên thông tin duy nhất
        String sqlSelectId = "SELECT ID FROM BOOKING_APP.DATPHONG WHERE KHACHHANG_ID = ? AND NGAYNHAN = ? AND NGAY_DAT = ? ORDER BY ID DESC FETCH FIRST 1 ROWS ONLY";
        ResultSet rs = jdbc.query(sqlSelectId,
            datPhong.getIdKhachHang(),
            new java.sql.Date(datPhong.getNgayNhan().getTime()),
            new java.sql.Date(datPhong.getNgayDat().getTime())
        );

        if (rs.next()) {
            int generatedId = rs.getInt("ID");
            datPhong.setIdDatPhong(generatedId);
            System.out.println("DATPHONG_ID: " + generatedId); 
        }

    } catch (Exception e) {
        e.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(null,
            "Lỗi khi thêm đặt phòng: " + e.getMessage(),
            "Lỗi",
            javax.swing.JOptionPane.ERROR_MESSAGE);
    }
    }
}
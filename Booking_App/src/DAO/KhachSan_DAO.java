package DAO;
import MODEL.KHACHSAN;
import Interface.IKhachSan;
import database.jdbcHelper;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.*;


public class KhachSan_DAO implements IKhachSan<KHACHSAN, String> {
    private jdbcHelper jdbc = new jdbcHelper("nguoidung_user","12345678");
    
    @Override
    public void loadTableKS(JTable myTable) {
    // Tạo model mới với tiêu đề cột và override isCellEditable trả về false
    DefaultTableModel model = new DefaultTableModel(
        new Object[]{"ID", "Tên đăng nhập", "Địa chỉ", "Mô tả"}, 0) {
        
    };

    String sql = "SELECT ID, TENDN, DIACHI, MOTA FROM BOOKING_APP.KHACHSAN";

    try {
        ResultSet rs = jdbc.query(sql);
        while (rs.next()) {
            Integer id = rs.getInt("ID");
            String tenDN = rs.getString("TENDN");
            String diaChi = rs.getString("DIACHI");
            String moTa = rs.getString("MOTA");
            model.addRow(new Object[]{id, tenDN, diaChi, moTa});
        }
        rs.getStatement().getConnection().close();

        // Set model mới vào JTable
        myTable.setModel(model);

    } catch (Exception e) {
        e.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(null, "Lỗi khi tải dữ liệu KHACHSAN");
    }
}

}

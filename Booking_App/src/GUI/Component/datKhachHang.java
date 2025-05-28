/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Component;


import DAO.KhachSan_DAO;
import MODEL.KHACHHANG;
import DAO.PhongKS_DAO;
import MODEL.Phong_KS;
import java.awt.CardLayout;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import MODEL.ChiTietDatPhong;
import MODEL.DatPhong;
import DAO.ChiTietDatPhong_DAO;
import DAO.DatPhong_DAO;
import DAO.KhachHang_DAO;

/**
 *
 * @author bobui
 */
public class datKhachHang extends javax.swing.JPanel {

    private JPanel parent;
    private CardLayout cardLayout;
    private KHACHHANG kh;
    private KhachSan_DAO ksDAO = new KhachSan_DAO(); 
    
    
    
    public void loadDanhSachKhachSan() {
        ksDAO.loadTableKS(listKS);
    }
    public datKhachHang(JPanel parent, CardLayout cardLayout, String email) {
        initComponents();
        this.parent = parent;
        this.cardLayout = cardLayout;
        KhachHang_DAO khdao = new KhachHang_DAO();
        this.kh = khdao.select(email);
        System.out.println(this.kh.getID());
        System.out.println(this.kh.getHOTEN());
//        comboFind.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { 
//            "Tất cả", 
//            "Phổ biến nhất", 
//            "Đánh giá cao nhất" 
//        }));
        loadDanhSachKhachSan();
    }

   
    @SuppressWarnings("unchecked")                        
                         
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listKS = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1320, 1025));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica Neue", 1, 18))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 96, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 22)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DANH SÁCH KHÁCH SẠN");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(501, 501, 501)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        listKS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "TÊN KHÁCH SẠN", "ĐỊA ĐIỂM", "MÔ TẢ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        listKS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listKSMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listKS);
        if (listKS.getColumnModel().getColumnCount() > 0) {
            listKS.getColumnModel().getColumn(0).setMinWidth(100);
            listKS.getColumnModel().getColumn(0).setPreferredWidth(100);
            listKS.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(355, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void listKSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listKSMouseClicked
        // TODO add your handling code here:
        // TODO add your handling code here:
        int selectedRow = this.listKS.getSelectedRow();
        System.out.println(this.kh.getID());
        if (selectedRow >= 0) {
        Integer ks_id = (Integer) this.listKS.getValueAt(selectedRow, 0); // Lấy ID khách sạn

        // Tạo JFrame mới để hiển thị danh sách phòng
        JFrame frame = new JFrame("Danh sách phòng - Khách sạn ID: " + ks_id);
        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Lấy danh sách phòng từ DAO
        PhongKS_DAO dao = new PhongKS_DAO();
        List<Phong_KS> danhSachPhong = dao.selectByKhachSan(ks_id);

        // Tạo bảng hiển thị danh sách phòng
        DefaultTableModel model = new DefaultTableModel(new Object[]{"ID", "Loại phòng", "Giá", "Mô tả", "SL còn lại"}, 0);
        for (Phong_KS phong : danhSachPhong) {
            model.addRow(new Object[]{phong.getId(), phong.getLoaiPhong(), phong.getGia(), phong.getMoTa(), phong.getSoluongConLai()});
        }

        JTable tblPhong = new JTable(model);
        tblPhong.setDefaultEditor(Object.class, null); // Không cho phép chỉnh sửa
        tblPhong.setRowHeight(30);

        // Thu nhỏ cột ID và mở rộng cột Mô tả
        tblPhong.getColumnModel().getColumn(0).setPreferredWidth(50); // Cột ID
        tblPhong.getColumnModel().getColumn(0).setMaxWidth(50);
        tblPhong.getColumnModel().getColumn(3).setPreferredWidth(300); // Cột Mô tả

        JScrollPane scrollPane = new JScrollPane(tblPhong);

        // Tạo panel chứa nút "Đặt" và ô nhập số lượng
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel lblSoLuong = new JLabel("Số lượng:");
        JTextField txtSoLuong = new JTextField(5);

        JLabel lblSoNgay = new JLabel("Số ngày:");  
        JTextField txtSoNgay = new JTextField(5); // Ô nhập số lượng
        JButton btnDat = new JButton("Đặt");

        // Xử lý sự kiện khi nhấn nút "Đặt"
        btnDat.addActionListener((e) -> {
        int selectedRoomRow = tblPhong.getSelectedRow();
        if (selectedRoomRow >= 0) {
            try {
            Integer phongId = (Integer) tblPhong.getValueAt(selectedRoomRow, 0); // ID phòng
            Object giaTienObj = tblPhong.getValueAt(selectedRoomRow, 2); // Giá tiền
            Double giaTien;

            // Kiểm tra và chuyển đổi giá trị của cột "Giá"
            if (giaTienObj instanceof Long) {
                giaTien = ((Long) giaTienObj).doubleValue();
            } else if (giaTienObj instanceof Double) {
                giaTien = (Double) giaTienObj;
            } else {
                throw new IllegalArgumentException("Giá trị không hợp lệ cho cột 'Giá'.");
            }

            Object soLuongConLaiObj = tblPhong.getValueAt(selectedRoomRow, 4); // Số lượng còn lại
            Integer soLuongConLai;

            // Kiểm tra và chuyển đổi giá trị của cột "SL còn lại"
            if (soLuongConLaiObj instanceof Long) {
                soLuongConLai = ((Long) soLuongConLaiObj).intValue();
            } else if (soLuongConLaiObj instanceof Integer) {
                soLuongConLai = (Integer) soLuongConLaiObj;
            } else {
                throw new IllegalArgumentException("Giá trị không hợp lệ cho cột 'SL còn lại'.");
            }

            String soLuongStr = txtSoLuong.getText(); // Số lượng phòng
            String ngayNhanStr = JOptionPane.showInputDialog(frame, "Nhập ngày nhận (YYYY-MM-DD):"); // Ngày nhận
            String ngayTraStr = JOptionPane.showInputDialog(frame, "Nhập ngày trả (YYYY-MM-DD):"); // Ngày trả

            // Kiểm tra dữ liệu nhập vào
            int soLuong = Integer.parseInt(soLuongStr);
            if (soLuong <= 0) {
                JOptionPane.showMessageDialog(frame, "Số lượng phải lớn hơn 0!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (soLuong > soLuongConLai) {
                JOptionPane.showMessageDialog(frame, "Số lượng phòng cần đặt vượt quá số lượng còn lại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Kiểm tra ngày nhận và ngày trả
            Date ngayNhan = java.sql.Date.valueOf(ngayNhanStr); // Chuyển đổi chuỗi sang java.sql.Date
            Date ngayTra = java.sql.Date.valueOf(ngayTraStr);
            if (ngayTra.before(ngayNhan)) {
                JOptionPane.showMessageDialog(frame, "Ngày trả phải sau ngày nhận!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Tính số ngày
            long diffInMillies = Math.abs(ngayTra.getTime() - ngayNhan.getTime());
            int soNgay = (int) (diffInMillies / (1000 * 60 * 60 * 24)); // Số ngày giữa ngày nhận và ngày trả

            // Tạo đối tượng DatPhong
            DatPhong datPhong = new DatPhong();
            datPhong.setIdKhachHang(this.kh.getID());
            datPhong.setNgayNhan(ngayNhan);
            datPhong.setSoNgay(soNgay);
            datPhong.setTrangThai("Đã đặt");
            datPhong.setNgayDat(new Date());

            DatPhong_DAO datPhongDAO = new DatPhong_DAO();
            datPhongDAO.insert(datPhong); // Chèn vào bảng DATPHONG trước

            System.out.println("DATPHONG_ID: " + datPhong.getIdDatPhong());
            
            // Tạo đối tượng ChiTietDatPhong
            ChiTietDatPhong chiTiet = new ChiTietDatPhong();
            chiTiet.setDatPhongId(datPhong.getIdDatPhong());
            chiTiet.setPhongId(phongId);
            chiTiet.setGiaTien(giaTien * soNgay * soLuong);
            chiTiet.setGhiChu("Đặt phòng");
            ChiTietDatPhong_DAO chiTietDAO = new ChiTietDatPhong_DAO();
            chiTietDAO.insert(chiTiet);

            // Hiển thị thông báo thành công
            JOptionPane.showMessageDialog(frame, "Đặt " + soLuong + " phòng từ " + ngayNhanStr + " đến " + ngayTraStr + " thành công cho phòng ID: " + phongId);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Vui lòng nhập số lượng hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(frame, "Vui lòng nhập ngày hợp lệ (YYYY-MM-DD)!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Lỗi khi lưu dữ liệu: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
            } else {
                JOptionPane.showMessageDialog(frame, "Vui lòng chọn một phòng để đặt!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
});

        // Thêm các thành phần vào bottomPanel
        bottomPanel.add(lblSoLuong); // Thêm nhãn "Số lượng"
        bottomPanel.add(txtSoLuong); // Thêm ô nhập số lượng
        bottomPanel.add(btnDat);

        // Thêm bảng và bottomPanel vào frame
        frame.setLayout(new BorderLayout());
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // Hiển thị frame
        frame.setVisible(true);
    }//GEN-LAST:event_listKSMouseClicked
    }//GEN-LAST:event_listKSMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable listKS;
    // End of variables declaration//GEN-END:variables
}

package GUI.Component;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

import MODEL.PhongCard;
import GUI.Component.HotelCard;
import MODEL.NGUOIDUNG;
import DAO.PhongKS_DAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Vector;
import MODEL.Phong_KS;
public class HomePage extends javax.swing.JPanel {

    /**
     * Creates new form HomePage2
     */
    private NGUOIDUNG user;
    private PhongKS_DAO phongKSDao = new PhongKS_DAO();
    public HomePage(NGUOIDUNG user){
        this.user = user;
        initComponents();
        loadData();
    }
    
    public void loadData(){
        listCard.removeAll(); 
        listCard.setLayout(new BoxLayout(listCard, BoxLayout.Y_AXIS));
        jScrollPane1.setBorder(null);
        add(jScrollPane1, BorderLayout.CENTER);

        // panel chứa các card
        listCard.setBackground(Color.WHITE);
        jScrollPane1.setViewportView(listCard);
        
        Vector<Phong_KS> listPhongKS = phongKSDao.showOnCard();
        
        int gap=10;
        for (Phong_KS phong : listPhongKS){
            
                HotelCard card = new HotelCard(phong, user);
                listCard.add(card);
                listCard.add(Box.createVerticalStrut(gap));
                //System.out.println("Add card: " + phong.getId());
            
        }
        //System.out.println("Tổng số phòng lấy từ DB: " + listPhongKS.size());
        if (listCard.getComponentCount() > 0) {
            int cardH = listCard.getComponent(0).getPreferredSize().height;
            int totalH = listPhongKS.size() * cardH + (listPhongKS.size() - 1) * gap;
            listCard.setPreferredSize(new Dimension(0, totalH));
        } else {
            System.out.println("Không có phòng nào được load lên giao diện.");
            
            JLabel emptyLabel = new JLabel("Không có phòng nào hiển thị.");
            emptyLabel.setFont(new Font("Arial", Font.ITALIC, 16));
            emptyLabel.setForeground(Color.GRAY);
            emptyLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            listCard.add(Box.createVerticalStrut(30));
            listCard.add(emptyLabel);
        }

        jScrollPane1.getVerticalScrollBar().setUnitIncrement(16);
        //System.out.println("Số card đã add: " + listCard.getComponentCount());
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listCard = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        timkiemLabel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        tinhComboBox = new javax.swing.JComboBox<>();
        locdiadiemLabel = new javax.swing.JLabel();
        locdanhgiaLabel = new javax.swing.JLabel();
        danhgiaComboBox = new javax.swing.JComboBox<>();
        timKSTextField = new javax.swing.JTextField();
        timKSLabel = new javax.swing.JLabel();
        timBtn = new javax.swing.JButton();
        rsBtn = new javax.swing.JButton();
        tinhLabel = new javax.swing.JLabel();
        tinhComboBox1 = new javax.swing.JComboBox<>();
        btnRefresh = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1320, 1025));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(1320, 100000));

        listCard.setPreferredSize(new java.awt.Dimension(1000, 1025));

        javax.swing.GroupLayout listCardLayout = new javax.swing.GroupLayout(listCard);
        listCard.setLayout(listCardLayout);
        listCardLayout.setHorizontalGroup(
            listCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1281, Short.MAX_VALUE)
        );
        listCardLayout.setVerticalGroup(
            listCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1025, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(listCard);

        javax.swing.GroupLayout timkiemLabelLayout = new javax.swing.GroupLayout(timkiemLabel);
        timkiemLabel.setLayout(timkiemLabelLayout);
        timkiemLabelLayout.setHorizontalGroup(
            timkiemLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1320, Short.MAX_VALUE)
        );
        timkiemLabelLayout.setVerticalGroup(
            timkiemLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 143, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica Neue", 1, 18))); // NOI18N

        tinhComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hà Nội", "Hạ Long", "Ninh Bình", "Sapa", "Thừa Thiên Huế", "Đà Nẵng", "Hội An", "Nha Trang", "Phú Yên", "Quảng Bình", "TP. Hồ Chí Minh", "Đà Lạt", "Phan Thiết", "Bà Rịa - Vũng Tàu", "Cần Thơ", "An Giang", "Kiên Giang" }));
        tinhComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tinhComboBoxActionPerformed(evt);
            }
        });

        locdiadiemLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        locdiadiemLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        locdiadiemLabel.setText("Lọc theo địa điểm");
        locdiadiemLabel.setAutoscrolls(true);
        locdiadiemLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        locdanhgiaLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        locdanhgiaLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        locdanhgiaLabel.setText("Lọc theo đánh giá");
        locdanhgiaLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        danhgiaComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0 ★ - 1 ★", "1 ★ - 2 ★", "2 ★ - 3 ★", "3 ★ - 4 ★", "4 ★ - 5 ★", " " }));

        timKSTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timKSTextFieldActionPerformed(evt);
            }
        });

        timKSLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        timKSLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timKSLabel.setText("Tìm kiếm khách sạn");
        timKSLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        timBtn.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        timBtn.setText("Tìm");
        timBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        timBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timBtnActionPerformed(evt);
            }
        });

        rsBtn.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        rsBtn.setText("Bỏ lọc, tìm");
        rsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rsBtnActionPerformed(evt);
            }
        });

        tinhLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tinhLabel.setText("Lọc theo tỉnh");
        tinhLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tinhComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "An Giang", "Bà Rịa – Vũng Tàu", "Bạc Liêu", "Bắc Giang", "Bắc Kạn", "Bắc Ninh", "Bến Tre", "Bình Dương", "Bình Định", "Bình Phước", "Bình Thuận", "Cà Mau", "Cần Thơ", "Cao Bằng", "Đà Nẵng", "Đắk Lắk", "Đắk Nông", "Điện Biên", "Đồng Nai", "Đồng Tháp", "Gia Lai", "Hà Giang", "Hà Nam", "Hà Nội", "Hà Tĩnh", "Hải Dương", "Hải Phòng", "Hậu Giang", "Hòa Bình", "Hưng Yên", "Khánh Hòa", "Kiên Giang", "Kon Tum", "Lai Châu", "Lâm Đồng", "Lạng Sơn", "Lào Cai", "Long An", "Nam Định", "Nghệ An", "Ninh Bình", "Ninh Thuận", "Phú Thọ", "Phú Yên", "Quảng Bình", "Quảng Nam", "Quảng Ngãi", "Quảng Ninh", "Quảng Trị", "Sóc Trăng", "Sơn La", "Tây Ninh", "Thái Bình", "Thái Nguyên", "Thanh Hóa", "Thừa Thiên Huế", "Tiền Giang", "TP Hồ Chí Minh", "Trà Vinh", "Tuyên Quang", "Vĩnh Long", "Vĩnh Phúc", "Yên Bái" }));
        tinhComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tinhComboBox1ActionPerformed(evt);
            }
        });

        btnRefresh.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        btnRefresh.setText("Làm mới");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(locdiadiemLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tinhComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(locdanhgiaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(danhgiaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tinhLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tinhComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                        .addComponent(timKSLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(timKSTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(timBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(timKSTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(timKSLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(timBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tinhLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tinhComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(locdiadiemLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(locdanhgiaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(danhgiaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tinhComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rsBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(timkiemLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(timkiemLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 859, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void timKSTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timKSTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_timKSTextFieldActionPerformed

    private void timBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timBtnActionPerformed
        // TODO add your handling code here:
        String tenKS = timKSTextField.getText().trim();
        Vector<Phong_KS> listPhongKS = phongKSDao.selectByTenKS(tenKS);

        listCard.removeAll();
        
        int gap = 10;
        for (Phong_KS phong : listPhongKS) {
            HotelCard card = new HotelCard(phong, user);
            listCard.add(card);
            listCard.add(Box.createVerticalStrut(gap));
        }
        if (!listPhongKS.isEmpty()) {
            int cardH = listCard.getComponent(0).getPreferredSize().height;
            int totalH = listPhongKS.size() * cardH + (listPhongKS.size() - 1) * gap;
            listCard.setPreferredSize(new Dimension(0, totalH));
        }
        
        listCard.revalidate();
        listCard.repaint();
    }//GEN-LAST:event_timBtnActionPerformed

    private void tinhComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tinhComboBoxActionPerformed
      String diaDiem = (String) tinhComboBox.getSelectedItem();
        Vector<Phong_KS> listPhongKS = phongKSDao.selectByDiaDiem(diaDiem);

        listCard.removeAll();
        int gap = 10;
        for (Phong_KS phong : listPhongKS) {
            HotelCard card = new HotelCard(phong, user);
            listCard.add(card);
            listCard.add(Box.createVerticalStrut(gap));
        }
        if (!listPhongKS.isEmpty()) {
            int cardH = listCard.getComponent(0).getPreferredSize().height;
            int totalH = listPhongKS.size() * cardH + (listPhongKS.size() - 1) * gap;
            listCard.setPreferredSize(new Dimension(0, totalH));
        }
        listCard.revalidate();
        listCard.repaint();
    }//GEN-LAST:event_tinhComboBoxActionPerformed

    private void rsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rsBtnActionPerformed
        
       
        loadData();
    }//GEN-LAST:event_rsBtnActionPerformed

    private void tinhComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tinhComboBox1ActionPerformed
        // TODO add your handling code here:
        String tinh = (String) tinhComboBox1.getSelectedItem();
        Vector<Phong_KS> listPhongKS = phongKSDao.selectByTinh(tinh);

        listCard.removeAll();
        int gap = 10;
        for (Phong_KS phong : listPhongKS) {
            HotelCard card = new HotelCard(phong, user);
            listCard.add(card);
            listCard.add(Box.createVerticalStrut(gap));
        }
        if (!listPhongKS.isEmpty()) {
            int cardH = listCard.getComponent(0).getPreferredSize().height;
            int totalH = listPhongKS.size() * cardH + (listPhongKS.size() - 1) * gap;
            listCard.setPreferredSize(new Dimension(0, totalH));
        }
        listCard.revalidate();
        listCard.repaint();
        
        
    }//GEN-LAST:event_tinhComboBox1ActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        this.loadData();
    }//GEN-LAST:event_btnRefreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRefresh;
    private javax.swing.JComboBox<String> danhgiaComboBox;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel listCard;
    private javax.swing.JLabel locdanhgiaLabel;
    private javax.swing.JLabel locdiadiemLabel;
    private javax.swing.JButton rsBtn;
    private javax.swing.JButton timBtn;
    private javax.swing.JLabel timKSLabel;
    private javax.swing.JTextField timKSTextField;
    private javax.swing.JPanel timkiemLabel;
    private javax.swing.JComboBox<String> tinhComboBox;
    private javax.swing.JComboBox<String> tinhComboBox1;
    private javax.swing.JLabel tinhLabel;
    // End of variables declaration//GEN-END:variables
}

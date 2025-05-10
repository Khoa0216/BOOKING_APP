/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Component;
import DAO.KhachHang_DAO;
import MODEL.KHACHHANG;
import java.awt.CardLayout;
import javax.swing.JPanel;
import utils.message;

public class homeKhachHang extends javax.swing.JPanel {
    private JPanel parent;
    private CardLayout cardLayout;
    
    public homeKhachHang(){
        initComponents();
    }
    public homeKhachHang(String email) {
        initComponents();
        setHelloLabel(email);
    }
    public void setHelloLabel(String email){
        KhachHang_DAO khdao = new KhachHang_DAO();
        KHACHHANG KH = new KHACHHANG();
        KH = khdao.select(email);
        HelloLabel.setText("Hello, " + KH.getHOTEN());
    }
    public homeKhachHang(JPanel parent, CardLayout cardLayout,String email){
        initComponents();
        this.parent = parent;
        this.cardLayout = cardLayout; 
        setHelloLabel(email);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        HelloLabel = new javax.swing.JLabel();
        KsLabel3 = new javax.swing.JLabel();
        KsLabel1 = new javax.swing.JLabel();
        KsLabel4 = new javax.swing.JLabel();
        KsLabel5 = new javax.swing.JLabel();
        KsLabel2 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1400, 1200));

        HelloLabel.setBackground(new java.awt.Color(255, 255, 242));
        HelloLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        HelloLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        HelloLabel.setText("Hello,");

        KsLabel3.setBackground(new java.awt.Color(204, 204, 204));
        KsLabel3.setText("Ks 3");

        KsLabel1.setBackground(new java.awt.Color(255, 255, 255));
        KsLabel1.setText("Ks 1");

        KsLabel4.setText("Ks 4");

        KsLabel5.setText("Ks 5");

        KsLabel2.setBackground(new java.awt.Color(204, 204, 204));
        KsLabel2.setText("Ks 2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(HelloLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(KsLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(KsLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(KsLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(KsLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(KsLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(HelloLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(KsLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(KsLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(KsLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(KsLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(KsLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 800, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel HelloLabel;
    private javax.swing.JLabel KsLabel1;
    private javax.swing.JLabel KsLabel2;
    private javax.swing.JLabel KsLabel3;
    private javax.swing.JLabel KsLabel4;
    private javax.swing.JLabel KsLabel5;
    // End of variables declaration//GEN-END:variables
   
}

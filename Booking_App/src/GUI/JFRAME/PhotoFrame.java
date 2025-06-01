/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.JFRAME;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.sql.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import database.jdbcHelper;
import database.Oracle_connection;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
/**
 *
 * @author Admin
 */
public class PhotoFrame extends javax.swing.JFrame {
    private int phongID;
    private JLabel[] lblAnhs;
   
    private File[] selectedFiles = new File[3];      // Ảnh người dùng chọn mới
    private byte[][] imageLoaded = new byte[3][];    // Ảnh đã load từ DB
    private int selectedIndex = -1; // Ảnh đang được chọn (0 - 2)
    
    public PhotoFrame(int phongID) {
        initComponents();
        this.phongID = phongID;
        
        lblAnhs = new JLabel[]{jLabel2, jLabel3, jLabel6};//Tên label bạn đặt trong UI
        for (int i = 0; i < lblAnhs.length; i++) {
            final int index = i;
            lblAnhs[i].addMouseListener(new MouseAdapter() {
              
                public void mouseClicked(MouseEvent e) {
                    selectedIndex = index;
                }
            });
        }
        
        
        jButton1.addActionListener(e ->chonAnh());
        jButton2.addActionListener(e ->chonAnh());
        jButton4.addActionListener(e -> xoaAnh());
        jButton3.addActionListener(e -> luuAnhVaoDB());
        
        loadAnhTuDatabase();
                
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    private void chonAnh() {
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(this, "Hãy click vào 1 ảnh để chọn.");
            return;
        }
        JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            selectedFiles[selectedIndex] = chooser.getSelectedFile();
            ImageIcon icon = new ImageIcon(
                new ImageIcon(selectedFiles[selectedIndex].getAbsolutePath())
                .getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)
            );
            lblAnhs[selectedIndex].setIcon(icon);
            lblAnhs[selectedIndex].setText("");
        }
    }
    
    private void xoaAnh() {
        if (selectedIndex == -1) {
        JOptionPane.showMessageDialog(this, "Hãy chọn ảnh cần xóa.");
        return;
    }
        selectedFiles[selectedIndex] = null;
        imageLoaded[selectedIndex] = null;
        lblAnhs[selectedIndex].setIcon(null);
        lblAnhs[selectedIndex].setText("Ảnh " + (selectedIndex + 1));
    }
    
    
    private void luuAnhVaoDB() {
        try (Connection conn = Oracle_connection.getConnection("booking_app", "12345678")) {
            String sql = "UPDATE PHONG SET ANH1 = ?, ANH2 = ?, ANH3 = ? WHERE ID = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            for (int i = 0; i < 3; i++) {
                if (selectedFiles[i] != null) {
                    FileInputStream fis = new FileInputStream(selectedFiles[i]);
                    ps.setBinaryStream(i + 1, fis, (int) selectedFiles[i].length());
                } else if (imageLoaded[i] != null) {
                    ps.setBinaryStream(i + 1, new ByteArrayInputStream(imageLoaded[i]), imageLoaded[i].length);
                } else {
                    ps.setNull(i + 1, java.sql.Types.BLOB);
                }
            }
            ps.setInt(4, phongID);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "Đã cập nhật ảnh thành công!");
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy phòng để cập nhật.");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi lưu ảnh.");
        }
    }
    
    private void loadAnhTuDatabase() {
        try (Connection conn = Oracle_connection.getConnection("booking_app", "12345678")) {
            String sql = "SELECT ANH1, ANH2, ANH3 FROM PHONG WHERE ID = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, phongID);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Blob[] blobs = new Blob[3];
                blobs[0] = rs.getBlob("ANH1");
                blobs[1] = rs.getBlob("ANH2");
                blobs[2] = rs.getBlob("ANH3");

                for (int i = 0; i < 3; i++) {
                    if (blobs[i] != null) {
                        byte[] imageData = blobs[i].getBytes(1, (int) blobs[i].length());
                        imageLoaded[i] = imageData; // <- Lưu dữ liệu ảnh để sau này có thể giữ lại nếu người dùng không sửa
                        
                        BufferedImage img = ImageIO.read(new ByteArrayInputStream(imageData));
                        ImageIcon icon = new ImageIcon(
                            img.getScaledInstance(150, 150, Image.SCALE_SMOOTH));
                        lblAnhs[i].setIcon(icon);
                        lblAnhs[i].setText("");
                    } else {
                        lblAnhs[i].setIcon(null);
                        lblAnhs[i].setText("Ảnh " + (i + 1));
                    }
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Không thể tải ảnh từ database.");
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(600, 500));

        jPanel1.setLayout(new java.awt.GridLayout(0, 3, 10, 10));

        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));
        jPanel1.add(jLabel2);

        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));
        jPanel1.add(jLabel3);

        jLabel6.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));
        jPanel1.add(jLabel6);

        jButton1.setText("Thêm ảnh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Lưu");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Xóa ảnh");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton2.setText("Chỉnh sửa");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 396, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PhotoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PhotoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PhotoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PhotoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PhotoFrame(1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}

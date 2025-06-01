package GUI.JFRAME;

import DAO.Login_SignUp_Check;
import GUI.Component.LoginPanel;
import GUI.Component.RegisterPanel;
import GUI.Component.SignUpKhachSan;
import GUI.Component.SignUpKhachHang;
import GUI.Component.quanlydatKhachHang;
import database.QueryHelper;

import GUI.Component.HomePage;
import MODEL.NGUOIDUNG;
import GUI.Component.homeKhachHang;
import GUI.Component.accKhachHang;
import java.sql.ResultSet;
import java.awt.CardLayout;
import database.jdbcHelper;

import MODEL.NGUOIDUNG;
import java.sql.SQLException;



public class Menu_KhachHang extends javax.swing.JFrame {
    private CardLayout CLayout;
    private homeKhachHang homeKH;
    private accKhachHang accKH;
    private quanlydatKhachHang qldKH;
    private NGUOIDUNG nguoidung; 
    private String email;
    private HomePage homePage;
    private NGUOIDUNG user;
    
    public Menu_KhachHang() {
        initComponents();
        email = "test";
        this.email = email;
        rightPanel.setLayout(new CardLayout());
        this.CLayout = (CardLayout) rightPanel.getLayout();
        
//        homeKH = new homeKhachHang(rightPanel, this.CLayout,email);
//        accKH = new accKhachHang(rightPanel, this.CLayout,email);
        
        // Truyền tham chiếu của MainFrame cho mỗi panel (nếu cần)
//        rightPanel.add(homeKH,"home");
//        rightPanel.add(accKH,"acc");
        rightPanel.add(homePage, "Home page");
         
        CLayout.show(rightPanel, "Home page");
    }
    public Menu_KhachHang(NGUOIDUNG user){
        jdbcHelper.user = "nguoidung_user";
        jdbcHelper.pass = "12345678";
        
        this.user = user;
        initComponents();
        this.email = user.getEMAIL();
        rightPanel.setLayout(new CardLayout());
        this.CLayout = (CardLayout) rightPanel.getLayout();
        
        homePage = new HomePage(user);
        homeKH = new homeKhachHang(rightPanel, this.CLayout,email);
        accKH = new accKhachHang(rightPanel, this.CLayout,email);
        qldKH = new quanlydatKhachHang(rightPanel,this.CLayout,email);
        
        // Truyền tham chiếu của MainFrame cho mỗi panel (nếu cần)
        rightPanel.add(homeKH,"Home page");
        rightPanel.add(accKH,"acc");
        rightPanel.add(qldKH,"qldat");
        rightPanel.add(homePage, "Home page");
         
        CLayout.show(rightPanel, "Home page");

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DashBoard = new javax.swing.JPanel();
        UserIcon = new javax.swing.JLabel();
        HomeBtn = new javax.swing.JButton();
        ManageBtn = new javax.swing.JButton();
        HelpBtn = new javax.swing.JButton();
        AccountBtn = new javax.swing.JButton();
        YourEmail = new javax.swing.JLabel();
        orderBtn = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();
        rightPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1720, 1025));
        setResizable(false);

        DashBoard.setBackground(new java.awt.Color(0, 102, 102));
        DashBoard.setPreferredSize(new java.awt.Dimension(300, 1025));

        UserIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/user (1).png"))); // NOI18N

        HomeBtn.setFont(new java.awt.Font("Helvetica Neue", 1, 20)); // NOI18N
        HomeBtn.setForeground(new java.awt.Color(0, 102, 102));
        HomeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/home-icon-silhouette.png"))); // NOI18N
        HomeBtn.setText("Trang chủ");
        HomeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeBtnActionPerformed(evt);
            }
        });

        ManageBtn.setFont(new java.awt.Font("Helvetica Neue", 1, 20)); // NOI18N
        ManageBtn.setForeground(new java.awt.Color(0, 102, 102));
        ManageBtn.setText("Quản lý đặt");
        ManageBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManageBtnActionPerformed(evt);
            }
        });

        HelpBtn.setFont(new java.awt.Font("Helvetica Neue", 1, 20)); // NOI18N
        HelpBtn.setForeground(new java.awt.Color(0, 102, 102));
        HelpBtn.setText("Trợ giúp");

        AccountBtn.setFont(new java.awt.Font("Helvetica Neue", 1, 20)); // NOI18N
        AccountBtn.setForeground(new java.awt.Color(0, 102, 102));
        AccountBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/user.png"))); // NOI18N
        AccountBtn.setText("Tài khoản");
        AccountBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AccountBtnActionPerformed(evt);
            }
        });

        YourEmail.setForeground(new java.awt.Color(255, 255, 255));
        YourEmail.setText("Your Email");

        orderBtn.setFont(new java.awt.Font("Helvetica Neue", 1, 20)); // NOI18N
        orderBtn.setForeground(new java.awt.Color(0, 102, 102));
        orderBtn.setText("Đặt");
        orderBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderBtnActionPerformed(evt);
            }
        });

        logoutBtn.setFont(new java.awt.Font("Helvetica Neue", 1, 20)); // NOI18N
        logoutBtn.setForeground(new java.awt.Color(0, 102, 102));
        logoutBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/user.png"))); // NOI18N
        logoutBtn.setText("Đăng xuất");
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DashBoardLayout = new javax.swing.GroupLayout(DashBoard);
        DashBoard.setLayout(DashBoardLayout);
        DashBoardLayout.setHorizontalGroup(
            DashBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashBoardLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(DashBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AccountBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(HelpBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(HomeBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ManageBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(orderBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logoutBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 27, Short.MAX_VALUE))
            .addGroup(DashBoardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(UserIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(YourEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DashBoardLayout.setVerticalGroup(
            DashBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashBoardLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(DashBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(UserIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(YourEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(77, 77, 77)
                .addComponent(HomeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(orderBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(ManageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(HelpBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(AccountBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );

        rightPanel.setPreferredSize(new java.awt.Dimension(1320, 1025));
        rightPanel.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(DashBoard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(rightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DashBoard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(rightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ManageBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManageBtnActionPerformed
        // TODO add your handling code here:
        //CLayout = (CardLayout)(rightPanel.getLayout());
        qldKH.loadtable();
        CLayout.show(rightPanel,"qldat");
    }//GEN-LAST:event_ManageBtnActionPerformed

    private void HomeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeBtnActionPerformed
//        homeKH.updateUserInfo(this.email);
//        CLayout = (CardLayout)(rightPanel.getLayout());
        homePage.loadData();
        CLayout.show(rightPanel, "Home page"); // Hiện panel "home"  
    }//GEN-LAST:event_HomeBtnActionPerformed

    private void AccountBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AccountBtnActionPerformed
        CLayout = (CardLayout)(rightPanel.getLayout());
        CLayout.show(rightPanel,"acc");
    }//GEN-LAST:event_AccountBtnActionPerformed

    private void orderBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_orderBtnActionPerformed

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        this.dispose();

        // Mở màn hình đăng nhập
        Main_Login_Register_JF login = new Main_Login_Register_JF();
        login.pack();
        login.setLocationRelativeTo(null);//Hiện ở giữa màn hình
        login.setVisible(true);
    }//GEN-LAST:event_logoutBtnActionPerformed

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
            java.util.logging.Logger.getLogger(Menu_KhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_KhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_KhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_KhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_KhachHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AccountBtn;
    private javax.swing.JPanel DashBoard;
    private javax.swing.JButton HelpBtn;
    private javax.swing.JButton HomeBtn;
    private javax.swing.JButton ManageBtn;
    private javax.swing.JLabel UserIcon;
    private javax.swing.JLabel YourEmail;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JButton orderBtn;
    private javax.swing.JPanel rightPanel;
    // End of variables declaration//GEN-END:variables
}

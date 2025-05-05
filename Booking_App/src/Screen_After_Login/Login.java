package Login_And_SignUp;
import Screen_After_Login.Menu_KhachHang;
import Screen_After_Login.Menu_DoanhNghiep_KhachSan;
import Screen_After_Login.Menu_DoanhNghiep_PhuongTien;

import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BackGround = new javax.swing.JPanel();
        Nen_tren = new javax.swing.JPanel();
        Nen_duoi = new javax.swing.JPanel();
        Login = new javax.swing.JLabel();
        Username = new javax.swing.JLabel();
        Dien_username = new javax.swing.JTextField();
        Password = new javax.swing.JLabel();
        Dien_password = new javax.swing.JPasswordField();
        Forgotten_password = new javax.swing.JButton();
        confirm_login = new javax.swing.JButton();
        Change_to_signup = new javax.swing.JButton();
        Label_ChangeTo_SignUp = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BackGround.setBackground(new java.awt.Color(244, 244, 242));

        Nen_tren.setBackground(new java.awt.Color(0, 102, 102));
        Nen_tren.setPreferredSize(new java.awt.Dimension(650, 105));

        javax.swing.GroupLayout Nen_trenLayout = new javax.swing.GroupLayout(Nen_tren);
        Nen_tren.setLayout(Nen_trenLayout);
        Nen_trenLayout.setHorizontalGroup(
            Nen_trenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        Nen_trenLayout.setVerticalGroup(
            Nen_trenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 105, Short.MAX_VALUE)
        );

        Nen_duoi.setBackground(new java.awt.Color(0, 102, 102));
        Nen_duoi.setPreferredSize(new java.awt.Dimension(650, 105));

        javax.swing.GroupLayout Nen_duoiLayout = new javax.swing.GroupLayout(Nen_duoi);
        Nen_duoi.setLayout(Nen_duoiLayout);
        Nen_duoiLayout.setHorizontalGroup(
            Nen_duoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        Nen_duoiLayout.setVerticalGroup(
            Nen_duoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 105, Short.MAX_VALUE)
        );

        Login.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        Login.setForeground(new java.awt.Color(0, 102, 102));
        Login.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Login.setText("ĐĂNG NHẬP");
        Login.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Login.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Username.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        Username.setForeground(new java.awt.Color(0, 0, 0));
        Username.setText("Email:");

        Dien_username.setBackground(new java.awt.Color(249, 249, 249));
        Dien_username.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Dien_username.setForeground(new java.awt.Color(102, 102, 102));
        Dien_username.setPreferredSize(new java.awt.Dimension(65, 30));

        Password.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        Password.setForeground(new java.awt.Color(0, 0, 0));
        Password.setText("Mật Khẩu:");

        Dien_password.setBackground(new java.awt.Color(249, 249, 249));
        Dien_password.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Dien_password.setForeground(new java.awt.Color(102, 102, 102));
        Dien_password.setPreferredSize(new java.awt.Dimension(65, 30));

        Forgotten_password.setBackground(new java.awt.Color(244, 244, 242));
        Forgotten_password.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Forgotten_password.setForeground(new java.awt.Color(102, 102, 102));
        Forgotten_password.setText("Quên mật khẩu?");
        Forgotten_password.setBorder(null);
        Forgotten_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Forgotten_passwordActionPerformed(evt);
            }
        });

        confirm_login.setBackground(new java.awt.Color(0, 102, 102));
        confirm_login.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        confirm_login.setForeground(new java.awt.Color(255, 255, 255));
        confirm_login.setText("Đăng Nhập");
        confirm_login.setPreferredSize(new java.awt.Dimension(140, 35));
        confirm_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirm_loginActionPerformed(evt);
            }
        });

        Change_to_signup.setBackground(new java.awt.Color(244, 244, 242));
        Change_to_signup.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        Change_to_signup.setForeground(new java.awt.Color(0, 102, 102));
        Change_to_signup.setText("Đăng Ký");
        Change_to_signup.setPreferredSize(new java.awt.Dimension(140, 35));
        Change_to_signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Change_to_signupActionPerformed(evt);
            }
        });

        Label_ChangeTo_SignUp.setForeground(new java.awt.Color(102, 102, 102));
        Label_ChangeTo_SignUp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_ChangeTo_SignUp.setText("Tôi chưa có tài khoản");
        Label_ChangeTo_SignUp.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout BackGroundLayout = new javax.swing.GroupLayout(BackGround);
        BackGround.setLayout(BackGroundLayout);
        BackGroundLayout.setHorizontalGroup(
            BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Nen_duoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Nen_tren, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(BackGroundLayout.createSequentialGroup()
                .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BackGroundLayout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Forgotten_password)
                            .addComponent(Password)
                            .addComponent(Username)
                            .addComponent(Dien_username, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
                            .addComponent(Dien_password, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(BackGroundLayout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addComponent(Login))
                    .addGroup(BackGroundLayout.createSequentialGroup()
                        .addGap(255, 255, 255)
                        .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(confirm_login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Change_to_signup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Label_ChangeTo_SignUp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        BackGroundLayout.setVerticalGroup(
            BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackGroundLayout.createSequentialGroup()
                .addComponent(Nen_tren, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(Login)
                .addGap(40, 40, 40)
                .addComponent(Username)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Dien_username, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Password)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Dien_password, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Forgotten_password)
                .addGap(43, 43, 43)
                .addComponent(confirm_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(Label_ChangeTo_SignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Change_to_signup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(Nen_duoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackGround, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackGround, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Forgotten_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Forgotten_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Forgotten_passwordActionPerformed

    private void confirm_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirm_loginActionPerformed
        // TODO add your handling code here:
        
        // lấy thông tin tài khoản và mật khẩu người dùng nhập
        String username = Dien_username.getText(); // Dien_username là TextField cho username
        String password = new String(Dien_password.getPassword());
       // Dien_password là PasswordField cho mật khẩu
        
        //System.out.println(username);
        //System.out.println(password);
        // kiểm tra đăng nhập
        
        String accountType = Login_And_SignUp.checkLogin(username, password);
        
        String name = Login_And_SignUp.getUserName(username);
        //System.out.println(name);
        //System.out.println(accountType);
        if (accountType != null) {
            // Hiển thị menu tùy theo loại tài khoản
            // Chuyển hướng tới giao diện chính cho người dùng
            if (accountType.equals("KHACHHANG")){// NẾU LÀ KHÁCH HÀNG.
                
                Menu_KhachHang MenuFrame= new Menu_KhachHang(name,username);
                 //Menu_KhachHang MenuFrame= new Menu_KhachHang(name);
                MenuFrame.pack();
                MenuFrame.setLocationRelativeTo(null);
                MenuFrame.setVisible(true);
                this.dispose();
            }
            else if (accountType.equals("DOANHNGHIEP")){ // NẾU LÀ DOANH NGHIỆP.
                
                String bussinessTypeString = Login_And_SignUp.checkLoaiDN(username, password);
                if (bussinessTypeString.equals("KHACHSAN")){
                    Menu_DoanhNghiep_KhachSan MenuFrame= new Menu_DoanhNghiep_KhachSan(name);
                    MenuFrame.pack();
                    MenuFrame.setLocationRelativeTo(null);
                    MenuFrame.setVisible(true);
                    this.dispose();
                } else if (bussinessTypeString.equals("HANGPHUONGTIEN")){
                    Menu_DoanhNghiep_PhuongTien MenuFrame= new Menu_DoanhNghiep_PhuongTien(name);
                    MenuFrame.pack();
                    MenuFrame.setLocationRelativeTo(null);
                    MenuFrame.setVisible(true);
                    this.dispose();
                }
                
            }
            
        } else {
            //JOptionPane để hiện lên thông báo không đăng nhập thành công.
            //this là form hiện tại (làm cửa sổ cha).
            //"Đăng nhập thất bại!" là thông tin thông báo.
            //"Lỗi" là title của bảng thông báo.
            //JOptionPane.ERROR_MESSAGE để hiện lên icon dấu x đỏ cảnh báo.
            JOptionPane.showMessageDialog(this, "Đăng nhập thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_confirm_loginActionPerformed

    private void Change_to_signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Change_to_signupActionPerformed
        // TODO add your handling code here:
        SignUp SUFrame = new SignUp();
        SUFrame.pack();
        SUFrame.setLocationRelativeTo(null);// hiện ở giữa màn hình
        SUFrame.setVisible(true);// cho phép hiện JFrame
        this.dispose(); // tắt màn hình hiện tại đi
    }//GEN-LAST:event_Change_to_signupActionPerformed
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
            java.util.logging.Logger.getLogger(Menu_DoanhNghiep_KhachSan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_DoanhNghiep_KhachSan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_DoanhNghiep_KhachSan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_DoanhNghiep_KhachSan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>n
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BackGround;
    private javax.swing.JButton Change_to_signup;
    private javax.swing.JPasswordField Dien_password;
    private javax.swing.JTextField Dien_username;
    private javax.swing.JButton Forgotten_password;
    private javax.swing.JLabel Label_ChangeTo_SignUp;
    private javax.swing.JLabel Login;
    private javax.swing.JPanel Nen_duoi;
    private javax.swing.JPanel Nen_tren;
    private javax.swing.JLabel Password;
    private javax.swing.JLabel Username;
    private javax.swing.JButton confirm_login;
    // End of variables declaration//GEN-END:variables
}

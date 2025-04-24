package Login_And_SignUp;

import javax.swing.JOptionPane;

public class SignUp extends javax.swing.JFrame {


    public SignUp() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BackGround = new javax.swing.JPanel();
        Nen_tren = new javax.swing.JPanel();
        Nen_duoi = new javax.swing.JPanel();
        SignUp = new javax.swing.JLabel();
        Full_Name = new javax.swing.JLabel();
        Full_Name_Fill = new javax.swing.JTextField();
        Email = new javax.swing.JLabel();
        Email_Fill = new javax.swing.JTextField();
        Password = new javax.swing.JLabel();
        Password_Fill = new javax.swing.JPasswordField();
        Confirm_Password = new javax.swing.JLabel();
        Confirm_Password_Fill = new javax.swing.JPasswordField();
        Choose_KH = new javax.swing.JButton();
        Choose_DN = new javax.swing.JButton();
        Label_OR = new javax.swing.JLabel();
        Have_An_Account = new javax.swing.JLabel();
        Login = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BackGround.setBackground(new java.awt.Color(244, 244, 242));
        BackGround.setPreferredSize(new java.awt.Dimension(650, 750));

        Nen_tren.setBackground(new java.awt.Color(0, 102, 102));
        Nen_tren.setPreferredSize(new java.awt.Dimension(650, 105));

        javax.swing.GroupLayout Nen_trenLayout = new javax.swing.GroupLayout(Nen_tren);
        Nen_tren.setLayout(Nen_trenLayout);
        Nen_trenLayout.setHorizontalGroup(
            Nen_trenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
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
            .addGap(0, 650, Short.MAX_VALUE)
        );
        Nen_duoiLayout.setVerticalGroup(
            Nen_duoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 105, Short.MAX_VALUE)
        );

        SignUp.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        SignUp.setForeground(new java.awt.Color(0, 102, 102));
        SignUp.setText("ĐĂNG KÝ");

        Full_Name.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        Full_Name.setForeground(new java.awt.Color(0, 0, 0));
        Full_Name.setText("Họ và Tên:");

        Full_Name_Fill.setBackground(new java.awt.Color(249, 249, 249));
        Full_Name_Fill.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Full_Name_Fill.setForeground(new java.awt.Color(102, 102, 102));
        Full_Name_Fill.setPreferredSize(new java.awt.Dimension(65, 30));

        Email.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        Email.setForeground(new java.awt.Color(0, 0, 0));
        Email.setText("Email:");

        Email_Fill.setBackground(new java.awt.Color(249, 249, 249));
        Email_Fill.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Email_Fill.setForeground(new java.awt.Color(102, 102, 102));
        Email_Fill.setPreferredSize(new java.awt.Dimension(65, 30));

        Password.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        Password.setForeground(new java.awt.Color(0, 0, 0));
        Password.setText("Mật Khẩu:");

        Password_Fill.setBackground(new java.awt.Color(249, 249, 249));
        Password_Fill.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Password_Fill.setForeground(new java.awt.Color(102, 102, 102));
        Password_Fill.setPreferredSize(new java.awt.Dimension(65, 30));

        Confirm_Password.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        Confirm_Password.setForeground(new java.awt.Color(0, 0, 0));
        Confirm_Password.setText("Xác Nhận Mật Khẩu Lần 2:");

        Confirm_Password_Fill.setBackground(new java.awt.Color(249, 249, 249));
        Confirm_Password_Fill.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Confirm_Password_Fill.setForeground(new java.awt.Color(102, 102, 102));
        Confirm_Password_Fill.setPreferredSize(new java.awt.Dimension(65, 30));

        Choose_KH.setBackground(new java.awt.Color(0, 102, 102));
        Choose_KH.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        Choose_KH.setForeground(new java.awt.Color(255, 255, 255));
        Choose_KH.setText("Khách Hàng");
        Choose_KH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Choose_KHActionPerformed(evt);
            }
        });

        Choose_DN.setBackground(new java.awt.Color(0, 102, 102));
        Choose_DN.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        Choose_DN.setForeground(new java.awt.Color(255, 255, 255));
        Choose_DN.setText("Doanh nghiệp");
        Choose_DN.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Choose_DN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Choose_DNActionPerformed(evt);
            }
        });

        Label_OR.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Label_OR.setForeground(new java.awt.Color(0, 0, 0));
        Label_OR.setText("Hay");

        Have_An_Account.setForeground(new java.awt.Color(102, 102, 102));
        Have_An_Account.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Have_An_Account.setText("Tôi đã có tài khoản");
        Have_An_Account.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        Login.setBackground(new java.awt.Color(255, 255, 255));
        Login.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        Login.setForeground(new java.awt.Color(0, 102, 102));
        Login.setText("Đăng Nhập");
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BackGroundLayout = new javax.swing.GroupLayout(BackGround);
        BackGround.setLayout(BackGroundLayout);
        BackGroundLayout.setHorizontalGroup(
            BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackGroundLayout.createSequentialGroup()
                .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Nen_tren, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nen_duoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(BackGroundLayout.createSequentialGroup()
                .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BackGroundLayout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Confirm_Password)
                            .addComponent(Password)
                            .addComponent(Email)
                            .addComponent(Full_Name)
                            .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(Confirm_Password_Fill, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Password_Fill, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Email_Fill, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Full_Name_Fill, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(BackGroundLayout.createSequentialGroup()
                        .addGap(239, 239, 239)
                        .addComponent(SignUp)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BackGroundLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BackGroundLayout.createSequentialGroup()
                        .addComponent(Choose_KH, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Label_OR)
                        .addGap(18, 18, 18)
                        .addComponent(Choose_DN)
                        .addGap(129, 129, 129))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BackGroundLayout.createSequentialGroup()
                        .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Have_An_Account, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Login, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(248, 248, 248))))
        );
        BackGroundLayout.setVerticalGroup(
            BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackGroundLayout.createSequentialGroup()
                .addComponent(Nen_tren, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SignUp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Full_Name)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Full_Name_Fill, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Email)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Email_Fill, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Password)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Password_Fill, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Confirm_Password)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Confirm_Password_Fill, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Choose_DN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Choose_KH, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Label_OR)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Have_An_Account, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Login, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(Nen_duoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(BackGround, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(BackGround, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
        // TODO add your handling code here:
        Login LGFrame = new Login();
        LGFrame.pack();
        LGFrame.setLocationRelativeTo(null);//Hiện ở giữa màn hình
        LGFrame.setVisible(true);//Cho phép hiện JFrame
        this.dispose();
    }//GEN-LAST:event_LoginActionPerformed

    private void Choose_KHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Choose_KHActionPerformed
        // TODO add your handling code here:
        
        // lấy thông tin người đăng ký nhập
        String fullname = Full_Name_Fill.getText(); // Email_Fill là TextField cho username
        String username = Email_Fill.getText(); // Email_Fill là TextField cho username
        String password = new String(Password_Fill.getPassword()); // Password_Fill là PasswordField cho mật khẩu
        String confirm_password = new String(Confirm_Password_Fill.getPassword()); // Password_Fill là PasswordField cho mật khẩu
        
        if(fullname.isEmpty() || username.isEmpty() || password.isEmpty() || confirm_password.isEmpty()){
            JOptionPane.showMessageDialog(this, "Bạn phải điền đầy đủ thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else if(!password.equals(confirm_password)){
            JOptionPane.showMessageDialog(this, "Mật khẩu xác nhận không khớp!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        SignUpKhachHang SUKHFrame = new SignUpKhachHang(fullname, username, password);
        SUKHFrame.pack();
        SUKHFrame.setLocationRelativeTo(null);//Hiện ở giữa màn hình
        SUKHFrame.setVisible(true);//Cho phép hiện JFrame
        this.dispose();
        
    }//GEN-LAST:event_Choose_KHActionPerformed

    private void Choose_DNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Choose_DNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Choose_DNActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BackGround;
    private javax.swing.JButton Choose_DN;
    private javax.swing.JButton Choose_KH;
    private javax.swing.JLabel Confirm_Password;
    private javax.swing.JPasswordField Confirm_Password_Fill;
    private javax.swing.JLabel Email;
    private javax.swing.JTextField Email_Fill;
    private javax.swing.JLabel Full_Name;
    private javax.swing.JTextField Full_Name_Fill;
    private javax.swing.JLabel Have_An_Account;
    private javax.swing.JLabel Label_OR;
    private javax.swing.JButton Login;
    private javax.swing.JPanel Nen_duoi;
    private javax.swing.JPanel Nen_tren;
    private javax.swing.JLabel Password;
    private javax.swing.JPasswordField Password_Fill;
    private javax.swing.JLabel SignUp;
    // End of variables declaration//GEN-END:variables
}

package Login_And_SignUp;

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
        Check_Condition = new javax.swing.JCheckBox();
        Have_An_Account = new javax.swing.JLabel();
        Full_Name = new javax.swing.JLabel();
        Full_Name_Fill = new javax.swing.JTextField();
        Email = new javax.swing.JLabel();
        Email_Fill = new javax.swing.JTextField();
        Password = new javax.swing.JLabel();
        Password_Fill = new javax.swing.JPasswordField();
        Confirm_Password = new javax.swing.JLabel();
        Confirm_Password_Fill = new javax.swing.JPasswordField();
        Confirm_SignUp = new javax.swing.JButton();
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

        Check_Condition.setBackground(new java.awt.Color(249, 249, 249));
        Check_Condition.setForeground(new java.awt.Color(102, 102, 102));
        Check_Condition.setText("Đồng ý cung cấp thông tin của tôi trong quá trình sử dụng.");
        Check_Condition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Check_ConditionActionPerformed(evt);
            }
        });

        Have_An_Account.setForeground(new java.awt.Color(102, 102, 102));
        Have_An_Account.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Have_An_Account.setText("Tôi đã có tài khoản");
        Have_An_Account.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        Full_Name.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        Full_Name.setForeground(new java.awt.Color(0, 0, 0));
        Full_Name.setText("Họ và Tên");

        Full_Name_Fill.setBackground(new java.awt.Color(249, 249, 249));
        Full_Name_Fill.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Full_Name_Fill.setForeground(new java.awt.Color(102, 102, 102));

        Email.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        Email.setForeground(new java.awt.Color(0, 0, 0));
        Email.setText("Email:");

        Email_Fill.setBackground(new java.awt.Color(249, 249, 249));
        Email_Fill.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Email_Fill.setForeground(new java.awt.Color(102, 102, 102));

        Password.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        Password.setForeground(new java.awt.Color(0, 0, 0));
        Password.setText("Mật Khẩu:");

        Password_Fill.setBackground(new java.awt.Color(249, 249, 249));
        Password_Fill.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Password_Fill.setForeground(new java.awt.Color(102, 102, 102));

        Confirm_Password.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        Confirm_Password.setForeground(new java.awt.Color(0, 0, 0));
        Confirm_Password.setText("Xác Nhận Mật Khẩu Lần 2:");

        Confirm_Password_Fill.setBackground(new java.awt.Color(249, 249, 249));
        Confirm_Password_Fill.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Confirm_Password_Fill.setForeground(new java.awt.Color(102, 102, 102));

        Confirm_SignUp.setBackground(new java.awt.Color(0, 102, 102));
        Confirm_SignUp.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        Confirm_SignUp.setForeground(new java.awt.Color(255, 255, 255));
        Confirm_SignUp.setText("Đăng Ký");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BackGroundLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SignUp)
                .addGap(242, 242, 242))
            .addGroup(BackGroundLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(Confirm_Password)
                        .addComponent(Password)
                        .addComponent(Email)
                        .addComponent(Full_Name)
                        .addComponent(Check_Condition)
                        .addComponent(Full_Name_Fill)
                        .addComponent(Email_Fill)
                        .addComponent(Password_Fill)
                        .addComponent(Confirm_Password_Fill, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE))
                    .addGroup(BackGroundLayout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Confirm_SignUp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Have_An_Account, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(Login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Check_Condition)
                .addGap(18, 18, 18)
                .addComponent(Confirm_SignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(Have_An_Account, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Login, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
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

    private void Check_ConditionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Check_ConditionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Check_ConditionActionPerformed

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
        // TODO add your handling code here:
        Login LGFrame = new Login();
        LGFrame.pack();
        LGFrame.setLocationRelativeTo(null);//Hiện ở giữa màn hình
        LGFrame.setVisible(true);//Cho phép hiện JFrame
        this.dispose();
    }//GEN-LAST:event_LoginActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BackGround;
    private javax.swing.JCheckBox Check_Condition;
    private javax.swing.JLabel Confirm_Password;
    private javax.swing.JPasswordField Confirm_Password_Fill;
    private javax.swing.JButton Confirm_SignUp;
    private javax.swing.JLabel Email;
    private javax.swing.JTextField Email_Fill;
    private javax.swing.JLabel Full_Name;
    private javax.swing.JTextField Full_Name_Fill;
    private javax.swing.JLabel Have_An_Account;
    private javax.swing.JButton Login;
    private javax.swing.JPanel Nen_duoi;
    private javax.swing.JPanel Nen_tren;
    private javax.swing.JLabel Password;
    private javax.swing.JPasswordField Password_Fill;
    private javax.swing.JLabel SignUp;
    // End of variables declaration//GEN-END:variables
}

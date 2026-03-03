package storage.view;

import java.awt.Color;
import java.sql.*;
import javax.swing.JOptionPane;

public class LoginPage extends javax.swing.JFrame {

    public LoginPage() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel10 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        panelKiri = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Parent = new javax.swing.JPanel();
        panelLogin = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cBox = new javax.swing.JCheckBox();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        panelRegister = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        cBoxSU = new javax.swing.JCheckBox();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();

        jLabel10.setText("jLabel10");

        jLabel22.setText("jLabel22");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login Page");
        getContentPane().setLayout(null);

        panelKiri.setBackground(new java.awt.Color(0, 102, 102));
        panelKiri.setMinimumSize(new java.awt.Dimension(350, 600));
        panelKiri.setLayout(null);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("INVENTORY");
        panelKiri.add(jLabel7);
        jLabel7.setBounds(90, 270, 138, 32);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("MANAGEMENT");
        panelKiri.add(jLabel8);
        jLabel8.setBounds(70, 300, 175, 32);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("SYSTEM");
        panelKiri.add(jLabel9);
        jLabel9.setBounds(110, 330, 100, 32);

        jLabel5.setBackground(new java.awt.Color(204, 204, 204));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Made By Kelompok 5");
        panelKiri.add(jLabel5);
        jLabel5.setBounds(90, 440, 140, 20);

        getContentPane().add(panelKiri);
        panelKiri.setBounds(0, 0, 340, 600);

        Parent.setBackground(Color.WHITE);
        Parent.setPreferredSize(new java.awt.Dimension(460, 600));
        Parent.setLayout(new java.awt.CardLayout());

        panelLogin.setBackground(new java.awt.Color(255, 255, 255));
        panelLogin.setPreferredSize(new java.awt.Dimension(460, 600));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Welcome Back");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("SIGN IN");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("USERNAME");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("PASSWORD");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/user.png"))); // NOI18N

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/pass.png"))); // NOI18N

        cBox.setBackground(new java.awt.Color(255, 255, 255));
        cBox.setText("View Password");
        cBox.setFocusPainted(false);
        cBox.addActionListener(this::cBoxActionPerformed);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Don't have an account?");

        jLabel14.setText("<html><font color='#006666'><u><b>Register</b></u></font></html>");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel14MouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelLoginLayout = new javax.swing.GroupLayout(panelLogin);
        panelLogin.setLayout(panelLoginLayout);
        panelLoginLayout.setHorizontalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGap(71, 339, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLoginLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(cBox)
                .addGap(79, 79, 79))
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelLoginLayout.setVerticalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(38, 38, 38)
                .addComponent(jLabel3)
                .addGap(24, 24, 24)
                .addComponent(jLabel11)
                .addGap(28, 28, 28)
                .addComponent(jLabel4)
                .addGap(24, 24, 24)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cBox)
                .addGap(66, 66, 66)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(248, Short.MAX_VALUE))
        );

        Parent.add(panelLogin, "card2");

        panelRegister.setBackground(new java.awt.Color(255, 255, 255));
        panelRegister.setForeground(new java.awt.Color(0, 102, 102));
        panelRegister.setPreferredSize(new java.awt.Dimension(460, 600));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Create Your Account");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 102, 102));
        jLabel16.setText("SIGN UP");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setText("USERNAME");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setText("EMAIL");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setText("PASSWORD");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel20.setText("CONFIRM PASSWORD");

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/user.png"))); // NOI18N

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Gmail.png"))); // NOI18N

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/pass.png"))); // NOI18N

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/pass.png"))); // NOI18N

        cBoxSU.setBackground(new java.awt.Color(255, 255, 255));
        cBoxSU.setText("View Passsword");
        cBoxSU.setFocusPainted(false);
        cBoxSU.addActionListener(this::cBoxSUActionPerformed);

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel26.setText("Already have an account?");

        jLabel27.setText("<html><font color='#006666'><u><b>Login</b></u></font></html>");
        jLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel27MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel27MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel27MouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelRegisterLayout = new javax.swing.GroupLayout(panelRegister);
        panelRegister.setLayout(panelRegisterLayout);
        panelRegisterLayout.setHorizontalGroup(
            panelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegisterLayout.createSequentialGroup()
                .addGroup(panelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelRegisterLayout.createSequentialGroup()
                        .addGroup(panelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRegisterLayout.createSequentialGroup()
                                .addGap(163, 163, 163)
                                .addComponent(jLabel16))
                            .addGroup(panelRegisterLayout.createSequentialGroup()
                                .addGap(143, 143, 143)
                                .addComponent(jLabel15))
                            .addGroup(panelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelRegisterLayout.createSequentialGroup()
                                    .addGap(57, 57, 57)
                                    .addGroup(panelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel17)
                                        .addComponent(jLabel19)
                                        .addComponent(jLabel20)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegisterLayout.createSequentialGroup()
                                    .addGap(64, 64, 64)
                                    .addGroup(panelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegisterLayout.createSequentialGroup()
                                            .addComponent(jLabel21)
                                            .addGap(296, 296, 296))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegisterLayout.createSequentialGroup()
                                            .addComponent(jLabel23)
                                            .addGap(296, 296, 296))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegisterLayout.createSequentialGroup()
                                            .addComponent(jLabel24)
                                            .addGap(296, 296, 296)))))
                            .addGroup(panelRegisterLayout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(jLabel25)))
                        .addGap(4, 4, 4))
                    .addGroup(panelRegisterLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelRegisterLayout.createSequentialGroup()
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63))
                            .addComponent(cBoxSU))))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        panelRegisterLayout.setVerticalGroup(
            panelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegisterLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel25)
                    .addGroup(panelRegisterLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addGroup(panelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelRegisterLayout.createSequentialGroup()
                                .addGroup(panelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panelRegisterLayout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addGap(24, 24, 24)
                                        .addComponent(jLabel21)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel18)
                                        .addGap(24, 24, 24))
                                    .addComponent(jLabel23))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel19)
                                .addGap(24, 24, 24))
                            .addComponent(jLabel24))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel20)
                        .addGap(24, 24, 24)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cBoxSU)
                .addGap(42, 42, 42)
                .addGroup(panelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(198, Short.MAX_VALUE))
        );

        Parent.add(panelRegister, "card3");

        getContentPane().add(Parent);
        Parent.setBounds(340, 0, 460, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void roundedButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roundedButton1ActionPerformed
        String Username, Password, passDb = null, query;
        String SUrl, SUser, SPass;
        SUrl = "jdbc:mysql://localhost:3306/java_user_database";
        SUser = "root";
        SPass = "";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection(SUrl, SUser, SPass)) {
                String username = txtUsername.getText().trim();
                char[] passwordChars = txtPassword.getPassword();
                
                if (username.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Username tidak boleh kosong!", "Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                } else if (passwordChars.length == 0) {
                    JOptionPane.showMessageDialog(this, "Password tidak boleh kosong!", "Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                } else {
                    Username = txtUsername.getText();
                    Password = new String(passwordChars);
                    
                    query = "SELECT password FROM users WHERE username=?";
                    PreparedStatement pst = con.prepareStatement(query);
                    pst.setString(1, Username);
                    
                    ResultSet rs = pst.executeQuery();
                    
                    if (rs.next()) {
                        passDb = rs.getString("password");
                        
                        if (Password.equals(passDb)){
                            MainFrame mainFrame = new MainFrame();
                            mainFrame.setLocationRelativeTo(null);
                            mainFrame.setResizable(false);
                            mainFrame.setVisible(true);
                            this.dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "Password salah!");
                        }
                        
                    } else {
                        JOptionPane.showMessageDialog(null, "Username tidak ditemukan!");
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_roundedButton1ActionPerformed

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        txtUsername.setText("");
        txtPassword.setText("");
        
        cBox.setSelected(false);
        
        Parent.removeAll();
        Parent.add(panelRegister);
        Parent.repaint();
        Parent.revalidate();
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseEntered
        jLabel14.setText("<html><font color='#007878'><u><b>Register</b></u></font></html>");
    }//GEN-LAST:event_jLabel14MouseEntered

    private void jLabel14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseExited
        jLabel14.setText("<html><font color='#006666'><u><b>Register</b></u></font></html>");
    }//GEN-LAST:event_jLabel14MouseExited

    private void cBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cBoxActionPerformed
        if (cBox.isSelected()) {
            txtPassword.setEchoChar((char) 0);
        } else {
            txtPassword.setEchoChar('*');
        }
    }//GEN-LAST:event_cBoxActionPerformed

    private void jLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseClicked
        suUsername.setText("");
        suEmail.setText("");
        suPassword.setText("");
        suConPassword.setText("");
        
        cBoxSU.setSelected(false);
        
        Parent.removeAll();
        Parent.add(panelLogin);
        Parent.repaint();
        Parent.revalidate();
    }//GEN-LAST:event_jLabel27MouseClicked

    private void jLabel27MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseExited
        jLabel27.setText("<html><font color='#006666'><u><b>Login</b></u></font></html>");
    }//GEN-LAST:event_jLabel27MouseExited

    private void jLabel27MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseEntered
        jLabel27.setText("<html><font color='#007878'><u><b>Login</b></u></font></html>");
    }//GEN-LAST:event_jLabel27MouseEntered

    private void cBoxSUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cBoxSUActionPerformed
        if (cBoxSU.isSelected()) {
            suPassword.setEchoChar((char) 0);
            suConPassword.setEchoChar((char) 0);
        } else {
            suPassword.setEchoChar('*');
            suConPassword.setEchoChar('*');
        }
    }//GEN-LAST:event_cBoxSUActionPerformed

    private void suPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suPasswordActionPerformed
       
    }//GEN-LAST:event_suPasswordActionPerformed

    private void btnSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignUpActionPerformed
        String Username, Password, conPassword, Email;
        String SUrl, SUser, SPass;
        SUrl = "jdbc:mysql://localhost:3306/java_user_database";
        SUser = "root";
        SPass = "";
        
        Username = suUsername.getText();
        Email = suEmail.getText();
        Password = new String(suPassword.getPassword());
        conPassword = new String(suConPassword.getPassword());
        
        if (Username.isEmpty() || Email.isEmpty() || Password.isEmpty() || conPassword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mohon isi semua data!", "Error",
                        JOptionPane.ERROR_MESSAGE
                        );
        } else if (!isValidEmail(Email)) {
            JOptionPane.showMessageDialog(this, "Format email tidak valid!\nContoh: nama@email.com", "Error",
                JOptionPane.ERROR_MESSAGE);
            suEmail.setText("");
        } else if (!Password.equals(conPassword)) {
            JOptionPane.showMessageDialog(this, "Password tidak sama!", "Error",
                        JOptionPane.ERROR_MESSAGE
                        );
            suPassword.setText("");
            suConPassword.setText("");
        } else {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                try (Connection con = DriverManager.getConnection(SUrl, SUser, SPass)) {
                    String checkQuery = "SELECT * FROM users WHERE username =? OR email=?";
                    PreparedStatement pst = con.prepareStatement(checkQuery);
                    pst.setString(1, Username);
                    pst.setString(2, Email);
                    ResultSet rs = pst.executeQuery();
                    
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(this, "Username atau Email sudah terdaftar!", "Error",
                                JOptionPane.ERROR_MESSAGE
                        );
                    } else {
                        String insertQuery = "INSERT INTO users (username, email, password) VALUES (?,?,?)";
                        PreparedStatement pstInsert = con.prepareStatement(insertQuery);
                        pstInsert.setString(1, Username);
                        pstInsert.setString(2, Email);
                        pstInsert.setString(3, Password);
                        
                        int row = pstInsert.executeUpdate();
                        
                        if (row > 0) {
                            JOptionPane.showMessageDialog(this, "Registrasi Berhasil! Silakan Login.");
                            
                            suUsername.setText("");
                            suEmail.setText("");
                            suPassword.setText("");
                            suConPassword.setText("");
                            
                            Parent.removeAll();
                            Parent.add(panelLogin);
                            Parent.repaint();
                            Parent.revalidate();
                        }
                        
                    }
                }
            } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnSignUpActionPerformed

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(emailRegex);
    }
    
    public static void main(String args[]) {}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Parent;
    private javax.swing.JCheckBox cBox;
    private javax.swing.JCheckBox cBoxSU;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel panelKiri;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JPanel panelRegister;
    // End of variables declaration//GEN-END:variables
    
}
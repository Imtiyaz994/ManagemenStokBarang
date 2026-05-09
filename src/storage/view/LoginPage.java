package storage.view;

import java.awt.Color;
import java.sql.*;
import javax.swing.JOptionPane;
import storage.component.util.DBConnection;

// halaman login & register
public class LoginPage extends javax.swing.JFrame {

    public LoginPage() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelKiri = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        Parent = new javax.swing.JPanel();
        panelLogin = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cBox = new javax.swing.JCheckBox();
        jLabel13 = new javax.swing.JLabel();
        lblToRegister = new javax.swing.JLabel();
        txtUsername = new storage.component.ui.TextField();
        txtPassword = new storage.component.ui.PasswordField();
        jLabel6 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        btnSignUp = new storage.component.ui.RoundedButton();
        panelRegister = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        cBoxSU = new javax.swing.JCheckBox();
        jLabel26 = new javax.swing.JLabel();
        lblToLogin = new javax.swing.JLabel();
        suUsername = new storage.component.ui.TextField();
        suEmail = new storage.component.ui.TextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        suPassword = new storage.component.ui.PasswordField();
        jLabel32 = new javax.swing.JLabel();
        suConPassword = new storage.component.ui.PasswordField();
        jLabel33 = new javax.swing.JLabel();
        btnSignIn = new storage.component.ui.RoundedButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login Page");
        setPreferredSize(new java.awt.Dimension(820, 620));
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

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/storage/icon/Storage.png"))); // NOI18N
        panelKiri.add(jLabel29);
        jLabel29.setBounds(100, 110, 130, 170);

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

        cBox.setBackground(new java.awt.Color(255, 255, 255));
        cBox.setText("View Password");
        cBox.setFocusPainted(false);
        cBox.addActionListener(this::cBoxActionPerformed);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Don't have an account?");

        lblToRegister.setText("<html><font color='#006666'><u><b>Register</b></u></font></html>");
        lblToRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblToRegisterMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblToRegisterMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblToRegisterMouseExited(evt);
            }
        });

        txtUsername.addActionListener(this::txtUsernameActionPerformed);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/storage/icon/user.png"))); // NOI18N

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/storage/icon/pass.png"))); // NOI18N

        btnSignUp.setText("LOGIN");
        btnSignUp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSignUp.setRadius(30);
        btnSignUp.addActionListener(this::btnSignInActionPerformed);

        javax.swing.GroupLayout panelLoginLayout = new javax.swing.GroupLayout(panelLogin);
        panelLogin.setLayout(panelLoginLayout);
        panelLoginLayout.setHorizontalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)))
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(panelLoginLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(cBox)
                                        .addGroup(panelLoginLayout.createSequentialGroup()
                                            .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel28)
                                                .addComponent(jLabel6))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(panelLoginLayout.createSequentialGroup()
                                                    .addGap(30, 30, 30)
                                                    .addComponent(jLabel13)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(lblToRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addComponent(jLabel3)))))
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(btnSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        panelLoginLayout.setVerticalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(44, 44, 44)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLoginLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel6)))
                .addGap(34, 34, 34)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(cBox)
                .addGap(15, 15, 15)
                .addComponent(btnSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(lblToRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(164, Short.MAX_VALUE))
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

        cBoxSU.setBackground(new java.awt.Color(255, 255, 255));
        cBoxSU.setText("View Passsword");
        cBoxSU.setFocusPainted(false);
        cBoxSU.addActionListener(this::cBoxSUActionPerformed);

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel26.setText("Already have an account?");

        lblToLogin.setText("<html><font color='#006666'><u><b>Login</b></u></font></html>");
        lblToLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblToLoginMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblToLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblToLoginMouseExited(evt);
            }
        });

        suEmail.setLabelText("Email");
        suEmail.addActionListener(this::suEmailActionPerformed);

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/storage/icon/user.png"))); // NOI18N

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/storage/icon/Gmail.png"))); // NOI18N

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/storage/icon/pass.png"))); // NOI18N

        suConPassword.setLabelText("Confirm Password");

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/storage/icon/pass.png"))); // NOI18N

        btnSignIn.setText("REGISTER");
        btnSignIn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSignIn.setRadius(30);
        btnSignIn.addActionListener(this::btnSignInActionPerformed1);

        javax.swing.GroupLayout panelRegisterLayout = new javax.swing.GroupLayout(panelRegister);
        panelRegister.setLayout(panelRegisterLayout);
        panelRegisterLayout.setHorizontalGroup(
            panelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegisterLayout.createSequentialGroup()
                .addGroup(panelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelRegisterLayout.createSequentialGroup()
                            .addGap(163, 163, 163)
                            .addComponent(jLabel16))
                        .addGroup(panelRegisterLayout.createSequentialGroup()
                            .addGap(143, 143, 143)
                            .addComponent(jLabel15))
                        .addGroup(panelRegisterLayout.createSequentialGroup()
                            .addGap(64, 64, 64)
                            .addGroup(panelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel17)
                                .addGroup(panelRegisterLayout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(jLabel30)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(suUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(panelRegisterLayout.createSequentialGroup()
                            .addGap(64, 64, 64)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelRegisterLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelRegisterLayout.createSequentialGroup()
                                .addComponent(jLabel33)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(suConPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel19)
                                .addGroup(panelRegisterLayout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(suEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel20))
                            .addGroup(panelRegisterLayout.createSequentialGroup()
                                .addComponent(jLabel32)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(suPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cBoxSU))))
                .addContainerGap(84, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegisterLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(panelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSignIn, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblToLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120))
        );
        panelRegisterLayout.setVerticalGroup(
            panelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegisterLayout.createSequentialGroup()
                .addGroup(panelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRegisterLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(suUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30))
                        .addGap(18, 23, Short.MAX_VALUE)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel31)
                            .addComponent(suEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(suPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(suConPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRegisterLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel33)))
                .addGap(18, 18, 18)
                .addComponent(cBoxSU)
                .addGap(24, 24, 24)
                .addComponent(btnSignIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblToLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        Parent.add(panelRegister, "card3");

        getContentPane().add(Parent);
        Parent.setBounds(340, 0, 460, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents
  
     // klik "Register" agar pindah ke panel register
    private void lblToRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblToRegisterMouseClicked
        txtUsername.setText("");
        txtPassword.setText("");
        
        cBox.setSelected(false);

        Parent.removeAll();
        Parent.add(panelRegister);
        Parent.repaint();
        Parent.revalidate();
    }//GEN-LAST:event_lblToRegisterMouseClicked

    // efek hover label Register (mengubah warna dari label)
    private void lblToRegisterMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblToRegisterMouseEntered
        lblToRegister.setText("<html><font color='#007878'><u><b>Register</b></u></font></html>");
    }//GEN-LAST:event_lblToRegisterMouseEntered

    private void lblToRegisterMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblToRegisterMouseExited
        lblToRegister.setText("<html><font color='#006666'><u><b>Register</b></u></font></html>");
    }//GEN-LAST:event_lblToRegisterMouseExited

     // checkbox show/hide password di login
    private void cBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cBoxActionPerformed
        if (cBox.isSelected()) {
            txtPassword.setEchoChar((char) 0);
        } else {
            txtPassword.setEchoChar('*');
        }
    }//GEN-LAST:event_cBoxActionPerformed
    
    // klik "Login" untuk balik ke panel login
    private void lblToLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblToLoginMouseClicked
        suUsername.setText("");
        suEmail.setText("");
        suPassword.setText("");
        suConPassword.setText("");

        cBoxSU.setSelected(false);

        Parent.removeAll();
        Parent.add(panelLogin);
        Parent.repaint();
        Parent.revalidate();
    }//GEN-LAST:event_lblToLoginMouseClicked

    // efek hover label Login
    private void lblToLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblToLoginMouseExited
        lblToLogin.setText("<html><font color='#006666'><u><b>Login</b></u></font></html>");
    }//GEN-LAST:event_lblToLoginMouseExited

    private void lblToLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblToLoginMouseEntered
        lblToLogin.setText("<html><font color='#007878'><u><b>Login</b></u></font></html>");
    }//GEN-LAST:event_lblToLoginMouseEntered

    private void cBoxSUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cBoxSUActionPerformed
        if (cBoxSU.isSelected()) {
            suPassword.setEchoChar((char) 0);
            suConPassword.setEchoChar((char) 0);
        } else {
            suPassword.setEchoChar('*');
            suConPassword.setEchoChar('*');
        }
    }//GEN-LAST:event_cBoxSUActionPerformed

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed

    }//GEN-LAST:event_txtUsernameActionPerformed

    private void suEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suEmailActionPerformed

    }//GEN-LAST:event_suEmailActionPerformed

    // proses login — cek username & password ke DB
    private void btnSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignInActionPerformed
        String Username, Password, passDb = null, query;

        try {
            try (Connection con = DBConnection.getConnection()) {
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

                    query = "SELECT password, role, status FROM users WHERE username=?";
                    PreparedStatement pst = con.prepareStatement(query);
                    pst.setString(1, Username);
 
                    ResultSet rs = pst.executeQuery();

                    if (rs.next()) {
                        passDb = rs.getString("password");
                        String role = rs.getString("role");
                        String status = rs.getString("status");
                        
                        if (status.equalsIgnoreCase("Inactive")) {
                            JOptionPane.showMessageDialog(null, "Akun kamu tidak aktif!");
                            return;
                        }

                        if (Password.equals(passDb)) {
                            
                            // login berhasil → buka MainFrame
                            MainFrame mainFrame = new MainFrame(role, username);
                            mainFrame.setSize(1190, 710);
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
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
          
    }//GEN-LAST:event_btnSignInActionPerformed
    
    // proses register — validasi input lalu simpan ke DB
    private void btnSignInActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignInActionPerformed1
        String Username, Password, conPassword, Email;
        
        Username = suUsername.getText();
        Email = suEmail.getText();
        Password = new String(suPassword.getPassword());
        conPassword = new String(suConPassword.getPassword());
        
        //validasi - validasi situasi jika teks kosong, format email salah, dan password tidak sama
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
                try (Connection con = DBConnection.getConnection()) {
                    // cek duplikat username atau email
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
                            
                            // balik ke panel login setelah selesai registrasi
                            Parent.removeAll();
                            Parent.add(panelLogin);
                            Parent.repaint();
                            Parent.revalidate();
                        }
                        
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnSignInActionPerformed1

     // validasi format email pakai regex
    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(emailRegex);
    }

    public static void main(String args[]) {}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Parent;
    private storage.component.ui.RoundedButton btnSignIn;
    private storage.component.ui.RoundedButton btnSignUp;
    private javax.swing.JCheckBox cBox;
    private javax.swing.JCheckBox cBoxSU;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblToLogin;
    private javax.swing.JLabel lblToRegister;
    private javax.swing.JPanel panelKiri;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JPanel panelRegister;
    private storage.component.ui.PasswordField suConPassword;
    private storage.component.ui.TextField suEmail;
    private storage.component.ui.PasswordField suPassword;
    private storage.component.ui.TextField suUsername;
    private storage.component.ui.PasswordField txtPassword;
    private storage.component.ui.TextField txtUsername;
    // End of variables declaration//GEN-END:variables

}

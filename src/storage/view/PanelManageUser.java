package storage.view;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

import java.sql.*;
import java.text.SimpleDateFormat;
import storage.component.util.DBConnection;
import storage.component.table.TableStyler;

public class PanelManageUser extends javax.swing.JPanel {
    
    private String selectedUsername = "";

    public PanelManageUser() {
        initComponents();
        TableStyler.style(userTable);
        btnUpdateUser.setEnabled(false);
        loadTableUser();
    }

    public void loadTableUser() {
    javax.swing.table.DefaultTableModel model = 
        (javax.swing.table.DefaultTableModel) userTable.getModel();
    model.setRowCount(0);
    try {
        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM users");
        while (rs.next()) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            String tanggal = sdf.format(rs.getTimestamp("created_at"));
            model.addRow(new Object[]{
                rs.getString("username"),
                rs.getString("email"),
                rs.getString("password"),
                rs.getString("role"),
                tanggal,
                rs.getString("status")
            });
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel21 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        panelUserDetails = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        checkPassword = new javax.swing.JCheckBox();
        jLabel28 = new javax.swing.JLabel();
        boxRole = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();
        boxStatus = new javax.swing.JComboBox<>();
        txtUsername = new storage.component.ui.TextField();
        txtEmail = new storage.component.ui.TextField();
        txtPassword = new storage.component.ui.PasswordField();
        txtConPassword = new storage.component.ui.PasswordField();
        btnDeleteUser = new storage.component.ui.RoundedButton();
        btnAddUser = new storage.component.ui.RoundedButton();
        btnUpdateUser = new storage.component.ui.RoundedButton();
        btnClearUser = new storage.component.ui.RoundedButton();
        jLabel31 = new javax.swing.JLabel();

        setBackground(Color.WHITE);
        setPreferredSize(new java.awt.Dimension(940, 710));
        setLayout(null);

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 102, 102));
        jLabel21.setText("MANAGE USER");
        add(jLabel21);
        jLabel21.setBounds(100, 30, 180, 32);

        userTable.setBackground(Color.WHITE);
        userTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Username", "Email", "Password", "Role", "Tanggal", "Status"
            }
        ));
        userTable.setFocusable(false);
        userTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userTableMouseClicked(evt);
            }
        });
        userTable.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                userTableComponentShown(evt);
            }
        });
        jScrollPane2.setViewportView(userTable);

        add(jScrollPane2);
        jScrollPane2.setBounds(24, 118, 490, 510);

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setText("User Table");
        add(jLabel22);
        jLabel22.setBounds(24, 86, 80, 20);

        jLabel23.setBackground(Color.WHITE);
        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 102, 102));
        jLabel23.setText("User Details");
        jLabel23.setOpaque(true);
        add(jLabel23);
        jLabel23.setBounds(570, 90, 90, 20);

        panelUserDetails.setBackground(Color.WHITE);
        panelUserDetails.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel24.setText("USERNAME");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel25.setText("EMAIL");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel26.setText("PASSWORD");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel27.setText("CONFIRM PASSWORD");

        checkPassword.setBackground(Color.WHITE);
        checkPassword.setText(" View Password");
        checkPassword.setFocusPainted(false);
        checkPassword.setFocusable(false);
        checkPassword.addActionListener(this::checkPasswordActionPerformed);

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel28.setText("ROLE");

        boxRole.setBackground(Color.WHITE);
        boxRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "User", "Admin" }));
        boxRole.setFocusable(false);

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel29.setText("STATUS");

        boxStatus.setBackground(Color.WHITE);
        boxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Inactive" }));
        boxStatus.setFocusable(false);

        txtEmail.setLabelText("Email");
        txtEmail.addActionListener(this::txtEmailActionPerformed);

        txtPassword.addActionListener(this::txtPasswordActionPerformed);

        txtConPassword.setLabelText("Confirm Password");

        javax.swing.GroupLayout panelUserDetailsLayout = new javax.swing.GroupLayout(panelUserDetails);
        panelUserDetails.setLayout(panelUserDetailsLayout);
        panelUserDetailsLayout.setHorizontalGroup(
            panelUserDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUserDetailsLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panelUserDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addComponent(jLabel26)
                    .addGroup(panelUserDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel24)
                        .addGroup(panelUserDetailsLayout.createSequentialGroup()
                            .addGroup(panelUserDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel29))
                            .addGap(33, 33, 33)
                            .addGroup(panelUserDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(boxRole, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(boxStatus, 0, 250, Short.MAX_VALUE)))
                        .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtConPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(checkPassword, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        panelUserDetailsLayout.setVerticalGroup(
            panelUserDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUserDetailsLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtConPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkPassword)
                .addGap(22, 22, 22)
                .addGroup(panelUserDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxRole, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28))
                .addGap(18, 18, 18)
                .addGroup(panelUserDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(boxStatus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        add(panelUserDetails);
        panelUserDetails.setBounds(542, 98, 370, 460);

        btnDeleteUser.setText("Delete");
        btnDeleteUser.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDeleteUser.setRadius(25);
        btnDeleteUser.addActionListener(this::btnDeleteUserActionPerformed);
        add(btnDeleteUser);
        btnDeleteUser.setBounds(830, 570, 90, 20);

        btnAddUser.setText("Add User");
        btnAddUser.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAddUser.setRadius(25);
        btnAddUser.addActionListener(this::btnAddUserActionPerformed);
        add(btnAddUser);
        btnAddUser.setBounds(530, 570, 90, 20);

        btnUpdateUser.setText("Update");
        btnUpdateUser.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUpdateUser.setRadius(25);
        btnUpdateUser.addActionListener(this::btnUpdateUserActionPerformed);
        add(btnUpdateUser);
        btnUpdateUser.setBounds(630, 570, 90, 20);

        btnClearUser.setText("Clear");
        btnClearUser.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnClearUser.setRadius(25);
        btnClearUser.addActionListener(this::btnClearUserActionPerformed);
        add(btnClearUser);
        btnClearUser.setBounds(730, 570, 90, 20);

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/storage/icon/group.png"))); // NOI18N
        add(jLabel31);
        jLabel31.setBounds(20, 20, 70, 64);
    }// </editor-fold>//GEN-END:initComponents

    private void userTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTableMouseClicked
        int index = userTable.getSelectedRow();
        TableModel model = userTable.getModel();
        if (index < 0) return;

        String username = model.getValueAt(index, 0).toString();
        txtUsername.setText(username);
        selectedUsername = username;

        String email = model.getValueAt(index, 1).toString();
        txtEmail.setText(email);

        String password = model.getValueAt(index, 2).toString();
        txtPassword.setText(password);

        String role = model.getValueAt(index, 3).toString();
        boxRole.setSelectedItem(role);

        String status = model.getValueAt(index, 5).toString();
        boxStatus.setSelectedItem(status);

        btnAddUser.setEnabled(false);
        btnUpdateUser.setEnabled(true);

        txtConPassword.setEnabled(false);
        txtConPassword.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_userTableMouseClicked

    private void userTableComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_userTableComponentShown
        loadTableUser();
    }//GEN-LAST:event_userTableComponentShown

    private void checkPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkPasswordActionPerformed
        if (checkPassword.isSelected()) {
            txtPassword.setEchoChar((char) 0);
            txtConPassword.setEchoChar((char) 0);
        } else {
            txtPassword.setEchoChar('*');
            txtConPassword.setEchoChar('*');
        }
    }//GEN-LAST:event_checkPasswordActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed

    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed

    }//GEN-LAST:event_txtPasswordActionPerformed

    private void btnDeleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteUserActionPerformed
        int confirm = JOptionPane.showConfirmDialog(null, "Yakin mau hapus user ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                Connection con = DBConnection.getConnection();

                String query = "DELETE FROM users WHERE username =?";
                PreparedStatement pst = con.prepareStatement(query);
                pst.setString(1, txtUsername.getText().trim());
                pst.executeUpdate();

                JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
                loadTableUser();

                txtUsername.setText("");
                txtEmail.setText("");
                txtPassword.setText("");
                txtConPassword.setText("");
                boxRole.setSelectedIndex(0);
                boxStatus.setSelectedIndex(0);
                btnAddUser.setEnabled(true);

                txtConPassword.setEnabled(true);
                txtConPassword.setBackground(new Color(255, 255, 255));

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_btnDeleteUserActionPerformed

    private void btnAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUserActionPerformed

        String username = txtUsername.getText().trim();
        String email = txtEmail.getText().trim();
        String password = new String (txtPassword.getPassword()).trim();
        String conPassword = new String (txtConPassword.getPassword()).trim();
        String role = boxRole.getSelectedItem().toString();
        String status = boxStatus.getSelectedItem().toString();

        if (username.isEmpty() || email.isEmpty() ||  password.isEmpty() || conPassword.isEmpty() || role.isEmpty() || status.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Semua Field Harus Diisi!");
            return;
        }

        if (!password.equals(conPassword)) {
            JOptionPane.showMessageDialog(null, "Password Harus Sama!");
            return;
        }

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement cek = con.prepareStatement("SELECT COUNT(*) FROM users WHERE username=? OR email=?");
            cek.setString(1, username);
            cek.setString(2, email);
            ResultSet rs = cek.executeQuery();
            rs.next();
            if (rs.getInt(1) > 0) {
                JOptionPane.showMessageDialog(null, "Username atau email sudah digunakan!");
                return;
            }

            String query = "INSERT INTO users (username, email, password, role, status) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, email);
            pst.setString(3, password);
            pst.setString(4,role);
            pst.setString(5, status);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "User berhasil ditambahkan!");
            loadTableUser();

            txtUsername.setText("");
            txtEmail.setText("");
            txtPassword.setText("");
            txtConPassword.setText("");
            boxRole.setSelectedIndex(0);
            boxStatus.setSelectedIndex(0);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnAddUserActionPerformed

    private void btnUpdateUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateUserActionPerformed

        String username = txtUsername.getText().trim();
        String email = txtEmail.getText().trim();
        String password = new String (txtPassword.getPassword()).trim();
        String role = boxRole.getSelectedItem().toString();
        String status = boxStatus.getSelectedItem().toString();

        if (username.isEmpty() || email.isEmpty() ||  password.isEmpty() || role.isEmpty() || status.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Semua Field Harus Diisi!");
            return;
        }

        try {
            Connection con = DBConnection.getConnection();

            String query = "UPDATE users SET username=?, email=?, password=?, role=?, status=? WHERE username=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, email);
            pst.setString(3, password);
            pst.setString(4, role);
            pst.setString(5, status);
            pst.setString(6, selectedUsername);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Data berhasil diupdate!");
            loadTableUser();

            txtUsername.setText("");
            txtEmail.setText("");
            txtPassword.setText("");
            txtConPassword.setText("");
            boxRole.setSelectedIndex(0);
            boxStatus.setSelectedIndex(0);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnUpdateUserActionPerformed

    private void btnClearUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearUserActionPerformed
        txtUsername.setText("");
        txtEmail.setText("");
        txtPassword.setText("");
        txtConPassword.setText("");

        boxRole.setSelectedIndex(0);
        boxStatus.setSelectedIndex(0);

        userTable.clearSelection();
        btnAddUser.setEnabled(true);
        btnUpdateUser.setEnabled(false);

        txtConPassword.setEnabled(true);
        txtConPassword.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_btnClearUserActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxRole;
    private javax.swing.JComboBox<String> boxStatus;
    private storage.component.ui.RoundedButton btnAddUser;
    private storage.component.ui.RoundedButton btnClearUser;
    private storage.component.ui.RoundedButton btnDeleteUser;
    private storage.component.ui.RoundedButton btnUpdateUser;
    private javax.swing.JCheckBox checkPassword;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelUserDetails;
    private storage.component.ui.PasswordField txtConPassword;
    private storage.component.ui.TextField txtEmail;
    private storage.component.ui.PasswordField txtPassword;
    private storage.component.ui.TextField txtUsername;
    private javax.swing.JTable userTable;
    // End of variables declaration//GEN-END:variables
}

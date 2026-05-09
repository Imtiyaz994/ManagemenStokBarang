package storage.view;

import javax.swing.JOptionPane;

// halaman utama — manajemen stok barang
public class MainFrame extends javax.swing.JFrame {
    
    private final String userRole;
    private final String username;
    
    public MainFrame(String role, String username) {
        this.userRole = role;
        this.username = username;
        initComponents(); 
    
        if (!userRole.equalsIgnoreCase("Admin")) {
            btnManageUser.setVisible(false);
        }
        
        Parent.add(new PanelDashboard());
        Parent.revalidate();
        Parent.repaint();
    }
         
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        sidebar = new javax.swing.JPanel();
        btnLogout = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        btnDashboard = new javax.swing.JButton();
        btnListBarang = new javax.swing.JButton();
        btnManageUser = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        btnRiwayat = new javax.swing.JButton();
        Parent = new javax.swing.JPanel();

        jTextField2.setText("jTextField2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Managemen Stok Barang");
        setBackground(new java.awt.Color(250, 250, 250));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(null);

        sidebar.setBackground(new java.awt.Color(0, 102, 102));
        sidebar.setLayout(null);

        btnLogout.setBackground(new java.awt.Color(0, 102, 102));
        btnLogout.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(250, 250, 250));
        btnLogout.setText("Logout");
        btnLogout.setFocusable(false);
        btnLogout.addActionListener(this::btnLogoutActionPerformed);
        sidebar.add(btnLogout);
        btnLogout.setBounds(60, 560, 120, 27);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("INVENTORY");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sidebar.add(jLabel2);
        jLabel2.setBounds(70, 130, 104, 25);
        sidebar.add(jSeparator2);
        jSeparator2.setBounds(40, 350, 160, 19);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("MANAGEMENT");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sidebar.add(jLabel7);
        jLabel7.setBounds(60, 160, 132, 25);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("SYSTEM");
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sidebar.add(jLabel8);
        jLabel8.setBounds(80, 190, 80, 25);
        sidebar.add(jSeparator3);
        jSeparator3.setBounds(40, 220, 160, 20);

        btnDashboard.setBackground(new java.awt.Color(0, 102, 102));
        btnDashboard.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDashboard.setForeground(new java.awt.Color(250, 250, 250));
        btnDashboard.setText("Home");
        btnDashboard.setFocusable(false);
        btnDashboard.addActionListener(this::btnDashboardActionPerformed);
        sidebar.add(btnDashboard);
        btnDashboard.setBounds(60, 230, 120, 27);

        btnListBarang.setBackground(new java.awt.Color(0, 102, 102));
        btnListBarang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnListBarang.setForeground(new java.awt.Color(250, 250, 250));
        btnListBarang.setText("List Barang");
        btnListBarang.setFocusable(false);
        btnListBarang.addActionListener(this::btnListBarangActionPerformed);
        sidebar.add(btnListBarang);
        btnListBarang.setBounds(60, 310, 120, 27);

        btnManageUser.setBackground(new java.awt.Color(0, 102, 102));
        btnManageUser.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnManageUser.setForeground(new java.awt.Color(250, 250, 250));
        btnManageUser.setText("Manage User");
        btnManageUser.setFocusable(false);
        btnManageUser.addActionListener(this::btnManageUserActionPerformed);
        sidebar.add(btnManageUser);
        btnManageUser.setBounds(60, 380, 120, 27);

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/storage/icon/truck.png"))); // NOI18N
        sidebar.add(jLabel32);
        jLabel32.setBounds(80, 40, 110, 80);

        btnRiwayat.setBackground(new java.awt.Color(0, 102, 102));
        btnRiwayat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnRiwayat.setForeground(new java.awt.Color(250, 250, 250));
        btnRiwayat.setText("Riwayat");
        btnRiwayat.setFocusable(false);
        btnRiwayat.addActionListener(this::btnRiwayatActionPerformed);
        sidebar.add(btnRiwayat);
        btnRiwayat.setBounds(60, 270, 120, 27);

        getContentPane().add(sidebar);
        sidebar.setBounds(0, 0, 248, 1275);

        Parent.setBackground(new java.awt.Color(255, 255, 255));
        Parent.setLayout(new java.awt.BorderLayout());
        getContentPane().add(Parent);
        Parent.setBounds(250, 0, 940, 710);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // konfirmasi logout sebelum balik ke login
    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        int confirm = JOptionPane.showConfirmDialog(null, "Yakin mau logout?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            LoginPage login = new LoginPage();
            login.setSize(810, 610);
            login.setLocationRelativeTo(null);
            login.setResizable(false);
            login.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashboardActionPerformed
        Parent.removeAll();
        Parent.add(new PanelDashboard());
        Parent.repaint();
        Parent.revalidate();
         
    }//GEN-LAST:event_btnDashboardActionPerformed

    private void btnListBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListBarangActionPerformed
        Parent.removeAll();
        Parent.add(new PanelListBarang(username));
        Parent.repaint();
        Parent.revalidate();
        
    }//GEN-LAST:event_btnListBarangActionPerformed

    private void btnManageUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageUserActionPerformed
        Parent.removeAll();
        Parent.add(new PanelManageUser());
        Parent.repaint();
        Parent.revalidate();
    }//GEN-LAST:event_btnManageUserActionPerformed

    private void btnRiwayatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRiwayatActionPerformed
        Parent.removeAll();
        Parent.add(new PanelRiwayat());
        Parent.repaint();
        Parent.revalidate();
    }//GEN-LAST:event_btnRiwayatActionPerformed

    public static void main(String args[]) {}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Parent;
    private javax.swing.JButton btnDashboard;
    private javax.swing.JButton btnListBarang;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnManageUser;
    private javax.swing.JButton btnRiwayat;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JPanel sidebar;
    // End of variables declaration//GEN-END:variables
}

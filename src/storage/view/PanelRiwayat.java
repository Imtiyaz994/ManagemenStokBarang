package storage.view;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.SimpleDateFormat;

import storage.component.DBConnection;
import storage.component.EventCallBack;
import storage.component.EventTextField;
import storage.component.TableStyler;

public class PanelRiwayat extends javax.swing.JPanel {

    public PanelRiwayat() {
        initComponents();
        TableStyler.style(tableRiwayat);
        loadTableRiwayat();
        
        textFieldAnimation.addEvent(new EventTextField() {

            @Override
            public void onPressed(EventCallBack call) {

                try {

                    // Simulasi loading search
                    Thread.sleep(1000);

                    call.done();

                } catch (Exception e) {
                    System.err.println(e);
                }
            }

            @Override
            public void onCancel() {

            }
        });
    }
    
    public void loadTableRiwayat () {
        DefaultTableModel model = (DefaultTableModel) tableRiwayat.getModel();
        model.setRowCount(0);
        
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM riwayat");
            
            while (rs.next()) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
                String tanggal = sdf.format(rs.getTimestamp("tanggal"));
                model.addRow(new Object[]{
                    rs.getString("nama"),
                    rs.getString("kode"),
                    rs.getString("jenis"),
                    rs.getString("stok"),
                    rs.getString("aksi"),
                    rs.getString("user_aksi"),
                    tanggal
                });
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableRiwayat = new javax.swing.JTable();
        cbxRiwayatHalaman = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textFieldAnimation = new storage.component.TextFieldAnimation();
        dateRiwayat = new com.toedter.calendar.JDateChooser();
        btnRiwayatRefresh = new javax.swing.JButton();
        menuUser1 = new storage.component.MenuUser();
        menuJenis2 = new storage.component.MenuJenis();
        menuAksi1 = new storage.component.MenuAksi();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(Color.WHITE);

        jPanel1.setBackground(Color.WHITE);
        jPanel1.setPreferredSize(new java.awt.Dimension(940, 710));
        jPanel1.setLayout(null);

        tableRiwayat.setBackground(Color.WHITE);
        tableRiwayat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nama", "Kode", "Jenis", "Stok", "Aksi", "User", "Tanggal"
            }
        ));
        jScrollPane1.setViewportView(tableRiwayat);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(30, 185, 880, 402);

        cbxRiwayatHalaman.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxRiwayatHalaman.addActionListener(this::cbxRiwayatHalamanActionPerformed);
        jPanel1.add(cbxRiwayatHalaman);
        cbxRiwayatHalaman.setBounds(838, 624, 72, 34);

        jLabel2.setText("Halaman");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(784, 633, 48, 16);

        jPanel2.setBackground(Color.WHITE);
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Riwayat Aktivitas");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(32, 24, 206, 57);

        textFieldAnimation.setAnimationColor(new java.awt.Color(0, 102, 102));
        textFieldAnimation.addActionListener(this::textFieldAnimationActionPerformed);
        jPanel2.add(textFieldAnimation);
        textFieldAnimation.setBounds(32, 87, 333, 43);
        jPanel2.add(dateRiwayat);
        dateRiwayat.setBounds(800, 90, 100, 38);

        btnRiwayatRefresh.setBackground(new java.awt.Color(242, 242, 242));
        btnRiwayatRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/storage/icon/Refresh.png"))); // NOI18N
        btnRiwayatRefresh.setBorder(null);
        btnRiwayatRefresh.addActionListener(this::btnRiwayatRefreshActionPerformed);
        jPanel2.add(btnRiwayatRefresh);
        btnRiwayatRefresh.setBounds(371, 87, 51, 43);
        jPanel2.add(menuUser1);
        menuUser1.setBounds(680, 90, 111, 38);
        jPanel2.add(menuJenis2);
        menuJenis2.setBounds(440, 90, 111, 38);
        jPanel2.add(menuAksi1);
        menuAksi1.setBounds(560, 90, 111, 38);
        jPanel2.add(jSeparator1);
        jSeparator1.setBounds(0, 217, 940, 3);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 940, 179);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void textFieldAnimationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldAnimationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldAnimationActionPerformed

    private void cbxRiwayatHalamanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxRiwayatHalamanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxRiwayatHalamanActionPerformed

    private void btnRiwayatRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRiwayatRefreshActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRiwayatRefreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRiwayatRefresh;
    private javax.swing.JComboBox<String> cbxRiwayatHalaman;
    private com.toedter.calendar.JDateChooser dateRiwayat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private storage.component.MenuAksi menuAksi1;
    private storage.component.MenuJenis menuJenis2;
    private storage.component.MenuUser menuUser1;
    private javax.swing.JTable tableRiwayat;
    private storage.component.TextFieldAnimation textFieldAnimation;
    // End of variables declaration//GEN-END:variables

}

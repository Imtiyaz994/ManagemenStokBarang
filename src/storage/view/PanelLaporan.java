package storage.view;

import java.sql.*;

import java.awt.Color;
import storage.component.table.TableStyler;

public class PanelLaporan extends javax.swing.JPanel {

    public PanelLaporan() {
        initComponents();
        TableStyler.style(tableRekap);
    }
    
    private void loadLaporan() {
        String kategori = (String) boxKategori.getSelectedItem();
        String dari     = (String) boxDari.getSelectedItem();
        String sampai   = (String) boxSampai.getSelectedItem();
        
        // Validasi tanggal
        String sqlDari, sqlSampai;
        try {
            java.text.SimpleDateFormat inputFmt = new java.text.SimpleDateFormat("dd/MM/yyyy");
            java.text.SimpleDateFormat sqlFmt   = new java.text.SimpleDateFormat("yyyy-MM-dd");
            java.util.Date tDari   = inputFmt.parse(dari);
            java.util.Date tSampai = inputFmt.parse(sampai);
 
            if (tDari.after(tSampai)) {
                jLabel2.setText("invalid");
                jLabel2.setForeground(new java.awt.Color(231, 23, 68));
                jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(
                    new java.awt.Color(231, 23, 68)));
                return;
            } else {
                jLabel2.setText("");
                jLabel2.setBorder(null);
            }
 
            sqlDari   = sqlFmt.format(tDari);
            sqlSampai = sqlFmt.format(tSampai);
 
        } catch (Exception ex) {
            jLabel2.setText("invalid");
            jLabel2.setForeground(new java.awt.Color(231, 23, 68));
            jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(
                new java.awt.Color(231, 23, 68)));
            return;
        }
 
        String whereKat = kategori.equalsIgnoreCase("Semua") ? "" : " AND jenis = '" + kategori + "'";
 
        try (Connection con = storage.component.util.DBConnection.getConnection();
             Statement st   = con.createStatement()) {
 
            ResultSet rs;
 
            // Total Barang
            rs = st.executeQuery("SELECT COUNT(*) AS total FROM barang WHERE 1=1" + whereKat);
            if (rs.next()) jLabel27.setText(String.valueOf(rs.getInt("total")));
 
            // Barang Masuk
            rs = st.executeQuery(
                "SELECT COALESCE(SUM(jumlah),0) AS total FROM transaksi " +
                "WHERE tipe='masuk' AND tanggal BETWEEN '" + sqlDari + "' AND '" + sqlSampai + "'" + whereKat);
            if (rs.next()) jLabel10.setText(String.valueOf(rs.getInt("total")));
 
            // Barang Keluar
            rs = st.executeQuery(
                "SELECT COALESCE(SUM(jumlah),0) AS total FROM transaksi " +
                "WHERE tipe='keluar' AND tanggal BETWEEN '" + sqlDari + "' AND '" + sqlSampai + "'" + whereKat);
            if (rs.next()) jLabel13.setText(String.valueOf(rs.getInt("total")));
 
            // Stok Menipis
            rs = st.executeQuery("SELECT COUNT(*) AS total FROM barang WHERE stok < 25" + whereKat);
            if (rs.next()) jLabel16.setText(String.valueOf(rs.getInt("total")));
 
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
 
        loadTabelRekap(kategori);
        tampilGrafik(sqlDari, sqlSampai);
    }
    
    private void loadTabelRekap(String kategori) {
        javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(
            new String[]{"Kode", "Nama Barang", "Kategori", "Stok"}, 0) {
            public boolean isCellEditable(int r, int c) { return false; }
        };
        tableRekap.setModel(model);
        TableStyler.style(tableRekap);
 
        String whereKat = kategori.equalsIgnoreCase("Semua") ? "" : " WHERE jenis = '" + kategori + "'";
 
        try (Connection con = storage.component.util.DBConnection.getConnection();
             Statement st   = con.createStatement();
             ResultSet rs   = st.executeQuery(
                 "SELECT kode, nama, jenis, stok FROM barang" + whereKat + " ORDER BY jenis, nama")) {
 
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("kode"),
                    rs.getString("nama"),
                    rs.getString("jenis"),
                    rs.getInt("stok")
                });
            }
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error tabel: " + e.getMessage());
        }
    }
    
    private void tampilGrafik(String dari, String sampai) {
        org.jfree.data.category.DefaultCategoryDataset dataset =
            new org.jfree.data.category.DefaultCategoryDataset();
 
        try (Connection con = storage.component.util.DBConnection.getConnection();
             Statement st   = con.createStatement()) {
 
            ResultSet rs = st.executeQuery(
                "SELECT TO_CHAR(tanggal,'Mon YYYY') AS bulan, " +
                "       DATE_TRUNC('month', tanggal) AS urutan, " +
                "       tipe, SUM(jumlah) AS total " +
                "FROM transaksi " +
                "WHERE tanggal BETWEEN '" + dari + "' AND '" + sampai + "' " +
                "GROUP BY DATE_TRUNC('month', tanggal), TO_CHAR(tanggal,'Mon YYYY'), tipe " +
                "ORDER BY urutan");
 
            while (rs.next()) {
                dataset.setValue(rs.getInt("total"),
                    rs.getString("tipe"), rs.getString("bulan"));
            }
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error grafik: " + e.getMessage());
        }
 
        org.jfree.chart.JFreeChart chart = org.jfree.chart.ChartFactory.createBarChart(
            "Grafik Bulanan", "Bulan", "Jumlah", dataset);
 
        org.jfree.chart.ChartPanel cp = new org.jfree.chart.ChartPanel(chart);
        panelGrafik.setLayout(new java.awt.BorderLayout());
        panelGrafik.removeAll();
        panelGrafik.add(jLabel29, java.awt.BorderLayout.NORTH);
        panelGrafik.add(cp, java.awt.BorderLayout.CENTER);
        panelGrafik.revalidate();
        panelGrafik.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        panelBox = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        boxPeriode = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        boxDari = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        boxSampai = new javax.swing.JComboBox<>();
        boxKategori = new javax.swing.JComboBox<>();
        panelBarang = new storage.component.ui.RoundedPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        panelMasuk = new storage.component.ui.RoundedPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        panelKeluar = new storage.component.ui.RoundedPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        panelMenipis = new storage.component.ui.RoundedPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        panelGrafik = new storage.component.ui.RoundedPanel();
        jLabel29 = new javax.swing.JLabel();
        panelRekap = new storage.component.ui.RoundedPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableRekap = new javax.swing.JTable();
        jLabel24 = new javax.swing.JLabel();
        roundedButton1 = new storage.component.ui.RoundedButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(940, 710));
        setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 19, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 102, 102));
        jLabel25.setText("LAPORAN / REPORT");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25)
                .addContainerGap(543, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        add(jPanel2);
        jPanel2.setBounds(0, 16, 725, 30);

        panelBox.setBackground(new java.awt.Color(255, 255, 255));
        panelBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        panelBox.setPreferredSize(new java.awt.Dimension(600, 100));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("PERIODE");

        jLabel2.setText("jLabel2");

        boxPeriode.setBackground(Color.WHITE);
        boxPeriode.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        boxPeriode.setForeground(new java.awt.Color(51, 51, 51));
        boxPeriode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bulanan", "Tahunan" }));
        boxPeriode.setFocusable(false);
        boxPeriode.setOpaque(true);
        boxPeriode.setPreferredSize(new java.awt.Dimension(120, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("DARI");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("SAMPAI");

        boxDari.setBackground(Color.WHITE);
        boxDari.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        boxDari.setForeground(new java.awt.Color(51, 51, 51));
        boxDari.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "30/04/2025" }));
        boxDari.setFocusable(false);
        boxDari.setOpaque(true);
        boxDari.setPreferredSize(new java.awt.Dimension(120, 30));
        boxDari.addActionListener(this::boxDariActionPerformed);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("KATEGORI");

        boxSampai.setBackground(Color.WHITE);
        boxSampai.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        boxSampai.setForeground(new java.awt.Color(51, 51, 51));
        boxSampai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01/04/2025" }));
        boxSampai.setFocusable(false);
        boxSampai.setOpaque(true);
        boxSampai.setPreferredSize(new java.awt.Dimension(120, 30));
        boxSampai.addActionListener(this::boxSampaiActionPerformed);

        boxKategori.setBackground(Color.WHITE);
        boxKategori.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        boxKategori.setForeground(new java.awt.Color(51, 51, 51));
        boxKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semua", "Elektronik", "ATK" }));
        boxKategori.setFocusable(false);
        boxKategori.setOpaque(true);
        boxKategori.setPreferredSize(new java.awt.Dimension(120, 30));
        boxKategori.addActionListener(this::boxKategoriActionPerformed);

        javax.swing.GroupLayout panelBoxLayout = new javax.swing.GroupLayout(panelBox);
        panelBox.setLayout(panelBoxLayout);
        panelBoxLayout.setHorizontalGroup(
            panelBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoxLayout.createSequentialGroup()
                .addGap(221, 221, 221)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelBoxLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panelBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(boxPeriode, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(80, 80, 80)
                .addGroup(panelBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBoxLayout.createSequentialGroup()
                        .addComponent(boxDari, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(boxSampai, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBoxLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(210, 210, 210)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(80, 80, 80)
                .addGroup(panelBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(boxKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)))
        );
        panelBoxLayout.setVerticalGroup(
            panelBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoxLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panelBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(panelBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(boxPeriode, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxDari, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxSampai, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(101, 101, 101)
                .addComponent(jLabel2))
        );

        add(panelBox);
        panelBox.setBounds(0, 60, 940, 90);

        panelBarang.setBackground(new Color(245, 245, 245));
        panelBarang.setLayout(null);

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 102, 102));
        jLabel26.setText("TOTAL BARANG");
        panelBarang.add(jLabel26);
        jLabel26.setBounds(10, 10, 100, 16);

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 102, 102));
        jLabel27.setText("246");
        panelBarang.add(jLabel27);
        jLabel27.setBounds(40, 30, 42, 32);

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 102, 102));
        jLabel28.setText("Item Terdaftar");
        panelBarang.add(jLabel28);
        jLabel28.setBounds(27, 75, 71, 15);

        add(panelBarang);
        panelBarang.setBounds(150, 180, 120, 100);

        panelMasuk.setBackground(new Color(245, 245, 245));
        panelMasuk.setLayout(null);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 102));
        jLabel9.setText("BARANG MASUK");
        panelMasuk.add(jLabel9);
        jLabel9.setBounds(10, 10, 100, 16);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 102, 102));
        jLabel10.setText("84");
        panelMasuk.add(jLabel10);
        jLabel10.setBounds(45, 30, 28, 32);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 102));
        jLabel11.setText("Bulan ini");
        jLabel11.setPreferredSize(new java.awt.Dimension(56, 15));
        panelMasuk.add(jLabel11);
        jLabel11.setBounds(40, 75, 46, 15);

        add(panelMasuk);
        panelMasuk.setBounds(310, 180, 120, 100);

        panelKeluar.setBackground(new Color(245, 245, 245));
        panelKeluar.setLayout(null);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(235, 110, 79));
        jLabel12.setText("BARANG KELUAR");
        panelKeluar.add(jLabel12);
        jLabel12.setBounds(10, 10, 110, 16);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 102));
        jLabel13.setText("57");
        panelKeluar.add(jLabel13);
        jLabel13.setBounds(45, 30, 30, 32);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 102, 102));
        jLabel14.setText("Bulan ini");
        panelKeluar.add(jLabel14);
        jLabel14.setBounds(40, 75, 46, 15);

        add(panelKeluar);
        panelKeluar.setBounds(470, 180, 120, 100);

        panelMenipis.setBackground(new Color(245, 245, 245));
        panelMenipis.setLayout(null);

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(252, 184, 49));
        jLabel15.setText("STOK MENIPIS");
        panelMenipis.add(jLabel15);
        jLabel15.setBounds(17, 10, 82, 16);

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 102, 102));
        jLabel16.setText("57");
        panelMenipis.add(jLabel16);
        jLabel16.setBounds(45, 30, 28, 32);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 102, 102));
        jLabel17.setText("Bulan ini");
        panelMenipis.add(jLabel17);
        jLabel17.setBounds(40, 75, 46, 15);

        add(panelMenipis);
        panelMenipis.setBounds(630, 180, 120, 100);

        panelGrafik.setLayout(null);

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 102, 102));
        jLabel29.setText("Grafik Bulanan");
        panelGrafik.add(jLabel29);
        jLabel29.setBounds(20, 20, 110, 20);

        add(panelGrafik);
        panelGrafik.setBounds(20, 330, 360, 290);

        panelRekap.setBackground(new java.awt.Color(255, 255, 255));
        panelRekap.setLayout(null);

        tableRekap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"BRG-001", "Laptop Asus", "Elektronik", "32"},
                {"BRG-002", "Kertas A4  ", "ATK", "5"},
                {"BRG-003", "Mouse", "Elektronik", "14"},
                {"BRG-004 ", "Printer   ", " ATK", "2"}
            },
            new String [] {
                "Kode", "Nama Barang", "Kategori", "Stok"
            }
        ));
        jScrollPane1.setViewportView(tableRekap);

        panelRekap.add(jScrollPane1);
        jScrollPane1.setBounds(30, 50, 460, 230);

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 102, 102));
        jLabel24.setText("Rekap Stok Barang");
        panelRekap.add(jLabel24);
        jLabel24.setBounds(30, 20, 140, 20);

        add(panelRekap);
        panelRekap.setBounds(390, 330, 520, 290);

        roundedButton1.setText("Export CSV");
        roundedButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        roundedButton1.setRadius(10);
        add(roundedButton1);
        roundedButton1.setBounds(780, 20, 120, 30);
    }// </editor-fold>//GEN-END:initComponents

    private void boxDariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxDariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxDariActionPerformed

    private void boxSampaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxSampaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxSampaiActionPerformed

    private void boxKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxKategoriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxKategoriActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxDari;
    private javax.swing.JComboBox<String> boxKategori;
    private javax.swing.JComboBox<String> boxPeriode;
    private javax.swing.JComboBox<String> boxSampai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private storage.component.ui.RoundedPanel panelBarang;
    private javax.swing.JPanel panelBox;
    private storage.component.ui.RoundedPanel panelGrafik;
    private storage.component.ui.RoundedPanel panelKeluar;
    private storage.component.ui.RoundedPanel panelMasuk;
    private storage.component.ui.RoundedPanel panelMenipis;
    private storage.component.ui.RoundedPanel panelRekap;
    private storage.component.ui.RoundedButton roundedButton1;
    private javax.swing.JTable tableRekap;
    // End of variables declaration//GEN-END:variables
}

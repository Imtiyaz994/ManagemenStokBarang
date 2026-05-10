package storage.view;

import storage.component.ui.RoundedPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import java.sql.*;
import storage.component.table.TableStyler;

public class PanelDashboard extends javax.swing.JPanel {

    public PanelDashboard() {
        initComponents();
        loadDashboard();
    }
    
    // load semua componen panel sekaligus
    private void loadDashboard() {
        loadcard();
        tampilGrafik();
        TableStyler.style(tableRekap);
        loadTabelBarang();
    }
    
    private void loadcard() {
        try {
            Connection con = storage.component.util.DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs;
            
            //Card total item
            rs = st.executeQuery("SELECT COUNT(*) as total FROM barang");
            if (rs.next()) {
                jLabel40.setText(String.valueOf(rs.getInt("total")));
            }
            
            //Card Low Stok
            rs = st.executeQuery("SELECT COUNT(*) as total FROM barang WHERE stok < 25");
            if (rs.next()) {
                jLabel33.setText(String.valueOf(rs.getInt("total")));
            }
            //Card Jenis Barang
            rs = st.executeQuery("SELECT COUNT(DISTINCT jenis) as total FROM barang");
            if (rs.next()) {
                jLabel35.setText(String.valueOf(rs.getInt("total")));
            }
            
            // card total item, jumlah semua unit
            rs = st.executeQuery("SELECT SUM(stok) as total FROM barang");
            if (rs.next()) {
                jLabel38.setText(String.valueOf(rs.getInt("total")));
            }
            
            con.close();
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null,"Error load statistik : " + e.getMessage());
        }
    }
    
    // grafik batang stop per jenis
    private void tampilGrafik() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        try {
            Connection con = storage.component.util.DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT jenis, SUM(stok) as total FROM barang GROUP BY jenis");
            while (rs.next()) {
                dataset.setValue(rs.getInt("total"), "Stok", rs.getString("jenis"));
            } 
            con.close();
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error load grafik: " + e.getMessage());
        }
        JFreeChart chart = ChartFactory.createBarChart ("Stok Barang", "Jenis", "Jumlah", dataset);
        
        ChartPanel cp = new ChartPanel(chart);
        panelgrafik.setLayout(new BorderLayout());
        panelgrafik.removeAll();
        panelgrafik.add(cp, BorderLayout.CENTER);
        panelgrafik.revalidate();
        panelgrafik.repaint();
    }
    
    // load tabel barang
    private void loadTabelBarang() {
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tableRekap.getModel();
        model.setRowCount(0); 
        
        try {
            Connection con = storage.component.util.DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT nama, kode, stok FROM barang WHERE stok < 25 ORDER BY stok ASC");
            while (rs.next()) {
                model.addRow(new Object[] {
                    rs.getString("nama"), 
                    rs.getString("kode"), 
                    rs.getInt("stok")
                });
            } 
            con.close();
        }
        catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error load tabel:" + e.getMessage());
        }
    }

    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TotalItem = new RoundedPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        panelgrafik = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableRekap = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        LowStok = new RoundedPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        JenisBarang = new RoundedPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        TotalStok = new RoundedPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        Refresh = new javax.swing.JButton();

        setBackground(Color.WHITE);
        setPreferredSize(new java.awt.Dimension(940, 710));
        setLayout(null);

        TotalItem.setBackground(new java.awt.Color(0, 102, 102));
        TotalItem.setMinimumSize(new java.awt.Dimension(170, 120));
        TotalItem.setPreferredSize(new java.awt.Dimension(200, 110));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Total Item");

        jLabel40.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("30");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Jenis Barang");

        javax.swing.GroupLayout TotalItemLayout = new javax.swing.GroupLayout(TotalItem);
        TotalItem.setLayout(TotalItemLayout);
        TotalItemLayout.setHorizontalGroup(
            TotalItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TotalItemLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(TotalItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel40)
                    .addComponent(jLabel17))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        TotalItemLayout.setVerticalGroup(
            TotalItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TotalItemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        add(TotalItem);
        TotalItem.setBounds(30, 90, 160, 110);

        panelgrafik.setBackground(new java.awt.Color(255, 255, 255));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 102, 102));
        jLabel20.setText("Stok Jenis Barang");

        javax.swing.GroupLayout panelgrafikLayout = new javax.swing.GroupLayout(panelgrafik);
        panelgrafik.setLayout(panelgrafikLayout);
        panelgrafikLayout.setHorizontalGroup(
            panelgrafikLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelgrafikLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel20)
                .addContainerGap(190, Short.MAX_VALUE))
        );
        panelgrafikLayout.setVerticalGroup(
            panelgrafikLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelgrafikLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addContainerGap(234, Short.MAX_VALUE))
        );

        add(panelgrafik);
        panelgrafik.setBounds(30, 280, 320, 260);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        tableRekap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nama", "Kode", "Stok"
            }
        ));
        jScrollPane3.setViewportView(tableRekap);

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 102, 102));
        jLabel21.setText("Barang Stok Menipis");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        add(jPanel8);
        jPanel8.setBounds(410, 280, 320, 270);

        LowStok.setBackground(new java.awt.Color(231, 23, 68));
        LowStok.setMinimumSize(new java.awt.Dimension(170, 120));
        LowStok.setPreferredSize(new java.awt.Dimension(200, 110));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Low Stok");

        jLabel33.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("30");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Stok < 25");

        javax.swing.GroupLayout LowStokLayout = new javax.swing.GroupLayout(LowStok);
        LowStok.setLayout(LowStokLayout);
        LowStokLayout.setHorizontalGroup(
            LowStokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LowStokLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(LowStokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jLabel33)
                    .addComponent(jLabel18))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        LowStokLayout.setVerticalGroup(
            LowStokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LowStokLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        add(LowStok);
        LowStok.setBounds(220, 90, 160, 110);

        JenisBarang.setBackground(new java.awt.Color(37, 89, 192));
        JenisBarang.setMinimumSize(new java.awt.Dimension(170, 120));
        JenisBarang.setPreferredSize(new java.awt.Dimension(200, 110));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Jenis Barang");

        jLabel35.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("30");

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Kategori");

        javax.swing.GroupLayout JenisBarangLayout = new javax.swing.GroupLayout(JenisBarang);
        JenisBarang.setLayout(JenisBarangLayout);
        JenisBarangLayout.setHorizontalGroup(
            JenisBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JenisBarangLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(JenisBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36)
                    .addComponent(jLabel35)
                    .addComponent(jLabel34))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        JenisBarangLayout.setVerticalGroup(
            JenisBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JenisBarangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel36)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        add(JenisBarang);
        JenisBarang.setBounds(410, 90, 160, 110);

        TotalStok.setBackground(new java.awt.Color(91, 221, 9));
        TotalStok.setMinimumSize(new java.awt.Dimension(170, 120));
        TotalStok.setPreferredSize(new java.awt.Dimension(200, 110));

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Total Stok");

        jLabel38.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("30");

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Unit Tersedia");

        javax.swing.GroupLayout TotalStokLayout = new javax.swing.GroupLayout(TotalStok);
        TotalStok.setLayout(TotalStokLayout);
        TotalStokLayout.setHorizontalGroup(
            TotalStokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TotalStokLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(TotalStokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel39)
                    .addComponent(jLabel38)
                    .addComponent(jLabel37))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        TotalStokLayout.setVerticalGroup(
            TotalStokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TotalStokLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel39)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        add(TotalStok);
        TotalStok.setBounds(600, 90, 160, 110);

        Refresh.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        Refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/storage/icon/Refresh.png"))); // NOI18N
        Refresh.setText("Refresh");
        Refresh.addActionListener(this::RefreshActionPerformed);
        add(Refresh);
        Refresh.setBounds(630, 30, 130, 32);
    }// </editor-fold>//GEN-END:initComponents

    // refresh semua data dash board
    private void RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshActionPerformed
        loadDashboard();
    }//GEN-LAST:event_RefreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JenisBarang;
    private javax.swing.JPanel LowStok;
    private javax.swing.JButton Refresh;
    private javax.swing.JPanel TotalItem;
    private javax.swing.JPanel TotalStok;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel panelgrafik;
    private javax.swing.JTable tableRekap;
    // End of variables declaration//GEN-END:variables
}

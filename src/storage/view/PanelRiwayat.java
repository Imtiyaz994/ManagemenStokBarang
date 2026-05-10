package storage.view;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.SimpleDateFormat;

import storage.component.util.DBConnection;
import storage.component.util.EventCallBack;
import storage.component.util.EventTextField;
import storage.component.table.TableStyler;

public class PanelRiwayat extends javax.swing.JPanel {
    int currentPage = 1;
    int limit = 10;
    boolean isRefreshing = false; // flag mencegah filter terpicu saat refresh
   
    public PanelRiwayat() {
        initComponents();
        TableStyler.style(tableRiwayat);
        loadUserCombo();
        loadJenisCombo();
        loadAksiCombo();
        loadHalaman();
        loadTableRiwayat();;
        
        // filter tabel berdasarkan opsi
        cbcxJenis.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String jenis = cbcxJenis.getSelectedItem().toString();
                filterByJenis(jenis);
            }
        });
        
        cbxAksi.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String aksi = cbxAksi.getSelectedItem().toString();
                filterByAksi(aksi);
            }
        });
        
        cbxUser.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (isRefreshing) return;
    
                String user = cbxUser.getSelectedItem().toString();
                filterByUser(user);
            }
        });
        
        dateChooser.addPropertyChangeListener(evt -> {
            if ("date".equals(evt.getPropertyName())) {
                filterByTanggal();
            }
        });       
        
        // melakukan search saat tekan enter
        searchBar.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                    if (isRefreshing) return;
                    currentPage = 1;
                    String keyword = searchBar.getText().trim();
                    searchRiwayat(keyword);
                }
            }
        });
        
        // melakukan search saat klik button search
        searchBar.addEvent(new EventTextField() {
            @Override
            public void onPressed(EventCallBack call) {
                javax.swing.SwingUtilities.invokeLater(() -> {
                    String keyword = searchBar.getText().trim();
                    currentPage = 1;
                    searchRiwayat(keyword);
                });
                call.done(); 
            }
            @Override
            public void onCancel() {
            }
         });
    }
    
    // load data ke tabel
    public void loadTableRiwayat() {
        DefaultTableModel model = (DefaultTableModel) tableRiwayat.getModel();
        model.setRowCount(0);
        
        try {
            Connection con = DBConnection.getConnection();
            String sql =  "SELECT * FROM riwayat " +  "ORDER BY tanggal DESC " +  "LIMIT ? OFFSET ?";
            PreparedStatement ps = con.prepareStatement(sql);
            int offset = (currentPage - 1) * limit;
            ps.setInt(1, limit);
            ps.setInt(2, offset);
            ResultSet rs = ps.executeQuery();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
                    
            while (rs.next()) {
                String tanggal = sdf.format(rs.getTimestamp("tanggal"));
                model.addRow(new Object[]{
                    rs.getString("nama"), 
                    rs.getString("kode"), 
                    rs.getString("jenis"),
                    rs.getString("jenis"), 
                    rs.getString("aksi"), 
                    rs.getString("user_aksi"), 
                    tanggal
                });
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    // set semua combox berdasarkan data yg ada
    public void loadUserCombo() {
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT username FROM users");                
            cbxUser.removeAllItems();
            
            while (rs.next()) {
                cbxUser.addItem(rs.getString("username"));  
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void loadJenisCombo() {
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs =  st.executeQuery("SELECT DISTINCT jenis FROM riwayat");             
            cbcxJenis.removeAllItems();
            
            while (rs.next()) {
                cbcxJenis.addItem(rs.getString("jenis"));   
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void loadAksiCombo() {
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT DISTINCT aksi FROM riwayat");
            cbxAksi.removeAllItems();

            while (rs.next()) {
                cbxAksi.addItem(rs.getString("aksi"));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    // filter tabel berdasarkan jenis, user, aksi, tanggal
    public void filterByJenis(String jenis) {
        DefaultTableModel model = (DefaultTableModel) tableRiwayat.getModel();
        model.setRowCount(0);

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps;

            if (jenis.equalsIgnoreCase("Semua")) {
                ps = con.prepareStatement( "SELECT * FROM riwayat");                
            } else {
                ps = con.prepareStatement("SELECT * FROM riwayat WHERE jenis = ?");
                ps.setString(1, jenis);
            }

            ResultSet rs = ps.executeQuery();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
                    
            while (rs.next()) {
                String tanggal = sdf.format(rs.getTimestamp("tanggal"));               
                model.addRow(new Object[]{rs.getString("nama"), rs.getString("kode"), rs.getString("jenis"), 
                                          rs.getString("aksi"), rs.getString("user_aksi"), tanggal });    
             }       

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void filterByAksi(String aksi) {
        DefaultTableModel model = (DefaultTableModel) tableRiwayat.getModel();             
        model.setRowCount(0);

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps;

            if (aksi.equalsIgnoreCase("Semua")) {
                ps = con.prepareStatement( "SELECT * FROM riwayat");

            } else {
                ps = con.prepareStatement( "SELECT * FROM riwayat WHERE aksi = ?");
                ps.setString(1, aksi);
            }

            ResultSet rs = ps.executeQuery();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");

            while (rs.next()) {
                String tanggal = sdf.format(rs.getTimestamp("tanggal"));
                model.addRow(new Object[]{rs.getString("nama"),rs.getString("kode"),rs.getString("jenis"),
                                          rs.getString("stok"), rs.getString("aksi"), rs.getString("user_aksi"), tanggal  });
 
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void filterByUser(String user) {
        DefaultTableModel model = (DefaultTableModel) tableRiwayat.getModel();
        model.setRowCount(0);

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps;

            if (user.equalsIgnoreCase("Semua")) {
                ps = con.prepareStatement("SELECT * FROM riwayat");
                        
            } else {
                ps = con.prepareStatement("SELECT * FROM riwayat WHERE user_aksi = ?" );
                ps.setString(1, user);
            }

            ResultSet rs = ps.executeQuery();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
                    
            while (rs.next()) {
                String tanggal = sdf.format(rs.getTimestamp("tanggal"));
                        
                model.addRow(new Object[]{rs.getString("nama"), rs.getString("kode"), rs.getString("jenis"),
                                          rs.getString("stok"), rs.getString("aksi"), rs.getString("user_aksi"), tanggal});
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void filterByTanggal() {
        DefaultTableModel model = (DefaultTableModel) tableRiwayat.getModel();
        model.setRowCount(0);

        try {
            java.util.Date selectedDate = dateChooser.getDate();
            Connection con = DBConnection.getConnection();
            PreparedStatement ps;

            if (selectedDate == null) {
                ps = con.prepareStatement("SELECT * FROM riwayat");

            } else {
                java.sql.Date sqlDate = new java.sql.Date(selectedDate.getTime());
                ps = con.prepareStatement("SELECT * FROM riwayat WHERE DATE(tanggal) = ?");
                ps.setDate(1, sqlDate);
            }

            ResultSet rs = ps.executeQuery();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");

            while (rs.next()) {
                String tanggal = sdf.format(rs.getTimestamp("tanggal"));

                model.addRow(new Object[]{ rs.getString("nama"), rs.getString("kode"), rs.getString("jenis"),
                                           rs.getString("stok"), rs.getString("aksi"), rs.getString("user_aksi"), tanggal});
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    // cari riwayat berdasarkan keyword
    public void searchRiwayat(String keyword) {
        DefaultTableModel model = (DefaultTableModel) tableRiwayat.getModel();
        model.setRowCount(0);

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM riwayat " +
                "WHERE nama ILIKE ? " +
                "OR kode ILIKE ? " +
                "OR jenis ILIKE ? " +
                "OR aksi ILIKE ? " +
                "OR user_aksi ILIKE ? " +
                "ORDER BY tanggal DESC");

            String query = "%" + keyword + "%";
            ps.setString(1, query);
            ps.setString(2, query);
            ps.setString(3, query);
            ps.setString(4, query);
            ps.setString(5, query);
            ResultSet rs = ps.executeQuery();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");

            while (rs.next()) {
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
    
    // hitung total halaman berdasakan total riwayat
    public void loadHalaman() {
        cbxHalaman.removeAllItems();

        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM riwayat");
            
            int total = 0;
            if (rs.next()) {
                total = rs.getInt(1);
            }

            int totalPage = (int) Math.ceil((double) total / limit);

            if (totalPage == 0) {
                cbxHalaman.addItem("Halaman 1");
                cbxHalaman.setSelectedIndex(0);
                return;
            }

            for (int i = 1; i <= totalPage; i++) {
                cbxHalaman.addItem("Halaman " + i);
            }

            cbxHalaman.setSelectedIndex(0);

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
        cbxHalaman = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        dateChooser = new com.toedter.calendar.JDateChooser();
        jSeparator1 = new javax.swing.JSeparator();
        cbxAksi = new javax.swing.JComboBox<>();
        cbcxJenis = new javax.swing.JComboBox<>();
        cbxUser = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnRefresh = new storage.component.ui.RoundedButton();
        searchBar = new storage.component.ui.TextFieldAnimation();
        jLabel1 = new javax.swing.JLabel();

        setBackground(Color.WHITE);
        setPreferredSize(new java.awt.Dimension(940, 710));

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
        jScrollPane1.setBounds(20, 260, 850, 270);

        cbxHalaman.addActionListener(this::cbxHalamanActionPerformed);
        jPanel1.add(cbxHalaman);
        cbxHalaman.setBounds(770, 550, 100, 34);

        jPanel2.setBackground(Color.WHITE);
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel2.setLayout(null);
        jPanel2.add(dateChooser);
        dateChooser.setBounds(790, 40, 100, 40);
        jPanel2.add(jSeparator1);
        jSeparator1.setBounds(0, 217, 940, 3);

        cbxAksi.setBackground(Color.WHITE);
        cbxAksi.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cbxAksi.setForeground(new java.awt.Color(51, 51, 51));
        cbxAksi.setFocusable(false);
        cbxAksi.setOpaque(true);
        cbxAksi.setPreferredSize(new java.awt.Dimension(120, 30));
        cbxAksi.addActionListener(this::cbxAksiActionPerformed);
        jPanel2.add(cbxAksi);
        cbxAksi.setBounds(530, 40, 120, 40);

        cbcxJenis.setBackground(Color.WHITE);
        cbcxJenis.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cbcxJenis.setForeground(new java.awt.Color(51, 51, 51));
        cbcxJenis.setFocusable(false);
        cbcxJenis.setOpaque(true);
        cbcxJenis.setPreferredSize(new java.awt.Dimension(120, 30));
        cbcxJenis.addActionListener(this::cbcxJenisActionPerformed);
        jPanel2.add(cbcxJenis);
        cbcxJenis.setBounds(420, 40, 100, 40);

        cbxUser.setBackground(Color.WHITE);
        cbxUser.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cbxUser.setForeground(new java.awt.Color(51, 51, 51));
        cbxUser.setFocusable(false);
        cbxUser.setOpaque(true);
        cbxUser.setPreferredSize(new java.awt.Dimension(120, 30));
        cbxUser.addActionListener(this::cbxUserActionPerformed);
        jPanel2.add(cbxUser);
        cbxUser.setBounds(660, 40, 120, 40);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("USER");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(660, 20, 120, 16);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("JENIS");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(420, 20, 100, 16);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("AKSI");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(530, 20, 120, 16);

        btnRefresh.setBackground(new java.awt.Color(255, 255, 255));
        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/storage/icon/Refresh.png"))); // NOI18N
        btnRefresh.setBorderColor(new java.awt.Color(255, 255, 255));
        btnRefresh.setColor(new java.awt.Color(255, 255, 255));
        btnRefresh.setColorClick(new java.awt.Color(204, 204, 204));
        btnRefresh.setColorOver(new java.awt.Color(255, 255, 255));
        btnRefresh.addActionListener(this::btnRefreshActionPerformed);
        jPanel2.add(btnRefresh);
        btnRefresh.setBounds(20, 30, 43, 43);

        searchBar.setAnimationColor(new java.awt.Color(0, 102, 102));
        searchBar.addActionListener(this::searchBarActionPerformed);
        jPanel2.add(searchBar);
        searchBar.setBounds(70, 30, 333, 43);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 120, 900, 100);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Riwayat Aktivitas");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(30, 30, 206, 57);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBarActionPerformed

    }//GEN-LAST:event_searchBarActionPerformed

    // load tabel berdasarkan halam yg dipilih
    private void cbxHalamanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxHalamanActionPerformed
        try {
            Object selectedObj = cbxHalaman.getSelectedItem();
            if (selectedObj == null) return;

            String selected = selectedObj.toString();

            if (!selected.startsWith("Halaman")) return;

            String angka = selected.replace("Halaman", "").trim();

            if (angka.isEmpty()) return;

            currentPage = Integer.parseInt(angka);

            loadTableRiwayat();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error halaman: " + e.getMessage());
        }
    }//GEN-LAST:event_cbxHalamanActionPerformed

    private void cbcxJenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbcxJenisActionPerformed

    }//GEN-LAST:event_cbcxJenisActionPerformed

    // reset semua field dan filter ke default
    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        try {
            isRefreshing = true;
            currentPage = 1;
            searchBar.setText("");
            dateChooser.setDate(null);

            if (cbxUser.getItemCount() > 0) cbxUser.setSelectedIndex(0);
            if (cbxAksi.getItemCount() > 0) cbxAksi.setSelectedIndex(0);
            if (cbcxJenis.getItemCount() > 0) cbcxJenis.setSelectedIndex(0);

            loadHalaman();
            loadTableRiwayat();
            isRefreshing = false;

        } catch (Exception e) {
            isRefreshing = false;
            JOptionPane.showMessageDialog(this, "Gagal refresh: " + e.getMessage());
        }
    
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void cbxAksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxAksiActionPerformed

    }//GEN-LAST:event_cbxAksiActionPerformed

    private void cbxUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxUserActionPerformed

    }//GEN-LAST:event_cbxUserActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private storage.component.ui.RoundedButton btnRefresh;
    private javax.swing.JComboBox<String> cbcxJenis;
    private javax.swing.JComboBox<String> cbxAksi;
    private javax.swing.JComboBox<String> cbxHalaman;
    private javax.swing.JComboBox<String> cbxUser;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private storage.component.ui.TextFieldAnimation searchBar;
    private javax.swing.JTable tableRiwayat;
    // End of variables declaration//GEN-END:variables
}

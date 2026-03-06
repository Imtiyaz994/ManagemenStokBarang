package storage.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.table.TableModel;

// halaman utama — manajemen stok barang
public class MainFrame extends javax.swing.JFrame {
    
    public MainFrame() {
        initComponents();
        
        // styling header tabel
        //Mengubah warna background dan font dari table
        table.getTableHeader().setBackground(new Color(0, 102, 102)); 
        table.getTableHeader().setForeground(Color.WHITE); 
        table.getTableHeader().setPreferredSize(
                new Dimension(table.getTableHeader().getWidth(), 25)
        );
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        table.getTableHeader().setBackground(new Color(0,102,102));
        table.getTableHeader().setForeground(Color.WHITE);
        
        table.setRowHeight(25); 
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        
        loadTableData();
        btnEdit.setEnabled(false); //edit hanya aktif jika ada suatu row yang di pilih
    }
    
    // cek semua field sudah diisi dan stok berisi angka
    private boolean validasiFields (String formType) {
        boolean namaIsi = !txtNama.getText().trim().isEmpty();
        boolean kodeIsi = !txtKode.getText().trim().isEmpty();
        boolean infoIsi = !txtInfo.getText().trim().isEmpty();
        boolean stokIsi = !txtStok.getText().trim().isEmpty();

        boolean stokAngka = false;
        if (stokIsi) {
            try {
                int stokVal = Integer.parseInt(txtStok.getText().trim());
                stokAngka = stokVal >= 0; 
            } catch (NumberFormatException e) {
                stokAngka = false;
            }
        }

        if (formType.equals("edit") || formType.equals("tambah")) {
            return namaIsi && kodeIsi && infoIsi && stokAngka;
        }

        return false;
               
    }

    // ambil semua data dari DB dan tampilkan ke tabel
    private void loadTableData() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // tabel di kosongkan dahulu

        String SUrl = "jdbc:mysql://localhost:3306/java_user_database";
        String SUser = "root";
        String SPass = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(SUrl, SUser, SPass);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from barang");

            int totalItem = 0;
            int lowStock = 0;

            while (rs.next()) {
                int stok = rs.getInt("stok");
                model.addRow(new Object[]{
                    rs.getString("nama"),
                    rs.getString("kode"),
                    rs.getString("jenis"),
                    stok,
                    rs.getString("infoTambah")
                });
                totalItem++;
                if (stok < 5) lowStock++; // hitung barang yang stoknya mau habis
            }

            totalItemCount.setText(String.valueOf(totalItem)); 
            lowStockCount.setText(String.valueOf(lowStock));

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sidebar = new javax.swing.JPanel();
        btnLogout = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        Parent = new javax.swing.JPanel();
        panelListBarang = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        panelLowStok = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lowStockCount = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        panelTotalItem = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        totalItemCount = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        PanelInput = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        btnTambah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtInfo = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        lblStok = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtKode = new javax.swing.JTextField();
        txtStok = new javax.swing.JTextField();
        cbxJenis = new javax.swing.JComboBox<>();
        btnBatal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Managemen Stok Barang");
        setBackground(new java.awt.Color(250, 250, 250));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(1190, 710));
        getContentPane().setLayout(null);

        sidebar.setBackground(new java.awt.Color(0, 102, 102));

        btnLogout.setBackground(new java.awt.Color(0, 102, 102));
        btnLogout.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(250, 250, 250));
        btnLogout.setText("Logout");
        btnLogout.setFocusable(false);
        btnLogout.addActionListener(this::btnLogoutActionPerformed);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("INVENTORY");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("MANAGEMENT");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("SYSTEM");
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout sidebarLayout = new javax.swing.GroupLayout(sidebar);
        sidebar.setLayout(sidebarLayout);
        sidebarLayout.setHorizontalGroup(
            sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebarLayout.createSequentialGroup()
                .addGroup(sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sidebarLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(sidebarLayout.createSequentialGroup()
                                .addGroup(sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, sidebarLayout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(sidebarLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(sidebarLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        sidebarLayout.setVerticalGroup(
            sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebarLayout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btnLogout)
                .addGap(47, 47, 47)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(890, Short.MAX_VALUE))
        );

        getContentPane().add(sidebar);
        sidebar.setBounds(0, 0, 248, 1275);

        Parent.setBackground(new java.awt.Color(255, 255, 255));
        Parent.setLayout(new java.awt.CardLayout());

        panelListBarang.setBackground(Color.WHITE);
        panelListBarang.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("List Barang");
        panelListBarang.add(jLabel1);
        jLabel1.setBounds(30, 30, 127, 32);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama", "Kode", "Jenis", "Stok", "Info Tambahan"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setFocusable(false);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        table.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                tableComponentShown(evt);
            }
        });
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setResizable(false);
            table.getColumnModel().getColumn(1).setResizable(false);
            table.getColumnModel().getColumn(2).setResizable(false);
            table.getColumnModel().getColumn(3).setResizable(false);
            table.getColumnModel().getColumn(4).setResizable(false);
        }

        panelListBarang.add(jScrollPane1);
        jScrollPane1.setBounds(30, 80, 870, 320);

        panelLowStok.setBackground(new java.awt.Color(255, 255, 255));
        panelLowStok.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        panelLowStok.setLayout(null);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Low Stock");
        panelLowStok.add(jLabel3);
        jLabel3.setBounds(10, 0, 60, 16);

        lowStockCount.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lowStockCount.setText("0");
        panelLowStok.add(lowStockCount);
        lowStockCount.setBounds(10, 20, 37, 10);

        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        jPanel3.setLayout(null);

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Total Item");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(10, 0, 60, 16);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("0");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(10, 20, 37, 10);

        panelLowStok.add(jPanel3);
        jPanel3.setBounds(670, 30, 0, 0);

        panelListBarang.add(panelLowStok);
        panelLowStok.setBounds(790, 30, 110, 39);

        panelTotalItem.setBackground(new java.awt.Color(255, 255, 255));
        panelTotalItem.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        panelTotalItem.setLayout(null);

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Total Item");
        panelTotalItem.add(jLabel9);
        jLabel9.setBounds(10, 0, 60, 16);

        totalItemCount.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        totalItemCount.setText("0");
        panelTotalItem.add(totalItemCount);
        totalItemCount.setBounds(10, 20, 37, 10);

        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        jPanel5.setLayout(null);

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Total Item");
        jPanel5.add(jLabel11);
        jLabel11.setBounds(10, 0, 60, 16);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("0");
        jPanel5.add(jLabel12);
        jLabel12.setBounds(10, 20, 37, 10);

        panelTotalItem.add(jPanel5);
        jPanel5.setBounds(670, 30, 0, 0);

        panelListBarang.add(panelTotalItem);
        panelTotalItem.setBounds(640, 30, 110, 39);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("Input Data Barang");
        jLabel4.setOpaque(true);
        panelListBarang.add(jLabel4);
        jLabel4.setBounds(40, 410, 210, 30);

        PanelInput.setBackground(new java.awt.Color(255, 255, 255));
        PanelInput.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        PanelInput.setLayout(null);
        PanelInput.add(jSeparator1);
        jSeparator1.setBounds(10, 180, 850, 10);

        btnTambah.setBackground(new java.awt.Color(0, 102, 102));
        btnTambah.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTambah.setForeground(new java.awt.Color(255, 255, 255));
        btnTambah.setText("Tambah");
        btnTambah.setFocusable(false);
        btnTambah.addActionListener(this::btnTambahActionPerformed);
        PanelInput.add(btnTambah);
        btnTambah.setBounds(100, 190, 150, 30);

        btnHapus.setBackground(new java.awt.Color(255, 102, 102));
        btnHapus.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHapus.setForeground(new java.awt.Color(255, 255, 255));
        btnHapus.setText("Hapus");
        btnHapus.setFocusable(false);
        btnHapus.addActionListener(this::btnHapusActionPerformed);
        PanelInput.add(btnHapus);
        btnHapus.setBounds(650, 190, 150, 30);

        btnEdit.setBackground(new java.awt.Color(102, 102, 102));
        btnEdit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setText("Edit");
        btnEdit.setFocusable(false);
        btnEdit.addActionListener(this::btnEditActionPerformed);
        PanelInput.add(btnEdit);
        btnEdit.setBounds(290, 190, 150, 30);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Nama Barang");
        PanelInput.add(jLabel10);
        jLabel10.setBounds(20, 50, 90, 16);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Kode Barang");
        PanelInput.add(jLabel13);
        jLabel13.setBounds(20, 100, 80, 16);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setText("Jenis Barang");
        PanelInput.add(jLabel14);
        jLabel14.setBounds(20, 150, 80, 16);
        PanelInput.add(txtInfo);
        txtInfo.setBounds(570, 90, 270, 80);
        PanelInput.add(txtNama);
        txtNama.setBounds(120, 40, 280, 30);

        lblStok.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblStok.setText("Stok");
        PanelInput.add(lblStok);
        lblStok.setBounds(470, 50, 90, 16);

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setText("Info Tambahan");
        PanelInput.add(jLabel16);
        jLabel16.setBounds(470, 100, 90, 16);
        PanelInput.add(txtKode);
        txtKode.setBounds(120, 90, 280, 30);
        PanelInput.add(txtStok);
        txtStok.setBounds(570, 40, 270, 30);

        cbxJenis.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbxJenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elektronik", "Makanan", "Obat", "Pakaian", " " }));
        cbxJenis.setFocusable(false);
        cbxJenis.setOpaque(true);
        PanelInput.add(cbxJenis);
        cbxJenis.setBounds(120, 140, 280, 30);

        btnBatal.setBackground(new java.awt.Color(153, 153, 153));
        btnBatal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBatal.setForeground(new java.awt.Color(255, 255, 255));
        btnBatal.setText("Batal");
        btnBatal.addActionListener(this::btnBatalActionPerformed);
        PanelInput.add(btnBatal);
        btnBatal.setBounds(470, 190, 150, 30);

        panelListBarang.add(PanelInput);
        PanelInput.setBounds(30, 420, 870, 230);

        Parent.add(panelListBarang, "card2");

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

    // tambah data baru ke DB
    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        String SUrl = "jdbc:mysql://localhost:3306/java_user_database";
        String SUser = "root";
        String SPass = "";

        String nama = txtNama.getText().trim();
        String kode = txtKode.getText().trim();
        String jenis = cbxJenis.getSelectedItem().toString();
        String stok = txtStok.getText().trim();
        String info = txtInfo.getText().trim();
        
        if (!validasiFields("tambah")) {
             JOptionPane.showMessageDialog(null, "Semua field harus diisi! Pastikan Stok berisi angka.");
            
        } else {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(SUrl, SUser, SPass);
                
                // cek duplikat kode(unique) sebelum insert
                String cekQuery = "SELECT COUNT(*) FROM barang WHERE kode=?";
                PreparedStatement cekPst = con.prepareStatement(cekQuery);
                cekPst.setString(1, kode);
                ResultSet rs = cekPst.executeQuery();
                rs.next();
                if (rs.getInt(1) > 0) {
                    JOptionPane.showMessageDialog(null, "Kode barang sudah digunakan!");
                    return;
                }
                
                String query = "insert into barang (nama, kode, jenis, stok, infoTambah) values (?,? ,? ,?, ?)";
                PreparedStatement pst = con.prepareStatement(query);
                pst.setString(1, nama);
                pst.setString(2, kode);
                pst.setString(3, jenis);
                pst.setInt(4, Integer.parseInt(stok));
                pst.setString(5, info);
                pst.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan!");
                
                loadTableData();

                txtNama.setText("");
                txtKode.setText("");
                txtStok.setText("");
                txtInfo.setText("");
                
            } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_btnTambahActionPerformed

    private void tableComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tableComponentShown
        loadTableData();
        btnEdit.setEnabled(false);
    }//GEN-LAST:event_tableComponentShown

    // klik row tabel → isi field input dengan data row tersebut (select row)
    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
       int index = table.getSelectedRow();
       
       TableModel model = table.getModel();
       
       String nama = model.getValueAt(index, 0).toString();
       txtNama.setText(nama);
       
       String kode = model.getValueAt(index, 1).toString();
       txtKode.setText(kode);
       txtKode.setEditable(false);  // kode tidak boleh diubah saat edit
       
       String jenis = model.getValueAt(index, 2).toString();
       cbxJenis.setSelectedItem(jenis);
       
       String stok = model.getValueAt(index, 3).toString();
       txtStok.setText(stok);
       lblStok.setText("Tambah Stok");
       
       String info = model.getValueAt(index, 4).toString();
       txtInfo.setText(info);
       
       btnEdit.setEnabled(true);
       btnTambah.setEnabled(false);
    }//GEN-LAST:event_tableMouseClicked

    // update data di DB berdasarkan kode
    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        String SUrl = "jdbc:mysql://localhost:3306/java_user_database";
        String SUser = "root";
        String SPass = "";

        String nama = txtNama.getText().trim();
        String kode = txtKode.getText().trim();
        String jenis = cbxJenis.getSelectedItem().toString();
        String stok = txtStok.getText().trim();
        String info = txtInfo.getText().trim();
        
        if (!validasiFields("edit")) {
             JOptionPane.showMessageDialog(null, "Semua field harus diisi! Pastikan Stok berisi angka.");
            
        } else {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(SUrl, SUser, SPass);
                
                String query = "update barang set nama=?, jenis=?, stok=?, infoTambah=? where kode=?";
                PreparedStatement pst = con.prepareStatement(query);
                pst.setString(1, nama);
                pst.setString(2, jenis);
                pst.setInt(3, Integer.parseInt(stok));
                pst.setString(4, info);
                pst.setString(5, kode); //pakai kode sebagai identifier karena unique
                pst.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Data berhasil diedit!");
                
                loadTableData();
                txtNama.setText("");
                txtKode.setText("");
                txtStok.setText("");
                txtInfo.setText("");
                
                txtKode.setEditable(true);
                btnEdit.setEnabled(false);
                btnTambah.setEnabled(true);
                
            
            } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_btnEditActionPerformed

    //btn batal untuk reset semua field dan keadaan tombol
    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        txtNama.setText("");
        txtKode.setText("");
        txtStok.setText("");
        txtInfo.setText("");
        
        txtKode.setEditable(true);
        table.clearSelection();
        btnEdit.setEnabled(false);
        btnTambah.setEnabled(true);
    }//GEN-LAST:event_btnBatalActionPerformed

    // hapus data dari DB berdasarkan kode
    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        int confirm = JOptionPane.showConfirmDialog(null, "Yakin mau hapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        String SUrl = "jdbc:mysql://localhost:3306/java_user_database";
        String SUser = "root";
        String SPass = "";
        
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(SUrl, SUser, SPass);
                
                String query = "delete from barang where kode=?";
                PreparedStatement pst = con.prepareStatement(query);
                pst.setString(1, txtKode.getText().trim());
                pst.executeUpdate();
               
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
                loadTableData();
                
                txtNama.setText("");
                txtKode.setText("");
                txtStok.setText("");
                txtInfo.setText("");
                
                btnEdit.setEnabled(false);
                btnTambah.setEnabled(true);
                txtKode.setEditable(true);
                
            } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }

        }
    }//GEN-LAST:event_btnHapusActionPerformed

    public static void main(String args[]) {}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelInput;
    private javax.swing.JPanel Parent;
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnTambah;
    private javax.swing.JComboBox<String> cbxJenis;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblStok;
    private javax.swing.JLabel lowStockCount;
    private javax.swing.JPanel panelListBarang;
    private javax.swing.JPanel panelLowStok;
    private javax.swing.JPanel panelTotalItem;
    private javax.swing.JPanel sidebar;
    private javax.swing.JTable table;
    private javax.swing.JLabel totalItemCount;
    private javax.swing.JTextField txtInfo;
    private javax.swing.JTextField txtKode;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtStok;
    // End of variables declaration//GEN-END:variables
}

package storage;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class MainFrame extends javax.swing.JDialog {
    
    static ArrayList <Barang> stokBarang = new ArrayList<>();
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MainFrame.class.getName());

   
    
    public MainFrame(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    
    private void clear() {
        inNama.setText("");
        inCode.setText("");
        inStok.setText("");
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        inStok = new javax.swing.JTextField();
        inCode = new javax.swing.JTextField();
        inNama = new javax.swing.JTextField();
        btnTampil = new javax.swing.JToggleButton();
        btnADD1 = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        output = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(500, 600));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel1.setText("Managemen Stok Barang");
        jLabel1.setName(""); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(140, 10, 190, 20);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Nama");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 50, 40, 20);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Kode Barang");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 110, 90, 20);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Stok");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 160, 50, 20);

        inStok.addActionListener(this::inStokActionPerformed);
        jPanel1.add(inStok);
        inStok.setBounds(140, 150, 310, 30);

        inCode.addActionListener(this::inCodeActionPerformed);
        jPanel1.add(inCode);
        inCode.setBounds(140, 100, 310, 30);

        inNama.addActionListener(this::inNamaActionPerformed);
        jPanel1.add(inNama);
        inNama.setBounds(140, 50, 310, 30);

        btnTampil.setText("Tampilkan");
        btnTampil.addActionListener(this::btnTampilActionPerformed);
        jPanel1.add(btnTampil);
        btnTampil.setBounds(330, 210, 110, 30);

        btnADD1.setText("Tambahkan");
        btnADD1.addActionListener(this::btnADD1ActionPerformed);
        jPanel1.add(btnADD1);
        btnADD1.setBounds(10, 210, 110, 30);

        output.setColumns(20);
        output.setRows(5);
        jScrollPane1.setViewportView(output);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 380, 450, 150);

        jButton1.setText("Edit");
        jPanel1.add(jButton1);
        jButton1.setBounds(90, 280, 72, 23);

        jButton2.setText("Hapus");
        jPanel1.add(jButton2);
        jButton2.setBounds(190, 280, 72, 20);

        jButton3.setText("Cari");
        jPanel1.add(jButton3);
        jButton3.setBounds(290, 280, 72, 23);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inNamaActionPerformed

    private void inCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inCodeActionPerformed

    private void btnTampilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTampilActionPerformed
        output.setText("");
        for (Barang a : stokBarang){
            output.append(a.toString() + "\n");
        }
    }//GEN-LAST:event_btnTampilActionPerformed

    private void inStokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inStokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inStokActionPerformed

    private void btnADD1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnADD1ActionPerformed
       String nama = inNama.getText();
       String kode = inCode.getText();
       String stok = inStok.getText();
       
       if ("".equals(nama)){
           JOptionPane.showMessageDialog(new JFrame(), " Nama Barang Tidak Boleh Kosong!", "ERROR",
                   JOptionPane.ERROR_MESSAGE
                   );
       } else if ("".equals(kode)){
           JOptionPane.showMessageDialog(new JFrame(), " Kode Barang Tidak Boleh Kosong!", "ERROR",
                   JOptionPane.ERROR_MESSAGE
                   );
       } else if ("".equals(stok)){
           JOptionPane.showMessageDialog(new JFrame(), " Stok Barang Tidak Boleh Kosong!", "ERROR",
                   JOptionPane.ERROR_MESSAGE
                   );
       } else if (!stok.matches("\\d+")){
           JOptionPane.showMessageDialog(new JFrame(), " Stok Barang Haruslah Angka!", "ERROR",
                   JOptionPane.ERROR_MESSAGE
                   );
       } else {
           boolean dupe = false;
           for (Barang b : stokBarang){
               if (b.getKode().equalsIgnoreCase(kode)){
                   dupe = true;
                   break;
               }
           }
           
           if (dupe){
               JOptionPane.showMessageDialog(new JFrame(), " Kode Barang Sudah Terdaftar!", "ERROR",
                   JOptionPane.ERROR_MESSAGE
                   );
               return;
           }
           
           int stock = Integer.parseInt(stok);
           
           
           //stokBarang.add(new Barang (nama, kode, stock));
           JOptionPane.showMessageDialog(null, "Barang Berhasil Ditambahkan!", "SUKSES!",
                   JOptionPane.INFORMATION_MESSAGE
                   );
            clear();
       }
           
       
       
    }//GEN-LAST:event_btnADD1ActionPerformed

  
            
    public static void main(String args[]) {
 
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnADD1;
    private javax.swing.JToggleButton btnTampil;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField inCode;
    private javax.swing.JTextField inNama;
    private javax.swing.JTextField inStok;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea output;
    // End of variables declaration//GEN-END:variables

  
}

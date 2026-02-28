package storage;

public class barangObat extends Barang{
    private String kategori;

    public barangObat (String nama, String kode, int stok, String kategori){
        super(nama, kode, stok);
        this.kategori = kategori;
    }

    public String getKategori() {
        return kategori;
    }

    @Override
    public String getInfoTambahan(){
        return "Kategori: " + kategori;
        // Kategori  -->  Obat Umum atau Obat Resep
    }
    
}
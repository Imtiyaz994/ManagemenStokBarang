package storage;

public class barangPakaian extends Barang {
    private int ukuran;

    public barangPakaian(String nama, String kode, int stok, int ukuran) {
        super(nama, kode, stok);
        this.ukuran = ukuran;
    }

    public int getUkuran() {
        return ukuran;
    }

    @Override
    public String getInfoTambahan (){
        return "Ukuran: " + getUkuran();
    }

}
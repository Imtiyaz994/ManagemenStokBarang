package storage;

public class barangElektronik extends Barang {
    private int garansi;

    public barangElektronik(String nama, String kode, int stok, int garansi) {
        super(nama, kode, stok);
        this.garansi = garansi;
    }

    public int getGaransi() {
        return garansi;
    }

    @Override
    public String getInfoTambahan (){
        return "Garansi: " + getGaransi() + "Bulan";
    }

}
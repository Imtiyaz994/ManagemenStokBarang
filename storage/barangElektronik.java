package storage;

public class barangElektronik extends Barang {
    private String garansi; 

    public barangElektronik(String nama, String kode, int stok, String garansi) {
        super(nama, kode, stok); 
        this.garansi = garansi;
    }

    public String getGaransi() {
        return garansi;
    }

    public boolean adaGaransi(
        return garansi > 0;
    )

    public String statusGaransi() {
        return adaGaransi() ? "Aktif" : "Habis";
    }

    @Override
    public void getInfoTambahan() {
        System.out.println("Garansi: " + garansi);
    }
}

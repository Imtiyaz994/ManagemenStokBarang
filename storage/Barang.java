package storage;

public abstract class Barang {
    private String nama;
    private String kode;
    private int stok;
    
    Barang(String nama, String kode, int stok){
        this.nama = nama;
        this.kode = kode;
        setStok(stok);
    }
    
    public String getKode () {
        return kode;
    }
    
    public String getNama () {
        return nama;
    }
    
    public int getStok () {
        return stok;
    }

    public void setStok(int stok){
        if (stok < 0){
            this.stok = 0;
        } else {
            this.stok = stok;
        }
        
    }

    public abstract String getInfoTambahan();

    @Override
    public String toString (){
        return String.format("%-15s | %-10s |  %-5s | %-15s", getNama(), getKode(), getStok(), getInfoTambahan());
    }
}




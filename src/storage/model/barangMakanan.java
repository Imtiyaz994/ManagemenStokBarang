package storage.model;

public class barangMakanan extends Barang{
    private String exp;

    public barangMakanan (String nama, String kode, int stok, String exp){
        super(nama, kode, stok);
        this.exp = exp;
    }

    public String getExp () {
        return exp;
    }

    @Override
    public String getInfoTambahan(){
        return "Exp: " + exp;
    }
    
}
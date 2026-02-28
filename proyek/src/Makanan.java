public class Makanan extends Produk {
    private String tanggalKadaluarsa;

    public Makanan(String nama, double harga, String tanggalKadaluarsa) {
        super(nama, harga);
        this.tanggalKadaluarsa = tanggalKadaluarsa;
    }

    public String getTanggalKadaluarsa() {
        return tanggalKadaluarsa;
    }

    // Overriding
    @Override
    public void infoProduk() {
        System.out.println("Makanan: " + getNama() +
                " | Harga: Rp" + getHarga() +
                " | Exp: " + tanggalKadaluarsa);
    }
}

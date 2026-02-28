public class Minuman extends Produk {
    private boolean dingin;

    public Minuman(String nama, double harga, boolean dingin) {
        super(nama, harga);
        this.dingin = dingin;
    }

    // Overriding
    @Override
    public void infoProduk() {
        String status = dingin ? "Dingin" : "Biasa";
        System.out.println("Minuman: " + getNama() +
                " | Harga: Rp" + getHarga() +
                " | Suhu: " + status);
    }
}

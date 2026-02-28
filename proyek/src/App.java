public class App {
    public static void main(String[] args) throws Exception {
        // Membuat produk
        Produk roti = new Makanan("Roti Coklat", 12000, "12-03-2026");
        Produk aqua = new Minuman("Air Mineral", 5000, true);
        Produk kopi = new Minuman("Kopi Hitam", 8000, false);

        // Array produk yang dibeli
        Produk[] keranjang = { roti, aqua, kopi };

        // Hitung total
        Transaksi trx = new Transaksi();
        double totalBayar = trx.hitungTotal(keranjang);

        // Cetak struk dengan kasir
        Kasir kasir1 = new Kasir("Dewi");
        kasir1.cetakStruk(keranjang, totalBayar);
    }
}

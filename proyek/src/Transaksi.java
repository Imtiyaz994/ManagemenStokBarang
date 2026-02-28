public class Transaksi {

    // Overloading 1: hitung total 1 produk
    public double hitungTotal(Produk p) {
        return p.getHarga();
    }

    // Overloading 2: hitung total banyak produk
    public double hitungTotal(Produk[] daftarProduk) {
        double total = 0;
        for (Produk p : daftarProduk) {
            total += p.getHarga();
        }
        return total;
    }
}

public class Kasir {
    private String namaKasir;

    public Kasir(String namaKasir) {
        this.namaKasir = namaKasir;
    }

    public void cetakStruk(Produk[] barang, double total) {
        System.out.println("\n====== STRUK PEMBAYARAN ======");
        System.out.println("Kasir: " + namaKasir);
        for (Produk p : barang) {
            p.infoProduk();  // polymorphism: panggil sesuai subclass
        }
        System.out.println("Total: Rp" + total);
        System.out.println("==============================\n");
    }
}

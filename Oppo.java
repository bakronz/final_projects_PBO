package project_akhir;

public class Oppo extends Smartphone {

    public Oppo(String tipe, int storage, double harga) {
        super("Oppo", tipe, storage, harga);
    }

    @Override
    public double hitungHarga(int jumlah) {
        return harga * jumlah;
    }
}

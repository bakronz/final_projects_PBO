package project_akhir;

public class Xiaomi extends Smartphone {

    public Xiaomi(String tipe, int storage, double harga) {
        super("Xiaomi", tipe, storage, harga);
    }

    @Override
    public double hitungHarga(int jumlah) {
        return harga * jumlah;
    }
}

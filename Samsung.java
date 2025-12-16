package project_akhir;

public class Samsung extends Smartphone {

    public Samsung(String tipe, int storage, double harga) {
        super("Samsung", tipe, storage, harga);
    }

    @Override
    public double hitungHarga(int jumlah) {
        return harga * jumlah;
    }
}

package project_akhir;

public class Iphone extends Smartphone {

    public Iphone(String tipe, int storage, double harga) {
        super("iPhone", tipe, storage, harga);
    }

    @Override
    public double hitungHarga(int jumlah) {
        return harga * jumlah;
    }
}

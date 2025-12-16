package project_akhir;

public class Vivo extends Smartphone {

    public Vivo(String tipe, int storage, double harga) {
        super("Vivo", tipe, storage, harga);
    }

    @Override
    public double hitungHarga(int jumlah) {
        return harga * jumlah;
    }
}

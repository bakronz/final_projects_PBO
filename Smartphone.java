package project_akhir;

public abstract class Smartphone {

    protected String merk;
    protected String tipe;
    protected int storage;
    protected double harga;
    protected int stok;

    public Smartphone(String merk, String tipe, int storage, double harga) {
        this.merk = merk;
        this.tipe = tipe;
        this.storage = storage;
        this.harga = harga;
        this.stok = 50; // semua unit stok awal 50
    }

    public abstract double hitungHarga(int jumlah);

    public void kurangiStok(int jumlah) {
        this.stok -= jumlah;
    }

    public int getStok() {
        return stok;
    }

    public int getStorage() {
        return storage;
    }
}

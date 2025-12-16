package project_akhir;

import javax.swing.*;
import java.awt.event.*;

public class FormPenjualan extends JFrame {

    JComboBox<String> cbMerk, cbTipe, cbStorage;
    JTextField txtJumlah;
    JLabel lblInfo, lblTotal;

    Smartphone hp;

    public FormPenjualan() {
        setTitle("Aplikasi Penjualan Smartphone");
        setSize(420, 320);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel l1 = new JLabel("Merk");
        l1.setBounds(30, 30, 100, 25);
        add(l1);

        cbMerk = new JComboBox<>(new String[]{"Xiaomi","Samsung","iPhone","Oppo","Vivo"});
        cbMerk.setBounds(150,30,200,25);
        add(cbMerk);

        JLabel l2 = new JLabel("Tipe HP");
        l2.setBounds(30,70,100,25);
        add(l2);

        cbTipe = new JComboBox<>();
        cbTipe.setBounds(150,70,200,25);
        add(cbTipe);

        JLabel l3 = new JLabel("Penyimpanan");
        l3.setBounds(30,110,100,25);
        add(l3);

        cbStorage = new JComboBox<>(new String[]{"64","128","256"});
        cbStorage.setBounds(150,110,200,25);
        add(cbStorage);

        JLabel l4 = new JLabel("Jumlah Beli");
        l4.setBounds(30,150,100,25);
        add(l4);

        txtJumlah = new JTextField();
        txtJumlah.setBounds(150,150,200,25);
        add(txtJumlah);

        JButton btn = new JButton("Hitung Total");
        btn.setBounds(150,190,200,30);
        add(btn);

        lblInfo = new JLabel("Stok: 50");
        lblInfo.setBounds(30,230,300,25);
        add(lblInfo);

        lblTotal = new JLabel("Total Harga: Rp 0");
        lblTotal.setBounds(30,260,300,25);
        add(lblTotal);

        cbMerk.addActionListener(e -> loadTipe());
        btn.addActionListener(e -> prosesBeli());

        loadTipe();
    }

    void loadTipe() {
        cbTipe.removeAllItems();
        String merk = cbMerk.getSelectedItem().toString();

        if (merk.equals("Xiaomi")) cbTipe.addItem("Redmi Note 13");
        if (merk.equals("Samsung")) cbTipe.addItem("Galaxy A15");
        if (merk.equals("iPhone")) cbTipe.addItem("iPhone 13");
        if (merk.equals("Oppo")) cbTipe.addItem("Reno 8");
        if (merk.equals("Vivo")) cbTipe.addItem("Y20");
    }

    void prosesBeli() {
        int jumlah = Integer.parseInt(txtJumlah.getText());
        int storage = Integer.parseInt(cbStorage.getSelectedItem().toString());

        hp = new Xiaomi("Default", storage, 4500000);

        if (!StockManager.cekStok(hp, jumlah)) {
            JOptionPane.showMessageDialog(this,"Stok tidak cukup!");
            return;
        }

        double total = hp.hitungHarga(jumlah);
        hp.kurangiStok(jumlah);

        lblInfo.setText("Penyimpanan: "+storage+" GB | Stok: "+hp.getStok());
        lblTotal.setText("Total Harga: Rp " + String.format("%,.0f", total));

        JOptionPane.showMessageDialog(this,"Pembelian berhasil!");
    }
}

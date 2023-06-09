package com.example.sima.data.model;

public class Barang {
    String kode_barang;
    String nama_barang;

    public Barang(String kode_barang, String nama_barang) {
        this.kode_barang = kode_barang;
        this.nama_barang = nama_barang;
    }

    public String getKode() {
        return kode_barang;
    }

    public String getNama() {
        return nama_barang;
    }

    @Override
    public String toString() {
        return nama_barang; // Menampilkan nama barang di spinner
    }
}

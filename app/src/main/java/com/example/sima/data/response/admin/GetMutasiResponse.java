package com.example.sima.data.response.admin;

import com.google.gson.annotations.SerializedName;

public class GetMutasiResponse {

    @SerializedName("tanggal")
    private String tanggal;

    @SerializedName("lokasi_awal")
    private String lokasiAwal;

    @SerializedName("lokasi_akhir")
    private String lokasiAkhir;

    @SerializedName("nama_gambar")
    private String namaGambar;

    @SerializedName("kode_barang")
    private String kodeBarang;

    @SerializedName("spesifikasi")
    private String spesifikasi;

    @SerializedName("nama_lengkap")
    private String namaLengkap;

    @SerializedName("nama_barang")
    private String namaBarang;

    @SerializedName("quality_control")
    private String qualityControl;

    public void setLokasiAwal(String lokasiAwal) {
        this.lokasiAwal = lokasiAwal;
    }

    public String getLokasiAwal() {
        return lokasiAwal;
    }

    public void setLokasiAkhir(String lokasiAkhir) {
        this.lokasiAkhir = lokasiAkhir;
    }

    public String getLokasiAkhir() {
        return lokasiAkhir;
    }

    public void setNamaGambar(String namaGambar) {
        this.namaGambar = namaGambar;
    }

    public String getNamaGambar() {
        return namaGambar;
    }

    public void setKodeBarang(String kodeBarang) {
        this.kodeBarang = kodeBarang;
    }

    public String getKodeBarang() {
        return kodeBarang;
    }

    public void setSpesifikasi(String spesifikasi) {
        this.spesifikasi = spesifikasi;
    }

    public String getSpesifikasi() {
        return spesifikasi;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setQualityControl(String qualityControl) {
        this.qualityControl = qualityControl;
    }

    public String getQualityControl() {
        return qualityControl;
    }


    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
}
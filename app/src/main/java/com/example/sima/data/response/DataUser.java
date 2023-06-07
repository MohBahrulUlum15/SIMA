package com.example.sima.data.response;

import com.google.gson.annotations.SerializedName;

public class DataUser {
    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public String getNoHandphone() {
        return noHandphone;
    }

    public void setNoHandphone(String noHandphone) {
        this.noHandphone = noHandphone;
    }

    public String getPendidikanTerakhir() {
        return pendidikanTerakhir;
    }

    public void setPendidikanTerakhir(String pendidikanTerakhir) {
        this.pendidikanTerakhir = pendidikanTerakhir;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getAlamatLengkap() {
        return alamatLengkap;
    }

    public void setAlamatLengkap(String alamatLengkap) {
        this.alamatLengkap = alamatLengkap;
    }

    public String getDepartemen() {
        return departemen;
    }

    public void setDepartemen(String departemen) {
        this.departemen = departemen;
    }

    public String getKewarganegaraan() {
        return kewarganegaraan;
    }

    public void setKewarganegaraan(String kewarganegaraan) {
        this.kewarganegaraan = kewarganegaraan;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @SerializedName("jabatan")
    private String jabatan;

    @SerializedName("nama_lengkap")
    private String namaLengkap;

    @SerializedName("agama")
    private String agama;

    @SerializedName("no_handphone")
    private String noHandphone;

    @SerializedName("pendidikan_terakhir")
    private String pendidikanTerakhir;

    @SerializedName("id_user")
    private String idUser;

    @SerializedName("alamat_lengkap")
    private String alamatLengkap;

    @SerializedName("departemen")
    private String departemen;

    @SerializedName("kewarganegaraan")
    private String kewarganegaraan;

    @SerializedName("password")
    private String password;

    @SerializedName("tempat_lahir")
    private String tempatLahir;

    @SerializedName("jenis_kelamin")
    private String jenisKelamin;

    @SerializedName("tanggal_lahir")
    private String tanggalLahir;

    @SerializedName("username")
    private String username;
}

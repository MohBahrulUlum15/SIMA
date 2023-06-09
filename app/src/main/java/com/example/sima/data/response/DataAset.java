package com.example.sima.data.response;

import com.google.gson.annotations.SerializedName;

public class DataAset{

	@SerializedName("merk")
	private String merk;

	@SerializedName("nama_gambar")
	private String namaGambar;

	@SerializedName("harga")
	private String harga;

	@SerializedName("kondisi")
	private String kondisi;

	@SerializedName("tanggal_masuk")
	private String tanggalMasuk;

	@SerializedName("jangka_penggunaan")
	private String jangkaPenggunaan;

	@SerializedName("penanggung_jawab")
	private String penanggungJawab;

	@SerializedName("nama_barang")
	private String namaBarang;

	@SerializedName("kode_barang")
	private String kodeBarang;

	public void setMerk(String merk){
		this.merk = merk;
	}

	public String getMerk(){
		return merk;
	}

	public void setNamaGambar(String namaGambar){
		this.namaGambar = namaGambar;
	}

	public String getNamaGambar(){
		return namaGambar;
	}

	public void setHarga(String harga){
		this.harga = harga;
	}

	public String getHarga(){
		return harga;
	}

	public void setKondisi(String kondisi){
		this.kondisi = kondisi;
	}

	public String getKondisi(){
		return kondisi;
	}

	public void setTanggalMasuk(String tanggalMasuk){
		this.tanggalMasuk = tanggalMasuk;
	}

	public String getTanggalMasuk(){
		return tanggalMasuk;
	}

	public void setJangkaPenggunaan(String jangkaPenggunaan){
		this.jangkaPenggunaan = jangkaPenggunaan;
	}

	public String getJangkaPenggunaan(){
		return jangkaPenggunaan;
	}

	public void setPenanggungJawab(String penanggungJawab){
		this.penanggungJawab = penanggungJawab;
	}

	public String getPenanggungJawab(){
		return penanggungJawab;
	}

	public void setNamaBarang(String namaBarang){
		this.namaBarang = namaBarang;
	}

	public String getNamaBarang(){
		return namaBarang;
	}

	public void setKodeBarang(String namaBarang){
		this.kodeBarang = kodeBarang;
	}

	public String getKodeBarang(){
		return kodeBarang;
	}
}
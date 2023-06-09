package com.example.sima.data.response;

import com.google.gson.annotations.SerializedName;

public class DataPerawatan {

	@SerializedName("nama_gambar")
	private String namaGambar;

	@SerializedName("kode_barang")
	private String kodeBarang;

	@SerializedName("tanggal")
	private String tanggal;

	@SerializedName("uraian_kegiatan")
	private String uraianKegiatan;

	public void setNamaGambar(String namaGambar){
		this.namaGambar = namaGambar;
	}

	public String getNamaGambar(){
		return namaGambar;
	}

	public void setKodeBarang(String kodeBarang){
		this.kodeBarang = kodeBarang;
	}

	public String getKodeBarang(){
		return kodeBarang;
	}

	public void setTanggal(String tanggal){
		this.tanggal = tanggal;
	}

	public String getTanggal(){
		return tanggal;
	}

	public void setUraianKegiatan(String uraianKegiatan){
		this.uraianKegiatan = uraianKegiatan;
	}

	public String getUraianKegiatan(){
		return uraianKegiatan;
	}
}
package com.example.sima.data.response.admin;

import com.google.gson.annotations.SerializedName;

public class GetUnitProduksiResponse{

	@SerializedName("nama_gambar")
	private String namaGambar;

	@SerializedName("daya_listrik")
	private String dayaListrik;

	@SerializedName("nama_lengkap")
	private String namaLengkap;

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

	public void setDayaListrik(String dayaListrik){
		this.dayaListrik = dayaListrik;
	}

	public String getDayaListrik(){
		return dayaListrik;
	}

	public void setNamaLengkap(String namaLengkap){
		this.namaLengkap = namaLengkap;
	}

	public String getNamaLengkap(){
		return namaLengkap;
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
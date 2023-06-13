package com.example.sima.data.response;

import com.google.gson.annotations.SerializedName;

public class DataUnitProduksi{

	@SerializedName("nama_gambar")
	private String namaGambar;

	@SerializedName("daya_listrik")
	private String dayaListrik;

	@SerializedName("tanggal")
	private String tanggal;

	@SerializedName("id_user")
	private String idUser;

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

	public void setTanggal(String tanggal){
		this.tanggal = tanggal;
	}

	public String getTanggal(){
		return tanggal;
	}

	public void setIdUser(String idUser){
		this.idUser = idUser;
	}

	public String getIdUser(){
		return idUser;
	}

	public void setUraianKegiatan(String uraianKegiatan){
		this.uraianKegiatan = uraianKegiatan;
	}

	public String getUraianKegiatan(){
		return uraianKegiatan;
	}
}
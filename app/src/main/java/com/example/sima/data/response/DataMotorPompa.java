package com.example.sima.data.response;

import com.google.gson.annotations.SerializedName;

public class DataMotorPompa {

	@SerializedName("arus_maks")
	private String arusMaks;

	@SerializedName("daya_listrik")
	private String dayaListrik;

	@SerializedName("kode_barang")
	private String kodeBarang;

	@SerializedName("cos")
	private String cos;

	@SerializedName("id_user")
	private String idUser;

	@SerializedName("tanggal")
	private String tanggal;

	public void setArusMaks(String arusMaks){
		this.arusMaks = arusMaks;
	}

	public String getArusMaks(){
		return arusMaks;
	}

	public void setDayaListrik(String dayaListrik){
		this.dayaListrik = dayaListrik;
	}

	public String getDayaListrik(){
		return dayaListrik;
	}

	public void setKodeBarang(String kodeBarang){
		this.kodeBarang = kodeBarang;
	}

	public String getKodeBarang(){
		return kodeBarang;
	}

	public void setCos(String cos){
		this.cos = cos;
	}

	public String getCos(){
		return cos;
	}

	public void setIdUser(String idUser){
		this.idUser = idUser;
	}

	public String getIdUser(){
		return idUser;
	}

	public void setTanggal(String tanggal){
		this.tanggal = tanggal;
	}

	public String getTanggal(){
		return tanggal;
	}
}
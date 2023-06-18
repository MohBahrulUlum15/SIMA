package com.example.sima.data.response.admin;

import com.google.gson.annotations.SerializedName;

public class GetSpekMotorPompaResponse{

	@SerializedName("arus_maks")
	private String arusMaks;

	@SerializedName("daya_listrik")
	private String dayaListrik;

	@SerializedName("kode_barang")
	private String kodeBarang;

	@SerializedName("cos_value")
	private String cosValue;

	@SerializedName("nama_lengkap")
	private String namaLengkap;

	@SerializedName("nama_barang")
	private String namaBarang;

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

	public void setCosValue(String cosValue){
		this.cosValue = cosValue;
	}

	public String getCosValue(){
		return cosValue;
	}

	public void setNamaLengkap(String namaLengkap){
		this.namaLengkap = namaLengkap;
	}

	public String getNamaLengkap(){
		return namaLengkap;
	}

	public void setNamaBarang(String namaBarang){
		this.namaBarang = namaBarang;
	}

	public String getNamaBarang(){
		return namaBarang;
	}

	public void setTanggal(String tanggal){
		this.tanggal = tanggal;
	}

	public String getTanggal(){
		return tanggal;
	}
}
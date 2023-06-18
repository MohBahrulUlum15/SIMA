package com.example.sima.data.response.admin;

import com.google.gson.annotations.SerializedName;

public class GetSpekPanelResponse{

	@SerializedName("kode_barang")
	private String kodeBarang;

	@SerializedName("kapasitas_beban")
	private String kapasitasBeban;

	@SerializedName("nama_lengkap")
	private String namaLengkap;

	@SerializedName("nama_barang")
	private String namaBarang;

	@SerializedName("tanggal")
	private String tanggal;

	@SerializedName("star_delta")
	private String starDelta;

	@SerializedName("direct_online")
	private String directOnline;

	public void setKodeBarang(String kodeBarang){
		this.kodeBarang = kodeBarang;
	}

	public String getKodeBarang(){
		return kodeBarang;
	}

	public void setKapasitasBeban(String kapasitasBeban){
		this.kapasitasBeban = kapasitasBeban;
	}

	public String getKapasitasBeban(){
		return kapasitasBeban;
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

	public void setStarDelta(String starDelta){
		this.starDelta = starDelta;
	}

	public String getStarDelta(){
		return starDelta;
	}

	public void setDirectOnline(String directOnline){
		this.directOnline = directOnline;
	}

	public String getDirectOnline(){
		return directOnline;
	}
}
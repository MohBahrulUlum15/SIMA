package com.example.sima.data.response;

import com.google.gson.annotations.SerializedName;

public class DataPanel {

	@SerializedName("kode_barang")
	private String kodeBarang;

	@SerializedName("kapasitas_beban")
	private String kapasitasBeban;

	@SerializedName("id_user")
	private String idUser;

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
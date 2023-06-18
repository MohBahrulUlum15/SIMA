package com.example.sima.data.response;

import com.google.gson.annotations.SerializedName;

public class DataGenset {

	@SerializedName("kondisi")
	private String kondisi;

	@SerializedName("kode_barang")
	private String kodeBarang;

	@SerializedName("merk_genset")
	private String merkGenset;

	@SerializedName("kapasitas")
	private String kapasitas;

	@SerializedName("id_user")
	private String idUser;

	@SerializedName("tanggal")
	private String tanggal;

	@SerializedName("tipe")
	private String tipe;

	public void setKondisi(String kondisi){
		this.kondisi = kondisi;
	}

	public String getKondisi(){
		return kondisi;
	}

	public void setKodeBarang(String kodeBarang){
		this.kodeBarang = kodeBarang;
	}

	public String getKodeBarang(){
		return kodeBarang;
	}

	public void setMerkGenset(String merkGenset){
		this.merkGenset = merkGenset;
	}

	public String getMerkGenset(){
		return merkGenset;
	}

	public void setKapasitas(String kapasitas){
		this.kapasitas = kapasitas;
	}

	public String getKapasitas(){
		return kapasitas;
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

	public void setTipe(String tipe){
		this.tipe = tipe;
	}

	public String getTipe(){
		return tipe;
	}
}
package com.example.sima.data.response.admin;

import com.google.gson.annotations.SerializedName;

public class GetSpekGensetResponse{

	@SerializedName("kondisi")
	private String kondisi;

	@SerializedName("kode_barang")
	private String kodeBarang;

	@SerializedName("merk_genset")
	private String merkGenset;

	@SerializedName("nama_lengkap")
	private String namaLengkap;

	@SerializedName("nama_barang")
	private String namaBarang;

	@SerializedName("kapasitas")
	private String kapasitas;

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

	public void setKapasitas(String kapasitas){
		this.kapasitas = kapasitas;
	}

	public String getKapasitas(){
		return kapasitas;
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
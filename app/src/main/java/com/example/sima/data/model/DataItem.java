package com.example.sima.data.model;

import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("kode_barang")
	private String kodeBarang;

	@SerializedName("nama_barang")
	private String namaBarang;

	public void setKodeBarang(String kodeBarang){
		this.kodeBarang = kodeBarang;
	}

	public String getKodeBarang(){
		return kodeBarang;
	}

	public void setNamaBarang(String namaBarang){
		this.namaBarang = namaBarang;
	}

	public String getNamaBarang(){
		return namaBarang;
	}
}
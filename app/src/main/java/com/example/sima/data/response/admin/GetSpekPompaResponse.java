package com.example.sima.data.response.admin;

import com.google.gson.annotations.SerializedName;

public class GetSpekPompaResponse{

	@SerializedName("head_pompa")
	private String headPompa;

	@SerializedName("kode_barang")
	private String kodeBarang;

	@SerializedName("debit_pompa")
	private String debitPompa;

	@SerializedName("nama_lengkap")
	private String namaLengkap;

	@SerializedName("nama_barang")
	private String namaBarang;

	@SerializedName("tanggal")
	private String tanggal;

	public void setHeadPompa(String headPompa){
		this.headPompa = headPompa;
	}

	public String getHeadPompa(){
		return headPompa;
	}

	public void setKodeBarang(String kodeBarang){
		this.kodeBarang = kodeBarang;
	}

	public String getKodeBarang(){
		return kodeBarang;
	}

	public void setDebitPompa(String debitPompa){
		this.debitPompa = debitPompa;
	}

	public String getDebitPompa(){
		return debitPompa;
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
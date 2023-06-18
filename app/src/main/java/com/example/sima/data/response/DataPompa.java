package com.example.sima.data.response;

import com.google.gson.annotations.SerializedName;

public class DataPompa {

	@SerializedName("head_pompa")
	private String headPompa;

	@SerializedName("kode_barang")
	private String kodeBarang;

	@SerializedName("debit_pompa")
	private String debitPompa;

	@SerializedName("id_user")
	private String idUser;

	@SerializedName("jenis_pompa")
	private String jenisPompa;

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

	public void setIdUser(String idUser){
		this.idUser = idUser;
	}

	public String getIdUser(){
		return idUser;
	}

	public void setJenisPompa(String jenisPompa){
		this.jenisPompa = jenisPompa;
	}

	public String getJenisPompa(){
		return jenisPompa;
	}

	public void setTanggal(String tanggal){
		this.tanggal = tanggal;
	}

	public String getTanggal(){
		return tanggal;
	}
}
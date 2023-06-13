package com.example.sima.data.response;

import com.google.gson.annotations.SerializedName;

public class DataLaporanHarian {

	@SerializedName("standmeter")
	private String standmeter;

	@SerializedName("luar_beban_puncak")
	private String luarBebanPuncak;

	@SerializedName("tanggal")
	private String tanggal;

	@SerializedName("id_user")
	private String idUser;

	@SerializedName("beban_puncak")
	private String bebanPuncak;

	@SerializedName("penggunaan_daya_reaktif")
	private String penggunaanDayaReaktif;

	@SerializedName("nama_karyawan_dua")
	private String namaKaryawanDua;

	@SerializedName("kode_laporan")
	private String kodeLaporan;

	public void setStandmeter(String standmeter){
		this.standmeter = standmeter;
	}

	public String getStandmeter(){
		return standmeter;
	}

	public void setLuarBebanPuncak(String luarBebanPuncak){
		this.luarBebanPuncak = luarBebanPuncak;
	}

	public String getLuarBebanPuncak(){
		return luarBebanPuncak;
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

	public void setBebanPuncak(String bebanPuncak){
		this.bebanPuncak = bebanPuncak;
	}

	public String getBebanPuncak(){
		return bebanPuncak;
	}

	public void setPenggunaanDayaReaktif(String penggunaanDayaReaktif){
		this.penggunaanDayaReaktif = penggunaanDayaReaktif;
	}

	public String getPenggunaanDayaReaktif(){
		return penggunaanDayaReaktif;
	}

	public void setNamaKaryawanDua(String namaKaryawanDua){
		this.namaKaryawanDua = namaKaryawanDua;
	}

	public String getNamaKaryawanDua(){
		return namaKaryawanDua;
	}

	public void setKodeLaporan(String kodeLaporan){
		this.kodeLaporan = kodeLaporan;
	}

	public String getKodeLaporan(){
		return kodeLaporan;
	}
}
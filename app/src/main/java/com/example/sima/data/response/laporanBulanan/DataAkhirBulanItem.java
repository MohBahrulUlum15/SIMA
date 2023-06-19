package com.example.sima.data.response.laporanBulanan;

import com.google.gson.annotations.SerializedName;

public class DataAkhirBulanItem{

	@SerializedName("standmeter")
	private String standmeter;

	@SerializedName("nama_lengkap")
	private String namaLengkap;

	@SerializedName("luar_beban_puncak")
	private String luarBebanPuncak;

	@SerializedName("tanggal")
	private String tanggal;

	@SerializedName("beban_puncak")
	private String bebanPuncak;

	@SerializedName("penggunaan_daya_reaktif")
	private String penggunaanDayaReaktif;

	public void setStandmeter(String standmeter){
		this.standmeter = standmeter;
	}

	public String getStandmeter(){
		return standmeter;
	}

	public void setNamaLengkap(String namaLengkap){
		this.namaLengkap = namaLengkap;
	}

	public String getNamaLengkap(){
		return namaLengkap;
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
}
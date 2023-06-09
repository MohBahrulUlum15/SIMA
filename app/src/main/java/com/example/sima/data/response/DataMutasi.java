package com.example.sima.data.response;

import com.google.gson.annotations.SerializedName;

public class DataMutasi {

	@SerializedName("lokasi_awal")
	private String lokasiAwal;

	@SerializedName("lokasi_akhir")
	private String lokasiAkhir;

	@SerializedName("nama_gambar")
	private String namaGambar;

	@SerializedName("kode_barang")
	private String kodeBarang;

	@SerializedName("spesifikasi")
	private String spesifikasi;

	@SerializedName("tanggal")
	private String tanggal;

	@SerializedName("id_user")
	private String idUser;

	@SerializedName("quality_control")
	private String qualityControl;

	public void setLokasiAwal(String lokasiAwal){
		this.lokasiAwal = lokasiAwal;
	}

	public String getLokasiAwal(){
		return lokasiAwal;
	}

	public void setLokasiAkhir(String lokasiAkhir){
		this.lokasiAkhir = lokasiAkhir;
	}

	public String getLokasiAkhir(){
		return lokasiAkhir;
	}

	public void setNamaGambar(String namaGambar){
		this.namaGambar = namaGambar;
	}

	public String getNamaGambar(){
		return namaGambar;
	}

	public void setKodeBarang(String kodeBarang){
		this.kodeBarang = kodeBarang;
	}

	public String getKodeBarang(){
		return kodeBarang;
	}

	public void setSpesifikasi(String spesifikasi){
		this.spesifikasi = spesifikasi;
	}

	public String getSpesifikasi(){
		return spesifikasi;
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

	public void setQualityControl(String qualityControl){
		this.qualityControl = qualityControl;
	}

	public String getQualityControl(){
		return qualityControl;
	}
}
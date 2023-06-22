package com.example.sima.data.response;

import com.google.gson.annotations.SerializedName;

public class DataRegister{

	@SerializedName("jabatan")
	private String jabatan;

	public String getValidasi() {
		return validasi;
	}

	public void setValidasi(String validasi) {
		this.validasi = validasi;
	}

	@SerializedName("validasi")
	private String validasi;

	@SerializedName("nama_lengkap")
	private String namaLengkap;

	@SerializedName("agama")
	private String agama;

	@SerializedName("no_handphone")
	private String noHandphone;

	@SerializedName("pendidikan_terakhir")
	private String pendidikanTerakhir;

	@SerializedName("alamat_lengkap")
	private String alamatLengkap;

	@SerializedName("keawrganegaraan")
	private String keawrganegaraan;

	@SerializedName("departemen")
	private String departemen;

	@SerializedName("password")
	private String password;

	@SerializedName("tempat_lahir")
	private String tempatLahir;

	@SerializedName("jenis_kelamin")
	private String jenisKelamin;

	@SerializedName("tanggal_lahir")
	private String tanggalLahir;

	@SerializedName("username")
	private String username;

	public void setJabatan(String jabatan){
		this.jabatan = jabatan;
	}

	public String getJabatan(){
		return jabatan;
	}

	public void setNamaLengkap(String namaLengkap){
		this.namaLengkap = namaLengkap;
	}

	public String getNamaLengkap(){
		return namaLengkap;
	}

	public void setAgama(String agama){
		this.agama = agama;
	}

	public String getAgama(){
		return agama;
	}

	public void setNoHandphone(String noHandphone){
		this.noHandphone = noHandphone;
	}

	public String getNoHandphone(){
		return noHandphone;
	}

	public void setPendidikanTerakhir(String pendidikanTerakhir){
		this.pendidikanTerakhir = pendidikanTerakhir;
	}

	public String getPendidikanTerakhir(){
		return pendidikanTerakhir;
	}

	public void setAlamatLengkap(String alamatLengkap){
		this.alamatLengkap = alamatLengkap;
	}

	public String getAlamatLengkap(){
		return alamatLengkap;
	}

	public void setKeawrganegaraan(String keawrganegaraan){
		this.keawrganegaraan = keawrganegaraan;
	}

	public String getKeawrganegaraan(){
		return keawrganegaraan;
	}

	public void setDepartemen(String departemen){
		this.departemen = departemen;
	}

	public String getDepartemen(){
		return departemen;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setTempatLahir(String tempatLahir){
		this.tempatLahir = tempatLahir;
	}

	public String getTempatLahir(){
		return tempatLahir;
	}

	public void setJenisKelamin(String jenisKelamin){
		this.jenisKelamin = jenisKelamin;
	}

	public String getJenisKelamin(){
		return jenisKelamin;
	}

	public void setTanggalLahir(String tanggalLahir){
		this.tanggalLahir = tanggalLahir;
	}

	public String getTanggalLahir(){
		return tanggalLahir;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}
}
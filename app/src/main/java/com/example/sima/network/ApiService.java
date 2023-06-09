package com.example.sima.network;

import com.example.sima.data.model.Barang;
import com.example.sima.data.response.DataAset;
import com.example.sima.data.response.DataGenset;
import com.example.sima.data.response.DataLaporanHarian;
import com.example.sima.data.response.DataMotorPompa;
import com.example.sima.data.response.DataMutasi;
import com.example.sima.data.response.DataPerawatan;
import com.example.sima.data.response.DataPompa;
import com.example.sima.data.response.DataRegister;
import com.example.sima.data.response.DataUser;
import com.example.sima.data.response.TambahGensetResponse;
import com.example.sima.data.response.TambahLaporanHarianResponse;
import com.example.sima.data.response.LoginResponse;
import com.example.sima.data.response.RegisterResponse;
import com.example.sima.data.response.TambahAsetResponse;
import com.example.sima.data.response.TambahMotorPompaResponse;
import com.example.sima.data.response.TambahMutasiResponse;
import com.example.sima.data.response.TambahPanelResponse;
import com.example.sima.data.response.TambahPerawatanResponse;
import com.example.sima.data.response.TambahPompaResponse;
import com.example.sima.data.response.TambahUnitProduksiResponse;
import com.example.sima.data.response.admin.GetLaporanResponse;
import com.example.sima.data.response.admin.GetMutasiResponse;
import com.example.sima.data.response.admin.GetPerawatanResponse;
import com.example.sima.data.response.admin.GetSpekGensetResponse;
import com.example.sima.data.response.admin.GetSpekMotorPompaResponse;
import com.example.sima.data.response.admin.GetSpekPanelResponse;
import com.example.sima.data.response.admin.GetSpekPompaResponse;
import com.example.sima.data.response.admin.GetUnitProduksiResponse;
import com.example.sima.data.response.admin.ValidasiResponse;
import com.example.sima.data.response.laporanBulanan.LaporanBulananResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

    @FormUrlEncoded
    @POST("auth/login.php")
    Call<LoginResponse> loginUser(
            @Field("username") String username,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("auth/register.php")
    Call<RegisterResponse> registerUser(
            @Field("nama_lengkap")
            String nama_lengkap,
            @Field("tempat_lahir")
            String tempat_lahir,
            @Field("tanggal_lahir")
            String tanggal_lahir,
            @Field("alamat_lengkap")
            String alamat_lengkap,
            @Field("jenis_kelamin")
            String jenis_kelamin,
            @Field("kewarganegaraan")
            String kewarganegaraan,
            @Field("agama")
            String agama,
            @Field("no_handphone")
            String no_handphone,
            @Field("pendidikan_terakhir")
            String pendidikan_terakhir,
            @Field("jabatan")
            String jabatan,
            @Field("departemen")
            String departemen,
            @Field("username")
            String username,
            @Field("password")
            String password,
            @Field("validasi")
            String validasi
    );

    @FormUrlEncoded
    @POST("sima/tambah_data/tambah_aset.php")
    Call<TambahAsetResponse> tambahAset(
            @Field("kode_barang")
            String kode_barang,
            @Field("nama_barang")
            String nama_barang,
            @Field("merk")
            String merk,
            @Field("harga")
            String harga,
            @Field("jangka_penggunaan")
            String jangka_penggunaan,
            @Field("tanggal_masuk")
            String tanggal_masuk,
            @Field("penanggung_jawab")
            String penanggung_jawab,
            @Field("kondisi")
            String kondisi,
            @Field("nama_gambar")
            String nama_gambar
    );

    @FormUrlEncoded
    @POST("sima/tambah_data/tambah_perawatan.php")
    Call<TambahPerawatanResponse> tambahPerawatan(
            @Field("tanggal")
            String tanggal,
            @Field("id_user")
            String id_user,
            @Field("kode_barang")
            String kode_barang,
            @Field("uraian_kegiatan")
            String uraian_kegiatan,
            @Field("nama_gambar")
            String nama_gambar
    );

    @FormUrlEncoded
    @POST("sima/tambah_data/tambah_mutasi.php")
    Call<TambahMutasiResponse> tambahMutasi(
            @Field("tanggal")
            String tanggal,
            @Field("kode_barang")
            String kode_barang,
            @Field("lokasi_awal")
            String lokasi_awal,
            @Field("spesifikasi")
            String spesifikasi,
            @Field("nama_gambar")
            String nama_gambar,
            @Field("lokasi_akhir")
            String lokasi_akhir,
            @Field("id_user")
            String is_user,
            @Field("quality_control")
            String quality_control
    );

    @FormUrlEncoded
    @POST("sima/tambah_data/tambah_unit_produksi.php")
    Call<TambahUnitProduksiResponse> tambahUnitProduksi(
            @Field("tanggal")
            String tanggal,
            @Field("id_user")
            String id_user,
            @Field("uraian_kegiatan")
            String uraian_kegiatan,
            @Field("daya_listrik")
            String daya_listrik,
            @Field("nama_gambar")
            String nama_gambar
    );

    @FormUrlEncoded
    @POST("sima/tambah_data/tambah_pompa.php")
    Call<TambahPompaResponse> tambahPompa(
            @Field("tanggal")
            String tanggal,
            @Field("kode_barang")
            String kode_barang,
            @Field("head_pompa")
            String head_pompa,
            @Field("debit_pompa")
            String debit_pompa,
            @Field("id_user")
            String is_user,
            @Field("jenis_pompa")
            String jenis_pompa
    );

    @FormUrlEncoded
    @POST("sima/tambah_data/tambah_motor_pompa.php")
    Call<TambahMotorPompaResponse> tambahMotorPompa(
            @Field("tanggal")
            String tanggal,
            @Field("kode_barang")
            String kode_barang,
            @Field("daya_listrik")
            String daya_listrik,
            @Field("arus_maks")
            String arus_maks,
            @Field("cos")
            String cos,
            @Field("id_user")
            String id_user
    );

    @FormUrlEncoded
    @POST("sima/tambah_data/tambah_panel.php")
    Call<TambahPanelResponse> tambahPanel(
            @Field("tanggal")
            String tanggal,
            @Field("kode_barang")
            String kode_barang,
            @Field("star_delta")
            String star_delta,
            @Field("direct_online")
            String direct_online,
            @Field("kapasitas_beban")
            String kapasitas_beban,
            @Field("id_user")
            String id_user
    );

    @FormUrlEncoded
    @POST("sima/tambah_data/tambah_genset.php")
    Call<TambahGensetResponse> tambahGenset(
            @Field("tanggal")
            String tanggal,
            @Field("kode_barang")
            String kode_barang,
            @Field("merk_genset")
            String merk_genset,
            @Field("tipe")
            String tipe,
            @Field("kapasitas")
            String kapasitas,
            @Field("kondisi")
            String kondisi,
            @Field("id_user")
            String id_user
    );

    @FormUrlEncoded
    @POST("sima/tambah_data/tambah_laporan_harian.php")
    Call<TambahLaporanHarianResponse> tambahLaporanHarian(
            @Field("tanggal")
            String tanggal,
            @Field("beban_puncak")
            String beban_puncak,
            @Field("luar_beban_puncak")
            String luar_beban_puncak,
            @Field("penggunaan_daya_reaktif")
            String penggunaan_daya_reaktif,
            @Field("standmeter")
            String standmeter,
            @Field("id_user")
            String id_user,
            @Field("nama_karyawan_dua")
            String nama_karyawan_dua);

    @GET("sima/get_data/get_nama_aset.php")
    Call<List<Barang>> getNamaBarang();

    @GET("sima/admin/get_aset.php")
    Call<List<DataAset>> getDataAset();

    @GET("sima/admin/get_karyawan.php")
    Call<List<DataUser>> getDataKaryawan();

    @GET("sima/admin/get_pendaftar.php")
    Call<List<DataUser>> getDataPendaftar();

    @GET("sima/admin/get_laporan_harian.php")
    Call<List<GetLaporanResponse>> getDataLaporanHarian();

    @GET("sima/admin/get_mutasi.php")
    Call<List<GetMutasiResponse>> getDataMutasi();

    @GET("sima/admin/get_perawatan.php")
    Call<List<GetPerawatanResponse>> getDataPerawatan();

    @GET("sima/admin/get_spek_genset.php")
    Call<List<GetSpekGensetResponse>> getDataSpekGenset();

    @GET("sima/admin/get_spek_motor_pompa.php")
    Call<List<GetSpekMotorPompaResponse>> getDataSpekMotorPompa();

    @GET("sima/admin/get_spek_panel.php")
    Call<List<GetSpekPanelResponse>> getDataSpekPanel();

    @GET("sima/admin/get_spek_pompa.php")
    Call<List<GetSpekPompaResponse>> getDataSpekPompa(
            @Query("jenis_pompa") String jenisPompa
    );

    @GET("sima/admin/get_unit_produksi.php")
    Call<List<GetUnitProduksiResponse>> getDataUnitProduksi();

    @GET("sima/admin/get_laporan_bulanan.php")
    Call<LaporanBulananResponse> getLaporanBulanan(
            @Query("bulan") String bulan
    );

    @FormUrlEncoded
    @POST("sima/admin/update_validasi_user.php")
    Call<ValidasiResponse> validasiPendaftar(
            @Field("id_user")
            String id_user,
            @Field("validasi")
            String validasi
    );
}


package com.example.sima.network;

import com.example.sima.data.model.Barang;
import com.example.sima.data.response.DataAset;
import com.example.sima.data.response.LoginResponse;
import com.example.sima.data.response.RegisterResponse;
import com.example.sima.data.response.TambahAsetResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

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
            String password
    );

    @FormUrlEncoded
    @POST("sima/tambah_aset.php")
    Call<TambahAsetResponse> tambahAset(
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

    @GET("sima/get_nama_aset.php")
    Call<List<Barang>> getNamaBarang();

    @GET("sima/get_aset.php")
    Call<List<DataAset>> getDataAset();
}


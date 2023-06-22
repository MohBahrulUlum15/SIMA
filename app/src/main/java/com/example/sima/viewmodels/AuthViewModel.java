package com.example.sima.viewmodels;

import androidx.lifecycle.ViewModel;

import com.example.sima.data.response.LoginResponse;
import com.example.sima.data.response.RegisterResponse;
import com.example.sima.network.ApiConfig;

import retrofit2.Call;
import retrofit2.Callback;

public class AuthViewModel extends ViewModel {
    public void login(String username, String password, Callback<LoginResponse> callback) {
        Call<LoginResponse> call = ApiConfig.getApiService().loginUser(username, password);
        call.enqueue(callback);
    }

    public void register(String nama_lengkap,
                         String tempat_lahir,
                         String tanggal_lahir,
                         String alamat_lengkap,
                         String jenis_kelamin,
                         String kewarganegaraan,
                         String agama,
                         String no_handphone,
                         String pendidikan_terakhir,
                         String jabatan,
                         String departemen,
                         String username,
                         String password,
                         String validasi,
                         Callback<RegisterResponse> callback) {
        Call<RegisterResponse> call = ApiConfig.getApiService().registerUser(
                nama_lengkap, tempat_lahir,
                tanggal_lahir, alamat_lengkap,
                jenis_kelamin, kewarganegaraan,
                agama, no_handphone, pendidikan_terakhir,
                jabatan, departemen, username, password, validasi);
        call.enqueue(callback);
    }
}

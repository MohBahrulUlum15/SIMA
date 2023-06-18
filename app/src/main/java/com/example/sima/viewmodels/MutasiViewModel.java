package com.example.sima.viewmodels;

import androidx.lifecycle.ViewModel;

import com.example.sima.data.response.admin.GetMutasiResponse;
import com.example.sima.data.response.TambahAsetResponse;
import com.example.sima.data.response.TambahMutasiResponse;
import com.example.sima.network.ApiConfig;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class MutasiViewModel extends ViewModel {

    public void tambahMutasi(String tanggal,
                           String kode_barang,
                           String lokasi_awal,
                           String spesifikasi,
                           String nama_gambar,
                           String lokasi_akhir,
                           String id_user,
                           String quality_control,
                           Callback<TambahMutasiResponse> callback) {
        Call<TambahMutasiResponse> call = ApiConfig.getApiService().tambahMutasi(tanggal, kode_barang,
                lokasi_awal, spesifikasi, nama_gambar, lokasi_akhir, id_user, quality_control);
        call.enqueue(callback);
    }

    public void getDataMutasi(Callback<List<GetMutasiResponse>> callback){
        Call<List<GetMutasiResponse>> call = ApiConfig.getApiService().getDataMutasi();
        call.enqueue(callback);
    }
}

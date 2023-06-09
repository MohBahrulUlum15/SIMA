package com.example.sima.viewmodels;

import androidx.lifecycle.ViewModel;

import com.example.sima.data.response.TambahPerawatanResponse;
import com.example.sima.network.ApiConfig;

import retrofit2.Call;
import retrofit2.Callback;

public class PerawatanViewModel extends ViewModel {

    public void tambahPerawatan(String tanggal,
                             String kode_barang,
                             String uraian_kegiatan,
                             String nama_gambar,
                             Callback<TambahPerawatanResponse> callback) {
        Call<TambahPerawatanResponse> call = ApiConfig.getApiService().tambahPerawatan(tanggal, kode_barang,
                uraian_kegiatan, nama_gambar);
        call.enqueue(callback);
    }
}

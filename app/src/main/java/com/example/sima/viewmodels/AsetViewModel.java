package com.example.sima.viewmodels;

import androidx.lifecycle.ViewModel;

import com.example.sima.data.response.DataAset;
import com.example.sima.data.response.TambahAsetResponse;
import com.example.sima.network.ApiConfig;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class AsetViewModel extends ViewModel {

    public void tambahAset(String nama_barang,
                           String merk,
                           String harga,
                           String jangka_penggunaan,
                           String tanggal_masuk,
                           String penanggung_jawab,
                           String kondisi,
                           String nama_gambar,
                           Callback<TambahAsetResponse> callback) {
        Call<TambahAsetResponse> call = ApiConfig.getApiService().tambahAset(
                nama_barang, merk,
                harga, jangka_penggunaan,
                tanggal_masuk, penanggung_jawab,
                kondisi, nama_gambar);
        call.enqueue(callback);
    }

    public void getFullAset(Callback<List<DataAset>> callback){
        Call<List<DataAset>> call = ApiConfig.getApiService().getDataAset();
        call.enqueue(callback);
    }

}

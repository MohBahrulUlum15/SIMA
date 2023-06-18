package com.example.sima.viewmodels;

import androidx.lifecycle.ViewModel;

import com.example.sima.data.response.admin.GetSpekGensetResponse;
import com.example.sima.data.response.TambahGensetResponse;
import com.example.sima.network.ApiConfig;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class GensetViewModel extends ViewModel {

    public void tambahGenset(String tanggal,
                                 String kode_barang,
                                 String merk_genset,
                                 String tipe,
                                 String kapasitas,
                                 String kondisi,
                                 String id_user,
                                 Callback<TambahGensetResponse> callback) {
        Call<TambahGensetResponse> call = ApiConfig.getApiService().tambahGenset(tanggal, kode_barang,
                merk_genset, tipe, kapasitas, kondisi, id_user);
        call.enqueue(callback);
    }

    public void getDataSpekGenset(Callback<List<GetSpekGensetResponse>> callback){
        Call<List<GetSpekGensetResponse>> call = ApiConfig.getApiService().getDataSpekGenset();
        call.enqueue(callback);
    }
}

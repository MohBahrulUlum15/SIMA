package com.example.sima.viewmodels;

import androidx.lifecycle.ViewModel;

import com.example.sima.data.response.admin.GetUnitProduksiResponse;
import com.example.sima.data.response.TambahPerawatanResponse;
import com.example.sima.data.response.TambahUnitProduksiResponse;
import com.example.sima.network.ApiConfig;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class UnitProduksiViewModel extends ViewModel {

    public void tambahUnitProduksi(String tanggal,
                                   String id_user,
                                   String uraian_kegiatan,
                                   String daya_listrik,
                                   String nama_gambar,
                                   Callback<TambahUnitProduksiResponse> callback) {
        Call<TambahUnitProduksiResponse> call = ApiConfig.getApiService().tambahUnitProduksi(tanggal, id_user,
                uraian_kegiatan, daya_listrik, nama_gambar);
        call.enqueue(callback);
    }

    public void getDataUnitProduksi(Callback<List<GetUnitProduksiResponse>> callback){
        Call<List<GetUnitProduksiResponse>> call = ApiConfig.getApiService().getDataUnitProduksi();
        call.enqueue(callback);
    }
}

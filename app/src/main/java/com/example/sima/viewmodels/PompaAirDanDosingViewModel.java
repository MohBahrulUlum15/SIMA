package com.example.sima.viewmodels;

import androidx.lifecycle.ViewModel;

import com.example.sima.data.response.admin.GetSpekPompaResponse;
import com.example.sima.data.response.TambahPompaResponse;
import com.example.sima.data.response.TambahUnitProduksiResponse;
import com.example.sima.network.ApiConfig;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class PompaAirDanDosingViewModel extends ViewModel {

    public void tambahPompa(String tanggal,
                            String kode_barang,
                            String head_pompa,
                            String debit_pompa,
                            String id_user,
                            String jenis_pompa,
                            Callback<TambahPompaResponse> callback) {
        Call<TambahPompaResponse> call = ApiConfig.getApiService().tambahPompa(tanggal, kode_barang,
                head_pompa, debit_pompa, id_user, jenis_pompa);
        call.enqueue(callback);
    }

    public void getDataSpekPompa(String jenisPompa, Callback<List<GetSpekPompaResponse>> callback){
        Call<List<GetSpekPompaResponse>> call = ApiConfig.getApiService().getDataSpekPompa(jenisPompa);
        call.enqueue(callback);
    }
}

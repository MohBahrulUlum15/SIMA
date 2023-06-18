package com.example.sima.viewmodels;

import androidx.lifecycle.ViewModel;

import com.example.sima.data.response.admin.GetSpekPanelResponse;
import com.example.sima.data.response.TambahPanelResponse;
import com.example.sima.network.ApiConfig;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class PanelViewModel extends ViewModel {

    public void tambahPanel(String tanggal,
                                 String kode_barang,
                                 String star_delta,
                                 String direct_online,
                                 String kapasitas_beban,
                                 String id_user,
                                 Callback<TambahPanelResponse> callback) {
        Call<TambahPanelResponse> call = ApiConfig.getApiService().tambahPanel(tanggal, kode_barang,
                star_delta, direct_online, kapasitas_beban, id_user);
        call.enqueue(callback);
    }

    public void getDataSpekPanel(Callback<List<GetSpekPanelResponse>> callback){
        Call<List<GetSpekPanelResponse>> call = ApiConfig.getApiService().getDataSpekPanel();
        call.enqueue(callback);
    }
}

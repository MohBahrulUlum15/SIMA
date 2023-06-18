package com.example.sima.viewmodels;

import androidx.lifecycle.ViewModel;

import com.example.sima.data.response.admin.GetSpekMotorPompaResponse;
import com.example.sima.data.response.TambahMotorPompaResponse;
import com.example.sima.network.ApiConfig;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class MotorPompaViewModel extends ViewModel {

    public void tambahMotorPompa(String tanggal,
                                 String kode_barang,
                                 String daya_listrik,
                                 String arus_maks,
                                 String cos,
                                 String id_user,
                                 Callback<TambahMotorPompaResponse> callback) {
        Call<TambahMotorPompaResponse> call = ApiConfig.getApiService().tambahMotorPompa(tanggal, kode_barang,
                daya_listrik, arus_maks, cos, id_user);
        call.enqueue(callback);
    }

    public void getDataSpekMotorPompa(Callback<List<GetSpekMotorPompaResponse>> callback){
        Call<List<GetSpekMotorPompaResponse>> call = ApiConfig.getApiService().getDataSpekMotorPompa();
        call.enqueue(callback);
    }

}

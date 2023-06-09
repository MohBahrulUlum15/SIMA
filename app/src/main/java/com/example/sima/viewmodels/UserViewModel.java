package com.example.sima.viewmodels;

import androidx.lifecycle.ViewModel;

import com.example.sima.data.response.DataUser;
import com.example.sima.data.response.DataUser;
import com.example.sima.data.response.admin.ValidasiResponse;
import com.example.sima.network.ApiConfig;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class UserViewModel extends ViewModel {

    public void getDataKaryawan(Callback<List<DataUser>> callback){
        Call<List<DataUser>> call = ApiConfig.getApiService().getDataKaryawan();
        call.enqueue(callback);
    }

    public void getDataPendaftar(Callback<List<DataUser>> callback){
        Call<List<DataUser>> call = ApiConfig.getApiService().getDataPendaftar();
        call.enqueue(callback);
    }

    public void validasiPendaftar(String id_user, String validasi, Callback<ValidasiResponse> callback){
        Call<ValidasiResponse> call = ApiConfig.getApiService().validasiPendaftar(id_user, validasi);
        call.enqueue(callback);
    }
}

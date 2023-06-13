package com.example.sima.viewmodels;

import androidx.lifecycle.ViewModel;

import com.example.sima.data.response.TambahLaporanHarianResponse;
import com.example.sima.data.response.TambahMutasiResponse;
import com.example.sima.network.ApiConfig;

import retrofit2.Call;
import retrofit2.Callback;

public class LaporanHarianViewModel extends ViewModel {

    public void tambahLaporanHarian(String tanggal,
                             String beban_puncak,
                             String luar_beban_puncak,
                             String penggunaan_daya_reaktif,
                             String standmeter,
                             String id_user,
                             String nama_karyawan_dua,
                             Callback<TambahLaporanHarianResponse> callback) {
        Call<TambahLaporanHarianResponse> call = ApiConfig.getApiService().tambahLaporanHarian(tanggal, beban_puncak, luar_beban_puncak, penggunaan_daya_reaktif,
                standmeter, id_user, nama_karyawan_dua);
        call.enqueue(callback);
    }
}

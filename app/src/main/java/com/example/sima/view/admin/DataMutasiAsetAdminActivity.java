package com.example.sima.view.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.sima.R;
import com.example.sima.data.adapter.MutasiAdapter;
import com.example.sima.data.response.admin.GetMutasiResponse;
import com.example.sima.data.response.admin.GetMutasiResponse;
import com.example.sima.databinding.ActivityDataMutasiAsetAdminBinding;
import com.example.sima.databinding.ActivityDataPerawatanAsetAdminBinding;
import com.example.sima.viewmodels.MutasiViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataMutasiAsetAdminActivity extends AppCompatActivity {

    private ActivityDataMutasiAsetAdminBinding binding;

    private MutasiViewModel mutasiViewModel;
    private RecyclerView recyclerView;
    private MutasiAdapter mutasiAdapter;
    private ArrayList<GetMutasiResponse> daftarMutasi;
    private ArrayList<GetMutasiResponse> filteredList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDataMutasiAsetAdminBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        mutasiViewModel = new ViewModelProvider(this).get(MutasiViewModel.class);

        recyclerView = findViewById(R.id.rv_data);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        daftarMutasi = new ArrayList<>();
        filteredList = new ArrayList<>();
        mutasiAdapter = new MutasiAdapter(filteredList);
        recyclerView.setAdapter(mutasiAdapter);

        mutasiViewModel.getDataMutasi(new Callback<List<GetMutasiResponse>>() {
            @Override
            public void onResponse(Call<List<GetMutasiResponse>> call, Response<List<GetMutasiResponse>> response) {
                if (response.isSuccessful()){
                    daftarMutasi.addAll(response.body());
                    filteredList.addAll(daftarMutasi);
                    mutasiAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(DataMutasiAsetAdminActivity.this, "Kosong! Tidak ada data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<GetMutasiResponse>> call, Throwable t) {
                Toast.makeText(DataMutasiAsetAdminActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                filteredList.clear();
                if (s.isEmpty()) {
                    filteredList.addAll(daftarMutasi);
                } else {
                    String filterPattern = s.toLowerCase().trim();
                    for (GetMutasiResponse mutasi : daftarMutasi) {
                        if (mutasi.getKodeBarang().toLowerCase().contains(filterPattern)
                                || mutasi.getNamaBarang().toLowerCase().contains(filterPattern)
                                || mutasi.getTanggal().toLowerCase().contains(filterPattern)
                                || mutasi.getLokasiAkhir().toLowerCase().contains(filterPattern)
                                || mutasi.getLokasiAwal().toLowerCase().contains(filterPattern)) {
                            filteredList.add(mutasi);
                        }
                    }
                }
                mutasiAdapter.notifyDataSetChanged();
                return true;
            }
        });
    }
}
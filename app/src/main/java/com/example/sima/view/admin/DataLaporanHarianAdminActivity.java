package com.example.sima.view.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.sima.R;
import com.example.sima.data.adapter.KaryawanAdapter;
import com.example.sima.data.adapter.LaporanAdapter;
import com.example.sima.data.response.DataAset;
import com.example.sima.data.response.admin.GetLaporanResponse;
import com.example.sima.data.response.admin.GetLaporanResponse;
import com.example.sima.databinding.ActivityDataKaryawanAdminBinding;
import com.example.sima.databinding.ActivityDataLaporanAdminBinding;
import com.example.sima.viewmodels.LaporanHarianViewModel;
import com.example.sima.viewmodels.UserViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataLaporanHarianAdminActivity extends AppCompatActivity {

    private ActivityDataLaporanAdminBinding binding;

    private LaporanHarianViewModel laporanHarianViewModel;
    private RecyclerView recyclerView;
    private LaporanAdapter laporanAdapter;
    private ArrayList<GetLaporanResponse> daftarLaporan;
    private ArrayList<GetLaporanResponse> filteredList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDataLaporanAdminBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        laporanHarianViewModel = new ViewModelProvider(this).get(LaporanHarianViewModel.class);

        recyclerView = findViewById(R.id.rv_data);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        daftarLaporan = new ArrayList<>();
        filteredList = new ArrayList<>();
        laporanAdapter = new LaporanAdapter(filteredList);
        recyclerView.setAdapter(laporanAdapter);

        laporanHarianViewModel.getDataLaporanHarian(new Callback<List<GetLaporanResponse>>() {
            @Override
            public void onResponse(Call<List<GetLaporanResponse>> call, Response<List<GetLaporanResponse>> response) {
                if (response.isSuccessful()){
                    daftarLaporan.addAll(response.body());
                    filteredList.addAll(daftarLaporan);
                    binding.tvJumlahData.setText("Jumlah data : " + String.valueOf(filteredList.size()));
                    laporanAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(DataLaporanHarianAdminActivity.this, "Kosong! Tidak ada data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<GetLaporanResponse>> call, Throwable t) {
                Toast.makeText(DataLaporanHarianAdminActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
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
                    filteredList.addAll(daftarLaporan);
                } else {
                    String filterPattern = s.toLowerCase().trim();
                    for (GetLaporanResponse laporan : daftarLaporan) {
                        if (laporan.getTanggal().toLowerCase().contains(filterPattern)) {
                            filteredList.add(laporan);
                        }
                    }
                }
                binding.tvJumlahData.setText("Jumlah data : " + String.valueOf(filteredList.size()));
                laporanAdapter.notifyDataSetChanged();
                return true;
            }
        });

        binding.btnCetakLaporanBulanan.setOnClickListener(view -> {startActivity(new Intent(DataLaporanHarianAdminActivity.this, CetakLaporanActivity.class));});
    }
}
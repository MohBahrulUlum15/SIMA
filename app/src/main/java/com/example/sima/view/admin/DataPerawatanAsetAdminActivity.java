package com.example.sima.view.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.sima.R;
import com.example.sima.data.adapter.LaporanAdapter;
import com.example.sima.data.adapter.PerawatanAdapter;
import com.example.sima.data.response.admin.GetPerawatanResponse;
import com.example.sima.data.response.admin.GetPerawatanResponse;
import com.example.sima.data.response.admin.GetPerawatanResponse;
import com.example.sima.databinding.ActivityDataLaporanAdminBinding;
import com.example.sima.databinding.ActivityDataPerawatanAsetAdminBinding;
import com.example.sima.viewmodels.PerawatanViewModel;
import com.example.sima.viewmodels.PerawatanViewModel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataPerawatanAsetAdminActivity extends AppCompatActivity {

    private ActivityDataPerawatanAsetAdminBinding binding;

    private PerawatanViewModel perawatanViewModel;
    private RecyclerView recyclerView;
    private PerawatanAdapter perawatanAdapter;
    private ArrayList<GetPerawatanResponse> daftarPerawatan;
    private ArrayList<GetPerawatanResponse> filteredList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDataPerawatanAsetAdminBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        perawatanViewModel = new ViewModelProvider(this).get(PerawatanViewModel.class);

        recyclerView = findViewById(R.id.rv_data);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        daftarPerawatan = new ArrayList<>();
        filteredList = new ArrayList<>();
        perawatanAdapter = new PerawatanAdapter(filteredList);
        recyclerView.setAdapter(perawatanAdapter);

        perawatanViewModel.getDataPerawatan(new Callback<List<GetPerawatanResponse>>() {
            @Override
            public void onResponse(Call<List<GetPerawatanResponse>> call, Response<List<GetPerawatanResponse>> response) {
                if (response.isSuccessful()){
                    daftarPerawatan.addAll(response.body());
                    filteredList.addAll(daftarPerawatan);
                    perawatanAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(DataPerawatanAsetAdminActivity.this, "Kosong! Tidak ada data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<GetPerawatanResponse>> call, Throwable t) {
                Toast.makeText(DataPerawatanAsetAdminActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
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
                    filteredList.addAll(daftarPerawatan);
                } else {
                    String filterPattern = s.toLowerCase().trim();
                    for (GetPerawatanResponse perawatan : daftarPerawatan) {
                        if (perawatan.getNamaBarang().toLowerCase().contains(filterPattern)
                                || perawatan.getNamaLengkap().toLowerCase().contains(filterPattern)
                                || perawatan.getUraianKegiatan().toLowerCase().contains(filterPattern)
                                || perawatan.getTanggal().toLowerCase().contains(filterPattern)) {
                            filteredList.add(perawatan);
                        }
                    }
                }
                perawatanAdapter.notifyDataSetChanged();
                return true;
            }
        });
    }
}
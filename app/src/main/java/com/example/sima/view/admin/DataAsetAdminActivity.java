package com.example.sima.view.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.sima.R;
import com.example.sima.data.adapter.AsetAdapter;
import com.example.sima.data.response.DataAset;
import com.example.sima.databinding.ActivityDataAsetAdminBinding;
import com.example.sima.viewmodels.AsetViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataAsetAdminActivity extends AppCompatActivity {

    private ActivityDataAsetAdminBinding binding;

    private AsetViewModel asetViewModel;
    private RecyclerView recyclerView;
    private AsetAdapter asetAdapter;
    private ArrayList<DataAset> daftarAset;
    private ArrayList<DataAset> filteredList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDataAsetAdminBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        asetViewModel = new ViewModelProvider(this).get(AsetViewModel.class);
        recyclerView = findViewById(R.id.rv_data);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        daftarAset = new ArrayList<>();
        filteredList = new ArrayList<>();
        asetAdapter = new AsetAdapter(filteredList);
        recyclerView.setAdapter(asetAdapter);

        asetViewModel.getFullAset(new Callback<List<DataAset>>() {
            @Override
            public void onResponse(Call<List<DataAset>> call, Response<List<DataAset>> response) {
                if (response.isSuccessful()) {
                    daftarAset.addAll(response.body());
                    filteredList.addAll(daftarAset);
                    asetAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(DataAsetAdminActivity.this, "Kosong! Tidak ada data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<DataAset>> call, Throwable t) {
                Toast.makeText(DataAsetAdminActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
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
                    filteredList.addAll(daftarAset);
                } else {
                    String filterPattern = s.toLowerCase().trim();
                    for (DataAset aset : daftarAset) {
                        if (aset.getKodeBarang().toLowerCase().contains(filterPattern)
                                || aset.getNamaBarang().toLowerCase().contains(filterPattern)
                                || aset.getMerk().toLowerCase().contains(filterPattern)) {
                            filteredList.add(aset);
                        }
                    }
                }
                asetAdapter.notifyDataSetChanged();
                return true;
            }
        });
    }
}
package com.example.sima.view.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sima.R;
import com.example.sima.data.adapter.SpekGensetAdapter;
import com.example.sima.data.response.admin.GetSpekGensetResponse;
import com.example.sima.data.response.admin.GetSpekGensetResponse;
import com.example.sima.databinding.ActivityDataSpekGensetAdminBinding;
import com.example.sima.viewmodels.GensetViewModel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataSpekGensetAdminActivity extends AppCompatActivity {

    private ActivityDataSpekGensetAdminBinding binding;
    private GensetViewModel gensetViewModel;
    private RecyclerView recyclerView;
    private SpekGensetAdapter gensetAdapter;
    private ArrayList<GetSpekGensetResponse> daftarSpekGenset;
    private ArrayList<GetSpekGensetResponse> filteredList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDataSpekGensetAdminBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        gensetViewModel = new ViewModelProvider(this).get(GensetViewModel.class);

        recyclerView = findViewById(R.id.rv_data);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        daftarSpekGenset = new ArrayList<>();
        filteredList = new ArrayList<>();
        gensetAdapter = new SpekGensetAdapter(filteredList);
        recyclerView.setAdapter(gensetAdapter);

        gensetViewModel.getDataSpekGenset(new Callback<List<GetSpekGensetResponse>>() {
            @Override
            public void onResponse(Call<List<GetSpekGensetResponse>> call, Response<List<GetSpekGensetResponse>> response) {
                if (response.isSuccessful()){
                    daftarSpekGenset.addAll(response.body());
                    filteredList.addAll(daftarSpekGenset);
                    binding.tvJumlahData.setText("Jumlah data : " + String.valueOf(filteredList.size()));
                    gensetAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(DataSpekGensetAdminActivity.this, "Kosong! Tidak ada data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<GetSpekGensetResponse>> call, Throwable t) {
                Toast.makeText(DataSpekGensetAdminActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filteredList.clear();
                if (newText.isEmpty()) {
                    filteredList.addAll(daftarSpekGenset);
                } else {
                    String filterPattern = newText.toLowerCase().trim();
                    for (GetSpekGensetResponse aset : daftarSpekGenset) {
                        if (aset.getNamaBarang().toLowerCase().contains(filterPattern)
                                || aset.getTanggal().toLowerCase().contains(filterPattern)
                        ) {
                            filteredList.add(aset);
                        }
                    }
                }
                binding.tvJumlahData.setText("Jumlah data : " + String.valueOf(filteredList.size()));
                gensetAdapter.notifyDataSetChanged();
                return true;
            }
        });
    }
}
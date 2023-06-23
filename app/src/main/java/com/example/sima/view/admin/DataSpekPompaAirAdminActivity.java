package com.example.sima.view.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.sima.R;
import com.example.sima.data.adapter.SpekPompaAdapter;
import com.example.sima.data.response.admin.GetSpekPompaResponse;
import com.example.sima.data.response.admin.GetSpekPompaResponse;
import com.example.sima.databinding.ActivityDataSpekPompaAirAdminBinding;
import com.example.sima.viewmodels.PompaAirDanDosingViewModel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataSpekPompaAirAdminActivity extends AppCompatActivity {

    ActivityDataSpekPompaAirAdminBinding binding;
    private PompaAirDanDosingViewModel pompaAirDanDosingViewModel;
    private RecyclerView recyclerView;
    private SpekPompaAdapter pompaAdapter;
    private ArrayList<GetSpekPompaResponse> daftarSpekPompa;
    private ArrayList<GetSpekPompaResponse> filteredList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDataSpekPompaAirAdminBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        pompaAirDanDosingViewModel = new ViewModelProvider(this).get(PompaAirDanDosingViewModel.class);
        recyclerView = findViewById(R.id.rv_data);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        daftarSpekPompa = new ArrayList<>();
        filteredList = new ArrayList<>();
        pompaAdapter = new SpekPompaAdapter(filteredList);
        recyclerView.setAdapter(pompaAdapter);

        pompaAirDanDosingViewModel.getDataSpekPompa("pompa air", new Callback<List<GetSpekPompaResponse>>() {
            @Override
            public void onResponse(Call<List<GetSpekPompaResponse>> call, Response<List<GetSpekPompaResponse>> response) {
                if (response.isSuccessful()){
                    daftarSpekPompa.addAll(response.body());
                    filteredList.addAll(daftarSpekPompa);
                    binding.tvJumlahData.setText("Jumlah data : " + String.valueOf(filteredList.size()));
                    pompaAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(DataSpekPompaAirAdminActivity.this, "Kosong! Tidak ada data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<GetSpekPompaResponse>> call, Throwable t) {
                Toast.makeText(DataSpekPompaAirAdminActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
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
                    filteredList.addAll(daftarSpekPompa);
                } else {
                    String filterPattern = newText.toLowerCase().trim();
                    for (GetSpekPompaResponse aset : daftarSpekPompa) {
                        if (aset.getNamaBarang().toLowerCase().contains(filterPattern)
                                || aset.getTanggal().toLowerCase().contains(filterPattern)
                        ) {
                            filteredList.add(aset);
                        }
                    }
                }
                binding.tvJumlahData.setText("Jumlah data : " + String.valueOf(filteredList.size()));
                pompaAdapter.notifyDataSetChanged();
                return true;
            }
        });
    }
}
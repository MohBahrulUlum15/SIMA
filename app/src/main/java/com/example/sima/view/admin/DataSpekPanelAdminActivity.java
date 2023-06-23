package com.example.sima.view.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.sima.R;
import com.example.sima.data.adapter.SpekPanelAdapter;
import com.example.sima.data.response.admin.GetSpekPanelResponse;
import com.example.sima.data.response.admin.GetSpekPanelResponse;
import com.example.sima.databinding.ActivityDataSpekPanelAdminBinding;
import com.example.sima.viewmodels.PanelViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataSpekPanelAdminActivity extends AppCompatActivity {

    ActivityDataSpekPanelAdminBinding binding;

    private PanelViewModel panelViewModel;
    private RecyclerView recyclerView;
    private SpekPanelAdapter panelAdapter;
    private ArrayList<GetSpekPanelResponse> daftarSpekPanel;
    private ArrayList<GetSpekPanelResponse> filteredList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDataSpekPanelAdminBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        panelViewModel = new ViewModelProvider(this).get(PanelViewModel.class);
        recyclerView = findViewById(R.id.rv_data);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        daftarSpekPanel = new ArrayList<>();
        filteredList = new ArrayList<>();
        panelAdapter = new SpekPanelAdapter(filteredList);
        recyclerView.setAdapter(panelAdapter);

        panelViewModel.getDataSpekPanel(new Callback<List<GetSpekPanelResponse>>() {
            @Override
            public void onResponse(Call<List<GetSpekPanelResponse>> call, Response<List<GetSpekPanelResponse>> response) {
                if (response.isSuccessful()){
                    daftarSpekPanel.addAll(response.body());
                    filteredList.addAll(daftarSpekPanel);
                    binding.tvJumlahData.setText("Jumlah data : " + String.valueOf(filteredList.size()));
                    panelAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(DataSpekPanelAdminActivity.this, "Kosong! Tidak ada data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<GetSpekPanelResponse>> call, Throwable t) {
                Toast.makeText(DataSpekPanelAdminActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
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
                    filteredList.addAll(daftarSpekPanel);
                } else {
                    String filterPattern = newText.toLowerCase().trim();
                    for (GetSpekPanelResponse aset : daftarSpekPanel) {
                        if (aset.getNamaBarang().toLowerCase().contains(filterPattern)
                                || aset.getTanggal().toLowerCase().contains(filterPattern)
                        ) {
                            filteredList.add(aset);
                        }
                    }
                }
                binding.tvJumlahData.setText("Jumlah data : " + String.valueOf(filteredList.size()));
                panelAdapter.notifyDataSetChanged();
                return true;
            }
        });
    }
}
package com.example.sima.view.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.sima.R;
import com.example.sima.data.adapter.SpekPanelAdapter;
import com.example.sima.data.response.admin.GetSpekPanelResponse;
import com.example.sima.viewmodels.PanelViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataSpekPanelAdminActivity extends AppCompatActivity {

    private PanelViewModel panelViewModel;
    private RecyclerView recyclerView;
    private SpekPanelAdapter panelAdapter;
    private List<GetSpekPanelResponse> daftarSpekPanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_spek_panel_admin);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        panelViewModel = new ViewModelProvider(this).get(PanelViewModel.class);

        recyclerView = findViewById(R.id.rv_data);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        daftarSpekPanel = new ArrayList<>();
        panelAdapter = new SpekPanelAdapter(daftarSpekPanel);
        recyclerView.setAdapter(panelAdapter);

        panelViewModel.getDataSpekPanel(new Callback<List<GetSpekPanelResponse>>() {
            @Override
            public void onResponse(Call<List<GetSpekPanelResponse>> call, Response<List<GetSpekPanelResponse>> response) {
                if (response.isSuccessful()){
                    daftarSpekPanel.addAll(response.body());
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
    }
}
package com.example.sima.view.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.sima.R;
import com.example.sima.data.adapter.SpekPompaAdapter;
import com.example.sima.data.response.admin.GetSpekPompaResponse;
import com.example.sima.viewmodels.PompaAirDanDosingViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataSpekPompaDosingAdminActivity extends AppCompatActivity {

    private PompaAirDanDosingViewModel pompaAirDanDosingViewModel;
    private RecyclerView recyclerView;
    private SpekPompaAdapter pompaAdapter;
    private List<GetSpekPompaResponse> daftarSpekPompa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_spek_pompa_dosing_admin);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        pompaAirDanDosingViewModel = new ViewModelProvider(this).get(PompaAirDanDosingViewModel.class);

        recyclerView = findViewById(R.id.rv_data);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        daftarSpekPompa = new ArrayList<>();
        pompaAdapter = new SpekPompaAdapter(daftarSpekPompa);
        recyclerView.setAdapter(pompaAdapter);

        pompaAirDanDosingViewModel.getDataSpekPompa("pompa dosing", new Callback<List<GetSpekPompaResponse>>() {
            @Override
            public void onResponse(Call<List<GetSpekPompaResponse>> call, Response<List<GetSpekPompaResponse>> response) {
                if (response.isSuccessful()){
                    daftarSpekPompa.addAll(response.body());
                    pompaAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(DataSpekPompaDosingAdminActivity.this, "Kosong! Tidak ada data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<GetSpekPompaResponse>> call, Throwable t) {
                Toast.makeText(DataSpekPompaDosingAdminActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
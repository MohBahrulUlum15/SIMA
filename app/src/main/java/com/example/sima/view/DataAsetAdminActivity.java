package com.example.sima.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.sima.R;
import com.example.sima.data.adapter.AsetAdapter;
import com.example.sima.data.response.DataAset;
import com.example.sima.viewmodels.AsetViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataAsetAdminActivity extends AppCompatActivity {

    private AsetViewModel asetViewModel;
    private RecyclerView recyclerView;
    private AsetAdapter asetAdapter;
    private List<DataAset> daftarAset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_aset_admin);

        asetViewModel = new ViewModelProvider(this).get(AsetViewModel.class);

        recyclerView = findViewById(R.id.rv_aset_admin);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        daftarAset = new ArrayList<>();
        asetAdapter = new AsetAdapter(daftarAset);
        recyclerView.setAdapter(asetAdapter);

        asetViewModel.getFullAset(new Callback<List<DataAset>>() {
            @Override
            public void onResponse(Call<List<DataAset>> call, Response<List<DataAset>> response) {
                if (response.isSuccessful()) {
                    daftarAset.addAll(response.body());
                    asetAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(DataAsetAdminActivity.this, "Gagal mengambil data aset", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<DataAset>> call, Throwable t) {
                Toast.makeText(DataAsetAdminActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
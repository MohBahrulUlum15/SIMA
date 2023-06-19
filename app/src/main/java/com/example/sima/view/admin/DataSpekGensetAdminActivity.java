package com.example.sima.view.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.sima.R;
import com.example.sima.data.adapter.SpekGensetAdapter;
import com.example.sima.data.response.admin.GetSpekGensetResponse;
import com.example.sima.databinding.ActivityDataSpekGensetAdminBinding;
import com.example.sima.viewmodels.GensetViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataSpekGensetAdminActivity extends AppCompatActivity {

    private GensetViewModel gensetViewModel;
    private RecyclerView recyclerView;
    private SpekGensetAdapter gensetAdapter;
    private List<GetSpekGensetResponse> daftarSpekGenset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_spek_genset_admin);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        gensetViewModel = new ViewModelProvider(this).get(GensetViewModel.class);

        recyclerView = findViewById(R.id.rv_data);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        daftarSpekGenset = new ArrayList<>();
        gensetAdapter = new SpekGensetAdapter(daftarSpekGenset);
        recyclerView.setAdapter(gensetAdapter);

        gensetViewModel.getDataSpekGenset(new Callback<List<GetSpekGensetResponse>>() {
            @Override
            public void onResponse(Call<List<GetSpekGensetResponse>> call, Response<List<GetSpekGensetResponse>> response) {
                if (response.isSuccessful()){
                    daftarSpekGenset.addAll(response.body());
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
    }
}
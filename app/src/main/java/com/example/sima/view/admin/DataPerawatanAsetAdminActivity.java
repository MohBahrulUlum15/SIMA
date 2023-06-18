package com.example.sima.view.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.sima.R;
import com.example.sima.data.adapter.LaporanAdapter;
import com.example.sima.data.adapter.PerawatanAdapter;
import com.example.sima.data.response.admin.GetPerawatanResponse;
import com.example.sima.data.response.admin.GetPerawatanResponse;
import com.example.sima.databinding.ActivityDataLaporanAdminBinding;
import com.example.sima.databinding.ActivityDataPerawatanAsetAdminBinding;
import com.example.sima.viewmodels.PerawatanViewModel;
import com.example.sima.viewmodels.PerawatanViewModel;

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
    private List<GetPerawatanResponse> daftarPerawatan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_perawatan_aset_admin);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        perawatanViewModel = new ViewModelProvider(this).get(PerawatanViewModel.class);

        recyclerView = findViewById(R.id.rv_data);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        daftarPerawatan = new ArrayList<>();
        perawatanAdapter = new PerawatanAdapter(daftarPerawatan);
        recyclerView.setAdapter(perawatanAdapter);

        perawatanViewModel.getDataPerawatan(new Callback<List<GetPerawatanResponse>>() {
            @Override
            public void onResponse(Call<List<GetPerawatanResponse>> call, Response<List<GetPerawatanResponse>> response) {
                if (response.isSuccessful()){
                    daftarPerawatan.addAll(response.body());
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
    }
}
package com.example.sima.view.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.sima.R;
import com.example.sima.data.adapter.AsetAdapter;
import com.example.sima.data.adapter.KaryawanAdapter;
import com.example.sima.data.response.DataAset;
import com.example.sima.data.response.DataUser;
import com.example.sima.databinding.ActivityDataAsetAdminBinding;
import com.example.sima.databinding.ActivityDataKaryawanAdminBinding;
import com.example.sima.viewmodels.AsetViewModel;
import com.example.sima.viewmodels.UserViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataKaryawanAdminActivity extends AppCompatActivity {

    private ActivityDataKaryawanAdminBinding binding;

    private UserViewModel userViewModel;
    private RecyclerView recyclerView;
    private KaryawanAdapter karyawanAdapter;
    private List<DataUser> daftarKaryawan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_karyawan_admin);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);

        recyclerView = findViewById(R.id.rv_data);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        daftarKaryawan = new ArrayList<>();
        karyawanAdapter = new KaryawanAdapter(daftarKaryawan);
        recyclerView.setAdapter(karyawanAdapter);

        userViewModel.getDataKaryawan(new Callback<List<DataUser>>() {
            @Override
            public void onResponse(Call<List<DataUser>> call, Response<List<DataUser>> response) {
                if (response.isSuccessful()){
                    daftarKaryawan.addAll(response.body());
                    karyawanAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(DataKaryawanAdminActivity.this, "Kosong! Tidak ada data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<DataUser>> call, Throwable t) {
                Toast.makeText(DataKaryawanAdminActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
package com.example.sima.view.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.sima.databinding.ActivityDashboardAdminBinding;
import com.example.sima.view.LoginActivity;

public class DashboardAdminActivity extends AppCompatActivity {

    private ActivityDashboardAdminBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashboardAdminBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        binding.btnDataKaryawan.setOnClickListener(view -> startActivity(new Intent(DashboardAdminActivity.this, DataKaryawanAdminActivity.class)));
        binding.btnDataAset.setOnClickListener(view -> startActivity(new Intent(DashboardAdminActivity.this, DataAsetAdminActivity.class)));
        binding.btnDataPerawatanAset.setOnClickListener(view -> startActivity(new Intent(DashboardAdminActivity.this, DataPerawatanAsetAdminActivity.class)));
        binding.btnDataMutasiAset.setOnClickListener(view -> startActivity(new Intent(DashboardAdminActivity.this, DataMutasiAsetAdminActivity.class)));
        binding.btnDataSpesifikasiAset.setOnClickListener(view -> startActivity(new Intent(DashboardAdminActivity.this, DataSpesifikasiAsetAdminActivity.class)));
        binding.btnDataLaporan.setOnClickListener(view -> startActivity(new Intent(DashboardAdminActivity.this, DataLaporanHarianAdminActivity.class)));

        binding.actionLogout.setOnClickListener(view -> {
            SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("isLoggedIn", false);
            editor.putString("id_user", "");
            editor.putString("jabatan", "");
            editor.apply();
            startActivity(new Intent(DashboardAdminActivity.this, LoginActivity.class));
            finish();
        });
    }
}
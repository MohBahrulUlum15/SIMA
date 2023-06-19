package com.example.sima.view.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.sima.databinding.ActivityDataSpesifikasiAsetAdminBinding;

public class DataSpesifikasiAsetAdminActivity extends AppCompatActivity {

    private ActivityDataSpesifikasiAsetAdminBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDataSpesifikasiAsetAdminBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        binding.btnPompaAir.setOnClickListener(view -> startActivity(new Intent(DataSpesifikasiAsetAdminActivity.this, DataSpekPompaAirAdminActivity.class)));

        binding.btnPompaDosing.setOnClickListener(view -> startActivity(new Intent(DataSpesifikasiAsetAdminActivity.this, DataSpekPompaDosingAdminActivity.class)));

        binding.btnMotorPompa.setOnClickListener(view -> startActivity(new Intent(DataSpesifikasiAsetAdminActivity.this, DataSpekMotorPompaAdminActivity.class)));

        binding.btnPanel.setOnClickListener(view -> startActivity(new Intent(DataSpesifikasiAsetAdminActivity.this, DataSpekPanelAdminActivity.class)));

        binding.btnGenset.setOnClickListener(view -> startActivity(new Intent(DataSpesifikasiAsetAdminActivity.this, DataSpekGensetAdminActivity.class)));

    }
}
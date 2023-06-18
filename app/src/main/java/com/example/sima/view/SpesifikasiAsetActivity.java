package com.example.sima.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.sima.databinding.ActivitySpesifikasiAsetBinding;

public class SpesifikasiAsetActivity extends AppCompatActivity {

    private ActivitySpesifikasiAsetBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySpesifikasiAsetBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnPompaAir.setOnClickListener(view -> startActivity(new Intent(SpesifikasiAsetActivity.this, PompaAirActivity.class)));

        binding.btnPompaDosing.setOnClickListener(view -> startActivity(new Intent(SpesifikasiAsetActivity.this, PompaDosingActivity.class)));

        binding.btnMotorPompa.setOnClickListener(view -> startActivity(new Intent(SpesifikasiAsetActivity.this, MotorPompaActivity.class)));

        binding.btnPanel.setOnClickListener(view -> startActivity(new Intent(SpesifikasiAsetActivity.this, PanelActivity.class)));

        binding.btnGenset.setOnClickListener(view -> startActivity(new Intent(SpesifikasiAsetActivity.this, GensetActivity.class)));

    }
}
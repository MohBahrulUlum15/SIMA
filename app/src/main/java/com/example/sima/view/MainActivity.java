package com.example.sima.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.sima.databinding.ActivityMainBinding;
import com.example.sima.network.SessionManager;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private SessionManager sessionManager;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        sessionManager = new SessionManager(this);

        setupAction();

        binding.username.setText("Hi, " + sessionManager.getNamaLengkap() + " | " + sessionManager.getIdUser());

    }

    private void setupAction() {

        binding.btnTambahAset.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, TambahAsetActivity.class)));

        binding.btnPerawatanAset.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, PerawatanAsetActivity.class)));

        binding.btnMutasiAset.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, MutasiAsetActivity.class)));

        binding.btnUnitProduksi.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, UnitProduksiActivity.class)));

        binding.btnSpesifikasiAset.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, SpesifikasiAsetActivity.class)));

        binding.btnLaporanHarian.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, LaporanHarianActivity.class)));

        binding.actionLogout.setOnClickListener(view -> {
            SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("isLoggedIn", false);
            editor.putString("id_user", "");
            editor.putString("jabatan", "");
            editor.apply();
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();
        });
    }
}
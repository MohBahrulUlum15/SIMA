package com.example.sima.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

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

//        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
//
//        boolean isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false);
//        String id_user = sharedPreferences.getString("id_user", "");
//        String jabatan = sharedPreferences.getString("jabatan", "");
//        String username = sharedPreferences.getString("username", "");
//
        binding.username.setText("Hi, " + sessionManager.getNamaLengkap() + " | " + sessionManager.getIdUser());

        binding.btnTambahAset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TambahAsetActivity.class));
            }
        });

        binding.btnPerawatanAset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PerawatanAsetActivity.class));
            }
        });

        binding.btnMutasiAset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MutasiAsetActivity.class));
            }
        });

        binding.btnUnitProduksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, UnitProduksiActivity.class));
            }
        });

        binding.actionLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("isLoggedIn", false);
                editor.putString("id_user", "");
                editor.putString("jabatan", "");
                editor.apply();
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                finish();
            }
        });
    }
}
package com.example.sima.view.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.sima.R;

public class DataSpesifikasiAsetAdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_spesifikasi_aset_admin);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }
}
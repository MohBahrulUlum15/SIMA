package com.example.sima.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Toast;

import com.example.sima.data.response.TambahAsetResponse;
import com.example.sima.databinding.ActivityTambahAsetBinding;
import com.example.sima.viewmodels.AsetViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TambahAsetActivity extends AppCompatActivity {

    private ActivityTambahAsetBinding binding;

    private AsetViewModel asetViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTambahAsetBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        asetViewModel = new ViewModelProvider(this).get(AsetViewModel.class);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        binding.actionSimpan.setOnClickListener(view -> {
            String nama_barang = binding.etNamaBarang.getText().toString();
            String merk = binding.etMerkBarang.getText().toString();
            String harga = binding.etHargaBarang.getText().toString();
            String jangka_penggunaan = binding.etJangkaPenggunaanBarang.getText().toString();
            String tanggal_masuk = binding.etTanggalMasuk.getText().toString();
            String penanggung_jawab = binding.etPenanggungJawab.getText().toString();
            String kondisi = binding.etKondisi.getText().toString();
            String nama_gambar = binding.etGambar.getText().toString();

            if (nama_barang.isEmpty()) {
                binding.etNamaBarang.setError("belum diisi!");
            } else if (merk.isEmpty()) {
                binding.etMerkBarang.setError("belum diisi!");
            } else if (harga.isEmpty()) {
                binding.etHargaBarang.setError("belum diisi!");
            } else if (jangka_penggunaan.isEmpty()) {
                binding.etJangkaPenggunaanBarang.setError("belum diisi!");
            } else if (tanggal_masuk.isEmpty()) {
                binding.etTanggalMasuk.setError("belum diisi!");
            } else if (penanggung_jawab.isEmpty()) {
                binding.etPenanggungJawab.setError("belum diisi!");
            } else if (kondisi.isEmpty()) {
                binding.etKondisi.setError("belum diisi!");
            } else if (nama_gambar.isEmpty()) {
                binding.etNamaBarang.setError("belum diisi!");
            } else {
                asetViewModel.tambahAset(nama_barang, merk, harga, jangka_penggunaan, tanggal_masuk, penanggung_jawab, kondisi, nama_gambar, new Callback<TambahAsetResponse>() {
                    @Override
                    public void onResponse(Call<TambahAsetResponse> call, Response<TambahAsetResponse> response) {
                        if (response.isSuccessful()) {
                            TambahAsetResponse tambahAsetResponse = response.body();
                            assert tambahAsetResponse != null;
                            if (tambahAsetResponse.isSuccess()) {
                                Toast.makeText(TambahAsetActivity.this, tambahAsetResponse.getMessage(), Toast.LENGTH_SHORT).show();
                                binding.etNamaBarang.setFocusable(true);
                                binding.etNamaBarang.setText("");
                                binding.etMerkBarang.setText("");
                                binding.etHargaBarang.setText("");
                                binding.etJangkaPenggunaanBarang.setText("");
                                binding.etTanggalMasuk.setText("");
                                binding.etPenanggungJawab.setText("");
                                binding.etKondisi.setText("");
                                binding.etGambar.setText("");
                            } else {
                                Toast.makeText(TambahAsetActivity.this, tambahAsetResponse.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(TambahAsetActivity.this, "Gagal!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<TambahAsetResponse> call, Throwable t) {
                        Toast.makeText(TambahAsetActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
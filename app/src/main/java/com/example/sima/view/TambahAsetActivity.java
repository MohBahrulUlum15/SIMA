package com.example.sima.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sima.R;
import com.example.sima.data.response.TambahAsetResponse;
import com.example.sima.databinding.ActivityTambahAsetBinding;
import com.example.sima.viewmodels.AsetViewModel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TambahAsetActivity extends AppCompatActivity {

    private ActivityTambahAsetBinding binding;

    private AsetViewModel asetViewModel;

    private EditText dateEditText;
    private SimpleDateFormat dateFormatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTambahAsetBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        asetViewModel = new ViewModelProvider(this).get(AsetViewModel.class);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        dateEditText = findViewById(R.id.et_tanggal_masuk);
        dateFormatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

        dateEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        binding.actionSimpan.setOnClickListener(view -> {
            String nama_barang = binding.etNamaBarang.getText().toString();
            String merk = binding.etMerkBarang.getText().toString();
            String harga = binding.etHargaBarang.getText().toString();
            String jangka_penggunaan = binding.etJangkaPenggunaanBarang.getText().toString();
            String tanggal_masuk = binding.etTanggalMasuk.getText().toString();
            String penanggung_jawab = binding.etPenanggungJawab.getText().toString();
            String kondisi = binding.etKondisi.getText().toString();
            String nama_gambar = "gambar";

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
//            } else if (nama_gambar.isEmpty()) {
//                binding.etGambar.setError("belum diisi!");
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
//                                binding.etGambar.setText("");
                                startActivity(new Intent(TambahAsetActivity.this, MainActivity.class));
                                finish();
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

    private void showDatePickerDialog() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
                        Calendar selectedDate = Calendar.getInstance();
                        selectedDate.set(selectedYear, selectedMonth, selectedDay);
                        String formattedDate = dateFormatter.format(selectedDate.getTime());
                        dateEditText.setText(formattedDate);
                    }
                }, year, month, day);

        datePickerDialog.show();
    }
}
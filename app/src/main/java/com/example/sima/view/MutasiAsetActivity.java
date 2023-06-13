package com.example.sima.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.sima.R;
import com.example.sima.data.model.Barang;
import com.example.sima.data.response.TambahMutasiResponse;
import com.example.sima.databinding.ActivityMutasiAsetBinding;
import com.example.sima.network.SessionManager;
import com.example.sima.viewmodels.AsetViewModel;
import com.example.sima.viewmodels.MutasiViewModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MutasiAsetActivity extends AppCompatActivity {

    private MutasiViewModel mutasiViewModel;
    private AsetViewModel asetViewModel;
    Spinner spinnerBarang;
    ArrayList<Barang> daftarBarang;
    ArrayAdapter<Barang> adapter;

    Boolean isSelected = true;

    String kodeBarangTerpilih;

    private EditText dateEditText;
    private SimpleDateFormat dateFormatter;

    private ActivityMutasiAsetBinding binding;

    SessionManager sessionManager;
    String ID_USER;

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMutasiAsetBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        asetViewModel = new ViewModelProvider(this).get(AsetViewModel.class);
        mutasiViewModel = new ViewModelProvider(this).get(MutasiViewModel.class);

        sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);

        boolean isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false);
        String id_user = sharedPreferences.getString("id_user", "");
        ID_USER = id_user;

        sessionManager = new SessionManager(this);

//        ID_USER = sessionManager.getIdUser();
        binding.etNamaKaryawan.setText(sessionManager.getNamaLengkap() + " | " + ID_USER);

        dateEditText = findViewById(R.id.et_tanggal);
        dateFormatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

        dateEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        // Inisialisasi spinner dan daftar barang
        spinnerBarang = findViewById(R.id.spinner_nama_barang);
        spinnerBarang.setPrompt("Pilih Barang");
        daftarBarang = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, daftarBarang);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBarang.setAdapter(adapter);

        spinnerBarang.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                binding.etNamaBarang.setText("");
                Barang barangTerpilih = (Barang) parent.getItemAtPosition(position);
                kodeBarangTerpilih = barangTerpilih.getKode();
                String namaBarangTerpilih = barangTerpilih.getNama();
                // Lakukan sesuatu dengan namaBarangTerpilih
                if (isSelected) {
                    binding.etNamaBarang.setText(namaBarangTerpilih + " | " + barangTerpilih.getKode());
                    isSelected = true;
                } else {
                    Toast.makeText(MutasiAsetActivity.this, "Pilih barang", Toast.LENGTH_SHORT).show();
                    isSelected = false;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Tidak ada barang yang dipilih
                binding.etNamaBarang.setText("");
            }
        });

        asetViewModel.getNamaAset(new Callback<List<Barang>>() {
            @Override
            public void onResponse(Call<List<Barang>> call, Response<List<Barang>> response) {
                if (response.isSuccessful()) {
                    List<Barang> dataBarang = response.body();
                    if (dataBarang != null) {
                        daftarBarang.add(0, new Barang("", ""));
                        daftarBarang.addAll(dataBarang);
                        // Memperbarui tampilan spinner
                        adapter.notifyDataSetChanged();
                    }
                } else {
                    Toast.makeText(MutasiAsetActivity.this, "Gagal menampilkan nama barang", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Barang>> call, Throwable t) {
                Toast.makeText(MutasiAsetActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        binding.actionSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tanggal = binding.etTanggal.getText().toString();
                String kode_barang = binding.etNamaBarang.getText().toString();
                String lokasi_awal = binding.etLokasiAwal.getText().toString();
                String spesifikasi = binding.etSpesifikasiBarang.getText().toString();
                String lokasi_akhir = binding.etLokasiAkhir.getText().toString();
                String id_user = binding.etNamaKaryawan.getText().toString();
                String quality_control = binding.etNamaPenanggungJawab.getText().toString();
                String nama_gambar = "gambar.jpg";

                if (tanggal.isEmpty()) {
                    binding.etTanggal.setError("belum diisi!");
                } else if (kode_barang.isEmpty()) {
                    binding.etNamaBarang.setError("belum diisi!");
                } else if (lokasi_awal.isEmpty()) {
                    binding.etLokasiAwal.setError("belum diisi!");
                } else if (spesifikasi.isEmpty()) {
                    binding.etSpesifikasiBarang.setError("belum diisi!");
                } else if (lokasi_akhir.isEmpty()) {
                    binding.etLokasiAkhir.setError("belum diisi!");
                } else if (id_user.isEmpty()) {
                    binding.etNamaBarang.setError("belum diisi!");
                } else if (quality_control.isEmpty()) {
                    binding.etNamaPenanggungJawab.setError("belum diisi!");
                } else {
                    mutasiViewModel.tambahMutasi(tanggal, kodeBarangTerpilih, lokasi_awal, spesifikasi, nama_gambar, lokasi_akhir, ID_USER, quality_control, new Callback<TambahMutasiResponse>() {
                        @Override
                        public void onResponse(Call<TambahMutasiResponse> call, Response<TambahMutasiResponse> response) {
                            if (response.isSuccessful()) {
                                TambahMutasiResponse tambahMutasiResponse = response.body();
                                if (tambahMutasiResponse.isSuccess()) {
                                    Toast.makeText(MutasiAsetActivity.this, tambahMutasiResponse.getMessage(), Toast.LENGTH_SHORT).show();
                                    binding.etTanggal.setText("");
                                    binding.etNamaBarang.setText("");
                                    startActivity(new Intent(MutasiAsetActivity.this, MainActivity.class));
                                    finish();
                                } else {
                                    Toast.makeText(MutasiAsetActivity.this, tambahMutasiResponse.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(MutasiAsetActivity.this, "Gagal!", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<TambahMutasiResponse> call, Throwable t) {
                            Toast.makeText(MutasiAsetActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
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
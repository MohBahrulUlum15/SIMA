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
import com.example.sima.data.response.TambahGensetResponse;
import com.example.sima.data.response.TambahGensetResponse;
import com.example.sima.databinding.ActivityGensetBinding;
import com.example.sima.databinding.ActivityPerawatanAsetBinding;
import com.example.sima.databinding.ActivityUnitProduksiBinding;
import com.example.sima.network.SessionManager;
import com.example.sima.viewmodels.AsetViewModel;
import com.example.sima.viewmodels.GensetViewModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GensetActivity extends AppCompatActivity {

    private ActivityGensetBinding binding;

    private GensetViewModel gensetViewModel;

    private AsetViewModel asetViewModel;
    Spinner spinnerBarang;
    ArrayList<Barang> daftarBarang;
    ArrayAdapter<Barang> adapter;
    Boolean isSelected = true;
    String kodeBarangTerpilih;

    private EditText dateEditText;
    private SimpleDateFormat dateFormatter;

    SessionManager sessionManager;
    String ID_USER;

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGensetBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        dateEditText = findViewById(R.id.et_tanggal);
        dateFormatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        dateEditText.setOnClickListener(v -> showDatePickerDialog());

        asetViewModel = new ViewModelProvider(this).get(AsetViewModel.class);
        gensetViewModel = new ViewModelProvider(this).get(GensetViewModel.class);

        sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        boolean isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false);
        String id_user = sharedPreferences.getString("id_user", "");
        ID_USER = id_user;

        sessionManager = new SessionManager(this);

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
                    Toast.makeText(GensetActivity.this, "Pilih barang", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(GensetActivity.this, "Gagal menampilkan nama barang", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Barang>> call, Throwable t) {
                Toast.makeText(GensetActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        binding.actionSimpan.setOnClickListener(view -> {
            String tanggal = binding.etTanggal.getText().toString();
            String kode_barang = binding.etNamaBarang.getText().toString();
            String merk_genset = binding.etMerkGenset.getText().toString();
            String tipe_genset = binding.etTipeGenset.getText().toString();
            String kapasitas = binding.etKapasitasGenset.getText().toString();
            String kondisi = binding.etKondisiGenset.getText().toString();

            if (tanggal.isEmpty()) {
                binding.etTanggal.setError("belum diisi!");
            } else if (kode_barang.isEmpty()) {
                binding.etNamaBarang.setError("belum diisi!");
            } else if (merk_genset.isEmpty()) {
                binding.etMerkGenset.setError("belum diisi!");
            } else if (tipe_genset.isEmpty()) {
                binding.etTipeGenset.setError("belum diisi!");
            }else if (kapasitas.isEmpty()) {
                binding.etKapasitasGenset.setError("belum diisi!");
            }else if (kondisi.isEmpty()) {
                binding.etKondisiGenset.setError("belum diisi!");
            } else {
                gensetViewModel.tambahGenset(tanggal, kodeBarangTerpilih, merk_genset, tipe_genset, kapasitas, kondisi, ID_USER, new Callback<TambahGensetResponse>() {
                    @Override
                    public void onResponse(Call<TambahGensetResponse> call, Response<TambahGensetResponse> response) {
                        if (response.isSuccessful()){
                            TambahGensetResponse tambaGensetResponse = response.body();
                            if (tambaGensetResponse.isSuccess()){
                                Toast.makeText(GensetActivity.this, tambaGensetResponse.getMessage(), Toast.LENGTH_SHORT).show();
                                binding.etTanggal.setText("");
                                binding.etNamaBarang.setText("");
                                binding.etMerkGenset.setText("");
                                binding.etTipeGenset.setText("");
                                binding.etKapasitasGenset.setText("");
                                binding.etKondisiGenset.setText("");
                                startActivity(new Intent(GensetActivity.this, MainActivity.class));
                                finish();
                            } else {
                                Toast.makeText(GensetActivity.this, tambaGensetResponse.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Toast.makeText(GensetActivity.this, "Gagal!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<TambahGensetResponse> call, Throwable t) {
                        Toast.makeText(GensetActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
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
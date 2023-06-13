package com.example.sima.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sima.R;
import com.example.sima.data.response.TambahPerawatanResponse;
import com.example.sima.data.response.TambahUnitProduksiResponse;
import com.example.sima.databinding.ActivityUnitProduksiBinding;
import com.example.sima.network.SessionManager;
import com.example.sima.viewmodels.PerawatanViewModel;
import com.example.sima.viewmodels.UnitProduksiViewModel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UnitProduksiActivity extends AppCompatActivity {

    private ActivityUnitProduksiBinding binding;

    private UnitProduksiViewModel unitProduksiViewModel;

    private EditText dateEditText;
    private SimpleDateFormat dateFormatter;

    SessionManager sessionManager;
    String ID_USER;

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUnitProduksiBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        unitProduksiViewModel = new ViewModelProvider(this).get(UnitProduksiViewModel.class);

        dateEditText = findViewById(R.id.et_tanggal);
        dateFormatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

        dateEditText.setOnClickListener(v -> showDatePickerDialog());

        sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);

        boolean isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false);
        String id_user = sharedPreferences.getString("id_user", "");
        ID_USER = id_user;

        sessionManager = new SessionManager(this);

        binding.etNamaKaryawan.setText(sessionManager.getNamaLengkap() + " | " + ID_USER);

        binding.actionSimpan.setOnClickListener(view -> {
            String tanggal = binding.etTanggal.getText().toString();
            String uraian_kegiatan = binding.etUraianKegiatan.getText().toString();
            String daya_listrik = binding.etDayaListrik.getText().toString();
            String nama_gambar = "gambar.jpg";

            if (tanggal.isEmpty()) {
                binding.etTanggal.setError("belum diisi!");
            } else if (uraian_kegiatan.isEmpty()) {
                binding.etUraianKegiatan.setError("belum diisi!");
            } else if (daya_listrik.isEmpty()) {
                binding.etDayaListrik.setError("belum diisi!");
            } else {
                unitProduksiViewModel.tambahUnitProduksi(tanggal, ID_USER, uraian_kegiatan, daya_listrik, nama_gambar, new Callback<TambahUnitProduksiResponse>() {
                    @Override
                    public void onResponse(Call<TambahUnitProduksiResponse> call, Response<TambahUnitProduksiResponse> response) {
                        if (response.isSuccessful()) {
                            TambahUnitProduksiResponse tambahUnitProduksiResponse = response.body();
                            if (tambahUnitProduksiResponse.isSuccess()) {
                                Toast.makeText(UnitProduksiActivity.this, tambahUnitProduksiResponse.getMessage(), Toast.LENGTH_SHORT).show();
                                binding.etTanggal.setText("");
                                binding.etDayaListrik.setText("");
                                binding.etUraianKegiatan.setText("");
                                startActivity(new Intent(UnitProduksiActivity.this, MainActivity.class));
                                finish();
                            } else {
                                Toast.makeText(UnitProduksiActivity.this, tambahUnitProduksiResponse.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(UnitProduksiActivity.this, "Gagal!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<TambahUnitProduksiResponse> call, Throwable t) {
                        Toast.makeText(UnitProduksiActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
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
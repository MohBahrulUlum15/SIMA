package com.example.sima.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sima.R;
import com.example.sima.data.response.TambahLaporanHarianResponse;
import com.example.sima.data.response.TambahMutasiResponse;
import com.example.sima.databinding.ActivityLaporanHarianBinding;
import com.example.sima.databinding.ActivityPerawatanAsetBinding;
import com.example.sima.databinding.ActivityUnitProduksiBinding;
import com.example.sima.network.SessionManager;
import com.example.sima.viewmodels.LaporanHarianViewModel;
import com.example.sima.viewmodels.MutasiViewModel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LaporanHarianActivity extends AppCompatActivity {

    private ActivityLaporanHarianBinding binding;

    private LaporanHarianViewModel laporanHarianViewModel;

    private EditText dateEditText;
    private SimpleDateFormat dateFormatter;

    SessionManager sessionManager;
    String ID_USER;

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLaporanHarianBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        laporanHarianViewModel = new ViewModelProvider(this).get(LaporanHarianViewModel.class);

        dateEditText = findViewById(R.id.et_tanggal);
        dateFormatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

        dateEditText.setOnClickListener(v -> showDatePickerDialog());

        sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);

        boolean isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false);
        String id_user = sharedPreferences.getString("id_user", "");
        ID_USER = id_user;

        sessionManager = new SessionManager(this);

        binding.etNamaKaryawan1.setText(sessionManager.getNamaLengkap() + " | " + ID_USER);

        binding.actionSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tanggal = binding.etTanggal.getText().toString();
                String beban_puncak = binding.etBebanPuncakLaporan.getText().toString();
                String luar_beban_puncak = binding.etLuarBebanPuncakLaporan.getText().toString();
                String penggunaan_daya_reaktif = binding.etPenggunaanDayaReaktifLaporan.getText().toString();
                String standmeter = binding.etStandmeterLaporan.getText().toString();
                String nama_karyawan_dua = binding.etNamaKaryawan2.getText().toString();

                if (tanggal.isEmpty()) {
                    binding.etTanggal.setError("belum diisi!");
                } else if (beban_puncak.isEmpty()) {
                    binding.etBebanPuncakLaporan.setError("belum diisi!");
                } else if (luar_beban_puncak.isEmpty()) {
                    binding.etLuarBebanPuncakLaporan.setError("belum diisi!");
                } else if (penggunaan_daya_reaktif.isEmpty()) {
                    binding.etPenggunaanDayaReaktifLaporan.setError("belum diisi!");
                } else if (standmeter.isEmpty()) {
                    binding.etStandmeterLaporan.setError("belum diisi!");
                } else if (nama_karyawan_dua.isEmpty()) {
                    binding.etNamaKaryawan2.setError("belum diisi!");
                } else {
                    laporanHarianViewModel.tambahLaporanHarian(tanggal, beban_puncak, luar_beban_puncak, penggunaan_daya_reaktif, standmeter, ID_USER, nama_karyawan_dua, new Callback<TambahLaporanHarianResponse>() {
                        @Override
                        public void onResponse(Call<TambahLaporanHarianResponse> call, Response<TambahLaporanHarianResponse> response) {
                            if (response.isSuccessful()) {
                                TambahLaporanHarianResponse tambahLaporanHarianResponse = response.body();
                                if (tambahLaporanHarianResponse.isSuccess()) {
                                    Toast.makeText(LaporanHarianActivity.this, tambahLaporanHarianResponse.getMessage(), Toast.LENGTH_SHORT).show();
                                    binding.etTanggal.setText("");
                                    binding.etBebanPuncakLaporan.setText("");
                                    startActivity(new Intent(LaporanHarianActivity.this, MainActivity.class));
                                    finish();
                                } else {
                                    Toast.makeText(LaporanHarianActivity.this, tambahLaporanHarianResponse.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(LaporanHarianActivity.this, "Gagal!", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<TambahLaporanHarianResponse> call, Throwable t) {
                            Toast.makeText(LaporanHarianActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
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
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
import com.example.sima.data.response.RegisterResponse;
import com.example.sima.databinding.ActivityRegisterBinding;
import com.example.sima.viewmodels.AuthViewModel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    private ActivityRegisterBinding binding;

    private AuthViewModel authViewModel;

    private EditText dateEditText;
    private SimpleDateFormat dateFormatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        authViewModel = new ViewModelProvider(this).get(AuthViewModel.class);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        dateEditText = findViewById(R.id.et_tanggal_lahir);
        dateFormatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

        dateEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        binding.actionLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                finish();
            }
        });

        binding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama_lengkap = binding.etNamaLengkap.getText().toString();
                String tempat_lahir = binding.etTempatLahir.getText().toString();
                String tanggal_lahir = binding.etTanggalLahir.getText().toString();
                String alamat_lengkap = binding.etAlamatLengkap.getText().toString();
                String jenis_kelamin = binding.etJenisKelamin.getText().toString();
                String kewarganegaraan = binding.etKewarganegaraan.getText().toString();
                String agama = binding.etAgama.getText().toString();
                String no_handphone = binding.etNoHandphone.getText().toString();
                String pendidikan_terakhir = binding.etPendidikanTerakhir.getText().toString();
                String jabatan = binding.etJabatan.getText().toString();
                String departemen = binding.etDepartemen.getText().toString();
                String username = binding.etUsername.getText().toString();
                String password = binding.etPassword.getText().toString();
                String validasi = "diproses";

                if (nama_lengkap.isEmpty()) {
                    binding.etNamaLengkap.setError("belum diisi!");
                } else if (tempat_lahir.isEmpty()) {
                    binding.etTempatLahir.setError("belum diisi!");
                } else if (tanggal_lahir.isEmpty()) {
                    binding.etTanggalLahir.setError("belum diisi!");
                } else if (alamat_lengkap.isEmpty()) {
                    binding.etAlamatLengkap.setError("belum diisi!");
                } else if (jenis_kelamin.isEmpty()) {
                    binding.etJenisKelamin.setError("belum diisi!");
                } else if (kewarganegaraan.isEmpty()) {
                    binding.etKewarganegaraan.setError("belum diisi!");
                } else if (agama.isEmpty()) {
                    binding.etAgama.setError("belum diisi!");
                } else if (no_handphone.isEmpty()) {
                    binding.etNoHandphone.setError("belum diisi!");
                } else if (pendidikan_terakhir.isEmpty()) {
                    binding.etPendidikanTerakhir.setError("belum diisi!");
                } else if (jabatan.isEmpty()) {
                    binding.etJabatan.setError("belum diisi!");
                } else if (departemen.isEmpty()) {
                    binding.etDepartemen.setError("belum diisi!");
                } else if (username.isEmpty()) {
                    binding.etUsername.setError("belum diisi!");
                } else if (password.isEmpty()) {
                    binding.etPassword.setError("belum diisi!");
                } else {
                    authViewModel.register(nama_lengkap, tempat_lahir, tanggal_lahir,
                            alamat_lengkap, jenis_kelamin, kewarganegaraan, agama, no_handphone, pendidikan_terakhir,
                            jabatan, departemen, username, password, validasi, new Callback<RegisterResponse>() {
                                @Override
                                public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                                    if (response.isSuccessful()) {
                                        RegisterResponse registerResponse = response.body();
                                        if (registerResponse.isSuccess()) {
                                            Toast.makeText(RegisterActivity.this, registerResponse.getMessage(), Toast.LENGTH_SHORT).show();
                                            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                                            finish();
                                        } else {
                                            Toast.makeText(RegisterActivity.this, registerResponse.getMessage(), Toast.LENGTH_SHORT).show();
                                        }
                                    } else {
                                        Toast.makeText(RegisterActivity.this, "Register Gagal!", Toast.LENGTH_SHORT).show();
                                    }
                                }

                                @Override
                                public void onFailure(Call<RegisterResponse> call, Throwable t) {
                                    Toast.makeText(RegisterActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

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
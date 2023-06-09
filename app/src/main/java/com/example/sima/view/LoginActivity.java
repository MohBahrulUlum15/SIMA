package com.example.sima.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.sima.data.response.LoginResponse;
import com.example.sima.databinding.ActivityLoginBinding;
import com.example.sima.network.SessionManager;
import com.example.sima.viewmodels.AuthViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    private AuthViewModel authViewModel;

    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        authViewModel = new ViewModelProvider(this).get(AuthViewModel.class);

        sessionManager = new SessionManager(this);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        binding.actionRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                finish();
            }
        });

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = binding.etLoginUsername.getText().toString();
                String password = binding.etLoginPassword.getText().toString();

                if (username.equals("")) {
                    binding.etLoginUsername.setError("username belum diisi!");
                } else if (password.equals("")) {
                    binding.etLoginPassword.setError("password belum diisi!");
                } else {
                    authViewModel.login(username, password, new Callback<LoginResponse>() {
                        @Override
                        public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                            if (response.isSuccessful()) {
                                // Handle successful login response
                                LoginResponse loginResponse = response.body();
                                // Process the login response data
                                if (loginResponse.getSuccess()) {
                                    sessionManager.createLoginSession(loginResponse.getData().getIdUser(), loginResponse.getData().getUsername(), loginResponse.getData().getPassword(), loginResponse.getData().getNamaLengkap());
                                    if (loginResponse.getData().getJabatan().equals("Admin")) {
                                        startActivity(new Intent(LoginActivity.this, DashboardAdminActivity.class));
                                        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                                        SharedPreferences.Editor editor = sharedPreferences.edit();
                                        editor.putBoolean("isLoggedIn", true);
                                        editor.putString("id_user", loginResponse.getData().getIdUser());
                                        editor.putString("jabatan", loginResponse.getData().getJabatan());
                                        editor.putString("username", loginResponse.getData().getUsername());
                                        editor.apply();
                                        finish();
                                    } else {
                                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                                        SharedPreferences.Editor editor = sharedPreferences.edit();
                                        editor.putBoolean("isLoggedIn", true);
                                        editor.putString("id_user", loginResponse.getData().getIdUser());
                                        editor.putString("jabatan", loginResponse.getData().getJabatan());
                                        editor.putString("username", loginResponse.getData().getUsername());
                                        editor.apply();
                                        finish();
                                        finish();
                                    }
                                } else {
                                    Toast.makeText(LoginActivity.this, loginResponse.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(LoginActivity.this, "Login Gagal!", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<LoginResponse> call, Throwable t) {
                            Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }
}
package com.example.sima.view.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.sima.R;
import com.example.sima.data.adapter.KaryawanAdapter;
import com.example.sima.data.adapter.PendaftarAdapter;
import com.example.sima.data.response.DataUser;
import com.example.sima.data.response.DataUser;
import com.example.sima.data.response.admin.ValidasiResponse;
import com.example.sima.databinding.ActivityDataKaryawanAdminBinding;
import com.example.sima.databinding.ActivityDataPendaftarAdminBinding;
import com.example.sima.view.RegisterActivity;
import com.example.sima.viewmodels.UserViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataPendaftarAdminActivity extends AppCompatActivity implements PendaftarAdapter.PendaftarClickListener {

    private ActivityDataPendaftarAdminBinding binding;
    private UserViewModel userViewModel;
    private RecyclerView recyclerView;
    private PendaftarAdapter pendaftarAdapter;
    private ArrayList<DataUser> daftarPendaftar;
    private ArrayList<DataUser> filteredList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDataPendaftarAdminBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);

        recyclerView = findViewById(R.id.rv_data);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        daftarPendaftar = new ArrayList<>();
        filteredList = new ArrayList<>();
        pendaftarAdapter = new PendaftarAdapter(filteredList);
        pendaftarAdapter.setPendaftarClickListener(this);
        recyclerView.setAdapter(pendaftarAdapter);

        userViewModel.getDataPendaftar(new Callback<List<DataUser>>() {
            @Override
            public void onResponse(Call<List<DataUser>> call, Response<List<DataUser>> response) {
                if (response.isSuccessful()) {
                    daftarPendaftar.addAll(response.body());
                    filteredList.addAll(daftarPendaftar);
                    binding.tvJumlahData.setText("Jumlah data : " + String.valueOf(filteredList.size()));
                    pendaftarAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(DataPendaftarAdminActivity.this, "Kosong! Tidak ada data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<DataUser>> call, Throwable t) {
                Toast.makeText(DataPendaftarAdminActivity.this, "Kosong! Tidak ada data", Toast.LENGTH_SHORT).show();
            }
        });

        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                filteredList.clear();
                if (s.isEmpty()) {
                    filteredList.addAll(daftarPendaftar);
                } else {
                    String filterPattern = s.toLowerCase().trim();
                    for (DataUser register : daftarPendaftar) {
                        if (register.getNamaLengkap().toLowerCase().contains(filterPattern)
                                || register.getTempatLahir().toLowerCase().contains(filterPattern)
                                || register.getNoHandphone().toLowerCase().contains(filterPattern)) {
                            filteredList.add(register);
                        }
                    }
                }
                binding.tvJumlahData.setText("Jumlah data : " + String.valueOf(filteredList.size()));
                pendaftarAdapter.notifyDataSetChanged();
                return true;
            }
        });
    }

    @Override
    public void onTerimaClicked(DataUser dataUser) {
        userViewModel.validasiPendaftar(dataUser.getIdUser(), "diterima", new Callback<ValidasiResponse>() {
            @Override
            public void onResponse(Call<ValidasiResponse> call, Response<ValidasiResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body().isSuccess()) {
                        Toast.makeText(DataPendaftarAdminActivity.this, response.body().getMessage() + " | Pendaftar Diterima", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(DataPendaftarAdminActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(DataPendaftarAdminActivity.this, "Validasi Gagal!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ValidasiResponse> call, Throwable t) {
                Toast.makeText(DataPendaftarAdminActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onTolakClicked(DataUser dataUser) {
        userViewModel.validasiPendaftar(dataUser.getIdUser(), "ditolak", new Callback<ValidasiResponse>() {
            @Override
            public void onResponse(Call<ValidasiResponse> call, Response<ValidasiResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body().isSuccess()) {
                        Toast.makeText(DataPendaftarAdminActivity.this, response.body().getMessage() + " | Pendaftar Ditolak", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(DataPendaftarAdminActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(DataPendaftarAdminActivity.this, "Validasi Gagal!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ValidasiResponse> call, Throwable t) {
                Toast.makeText(DataPendaftarAdminActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
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
import com.example.sima.data.response.DataUser;
import com.example.sima.data.response.DataUser;
import com.example.sima.databinding.ActivityDataKaryawanAdminBinding;
import com.example.sima.viewmodels.UserViewModel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataKaryawanAdminActivity extends AppCompatActivity {

    private ActivityDataKaryawanAdminBinding binding;
    private UserViewModel userViewModel;
    private RecyclerView recyclerView;
    private KaryawanAdapter karyawanAdapter;
    private ArrayList<DataUser> daftarKaryawan;
    private ArrayList<DataUser> filteredList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDataKaryawanAdminBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);

        recyclerView = findViewById(R.id.rv_data);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        daftarKaryawan = new ArrayList<>();
        filteredList = new ArrayList<>();
        karyawanAdapter = new KaryawanAdapter(filteredList);
        recyclerView.setAdapter(karyawanAdapter);

        userViewModel.getDataKaryawan(new Callback<List<DataUser>>() {
            @Override
            public void onResponse(Call<List<DataUser>> call, Response<List<DataUser>> response) {
                if (response.isSuccessful()) {
                    daftarKaryawan.addAll(response.body());
                    filteredList.addAll(daftarKaryawan);
                    binding.tvJumlahData.setText("Jumlah data : " + String.valueOf(filteredList.size()));
                    karyawanAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(DataKaryawanAdminActivity.this, "Kosong! Tidak ada data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<DataUser>> call, Throwable t) {
                Toast.makeText(DataKaryawanAdminActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
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
                    filteredList.addAll(daftarKaryawan);
                } else {
                    String filterPattern = s.toLowerCase().trim();
                    for (DataUser karyawan : daftarKaryawan) {
                        if (karyawan.getNamaLengkap().toLowerCase().contains(filterPattern)
                                || karyawan.getTempatLahir().toLowerCase().contains(filterPattern)
                                || karyawan.getNoHandphone().toLowerCase().contains(filterPattern)) {
                            filteredList.add(karyawan);
                        }
                    }
                }
                binding.tvJumlahData.setText("Jumlah data : " + String.valueOf(filteredList.size()));
                karyawanAdapter.notifyDataSetChanged();
                return true;
            }
        });
    }
}
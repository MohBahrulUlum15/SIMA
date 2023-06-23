package com.example.sima.view.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.sima.R;
import com.example.sima.data.adapter.SpekMotorPompaAdapter;
import com.example.sima.data.response.DataAset;
import com.example.sima.data.response.admin.GetSpekMotorPompaResponse;
import com.example.sima.databinding.ActivityDataSpekGensetAdminBinding;
import com.example.sima.databinding.ActivityDataSpekMotorPompaAdminBinding;
import com.example.sima.viewmodels.MotorPompaViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataSpekMotorPompaAdminActivity extends AppCompatActivity {

    ActivityDataSpekMotorPompaAdminBinding binding;

    private MotorPompaViewModel motorPompaViewModel;
    private RecyclerView recyclerView;
    private SpekMotorPompaAdapter motorPompaAdapter;
    private ArrayList<GetSpekMotorPompaResponse> daftarSpekMotorPompa;
    private ArrayList<GetSpekMotorPompaResponse> filteredList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDataSpekMotorPompaAdminBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        motorPompaViewModel = new ViewModelProvider(this).get(MotorPompaViewModel.class);
        recyclerView = findViewById(R.id.rv_data);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        daftarSpekMotorPompa = new ArrayList<>();
        filteredList = new ArrayList<>();
        motorPompaAdapter = new SpekMotorPompaAdapter(filteredList);
        recyclerView.setAdapter(motorPompaAdapter);

        motorPompaViewModel.getDataSpekMotorPompa(new Callback<List<GetSpekMotorPompaResponse>>() {
            @Override
            public void onResponse(Call<List<GetSpekMotorPompaResponse>> call, Response<List<GetSpekMotorPompaResponse>> response) {
                if (response.isSuccessful()) {
                    daftarSpekMotorPompa.addAll(response.body());
                    filteredList.addAll(daftarSpekMotorPompa);
                    binding.tvJumlahData.setText("Jumlah data : " + String.valueOf(filteredList.size()));
                    motorPompaAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(DataSpekMotorPompaAdminActivity.this, "Kosong! Tidak ada data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<GetSpekMotorPompaResponse>> call, Throwable t) {
                Toast.makeText(DataSpekMotorPompaAdminActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filteredList.clear();
                if (newText.isEmpty()) {
                    filteredList.addAll(daftarSpekMotorPompa);
                } else {
                    String filterPattern = newText.toLowerCase().trim();
                    for (GetSpekMotorPompaResponse aset : daftarSpekMotorPompa) {
                        if (aset.getNamaBarang().toLowerCase().contains(filterPattern)
                                || aset.getTanggal().toLowerCase().contains(filterPattern)
                        ) {
                            filteredList.add(aset);
                        }
                    }
                }
                binding.tvJumlahData.setText("Jumlah data : " + String.valueOf(filteredList.size()));
                motorPompaAdapter.notifyDataSetChanged();
                return true;
            }
        });
    }
}
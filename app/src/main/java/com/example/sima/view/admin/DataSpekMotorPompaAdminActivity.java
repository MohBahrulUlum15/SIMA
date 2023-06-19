package com.example.sima.view.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.sima.R;
import com.example.sima.data.adapter.SpekMotorPompaAdapter;
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

    private MotorPompaViewModel motorPompaViewModel;
    private RecyclerView recyclerView;
    private SpekMotorPompaAdapter motorPompaAdapter;
    private List<GetSpekMotorPompaResponse> daftarSpekMotorPompa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_spek_motor_pompa_admin);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        motorPompaViewModel = new ViewModelProvider(this).get(MotorPompaViewModel.class);

        recyclerView = findViewById(R.id.rv_data);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        daftarSpekMotorPompa = new ArrayList<>();
        motorPompaAdapter = new SpekMotorPompaAdapter(daftarSpekMotorPompa);
        recyclerView.setAdapter(motorPompaAdapter);

        motorPompaViewModel.getDataSpekMotorPompa(new Callback<List<GetSpekMotorPompaResponse>>() {
            @Override
            public void onResponse(Call<List<GetSpekMotorPompaResponse>> call, Response<List<GetSpekMotorPompaResponse>> response) {
                if (response.isSuccessful()){
                    daftarSpekMotorPompa.addAll(response.body());
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
    }
}
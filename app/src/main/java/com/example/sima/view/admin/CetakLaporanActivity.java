package com.example.sima.view.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.sima.R;
import com.example.sima.data.response.laporanBulanan.DataAkhirBulanItem;
import com.example.sima.data.response.laporanBulanan.DataAwalBulanItem;
import com.example.sima.data.response.laporanBulanan.DataLaporan;
import com.example.sima.data.response.laporanBulanan.LaporanBulananResponse;
import com.example.sima.databinding.ActivityCetakLaporanBinding;
import com.example.sima.viewmodels.LaporanHarianViewModel;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CetakLaporanActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private ActivityCetakLaporanBinding binding;

    LaporanHarianViewModel laporanHarianViewModel;

    private String bulanTerpilih;

    Double hasilLiterPerBulan;
    Double hasilLiterPerDetik;

    // Mendapatkan tanggal saat ini
    Date currentDate = new Date();

    // Mengatur format tanggal yang diinginkan
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy", Locale.getDefault());
    String formattedDate = dateFormat.format(currentDate);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCetakLaporanBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        laporanHarianViewModel = new ViewModelProvider(this).get(LaporanHarianViewModel.class);

        binding.txtJudul.setText("");
        binding.txtTanggal.setText("");
        binding.txtDeskripsi.setText("");
        binding.txtLiterPerBulan.setText("");
        binding.txtLiterPerDetik.setText("");
        binding.txtPetugas.setText("");

        // Mendapatkan referensi ke Spinner di layout
        Spinner monthSpinner = findViewById(R.id.spinner_bulan);
        // Membuat adapter ArrayAdapter dengan daftar nama bulan
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.months_array, android.R.layout.simple_spinner_item);
        // Menentukan layout dropdown yang digunakan saat spinner di-klik
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Menghubungkan adapter dengan spinner
        monthSpinner.setAdapter(adapter);
        // Menetapkan listener untuk mendeteksi item yang dipilih
        monthSpinner.setOnItemSelectedListener(this);

        binding.btnCetakLaporan.setOnClickListener(view -> {
            if (binding.etBulan.getText().length() < 1){
                Toast.makeText(this, "Belum memilih bulan!", Toast.LENGTH_SHORT).show();
            } else {
                laporanHarianViewModel.getLaporanBulanan(bulanTerpilih, new Callback<LaporanBulananResponse>() {
                    @Override
                    public void onResponse(Call<LaporanBulananResponse> call, Response<LaporanBulananResponse> response) {
                        if (response.isSuccessful()){
                            LaporanBulananResponse laporanResponse = response.body();
                            if (laporanResponse.isSuccess()) {
                                DataLaporan laporanData = laporanResponse.getData();
                                List<DataAwalBulanItem> dataAwalBulan = laporanData.getDataAwalBulan();
                                List<DataAkhirBulanItem> dataAkhirBulan = laporanData.getDataAkhirBulan();

                                // Mengambil nilai standmeter dari dataAwalBulan dan dataAkhirBulan
                                String standmeterAwalBulan = dataAwalBulan.get(0).getStandmeter();
                                String standmeterAkhirBulan = dataAkhirBulan.get(0).getStandmeter();

//                                    Rumus Laporan Bulanan
//                                    Perhitungan satuan Liter selama 1 bulan
//                                    A = B - C = D X 10 = E X 1000 = (hasilnya)
//                                    Perhitungan satuan Liter selama 1 detik dalam sebulan
//                                    F = a : 2628002,88 = (hasilnya)
//                                    Keterangan
//                                    A = satuan liter selama sebulan
//                                    B = jumlah stand meter di tanggal akhir bulan (28/29/30/31)
//                                    C = jumlah stand meter ditanggal awal bulan (01)
//                                    D = hasil pengurangan stand meter
//                                    E = hasil perkalian stand meter dengan jumlah angka yg ada di stand meter
//                                    F = satuan liter dalam satu detik selama sebulan
                                // Lakukan operasi yang diperlukan dengan nilai standmeter

                                Double D = Double.valueOf(standmeterAkhirBulan) - Double.valueOf(standmeterAwalBulan);
                                Double E = D * 10;
                                hasilLiterPerBulan = E * 1000;
                                hasilLiterPerDetik = hasilLiterPerBulan / 2628002.88;

                                binding.txtLiterPerBulan.setText(hasilLiterPerBulan.toString());
                                binding.txtLiterPerDetik.setText(hasilLiterPerDetik.toString());

                                binding.txtJudul.setText("Laporan Bulan " + bulanTerpilih);
                                binding.txtTanggal.setText(formattedDate);
                                binding.txtDeskripsi.setText("Berikut ini adalah laporan produksi air bersih pada bulan " + bulanTerpilih + " yang telah diperhitungkan selama sebulan, mulai dari awal hingga akhir bulan.");
                                binding.txtLiterPerBulan.setText("Satuan Liter dalam sebulan:\n" + hasilLiterPerBulan + "L");
                                binding.txtLiterPerDetik.setText("Satuan Liter per detik dalam sebulan:\n" + hasilLiterPerDetik + "L");
                                binding.txtPetugas.setText("");

                            } else {
                                String message = laporanResponse.getMsg();
                                Toast.makeText(CetakLaporanActivity.this, message, Toast.LENGTH_SHORT).show();
                                // Penanganan jika terdapat pesan error dari respons API
                            }
                        } else {
                            Toast.makeText(CetakLaporanActivity.this, "Gagal mengambil data", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<LaporanBulananResponse> call, Throwable t) {
                        Toast.makeText(CetakLaporanActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        binding.btnCetakPdf.setOnClickListener(view -> {

        });

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        // Mengambil nilai atau value item yang dipilih
        String selectedMonth = adapterView.getItemAtPosition(i).toString();
        bulanTerpilih = selectedMonth;

        // Menampilkan nilai atau value item yang dipilih di TextView
        EditText selectedMonthTextView = findViewById(R.id.et_bulan);
        selectedMonthTextView.setText(selectedMonth);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
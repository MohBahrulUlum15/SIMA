package com.example.sima.data.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sima.R;
import com.example.sima.data.response.admin.GetMutasiResponse;

import java.util.List;

public class MutasiAdapter extends RecyclerView.Adapter<MutasiAdapter.MutasiViewHolder> {

    private List<GetMutasiResponse> daftarMutasi;

    public MutasiAdapter(List<GetMutasiResponse> daftarMutasi) {
        this.daftarMutasi = daftarMutasi;
    }

    @NonNull
    @Override
    public MutasiAdapter.MutasiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mutasi, parent, false);
        return new MutasiViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MutasiAdapter.MutasiViewHolder holder, int position) {
        GetMutasiResponse dataMutasi = daftarMutasi.get(position);
        holder.tvTanggal.setText(dataMutasi.getTanggal());
        holder.tvNamaBarang.setText(dataMutasi.getNamaBarang());
        holder.tvLokasiAwal.setText("Lokasi awal : " + dataMutasi.getLokasiAwal());
        holder.tvlokasiAkhir.setText("Lokasi akhir : " + dataMutasi.getLokasiAkhir());
        holder.tvSpesifikasi.setText("Spesifikasi : " + dataMutasi.getSpesifikasi());
        holder.tvPenanggungJawab.setText("Penanggung jawab : " + dataMutasi.getNamaLengkap());
    }

    @Override
    public int getItemCount() {
        return daftarMutasi.size();
    }

    public class MutasiViewHolder extends RecyclerView.ViewHolder{
        public TextView tvTanggal, tvNamaBarang, tvLokasiAwal, tvlokasiAkhir, tvSpesifikasi, tvPenanggungJawab;
        public MutasiViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTanggal = itemView.findViewById(R.id.tv_tanggal);
            tvNamaBarang = itemView.findViewById(R.id.tv_nama_barang);
            tvLokasiAwal = itemView.findViewById(R.id.tv_lokasi_awal);
            tvlokasiAkhir = itemView.findViewById(R.id.tv_lokasi_akhir);
            tvSpesifikasi = itemView.findViewById(R.id.tv_spesifikasi);
            tvPenanggungJawab = itemView.findViewById(R.id.tv_penanggung_jawab);
        }
    }
}

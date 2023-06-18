package com.example.sima.data.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sima.R;
import com.example.sima.data.response.admin.GetPerawatanResponse;

import java.util.List;

public class PerawatanAdapter extends RecyclerView.Adapter<PerawatanAdapter.PerawatanViewHolder> {

    private List<GetPerawatanResponse> daftarPerawatan;

    public PerawatanAdapter(List<GetPerawatanResponse> daftarPerawatan) {
        this.daftarPerawatan = daftarPerawatan;
    }

    @NonNull
    @Override
    public PerawatanAdapter.PerawatanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_perawatan, parent, false);
        return new PerawatanViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull PerawatanAdapter.PerawatanViewHolder holder, int position) {
        GetPerawatanResponse dataPerawatan = daftarPerawatan.get(position);
        holder.tvNama.setText(dataPerawatan.getNamaLengkap());
        holder.tvTanggal.setText(dataPerawatan.getTanggal());
        holder.tvNamaBarang.setText(dataPerawatan.getNamaBarang());
        holder.tvUraianKegiatan.setText(dataPerawatan.getUraianKegiatan());
    }

    @Override
    public int getItemCount() {
        return daftarPerawatan.size();
    }

    public class PerawatanViewHolder extends RecyclerView.ViewHolder{
        public TextView tvNama, tvTanggal, tvNamaBarang, tvUraianKegiatan;
        public PerawatanViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tv_nama_karyawan);
            tvTanggal = itemView.findViewById(R.id.tv_tanggal);
            tvNamaBarang = itemView.findViewById(R.id.tv_nama_barang);
            tvUraianKegiatan = itemView.findViewById(R.id.tv_uraian_kegiatan);
        }
    }
}

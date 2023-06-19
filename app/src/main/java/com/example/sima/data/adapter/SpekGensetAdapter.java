package com.example.sima.data.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sima.R;
import com.example.sima.data.response.admin.GetSpekGensetResponse;

import java.util.List;

public class SpekGensetAdapter extends RecyclerView.Adapter<SpekGensetAdapter.SpekGensetViewHolder> {

    private List<GetSpekGensetResponse> daftarSpekGenset;

    public SpekGensetAdapter(List<GetSpekGensetResponse> daftarSpekGenset) {
        this.daftarSpekGenset = daftarSpekGenset;
    }

    @NonNull
    @Override
    public SpekGensetAdapter.SpekGensetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_genset, parent, false);
        return new SpekGensetViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull SpekGensetAdapter.SpekGensetViewHolder holder, int position) {
        GetSpekGensetResponse dataSpekGenset = daftarSpekGenset.get(position);
        holder.tvKodeBarang.setText(dataSpekGenset.getKodeBarang());
        holder.tvNamaBarang.setText(dataSpekGenset.getNamaBarang());
        holder.tvMerkGenset.setText(dataSpekGenset.getMerkGenset());
        holder.tvKapasitas.setText(dataSpekGenset.getKapasitas());
        holder.tvtipe.setText(dataSpekGenset.getTipe());
    }

    @Override
    public int getItemCount() {
        return daftarSpekGenset.size();
    }

    public class SpekGensetViewHolder extends RecyclerView.ViewHolder{
        public TextView tvKodeBarang, tvNamaBarang, tvMerkGenset, tvKapasitas, tvtipe;
        public SpekGensetViewHolder(@NonNull View itemView) {
            super(itemView);
            tvKodeBarang = itemView.findViewById(R.id.tv_kode_barang);
            tvNamaBarang = itemView.findViewById(R.id.tv_nama_barang);
            tvMerkGenset = itemView.findViewById(R.id.tv_merk_genset);
            tvKapasitas = itemView.findViewById(R.id.tv_kapasitas);
            tvtipe = itemView.findViewById(R.id.tv_tipe);
        }
    }
}

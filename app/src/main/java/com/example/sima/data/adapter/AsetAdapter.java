package com.example.sima.data.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sima.R;

import java.util.List;

public class AsetAdapter extends RecyclerView.Adapter<AsetAdapter.AsetViewHolder> {

    private List<com.example.sima.data.response.DataAset> daftarAset;

    public AsetAdapter(List<com.example.sima.data.response.DataAset> daftarAset) {
        this.daftarAset = daftarAset;
    }

    @NonNull
    @Override
    public AsetAdapter.AsetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_aset, parent, false);
        return new AsetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AsetAdapter.AsetViewHolder holder, int position) {
        com.example.sima.data.response.DataAset dataAset = daftarAset.get(position);
        holder.tvNama.setText(dataAset.getNamaBarang());
        holder.tvMerk.setText(dataAset.getMerk());
        holder.tvHarga.setText(dataAset.getHarga());
        holder.tvJangka.setText(dataAset.getJangkaPenggunaan());
    }

    @Override
    public int getItemCount() {
        return daftarAset.size();
    }

    public class AsetViewHolder extends RecyclerView.ViewHolder{
        public TextView tvNama;
        public TextView tvMerk;
        public TextView tvHarga;
        public TextView tvJangka;
        public AsetViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tv_nama_aset);
            tvMerk = itemView.findViewById(R.id.tv_merk_aset);
            tvHarga = itemView.findViewById(R.id.tv_harga_aset);
            tvJangka = itemView.findViewById(R.id.tv_jangka_aset);
        }
    }
}

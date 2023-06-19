package com.example.sima.data.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sima.R;
import com.example.sima.data.response.DataAset;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AsetAdapter extends RecyclerView.Adapter<AsetAdapter.AsetViewHolder> {

    private List<DataAset> daftarAset;

    public AsetAdapter(List<DataAset> daftarAset) {
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
        holder.tvKode.setText(dataAset.getKodeBarang());
        holder.tvNama.setText(dataAset.getNamaBarang());
        holder.tvMerk.setText(dataAset.getMerk());
    }

    @Override
    public int getItemCount() {
        return daftarAset.size();
    }

    public class AsetViewHolder extends RecyclerView.ViewHolder{
        public TextView tvKode, tvNama, tvMerk;
        public AsetViewHolder(@NonNull View itemView) {
            super(itemView);
            tvKode = itemView.findViewById(R.id.tv_kode_barang);
            tvNama = itemView.findViewById(R.id.tv_nama_aset);
            tvMerk = itemView.findViewById(R.id.tv_merk_aset);
        }
    }

}

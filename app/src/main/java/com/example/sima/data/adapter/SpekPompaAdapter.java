package com.example.sima.data.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sima.R;
import com.example.sima.data.response.admin.GetSpekPompaResponse;

import java.util.List;

public class SpekPompaAdapter extends RecyclerView.Adapter<SpekPompaAdapter.SpekPompaViewHolder> {

    private List<GetSpekPompaResponse> daftarSpekPompa;

    public SpekPompaAdapter(List<GetSpekPompaResponse> daftarSpekPompa) {
        this.daftarSpekPompa = daftarSpekPompa;
    }

    @NonNull
    @Override
    public SpekPompaAdapter.SpekPompaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pompa, parent, false);
        return new SpekPompaViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull SpekPompaAdapter.SpekPompaViewHolder holder, int position) {
        GetSpekPompaResponse dataSpekPompa = daftarSpekPompa.get(position);
        holder.tvKodeBarang.setText(dataSpekPompa.getKodeBarang());
        holder.tvNamaBarang.setText(dataSpekPompa.getNamaBarang());
        holder.tvHeadPompa.setText(dataSpekPompa.getHeadPompa());
        holder.tvDebitPompa.setText(dataSpekPompa.getDebitPompa());
    }

    @Override
    public int getItemCount() {
        return daftarSpekPompa.size();
    }

    public class SpekPompaViewHolder extends RecyclerView.ViewHolder{
        public TextView tvKodeBarang, tvNamaBarang, tvHeadPompa, tvDebitPompa;
        public SpekPompaViewHolder(@NonNull View itemView) {
            super(itemView);
            tvKodeBarang = itemView.findViewById(R.id.tv_kode_barang);
            tvNamaBarang = itemView.findViewById(R.id.tv_nama_barang);
            tvHeadPompa = itemView.findViewById(R.id.tv_head_pompa);
            tvDebitPompa = itemView.findViewById(R.id.tv_debit_pompa);
        }
    }
}

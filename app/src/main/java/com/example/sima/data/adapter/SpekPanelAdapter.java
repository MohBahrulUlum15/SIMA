package com.example.sima.data.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sima.R;
import com.example.sima.data.response.admin.GetSpekPanelResponse;

import java.util.List;

public class SpekPanelAdapter extends RecyclerView.Adapter<SpekPanelAdapter.SpekPanelViewHolder> {

    private List<GetSpekPanelResponse> daftarSpekPanel;

    public SpekPanelAdapter(List<GetSpekPanelResponse> daftarSpekPanel) {
        this.daftarSpekPanel = daftarSpekPanel;
    }

    @NonNull
    @Override
    public SpekPanelAdapter.SpekPanelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_panel, parent, false);
        return new SpekPanelViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull SpekPanelAdapter.SpekPanelViewHolder holder, int position) {
        GetSpekPanelResponse dataSpekPanel = daftarSpekPanel.get(position);
        holder.tvKodeBarang.setText(dataSpekPanel.getKodeBarang());
        holder.tvNamaBarang.setText(dataSpekPanel.getNamaBarang());
        holder.tvStarDelta.setText(dataSpekPanel.getStarDelta());
        holder.tvDirectOnline.setText(dataSpekPanel.getDirectOnline());
        holder.tvKapasitasBeban.setText(dataSpekPanel.getKapasitasBeban());
    }

    @Override
    public int getItemCount() {
        return daftarSpekPanel.size();
    }

    public class SpekPanelViewHolder extends RecyclerView.ViewHolder{
        public TextView tvKodeBarang, tvNamaBarang, tvStarDelta, tvDirectOnline, tvKapasitasBeban;
        public SpekPanelViewHolder(@NonNull View itemView) {
            super(itemView);
            tvKodeBarang = itemView.findViewById(R.id.tv_kode_barang);
            tvNamaBarang = itemView.findViewById(R.id.tv_nama_barang);
            tvStarDelta = itemView.findViewById(R.id.tv_star_delta);
            tvDirectOnline = itemView.findViewById(R.id.tv_direct_online);
            tvKapasitasBeban = itemView.findViewById(R.id.tv_kapasitas_beban);
        }
    }
}

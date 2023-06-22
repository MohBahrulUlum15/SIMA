package com.example.sima.data.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sima.R;
import com.example.sima.data.response.admin.GetLaporanResponse;

import java.util.List;

public class LaporanAdapter extends RecyclerView.Adapter<LaporanAdapter.LaporanViewHolder> {

    private List<GetLaporanResponse> daftarLaporan;

    public LaporanAdapter(List<GetLaporanResponse> daftarLaporan) {
        this.daftarLaporan = daftarLaporan;
    }

    @NonNull
    @Override
    public LaporanAdapter.LaporanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_laporan, parent, false);
        return new LaporanViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull LaporanAdapter.LaporanViewHolder holder, int position) {
        GetLaporanResponse dataLaporan = daftarLaporan.get(position);
        holder.tvTanggal.setText(dataLaporan.getTanggal());
        holder.tvBebanPuncak.setText("Beban Puncak : " + dataLaporan.getBebanPuncak());
        holder.tvLuarBebanPuncak.setText("Luar Beban Puncak : " + dataLaporan.getLuarBebanPuncak());
        holder.tvStandmeter.setText("Standmeter : " + dataLaporan.getStandmeter());
    }

    @Override
    public int getItemCount() {
        return daftarLaporan.size();
    }

    public class LaporanViewHolder extends RecyclerView.ViewHolder{
        public TextView tvTanggal, tvBebanPuncak, tvLuarBebanPuncak, tvStandmeter;
        public LaporanViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTanggal = itemView.findViewById(R.id.tv_tanggal);
            tvBebanPuncak = itemView.findViewById(R.id.tv_beban_puncak);
            tvLuarBebanPuncak = itemView.findViewById(R.id.tv_luar_beban_puncak);
            tvStandmeter = itemView.findViewById(R.id.tv_standmeter);
        }
    }
}

package com.example.sima.data.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sima.R;
import com.example.sima.data.response.admin.GetSpekMotorPompaResponse;

import java.util.List;

public class SpekMotorPompaAdapter extends RecyclerView.Adapter<SpekMotorPompaAdapter.SpekMotorPompaViewHolder> {

    private List<GetSpekMotorPompaResponse> daftarSpekMotorPompa;

    public SpekMotorPompaAdapter(List<GetSpekMotorPompaResponse> daftarSpekMotorPompa) {
        this.daftarSpekMotorPompa = daftarSpekMotorPompa;
    }

    @NonNull
    @Override
    public SpekMotorPompaAdapter.SpekMotorPompaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_motor_pompa, parent, false);
        return new SpekMotorPompaViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull SpekMotorPompaAdapter.SpekMotorPompaViewHolder holder, int position) {
        GetSpekMotorPompaResponse dataSpekMotorPompa = daftarSpekMotorPompa.get(position);
        holder.tvKodeBarang.setText(dataSpekMotorPompa.getKodeBarang());
        holder.tvNamaBarang.setText(dataSpekMotorPompa.getNamaBarang());
        holder.tvDayaListrik.setText(dataSpekMotorPompa.getDayaListrik());
        holder.tvArusMaks.setText(dataSpekMotorPompa.getArusMaks());
        holder.tvCos.setText(dataSpekMotorPompa.getCosValue());
    }

    @Override
    public int getItemCount() {
        return daftarSpekMotorPompa.size();
    }

    public class SpekMotorPompaViewHolder extends RecyclerView.ViewHolder{
        public TextView tvKodeBarang, tvNamaBarang, tvDayaListrik, tvArusMaks, tvCos;
        public SpekMotorPompaViewHolder(@NonNull View itemView) {
            super(itemView);
            tvKodeBarang = itemView.findViewById(R.id.tv_kode_barang);
            tvNamaBarang = itemView.findViewById(R.id.tv_nama_barang);
            tvDayaListrik = itemView.findViewById(R.id.tv_daya_listrik);
            tvArusMaks = itemView.findViewById(R.id.tv_arus_maksimal);
            tvCos = itemView.findViewById(R.id.tv_cos);
        }
    }
}

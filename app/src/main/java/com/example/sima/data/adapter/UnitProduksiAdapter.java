package com.example.sima.data.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sima.R;
import com.example.sima.data.response.admin.GetUnitProduksiResponse;

import java.util.List;

public class UnitProduksiAdapter extends RecyclerView.Adapter<UnitProduksiAdapter.UnitProduksiViewHolder> {

    private List<GetUnitProduksiResponse> daftarUnitProduksi;

    public UnitProduksiAdapter(List<GetUnitProduksiResponse> daftarUnitProduksi) {
        this.daftarUnitProduksi = daftarUnitProduksi;
    }

    @NonNull
    @Override
    public UnitProduksiAdapter.UnitProduksiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_unit_produksi, parent, false);
        return new UnitProduksiViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull UnitProduksiAdapter.UnitProduksiViewHolder holder, int position) {
        GetUnitProduksiResponse dataUnitProduksi = daftarUnitProduksi.get(position);
        holder.tvNama.setText(dataUnitProduksi.getNamaLengkap());
        holder.tvTanggal.setText(dataUnitProduksi.getTanggal());
        holder.tvUraianKegiatan.setText(dataUnitProduksi.getUraianKegiatan());
    }

    @Override
    public int getItemCount() {
        return daftarUnitProduksi.size();
    }

    public class UnitProduksiViewHolder extends RecyclerView.ViewHolder{
        public TextView tvNama, tvTanggal, tvNamaBarang, tvUraianKegiatan;
        public UnitProduksiViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tv_nama_karyawan);
            tvTanggal = itemView.findViewById(R.id.tv_tanggal);
            tvUraianKegiatan = itemView.findViewById(R.id.tv_uraian_kegiatan);
        }
    }
}

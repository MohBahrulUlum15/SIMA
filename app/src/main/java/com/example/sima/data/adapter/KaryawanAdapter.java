package com.example.sima.data.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sima.R;
import com.example.sima.data.response.DataUser;

import java.util.List;

public class KaryawanAdapter extends RecyclerView.Adapter<KaryawanAdapter.KaryawanViewHolder> {

    private List<DataUser> daftarKaryawan;

    public KaryawanAdapter(List<DataUser> daftarKaryawan) {
        this.daftarKaryawan = daftarKaryawan;
    }

    @NonNull
    @Override
    public KaryawanAdapter.KaryawanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_karyawan, parent, false);
        return new KaryawanViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull KaryawanAdapter.KaryawanViewHolder holder, int position) {
        DataUser dataKaryawan = daftarKaryawan.get(position);
        holder.tvNamaKaryawan.setText(dataKaryawan.getNamaLengkap());
        holder.tvTempatTanggalLahir.setText(dataKaryawan.getTempatLahir() + ", " + dataKaryawan.getTanggalLahir());
        holder.tvAlamat.setText(dataKaryawan.getAlamatLengkap());
        holder.tvNoHandphone.setText(dataKaryawan.getNoHandphone());
    }

    @Override
    public int getItemCount() {
        return daftarKaryawan.size();
    }

    public class KaryawanViewHolder extends RecyclerView.ViewHolder{
        public TextView tvNamaKaryawan, tvTempatTanggalLahir, tvAlamat, tvNoHandphone;
        public KaryawanViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNamaKaryawan = itemView.findViewById(R.id.tv_nama_karyawan);
            tvTempatTanggalLahir = itemView.findViewById(R.id.tv_tempat_tanggal_lahir);
            tvAlamat = itemView.findViewById(R.id.tv_alamat);
            tvNoHandphone = itemView.findViewById(R.id.tv_no_handphone);
        }
    }
}

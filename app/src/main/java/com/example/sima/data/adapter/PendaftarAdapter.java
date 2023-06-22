package com.example.sima.data.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sima.R;
import com.example.sima.data.response.DataRegister;
import com.example.sima.data.response.DataUser;

import java.util.ArrayList;
import java.util.List;

public class PendaftarAdapter extends RecyclerView.Adapter<PendaftarAdapter.KaryawanViewHolder> {

    private List<DataUser> daftarPendaftar;

    private PendaftarClickListener clickListener;

    public interface PendaftarClickListener {
        void onTerimaClicked(DataUser dataUser);
        void onTolakClicked(DataUser dataUser);
    }

    public void setPendaftarClickListener(PendaftarClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public PendaftarAdapter(ArrayList<DataUser> daftarPendaftar) {
        this.daftarPendaftar = daftarPendaftar;
    }

    @NonNull
    @Override
    public PendaftarAdapter.KaryawanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pendaftar, parent, false);
        return new KaryawanViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull PendaftarAdapter.KaryawanViewHolder holder, int position) {
        DataUser dataPendaftar = daftarPendaftar.get(position);
        holder.tvNamaKaryawan.setText(dataPendaftar.getNamaLengkap() + " | " + dataPendaftar.getIdUser());
        holder.tvTempatTanggalLahir.setText(dataPendaftar.getTempatLahir() + ", " + dataPendaftar.getTanggalLahir());
        holder.tvAlamat.setText(dataPendaftar.getAlamatLengkap());
        holder.tvNoHandphone.setText(dataPendaftar.getNoHandphone());
        holder.tvStatus.setText("Status: " + dataPendaftar.getValidasi());
    }

    @Override
    public int getItemCount() {
        return daftarPendaftar.size();
    }

    public class KaryawanViewHolder extends RecyclerView.ViewHolder{
        public TextView tvNamaKaryawan, tvTempatTanggalLahir, tvAlamat, tvNoHandphone, tvStatus;
        public Button btnTerima, btnTolak;
        public KaryawanViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNamaKaryawan = itemView.findViewById(R.id.tv_nama_karyawan);
            tvTempatTanggalLahir = itemView.findViewById(R.id.tv_tempat_tanggal_lahir);
            tvAlamat = itemView.findViewById(R.id.tv_alamat);
            tvNoHandphone = itemView.findViewById(R.id.tv_no_handphone);
            tvStatus = itemView.findViewById(R.id.tv_status);
            btnTerima = itemView.findViewById(R.id.btn_terima);
            btnTolak = itemView.findViewById(R.id.btn_tolak);

            btnTerima.setOnClickListener(view -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION && clickListener != null) {
                    DataUser dataUser = daftarPendaftar.get(position);
                    clickListener.onTerimaClicked(dataUser);
                }
            });

            btnTolak.setOnClickListener(view -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION && clickListener != null) {
                    DataUser dataUser = daftarPendaftar.get(position);
                    clickListener.onTolakClicked(dataUser);
                }
            });
        }
    }
}

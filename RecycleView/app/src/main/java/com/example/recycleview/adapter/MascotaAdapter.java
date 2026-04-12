package com.example.recycleview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview.R;
import com.example.recycleview.models.Mascota;

import java.util.ArrayList;

public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.ViewHolder> {

    private ArrayList<Mascota> dataMascota;
    private Listener listener;

    public interface Listener {
        void onClick(Mascota item);
        void onEdit(Mascota item);
        void onDelete(Mascota item);
    }

    public MascotaAdapter(ArrayList<Mascota> dataMascota, Listener listener) {
        this.dataMascota = dataMascota;
        this.listener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textNombreM, textEdadM, textAlturaM;
        ImageView imagenM;
        ImageButton btnEdit, btnDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textNombreM = itemView.findViewById(R.id.textNombreM);
            textEdadM = itemView.findViewById(R.id.textEdadM);
            textAlturaM = itemView.findViewById(R.id.textAlturaM);
            imagenM = itemView.findViewById(R.id.imagenM);
            btnEdit = itemView.findViewById(R.id.btnEdit);
            btnDelete = itemView.findViewById(R.id.btnDelete);
            
            // Click en el item completo
            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION && listener != null) {
                    listener.onClick(dataMascota.get(position));
                }
            });

            // Click en el botón Editar
            if (btnEdit != null) {
                btnEdit.setOnClickListener(v -> {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION && listener != null) {
                        listener.onEdit(dataMascota.get(position));
                    }
                });
            }

            // Click en el botón Eliminar
            if (btnDelete != null) {
                btnDelete.setOnClickListener(v -> {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION && listener != null) {
                        listener.onDelete(dataMascota.get(position));
                    }
                });
            }
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mascota, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Mascota mascota = dataMascota.get(position);
        holder.textNombreM.setText(mascota.getNombrePerro());
        holder.textAlturaM.setText(String.valueOf(mascota.getAlturaPerro()));
        holder.textEdadM.setText(String.valueOf(mascota.getEdadPerro()));
        holder.imagenM.setImageResource(mascota.getImg());
    }

    @Override
    public int getItemCount() {
        return dataMascota.size();
    }
}

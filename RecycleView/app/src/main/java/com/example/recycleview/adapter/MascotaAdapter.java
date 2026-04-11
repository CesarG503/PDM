package com.example.recycleview.adapter;

import android.media.ImageReader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview.R;
import com.example.recycleview.models.Mascota;

import java.util.ArrayList;

public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.ViewHolder>
{

    private ArrayList<Mascota> dataMascota;
    private OnItemClickListener listener; //agrego este artributo


    public MascotaAdapter(ArrayList<Mascota> dataMascota) {
        this.dataMascota = dataMascota;
    }

    public MascotaAdapter(ArrayList<Mascota> dataMascota, OnItemClickListener listener) {
        this.dataMascota = dataMascota;
        this.listener = listener;
    }
    
    public interface OnItemClickListener {
        void onItemClick(Mascota item);
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView textNombreM, textEdadM, textAlturaM;
        ImageView imagenM;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textNombreM = itemView.findViewById(R.id.textNombreM);
            textEdadM = itemView.findViewById(R.id.textEdadM);
            textAlturaM= itemView.findViewById(R.id.textAlturaM);
            imagenM = itemView.findViewById(R.id.imagenM);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getPosition();
                    if (position != RecyclerView.NO_POSITION && listener != null) {
                        listener.onItemClick(dataMascota.get(position));
                    }
                }
            });
        }
    }

    @NonNull
    @Override
    public MascotaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mascota,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaAdapter.ViewHolder holder, int position) {

        Mascota mascota = dataMascota.get(position);

        holder.textNombreM.setText(mascota.getNombrePerro());
        holder.textAlturaM.setText(String.valueOf( mascota.getAlturaPerro()));
        holder.textEdadM.setText(String.valueOf( mascota.getEdadPerro()));

        holder.imagenM.setImageResource(mascota.getImg());
    }

    @Override
    public int getItemCount() {
        return dataMascota.size();
    }
}

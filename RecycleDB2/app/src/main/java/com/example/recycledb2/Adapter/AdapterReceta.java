package com.example.recycledb2.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycledb2.Entitys.Receta;
import com.example.recycledb2.R;

import java.util.ArrayList;

public class AdapterReceta extends RecyclerView.Adapter<AdapterReceta.viewHolder>
{
    public ArrayList<Receta> dataReceta;

    public AdapterReceta(ArrayList<Receta> dataReceta) {
        this.dataReceta = dataReceta;
    }

    public class viewHolder extends RecyclerView.ViewHolder
    {
        TextView textNombre,textDescripcion,textServicios;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            textNombre = itemView.findViewById(R.id.textNombre);
            textDescripcion = itemView.findViewById(R.id.textDescripcion);
            textServicios = itemView.findViewById(R.id.textServicios);
        }
    }

    @NonNull
    @Override
    public AdapterReceta.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_receta, parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterReceta.viewHolder holder, int position) {

        Receta receta = dataReceta.get(position);

        holder.textNombre.setText(String.valueOf(receta.nombre));
        holder.textDescripcion.setText(String.valueOf(receta.descripcion));
        holder.textServicios.setText(String.valueOf(receta.servicios));
    }

    @Override
    public int getItemCount() {
        return dataReceta.size();
    }
}

package com.example.recycledb;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycledb.entitys.Ingrediente;

import java.util.ArrayList;

public class AdapterIngrediente extends RecyclerView.Adapter<AdapterIngrediente.viewHolder> {

    ArrayList<Ingrediente> ingredientesData;

    public AdapterIngrediente(ArrayList<Ingrediente> ingredientesData) {
        this.ingredientesData = ingredientesData;
    }

    public static class viewHolder extends RecyclerView.ViewHolder
    {
        TextView textNombreI, textCantidadI;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            textCantidadI = itemView.findViewById(R.id.textCantidadI);
            textNombreI = itemView.findViewById(R.id.textNombreI);
        }

    }

    @NonNull
    @Override
    public AdapterIngrediente.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ingrediente, parent, false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterIngrediente.viewHolder holder, int position) {

        Ingrediente ingrediente = ingredientesData.get(position);

        holder.textNombreI.setText(ingrediente.nombre_ingrediente);
        holder.textCantidadI.setText(String.valueOf(ingrediente.cantidad));

    }

    @Override
    public int getItemCount() {
        return ingredientesData.size();
    }
}

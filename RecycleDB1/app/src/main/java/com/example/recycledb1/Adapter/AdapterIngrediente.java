package com.example.recycledb1.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycledb1.Entitys.Ingrediente;
import com.example.recycledb1.R;

import java.util.ArrayList;

public class AdapterIngrediente extends RecyclerView.Adapter<AdapterIngrediente.viewHolder>
{

    public ArrayList<Ingrediente> dataIngredite;

    public AdapterIngrediente(ArrayList<Ingrediente> dataIngredite) {
        this.dataIngredite = dataIngredite;
    }

    public class viewHolder extends RecyclerView.ViewHolder
    {
        TextView textNombreI,textCantidadI;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            textNombreI = itemView.findViewById(R.id.textNombreI);
            textCantidadI= itemView.findViewById(R.id.textCantidadI);

        }
    }

    @NonNull
    @Override
    public AdapterIngrediente.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ingrediente, parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterIngrediente.viewHolder holder, int position) {

        Ingrediente ingrediente = dataIngredite.get(position);

        holder.textNombreI.setText(String.valueOf(ingrediente.nombre_ingrediente));
        holder.textCantidadI.setText(String.valueOf(ingrediente.cantidad));


    }

    @Override
    public int getItemCount() {
        return dataIngredite.size();
    }
}

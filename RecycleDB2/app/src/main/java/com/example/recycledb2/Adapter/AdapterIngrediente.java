package com.example.recycledb2.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycledb2.Entitys.Ingrediente;
import com.example.recycledb2.R;

import java.util.ArrayList;

public class AdapterIngrediente extends RecyclerView.Adapter<AdapterIngrediente.viewHolder>
{

    public ArrayList<Ingrediente> dataIngrediente;

    public Listener listener;


    public interface Listener
    {
        void OnClick(Ingrediente ingrediente);
    }

    public AdapterIngrediente(ArrayList<Ingrediente> dataIngrediente) {
        this.dataIngrediente = dataIngrediente;
    }

    public AdapterIngrediente(ArrayList<Ingrediente> dataIngrediente, Listener listener) {
        this.dataIngrediente = dataIngrediente;
        this.listener = listener;
    }

    public class viewHolder extends RecyclerView.ViewHolder
    {
        TextView textNombreI,textCantidadI;
        ImageButton btnEdit,btnDelete;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            textNombreI = itemView.findViewById(R.id.textNombreI);
            textCantidadI = itemView.findViewById(R.id.textCantidadI);

            btnEdit = itemView.findViewById(R.id.btnEdit);
            btnDelete = itemView.findViewById(R.id.btnDelete);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int postion = getAdapterPosition();
                    if (postion != RecyclerView.NO_POSITION & listener != null)
                    {
                        listener.OnClick(dataIngrediente.get(postion));
                    }
                }
            });
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

        Ingrediente ingrediente = dataIngrediente.get(position);

        holder.textNombreI.setText(String.valueOf(ingrediente.nombre));
        holder.textCantidadI.setText(String.valueOf(ingrediente.cantidad));

        int pos = holder.getAdapterPosition();

    }

    @Override
    public int getItemCount() {
        return dataIngrediente.size();
    }
}

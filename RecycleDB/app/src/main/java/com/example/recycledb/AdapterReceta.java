package com.example.recycledb;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycledb.entitys.Receta;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class AdapterReceta extends RecyclerView.Adapter<AdapterReceta.viewHolder>
{

    private  List<Receta> recetaData;
    private Listener listener;

    public interface Listener
    {
        void OnClick(Receta receta);
        void OnDelete(Receta receta);

    }

    public AdapterReceta(List<Receta> recetaData, Listener listener) {
        this.recetaData = recetaData;
        this.listener = listener;
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        TextView textNombreR,textdescripcionR, textServiciosR;

        ImageButton btnDelete, btnEdit;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            textdescripcionR = itemView.findViewById(R.id.textDescripcionR);
            textNombreR = itemView.findViewById(R.id.textnombreR);
            textServiciosR = itemView.findViewById(R.id.textServiciosR);

            btnDelete = itemView.findViewById(R.id.btnDelete);
            btnEdit = itemView.findViewById(R.id.btnEdit);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Integer position = getAdapterPosition();

                    if (position != RecyclerView.NO_POSITION && listener != null)
                    {
                        listener.OnClick(recetaData.get(position));
                    }
                }
            });

        }
    }

    @NonNull
    @Override
    public AdapterReceta.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_receta, parent, false);

        return new  viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterReceta.viewHolder holder, int position) {

        Receta receta = recetaData.get(position);

        holder.textServiciosR.setText(String.valueOf( receta.servicios ));
        holder.textNombreR.setText(String.valueOf( receta.nombre ));
        holder.textdescripcionR.setText(String.valueOf( receta.descripcion ));


        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.OnDelete( recetaData.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        return recetaData.size();
    }
}

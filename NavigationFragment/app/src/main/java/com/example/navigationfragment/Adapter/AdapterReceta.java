package com.example.navigationfragment.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navigationfragment.R;
import com.example.navigationfragment.entitys.Receta;

import java.util.ArrayList;
import java.util.List;

public class AdapterReceta extends RecyclerView.Adapter<AdapterReceta.viewHolder>
{

    public ArrayList<Receta> dataReceta;

    public Listener listener;

    public AdapterReceta(ArrayList<Receta> dataReceta, Listener listener) {
        this.dataReceta = dataReceta;
        this.listener = listener;
    }

    public interface Listener
    {
        void OnClickEdit(Receta receta);
        void OnClickDelete(Receta receta);
    }


    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_receta,parent,false);

        return new viewHolder(view);

    }


    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        Receta receta = dataReceta.get(position);

        holder.textView.setText(String.valueOf(receta.nombre_receta));
        holder.textView2.setText(String.valueOf(receta.descripcion_receta));
        holder.textView3.setText(String.valueOf(receta.servicios));


        holder.btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (listener != null)
                {
                    listener.OnClickDelete(receta);
                }
            }
        });

        holder.btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null)
                {
                    listener.OnClickEdit(receta);
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return dataReceta.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder
    {

        TextView textView, textView2, textView3;
        ImageButton btn_edit, btn_delete;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView2);
            textView3 =  itemView.findViewById(R.id.textView3);

            btn_edit =  itemView.findViewById(R.id.btn_edit);
            btn_delete =  itemView.findViewById(R.id.btn_delete);




        }
    }


}

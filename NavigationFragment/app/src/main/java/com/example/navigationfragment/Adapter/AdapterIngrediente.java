package com.example.navigationfragment.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navigationfragment.R;
import com.example.navigationfragment.entitys.Ingrediente;

import java.util.ArrayList;

public class AdapterIngrediente extends RecyclerView.Adapter<AdapterIngrediente.viewHolder>
{

    private ArrayList<Ingrediente> dataIngrediente;

    private Listener lister;

    public AdapterIngrediente(ArrayList<Ingrediente> dataIngrediente, Listener lister) {
        this.dataIngrediente = dataIngrediente;
        this.lister = lister;
    }

    public interface Listener
    {
         void OnClick(Ingrediente ingrediente);
        void OnDeleteClick(Ingrediente ingrediente);

        void OnUpdateClick(Ingrediente ingrediente);
    }


    public class viewHolder extends RecyclerView.ViewHolder
    {

        TextView textView,textView2,textView3;
        ImageButton btn_delete, btn_edit;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            textView =itemView.findViewById(R.id.textView);
            textView2=itemView.findViewById(R.id.textView2);
            textView3=itemView.findViewById(R.id.textView3);

            btn_delete = itemView.findViewById(R.id.btn_delete);
            btn_edit= itemView.findViewById(R.id.btn_edit);
        }
    }


    @NonNull
    @Override
    public AdapterIngrediente.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_receta, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterIngrediente.viewHolder holder, int position) {

        Ingrediente ingrediente = dataIngrediente.get(position);

        holder.textView.setText(String.valueOf(ingrediente.nombre));
        holder.textView2.setText(String.valueOf(ingrediente.cantidad));

        holder.btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (lister != null)
                {
                    lister.OnDeleteClick(ingrediente);
                }

            }
        });

        holder.btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lister != null)
                {
                    lister.OnUpdateClick(ingrediente);
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return dataIngrediente.size();
    }
}

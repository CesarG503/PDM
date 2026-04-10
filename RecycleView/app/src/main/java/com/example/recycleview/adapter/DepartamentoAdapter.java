package com.example.recycleview.adapter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview.R;
import com.example.recycleview.models.Departamento;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DepartamentoAdapter extends RecyclerView.Adapter<DepartamentoAdapter.ViewHolder>
{

    private ArrayList<Departamento> dataDepartamento;

    public DepartamentoAdapter(ArrayList<Departamento> dataDepartamento) {
        this.dataDepartamento = dataDepartamento;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {

        TextView textNombreDep, textNumeroDep, textKilometrosDep;
        Button button3;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textNombreDep  = itemView.findViewById(R.id.textNombreDep);
            textNumeroDep = itemView.findViewById(R.id.textNumeroDep);
            textKilometrosDep = itemView.findViewById(R.id.textKilometrosDep);

            button3 = itemView.findViewById(R.id.button3);
        }
    }

    @NonNull
    @Override
    public DepartamentoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.departamento_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DepartamentoAdapter.ViewHolder holder, int position) {

        Departamento departamento = dataDepartamento.get(position);

        holder.textNombreDep.setText(departamento.getNombreDep());
        holder.textNumeroDep.setText( String.valueOf(departamento.getNumeroDep()));
        holder.textKilometrosDep.setText(String.valueOf(departamento.getKilometrosDep()));

        holder.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder log = new AlertDialog.Builder(holder.itemView.getContext());

                log.setMessage("HOLA");
                log.setPositiveButton("siu", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                log.show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return dataDepartamento.size();
    }


}

package com.example.imcviewholder;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.imcviewholder.models.Comida;

import java.util.ArrayList;

public class AdaptadorComida extends BaseAdapter
{

    public ArrayList<Comida> dataComida;
    public ArrayList<Comida> dataComidaOriginal;

    public Context context;
    public LayoutInflater inflater;


    public AdaptadorComida(ArrayList<Comida> dataComida, Context context) {
        this.dataComidaOriginal = new ArrayList<>(dataComida);
        this.dataComida = dataComida;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return dataComida.size();
    }

    @Override
    public Object getItem(int position) {
        return dataComida.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder
    {
        public TextView textCategoriaC;
        public TextView textNombreC;
        public TextView textPrecioC;
        public ImageView imageComida;
        public Button buttonAgregar;

    }

    public void  filtrar(String categoria)
    {
        dataComida.clear();
        for (Comida comida: dataComidaOriginal )
        {
            if (comida.getCategoria().equals(categoria))
            {
                dataComida.add(comida);
            }
        }
        notifyDataSetChanged();

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null)
        {
            convertView = inflater.inflate(R.layout.comida_item,parent,false);

            holder = new ViewHolder();

            holder.textNombreC = convertView.findViewById(R.id.textNombreC);
            holder.textCategoriaC = convertView.findViewById(R.id.textCategoriaC);
            holder.textPrecioC = convertView.findViewById(R.id.textPrecioC);
            holder.imageComida = convertView.findViewById(R.id.imageComida);
            holder.buttonAgregar = convertView.findViewById(R.id.buttonAgregar);

            convertView.setTag(holder);
        }else
        {
            holder = (ViewHolder) convertView.getTag();
        }


        Comida comida = dataComida.get(position);

        //if (!comida.isVisible())
       // {
       //     convertView.setVisibility( View.GONE);
       //     return convertView;
       // }
       // else
       // {
       //     convertView.setVisibility(View.VISIBLE);
      //  }

        holder.textNombreC.setText(comida.getNombre());
        holder.textCategoriaC.setText(comida.getCategoria());
        holder.textPrecioC.setText("$" + String.valueOf( comida.getPrecio()));
        holder.imageComida.setImageResource(R.drawable.ic_launcher_background);


        holder.buttonAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder log = new AlertDialog.Builder(context);

                log.setTitle("titulo");

                log.setMessage("si o no");

                log.setPositiveButton("si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        int cantidad = comida.getCantidad() +1;
                        comida.setCantidad(cantidad);
                        Toast.makeText(context, String.valueOf(comida.getCantidad()), Toast.LENGTH_SHORT).show();
                        AdaptadorComida.this.notifyDataSetChanged();
                    }
                });

                log.setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dataComidaOriginal.remove(comida);
                        dataComida.remove(comida);
                        AdaptadorComida.this.notifyDataSetChanged();
                    }
                });

                log.show();

            }
        });



        return convertView;
    }
}

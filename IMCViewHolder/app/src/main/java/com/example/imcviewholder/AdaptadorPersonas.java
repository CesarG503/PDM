package com.example.imcviewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.imcviewholder.models.Persona;

import java.util.ArrayList;

public class AdaptadorPersonas extends BaseAdapter {

    public ArrayList<Persona> dataPersonas;
    public Context context;
    public LayoutInflater infalter;

    public AdaptadorPersonas(ArrayList<Persona> dataPersonas, Context context)
    {
        this.dataPersonas = dataPersonas;
        this.context = context;
        this.infalter = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return dataPersonas.size();
    }

    @Override
    public Object getItem(int position) {
        return dataPersonas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class  ViewHolder
    {
        public TextView textNombre;
        public TextView textEdad;
        public TextView textGenero;
        public TextView textAltura;
        public TextView textPeso;
        public TextView textIMC;
        public TextView textCategoria;
        public ImageView imagePersona;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null)
        {


            convertView = infalter.inflate(R.layout.persona_item, parent, false);
            holder = new ViewHolder();
            //definiocion del holder

            holder.textNombre = convertView.findViewById(R.id.textNombre);
            holder.textEdad = convertView.findViewById(R.id.textEdad);
            holder.textGenero = convertView.findViewById(R.id.textGenero);
            holder.textAltura = convertView.findViewById(R.id.textAltura);
            holder.textPeso = convertView.findViewById(R.id.textPeso);
            holder.textIMC = convertView.findViewById(R.id.textIMC);
            holder.textCategoria = convertView.findViewById(R.id.textCategoria);
            holder.imagePersona = convertView.findViewById(R.id.imagePersona);

            convertView.setTag(holder);

        }else
        {
            holder = (ViewHolder) convertView.getTag();
        }

        Persona persona = dataPersonas.get(position);

        holder.textNombre.setText(persona.getNombre());
        holder.textEdad.setText(String.valueOf( persona.getEdad()));
        holder.textGenero.setText(persona.getGenero());
        holder.textAltura.setText(String.valueOf( persona.getAltura()));
        holder.textPeso.setText(String.valueOf( persona.getPeso()));
        holder.textIMC.setText(String.valueOf( persona.getIMC()));
        holder.textCategoria.setText(persona.getCategoria());
        holder.imagePersona.setImageResource(R.drawable.ic_launcher_background);

        return convertView;
    }
}

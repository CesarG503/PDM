package com.example.multiple;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.multiple.models.Producto;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AdaptadorPrueba extends BaseAdapter {

    public ArrayList<Producto> dataProducto;
    public Context context;
    public LayoutInflater inflater;


    public AdaptadorPrueba(ArrayList<Producto> dataProducto, Context context)
    {
        this.dataProducto = dataProducto;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return dataProducto.size();
    }

    @Override
    public Object getItem(int position) {
        return dataProducto.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder
    {
        public TextView texto1;
        public TextView texto2;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null)
        {
            convertView = inflater.inflate(R.layout.prueba, parent, false);
            holder = new ViewHolder();

            // inicializar las variables de los objetos items

            holder.texto1 = convertView.findViewById(R.id.texto1);
            holder.texto2 = convertView.findViewById(R.id.texto2);

            convertView.setTag(holder); //guardamos el enlace de los objetos

            // se puede agregar aqui la logica de los items
            // -setOnClickListeners
            // -Add
        }
        else
        {
            holder = (ViewHolder) convertView.getTag();

        }

        // ingresamos los datos

        Producto producto = dataProducto.get(position);

        holder.texto1.setText(producto.getNombre_producto());
        holder.texto2.setText( String.valueOf(producto.getPrecio()));


        return convertView;
    }
}

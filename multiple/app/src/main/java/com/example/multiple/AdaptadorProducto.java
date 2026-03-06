package com.example.multiple;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.multiple.models.Producto;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AdaptadorProducto  extends BaseAdapter {

    public ArrayList<Producto> dataProducto;

    public Context context;
    public LayoutInflater inflater;

    public AdaptadorProducto(ArrayList<Producto> dataProducto, Context context) {
        this.context = context;
        this.dataProducto = dataProducto;
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


    static class ViewHolder{
        public TextView nombreProducto;
        public TextView precioProducto;

        public Button eliminar;

        public ImageView img;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_productos, parent, false);
            holder = new ViewHolder();
            holder.nombreProducto = convertView.findViewById(R.id.nombreProducto);
            holder.precioProducto = convertView.findViewById(R.id.precioProducto);

            holder.img = convertView.findViewById(R.id.img);
            holder.eliminar = convertView.findViewById(R.id.eliminar);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Producto p = dataProducto.get(position);
        holder.nombreProducto.setText(p.getNombre_producto());
        holder.img.setImageResource(p.getImagen());
        holder.precioProducto.setText(String.valueOf(p.getPrecio()) );

        return convertView;
    }


}

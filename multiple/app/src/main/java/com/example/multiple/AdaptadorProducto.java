package com.example.multiple;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

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

        public CheckBox isSelect;
    }

    public ArrayList<Producto> getDataProducto()
    {
        return dataProducto;
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

            holder.isSelect = convertView.findViewById(R.id.isSelect);
            holder.isSelect.setOnCheckedChangeListener(null);


            convertView.setTag(holder);

            holder.eliminar.setOnClickListener(new View.OnClickListener() {
                                                   @Override
                                                   public void onClick(View v) {

                                                       AlertDialog.Builder dialogo = new AlertDialog.Builder(context);
                                                       
                                                       dialogo.setTitle("estas seguro?");
                                                       dialogo.setMessage("de verdad ?");
                                                       dialogo.setPositiveButton("si", (dialog,sw)->{
                                                           
                                                           dataProducto.remove(position);
                                                           notifyDataSetChanged();
                                                           
                                                       });
                                                       dialogo.setNegativeButton("no", (dialog,sw)->{
                                                           Toast.makeText(context, "no se elimino", Toast.LENGTH_SHORT).show();
                                                       });

                                                       dialogo.setNegativeButton("siu", new DialogInterface.OnClickListener() {
                                                           @Override
                                                           public void onClick(DialogInterface dialog, int which) {

                                                           }
                                                       });

                                                       dialogo.show();
                                         
                                                   }
                                               }
            );


        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Producto p = dataProducto.get(position);
        holder.nombreProducto.setText(p.getNombre_producto());
        holder.img.setImageResource(p.getImagen());
        holder.precioProducto.setText(String.valueOf(p.getPrecio()) );


        holder.isSelect.setChecked(p.isSeleccionado());

        holder.isSelect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {

                p.setSeleccionado(isChecked);
            }
        });

        return convertView;
    }


}

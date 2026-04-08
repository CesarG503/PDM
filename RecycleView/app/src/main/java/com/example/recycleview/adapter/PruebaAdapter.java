package com.example.recycleview.adapter;

import android.view.LayoutInflater;
import android.view.VerifiedInputEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview.R;
import com.example.recycleview.models.Producto;

import java.util.ArrayList;

public class PruebaAdapter extends RecyclerView.Adapter<PruebaAdapter.viewHolder>
{
    private ArrayList<Producto> dataProducto;


    public PruebaAdapter(ArrayList<Producto> dataProducto) {
        this.dataProducto = dataProducto;
    }


    @NonNull
    @Override
    public PruebaAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_producto, parent, false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PruebaAdapter.viewHolder holder, int position)
    {
        // le damos las propiedades y datos a cada item
        Producto producto = dataProducto.get(position);
        holder.imageP.setImageResource(producto.image);
        holder.textoNombreP.setText(producto.nombre);
        holder.textoStockP.setText(String.valueOf(producto.stock));


    }
    @Override
    public int getItemCount() {
        return dataProducto.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder
    {
        // inicializamos los objetos de nuestro layout item
        public TextView textoNombreP,textoStockP;
        public ImageView imageP;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            textoNombreP = itemView.findViewById(R.id.textNombreP);
            textoStockP = itemView.findViewById(R.id.textoStockP);
            imageP = itemView.findViewById(R.id.imageP);
        }
    }

}

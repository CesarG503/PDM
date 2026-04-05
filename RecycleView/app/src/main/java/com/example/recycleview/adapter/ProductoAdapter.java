package com.example.recycleview.adapter;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview.R;
import com.example.recycleview.models.Producto;

import java.util.ArrayList;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ProductoVH>
{

    private  ArrayList<Producto> data;

    public ProductoAdapter(ArrayList<Producto> data) {
        this.data = data;
    }



    @NonNull
    @Override
    public ProductoAdapter.ProductoVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent,false);



        return new ProductoVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoAdapter.ProductoVH holder, int position) {

        Producto producto = data.get(position);

        holder.imageProducto.setImageResource(producto.image);

        holder.textNombre.setText(producto.getNombre());
        holder.textStock.setText(String.valueOf( producto.getStock()));



    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ProductoVH extends RecyclerView.ViewHolder {

        public TextView textNombre;
        public TextView textStock;
        public ImageView imageProducto;

        public Button button;

        public ProductoVH(@NonNull View itemView) {


            super(itemView);

            textNombre = itemView.findViewById(R.id.textNombre);
            textStock = itemView.findViewById(R.id.textStock);
            button = itemView.findViewById(R.id.button);
            imageProducto= itemView.findViewById(R.id.imageProducto);

        }
    }
}

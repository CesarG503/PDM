package com.example.recycleview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview.R;
import com.example.recycleview.models.Peliculas;

import java.util.ArrayList;

public class PeliculaAdapter extends RecyclerView.Adapter<PeliculaAdapter.ViewHolder>
{

    private ArrayList<Peliculas> dataPeliculas;

    public PeliculaAdapter(ArrayList<Peliculas> dataPeliculas) {
        this.dataPeliculas = dataPeliculas;
    }



    // clase ViewHolder aqui asignamos todos los elementos de nuestra vista a esta clase
    public class  ViewHolder extends RecyclerView.ViewHolder
    {

        TextView textName, textSala,textCosto,textAsientos;
        ImageView imagenPelicula;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textName = itemView.findViewById(R.id.textName);
            textSala = itemView.findViewById(R.id.textSala);
            textCosto = itemView.findViewById(R.id.textCosto);
            textAsientos = itemView.findViewById(R.id.textAsientos);

            imagenPelicula = itemView.findViewById(R.id.imagenPelicula);
        }
    }


    // por ultimo asociamos el todo lo que hemos hecho para mandarlo a la vista principal y mediante se vaya identando se van a ir creados las vistas
    @NonNull
    @Override
    public PeliculaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pelicula, parent, false);

        return new ViewHolder(view);
    }


    // Aqui asignamos los atributos a los elementos que hemos inicializado en el ViewHolder
    @Override
    public void onBindViewHolder(@NonNull PeliculaAdapter.ViewHolder holder, int position) {

        Peliculas pelicula = dataPeliculas.get(position);


        holder.textName.setText(pelicula.getNombre());
        holder.textSala.setText( String.valueOf(pelicula.getSala()) );
        holder.textCosto.setText(String.valueOf(pelicula.getConsto()));
        holder.textAsientos.setText(String.valueOf(pelicula.getAsientos()));

        holder.imagenPelicula.setImageResource(pelicula.getImg());

    }

    // devolver el tamaño del arreglo que mandamos como parametro
    @Override
    public int getItemCount() {
        return dataPeliculas.size();
    }
}

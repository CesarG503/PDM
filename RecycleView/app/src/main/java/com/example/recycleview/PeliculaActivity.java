package com.example.recycleview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview.adapter.PeliculaAdapter;
import com.example.recycleview.models.Peliculas;

import java.util.ArrayList;

public class PeliculaActivity extends AppCompatActivity {

    ArrayList<Peliculas> peliculas;
    PeliculaAdapter adapter;
    RecyclerView RecyclePelicula;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pelicula);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RecyclePelicula = findViewById(R.id.RecyclePelicula);
        peliculas = new ArrayList<>();

        peliculas.add(new Peliculas("spyderman",10,10,1,R.drawable.ic_launcher_background));

        adapter = new PeliculaAdapter(peliculas);

        RecyclePelicula.setLayoutManager( new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        RecyclePelicula.setAdapter(adapter);


    }
}
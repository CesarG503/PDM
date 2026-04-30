package com.example.recycledb2;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.recycledb2.Adapter.AdapterIngrediente;
import com.example.recycledb2.Adapter.AdapterReceta;
import com.example.recycledb2.DAO.DAOReceta;
import com.example.recycledb2.Database.AppDatabase;
import com.example.recycledb2.Entitys.Ingrediente;
import com.example.recycledb2.Entitys.Receta;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recycleReceta;
    ArrayList<Receta> recetas;
    AdapterReceta adapterReceta;

    //datos
    AppDatabase database;
    DAOReceta daoReceta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        database = Room.databaseBuilder(this, AppDatabase.class,"db").allowMainThreadQueries().build();
        daoReceta = database.daoReceta();

        recycleReceta = findViewById(R.id.recycleReceta);

        recetas = new ArrayList<>();

        Receta receta = new Receta();

        receta.nombre = "nuevo";
        receta.descripcion = "goad";
        receta.servicios = 10;

        daoReceta.insert(receta);
        recetas.addAll(daoReceta.selectAll());



        adapterReceta = new AdapterReceta(recetas);
        recycleReceta.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recycleReceta.setLayoutManager(new GridLayoutManager(this, 2, RecyclerView.HORIZONTAL, false));
        recycleReceta.setAdapter(adapterReceta);


    }
}
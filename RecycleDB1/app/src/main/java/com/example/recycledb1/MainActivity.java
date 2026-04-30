package com.example.recycledb1;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.recycledb1.Adapter.AdapterReceta;
import com.example.recycledb1.DAO.DAOReceta;
import com.example.recycledb1.Database.AppDatabase;
import com.example.recycledb1.Entitys.Receta;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView RecycleReceta;
    ArrayList<Receta> recetas;
    AdapterReceta adapterReceta;

    AppDatabase database;
    DAOReceta daoReceta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //this.deleteDatabase("db");
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


        RecycleReceta = findViewById(R.id.RecycleReceta);

        recetas = new ArrayList<>();
        Receta receta = new Receta();

        receta.nombre = "hola";
        receta.descripcion = "que tal";
        receta.servicios = 12;

        //for (int i = 0; i < 5; i++) {
        //  recetas.add(receta);
        //  daoReceta.insert(receta);
        //}

        recetas.addAll(daoReceta.selectAll());

        adapterReceta = new AdapterReceta(recetas, new AdapterReceta.Listener() {
            @Override
            public void Onclick(Receta receta) {
                Toast.makeText(MainActivity.this, receta.nombre.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        RecycleReceta.setLayoutManager(new GridLayoutManager(this, 1, LinearLayoutManager.HORIZONTAL,false));
        RecycleReceta.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));

        RecycleReceta.setAdapter(adapterReceta);

    }
}
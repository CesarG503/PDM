package com.example.recycledb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.recycledb.DAO.DAO;
import com.example.recycledb.DAO.DAOingrediente;
import com.example.recycledb.Database.AppDatabase;
import com.example.recycledb.entitys.Ingrediente;
import com.example.recycledb.entitys.Receta;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AppDatabase database;

    private RecyclerView recycleReceta;
    private List<Receta> listaReceta;
    private AdapterReceta adapterReceta;


    private RecyclerView recycleIngredientes;
    private AdapterIngrediente adapterIngrediente;
    private ArrayList<Ingrediente> ingredientes;

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

        //database

        database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "db").allowMainThreadQueries().build();

        //dao recetas

        DAO dao = database.recetaDao();

        Receta receta = new Receta();

        receta.nombre = "caracol";
        receta.descripcion = "sopa de caracol";
        receta.servicios = 1;

        //for (int i = 0; i < 10; i++) {
        //  dao.insertReceta(receta);
        //}
        // recetas

        recycleReceta = findViewById(R.id.recycleReceta);
        recycleReceta.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        listaReceta = dao.selectAllReceta() ;
        adapterReceta = new AdapterReceta(listaReceta, new AdapterReceta.Listener() {
            @Override
            public void OnClick(Receta receta) {

                DAOingrediente daoIngrediente = database.ingredienteDao();
                List<Ingrediente> lista = daoIngrediente.selectRecetaIngredientes(receta.id);

                ingredientes.clear();

                ingredientes.addAll(lista);

                adapterIngrediente.notifyDataSetChanged();
            }

            @Override
            public void OnDelete(Receta receta) {

                listaReceta.remove(receta);
                DAO dao = database.recetaDao();

                dao.deleteReceta(receta);
                adapterReceta.notifyDataSetChanged();

            }
        });

        recycleReceta.setAdapter(adapterReceta);


        // Ingrediuentes

        recycleIngredientes = findViewById(R.id.recycleIngredientes2);
        ingredientes = new ArrayList<>();

        adapterIngrediente =  new AdapterIngrediente(ingredientes);
        recycleIngredientes.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recycleIngredientes.setAdapter(adapterIngrediente);

        //dao ingredientes

        DAOingrediente daoIngrediente = database.ingredienteDao();

        Ingrediente ingrediente = new Ingrediente();

        ingrediente.id_receta = 1;
        ingrediente.nombre_ingrediente = "pollo";
        ingrediente.cantidad = 10;

        //for (int i = 0; i < 4; i++) {
        //    daoIngrediente.insert(ingrediente);
        //}

    }

    public void nueva(View view) {
        Intent intent = new Intent(this,RecetaForm.class);
        startActivity(intent);

    }
}
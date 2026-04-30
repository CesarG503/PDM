package com.example.recycledb1;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.recycledb1.Adapter.AdapterIngrediente;
import com.example.recycledb1.DAO.DAOIngrediente;
import com.example.recycledb1.Database.DatabaseIngre;
import com.example.recycledb1.Entitys.Ingrediente;

import java.util.ArrayList;

public class MainActy extends AppCompatActivity {

    RecyclerView recycleIngrediente;
    ArrayList<Ingrediente> ingredientes;
    AdapterIngrediente adapterIngrediente;
    DAOIngrediente daoIngrediente;

    DatabaseIngre databaseIngre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_acty);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        databaseIngre = Room.databaseBuilder(this, DatabaseIngre.class, "db_ingre").allowMainThreadQueries().build();
        daoIngrediente = databaseIngre.daoIngrediente();

        recycleIngrediente = findViewById(R.id.recycleIngrediente);
        ingredientes = new ArrayList<>();

        Ingrediente ingrediente = new Ingrediente();

        ingrediente.nombre_ingrediente = "cebolla";
        ingrediente.cantidad = 12;

       // daoIngrediente.insert(ingrediente);
        ingredientes.addAll(daoIngrediente.selecAll());


        adapterIngrediente = new AdapterIngrediente(ingredientes);
        recycleIngrediente.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        recycleIngrediente.setAdapter(adapterIngrediente);

    }
}
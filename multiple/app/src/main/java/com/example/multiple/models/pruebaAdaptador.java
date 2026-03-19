package com.example.multiple.models;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.multiple.AdaptadorProducto;
import com.example.multiple.AdaptadorPrueba;
import com.example.multiple.R;

import java.util.ArrayList;

public class pruebaAdaptador extends AppCompatActivity {


    private ListView listViewProductos;

    private ArrayList<Producto> productos;
    private AdaptadorPrueba adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_prueba_adaptador);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        productos = new ArrayList<>();
        productos.add(new Producto(R.drawable.log, 2.22,"brocha"));

        //for (int i = 0; i < 10; i++) {
           // productos.add(new Producto(R.drawable.log, 2.22,"brocha"));
        //}


        adapter = new AdaptadorPrueba(productos,this);

        listViewProductos = findViewById(R.id.listViewProductos);

        listViewProductos.setAdapter(adapter);



    }
}
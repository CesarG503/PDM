package com.example.imcviewholder;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.imcviewholder.models.Comida;

import java.util.ArrayList;

public class formulario extends AppCompatActivity {

    private Spinner spinner_categorias;

    private  ArrayList<String> categorias;
    private ArrayAdapter<String> adapterCategoria;
    private ListView listViewComida;
    private ListView listViewCarrito;
    private ArrayList<Comida> listaComida;
    private ArrayList<Comida> listaComidaCarro;

    public ArrayAdapter<Comida> adapterComidaCarro;
    private AdaptadorComida adaperComida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_formulario);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        spinner_categorias = findViewById(R.id.spinner_categorias);

        categorias = new ArrayList<>();

        categorias.add("Fruta");
        categorias.add("Verdura");
        categorias.add("Semillas");

        adapterCategoria = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categorias);
        adapterCategoria.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner_categorias.setAdapter(adapterCategoria);



        listViewComida = findViewById(R.id.listViewComida);
        listaComida = new ArrayList<>();

        listaComida.add(new Comida("manzana","Fruta",12.2));
        listaComida.add(new Comida("goad","Fruta",12.2));
        listaComida.add(new Comida("daog","Fruta",12.2));
        listaComida.add(new Comida("pera","Verdura",12.2));
        listaComida.add(new Comida("naranja","Semillas",12.2));

        adaperComida = new AdaptadorComida(listaComida, this);
        listViewComida.setAdapter(adaperComida);

        listViewCarrito = findViewById(R.id.listViewCarrito);
        listaComidaCarro = new ArrayList<>();
        adapterComidaCarro = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaComidaCarro);
        adapterComidaCarro.setDropDownViewResource(android.R.layout.simple_list_item_1);
        listViewCarrito.setAdapter(adapterComidaCarro);

        adaperComida.registerDataSetObserver(new DataSetObserver() {
            @Override
            public void onChanged() {
                super.onChanged();

                listaComidaCarro.clear();

                for (Comida comida: adaperComida.dataComidaOriginal) {

                    if (comida.getCantidad() >0)
                    {
                        listaComidaCarro.add( comida);
                    }
                }
                adapterComidaCarro.notifyDataSetChanged();
            }
        });


        spinner_categorias.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                adaperComida.filtrar(parent.getSelectedItem().toString());
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




    }
}
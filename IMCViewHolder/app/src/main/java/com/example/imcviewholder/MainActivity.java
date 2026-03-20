package com.example.imcviewholder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.imcviewholder.models.Persona;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listViewPersonas;
    private ArrayList<Persona> listaPersonas;
    private AdaptadorPersonas adapter;

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

        listViewPersonas  = findViewById(R.id.listViewPersonas);
        listaPersonas = new ArrayList<>();
        listaPersonas.add(new Persona(12,12,"masculino",12, "Cesar"));
        listaPersonas.add(new Persona(12,12,"masculino",12, "Cesar"));
        listaPersonas.add(new Persona(12,12,"masculino",12, "Cesar"));
        listaPersonas.add(new Persona(12,12,"masculino",12, "Cesar"));


        adapter = new AdaptadorPersonas(listaPersonas, this);

        listViewPersonas.setAdapter(adapter);

    }

    public void siguiente(View view) {
        Intent intent = new Intent(this, formulario.class);
        startActivity(intent);
    }
}
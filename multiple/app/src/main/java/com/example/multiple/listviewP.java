package com.example.multiple;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class listviewP extends AppCompatActivity {

    private Spinner spinner_lista;
    private EditText texto_nombre;

    private ArrayList<String> nombres;
    private ArrayAdapter<String > adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_listview_p);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // inicializar las variables

        spinner_lista = findViewById(R.id.spinner_lista);
        texto_nombre = findViewById(R.id.texto_nombre);

        nombres = new ArrayList<>();

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,nombres);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        spinner_lista.setAdapter(adapter);


    }

    public void add(View view) {

        String nombre = texto_nombre.getText().toString();
        nombres.add(nombre);
        adapter.notifyDataSetChanged();

    }
}
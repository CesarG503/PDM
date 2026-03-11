package com.example.comida;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class calcular_moneda extends AppCompatActivity {

    private ListView listViewMondas;
    private  ListView listView_conversiones;
    private ArrayList<String> lista_conversiones;
    private ArrayAdapter<String> adapter_c;

    private ArrayList<String> listMonedas;

    private ArrayAdapter<String> adapter;
    private EditText cantidad;

    private TextView texto_seleccion;
    private int seleccion = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calcular_moneda);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        listViewMondas = findViewById(R.id.listViewMondas);
        cantidad = findViewById(R.id.cantidad);
        texto_seleccion = findViewById(R.id.texto_seleccion);

        listView_conversiones = findViewById(R.id.listView_conversiones);
        lista_conversiones = new ArrayList<>();

        adapter_c = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, lista_conversiones);
        adapter_c.setDropDownViewResource(android.R.layout.simple_spinner_item);
        listView_conversiones.setAdapter(adapter_c);


        listMonedas = new ArrayList<>();
        listMonedas.add("Euro");
        listMonedas.add("peso mexicano");
        listMonedas.add("quetzal");

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,listMonedas);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        listViewMondas.setAdapter(adapter);

        listViewMondas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                texto_seleccion.setText("Seleccione su moneda: " +parent.getItemAtPosition(position).toString());
                seleccion = position;
            }
        });

    }

    public void calcular(View view) {
        String cantidadS = cantidad.getText().toString().trim();
        String guardar;
        if (!cantidadS.isEmpty())
        {
            double total = Double.parseDouble(cantidadS);

            guardar = "";

            if (seleccion == 0)
            {
                guardar +="Euro -> dolar";
                total *= 1.08;

            }
            else if (seleccion == 1)
            {
                guardar +="Peso Mexicano -> dolar";
                total *= 0.049;

            } else if (seleccion == 2)
            {
                guardar +="Quetzal -> dolar";
                total *= 0.13;
            }
            guardar += "  " + cantidadS + " -> $"+ total;

            lista_conversiones.add(guardar);
            adapter_c.notifyDataSetChanged();
        }
        else{
            cantidad.setError("Ingrese un valor");
        }


    }
}
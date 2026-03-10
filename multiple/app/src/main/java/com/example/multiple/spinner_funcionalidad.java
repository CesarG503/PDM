package com.example.multiple;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.multiple.models.Producto;

import java.util.ArrayList;

public class spinner_funcionalidad extends AppCompatActivity {

    private Spinner spinner_departamento;
    private EditText itemNuevo;


    private Spinner spinner_numeros;
    private ArrayAdapter<CharSequence> numeros;
    private ArrayAdapter<Producto> producto_adapter;

    private Button boton;
    private ArrayList<String> departamentos;

    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_spinner_funcionalidad);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //INICIALIZACION DE LOS COMPONENTES

        spinner_departamento = findViewById(R.id.spinner_departamento);
        itemNuevo = findViewById(R.id.itemNuevo);

        departamentos = new ArrayList<String>();
        departamentos.add("san Miguel");
        departamentos.add("san usulutan");

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, departamentos );

        //adapter = ArrayAdapter.createFromResource(this, R.array.numeros, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_departamento.setAdapter(adapter);

        boton = findViewById(R.id.button21);


        spinner_numeros = findViewById(R.id.spinner_numeros);

        numeros = ArrayAdapter.createFromResource(this, R.array.numeros, android.R.layout.simple_spinner_item);


       /* Spinner con datos del arreglo de variables */

        ArrayList<Producto> productos = new ArrayList<>();
        Producto producto = new Producto(1,21.21,"carne");
        productos.add(producto);

        producto_adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,productos);

        producto_adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);


        spinner_numeros.setAdapter(numeros);

        spinner_numeros.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner_numeros.setAdapter(producto_adapter);

        // FIN INICIALIZACION DE LOS COMPONENTES


        spinner_departamento.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(spinner_funcionalidad.this, parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();

                boton.setText("Eliminar: " + parent.getItemAtPosition(position).toString());
                if (departamentos.size() == 0)
                {
                    boton.setText("Eliminar");
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void agregar(View view) {

        String item = itemNuevo.getText().toString().trim();

        if (item.isEmpty())
        {
            itemNuevo.setError("No se aceptan vacio");
        }
        else
        {
            departamentos.add(item);
            adapter.notifyDataSetChanged();
            itemNuevo.setText("");
        }
    }
    public void eliminar(View view) {
        int pos = spinner_departamento.getSelectedItemPosition();

        if (departamentos.size() > 0)
        {
            //Toast.makeText(this, pos, Toast.LENGTH_SHORT).show();
            departamentos.remove(pos);
            adapter.notifyDataSetChanged();
        }
        else
        {
            boton.setText("Eliminar");
        }
    }
}
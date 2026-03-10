package com.example.multiple;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    private Spinner departamentos;
    private TextView texto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        departamentos = findViewById(R.id.spinner);
        texto = findViewById(R.id.seleccion);

        ArrayAdapter<CharSequence> data = ArrayAdapter.createFromResource(this, R.array.lista_departamentos, android.R.layout.simple_spinner_item);

        data.setDropDownViewResource(android.R.layout.simple_spinner_item);

        departamentos.setAdapter(data);

        ArrayList<String> listaNombres = new ArrayList<String>();

        listaNombres.add("San miguel");listaNombres.add("Usulutan");


        ArrayAdapter<String> dataN = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listaNombres);


        departamentos.setAdapter(dataN);


        departamentos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                Toast.makeText(MainActivity2.this, "Indice" + position, Toast.LENGTH_SHORT).show();
                String seleccion = departamentos.getSelectedItem().toString();
                texto.setText(seleccion);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        ArrayList<Departamento> dataDepartamento = new ArrayList<Departamento>();

        dataDepartamento.add(new Departamento("1234","san miguel"));
        dataDepartamento.add(new Departamento("12345","san usulutan"));



        ArrayAdapter<Departamento> dataC = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataDepartamento);

        departamentos.setAdapter(dataC);

        departamentos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Departamento tem = (Departamento) parent.getItemAtPosition(position);

                Toast.makeText(MainActivity2.this, tem.toString(), Toast.LENGTH_SHORT).show();

                texto.setText(tem.toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    public void AbrirForm(View view) {

        Intent intent = new Intent(MainActivity2.this, Formulario.class);
        startActivity(intent);
    }

    public void IMC(View view) {

        Intent intent = new Intent(this, IMC.class);
        startActivity(intent);
    }

    public void irListaView(View view) {
        Intent intent = new Intent(this, ListaView.class);
        startActivity(intent);
    }

    public void irSpinner(View view) {

        Intent intent = new Intent(this, spinner_funcionalidad.class);

        intent.putExtra("hola", "hola loco");

        startActivity(intent);

    }
}
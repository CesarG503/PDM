package com.example.recycleview;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview.adapter.MascotaAdapter;
import com.example.recycleview.models.Mascota;

import java.util.ArrayList;

public class MascotaActivity extends AppCompatActivity {

    RecyclerView RecycleMascota;
    ArrayList<Mascota> mascotas;
    MascotaAdapter adapterMascota;
    Mascota mascotaSeleccionada;
    TextView seleccion;

    Spinner spinner_mascota;
    ArrayAdapter<String> adapter_spinner;
    
    ArrayList<String> lista_spinner;
    EditText textBuscador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mascota);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RecycleMascota = findViewById(R.id.RecycleMascota);
        mascotas = new ArrayList<>();

        mascotas.add(new Mascota("perro", 1, R.drawable.ic_launcher_background, 12));
        mascotas.add(new Mascota("gato", 1, R.drawable.ic_launcher_background, 12));
        mascotas.add(new Mascota("vaca", 1, R.drawable.ic_launcher_background, 12));
        mascotas.add(new Mascota("orangutan", 1, R.drawable.ic_launcher_background, 12));
        mascotas.add(new Mascota("camello", 1, R.drawable.ic_launcher_background, 12));

        seleccion = findViewById(R.id.seleccion);

        // Implementación de la interfaz con múltiples métodos
        adapterMascota = new MascotaAdapter(mascotas, new MascotaAdapter.Listener() {
            @Override
            public void onClick(Mascota item) {

                mascotaSeleccionada = item;
                seleccion.setText("Seleccion: " + mascotaSeleccionada.getNombrePerro());

            }

            @Override
            public void onEdit(Mascota item) {

            }

            @Override
            public void onDelete(Mascota item) {
                mascotas.remove(item);
                adapterMascota.notifyDataSetChanged();

            }
        });

        RecycleMascota.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        RecycleMascota.setAdapter(adapterMascota);


        spinner_mascota = findViewById(R.id.spinner_mascota);

        lista_spinner = new ArrayList<>();

        lista_spinner.add("Todo");
        for (Mascota mascota: mascotas)
        {
            lista_spinner.add(mascota.getNombrePerro());
            
        }

        adapter_spinner = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, lista_spinner);
        adapter_spinner.setDropDownViewResource(android.R.layout.simple_spinner_item);

        spinner_mascota.setAdapter(adapter_spinner);

        spinner_mascota.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String seleccion = parent.getSelectedItem().toString();
                adapterMascota.filtrar(seleccion);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        textBuscador = findViewById(R.id.textBuscador);

        textBuscador.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                String busqueda = textBuscador.getText().toString();
                if (busqueda != null)
                {
                    adapterMascota.filtrar(busqueda);
                }

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
        });


    }

    public void principal(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

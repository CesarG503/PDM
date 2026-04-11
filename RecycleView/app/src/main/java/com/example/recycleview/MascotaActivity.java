package com.example.recycleview;

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

import com.example.recycleview.adapter.MascotaAdapter;
import com.example.recycleview.models.Mascota;

import java.util.ArrayList;

public class MascotaActivity extends AppCompatActivity {

    RecyclerView RecycleMascota;
    ArrayList<Mascota> mascotas;
    MascotaAdapter adapterMascota;

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

        mascotas.add(new Mascota("perro",1, R.drawable.ic_launcher_background,12));
        mascotas.add(new Mascota("gato",1, R.drawable.ic_launcher_background,12));
        mascotas.add(new Mascota("vaca",1, R.drawable.ic_launcher_background,12));
        mascotas.add(new Mascota("orangutan",1, R.drawable.ic_launcher_background,12));
        mascotas.add(new Mascota("camello",1, R.drawable.ic_launcher_background,12));

        adapterMascota = new MascotaAdapter(mascotas);

        RecycleMascota.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));

        RecycleMascota.setAdapter(adapterMascota);




    }
    
    public void principal(View view) {

        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);
    }
}
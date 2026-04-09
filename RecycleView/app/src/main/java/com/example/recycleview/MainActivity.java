package com.example.recycleview;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.recycleview.adapter.ProductoAdapter;
import com.example.recycleview.adapter.PruebaAdapter;
import com.example.recycleview.models.Producto;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public RecyclerView recycleViewProducto;
    public PruebaAdapter adapterPrueba;

    public RecyclerView dataRecycler;

    public ArrayList<Producto> dataProducto;
    public ProductoAdapter adapter;

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

        dataRecycler = findViewById(R.id.listaRecycler);

        dataProducto = new ArrayList<>();
        dataProducto.add(new Producto("nombre", R.drawable.ic_launcher_background,2));
        dataProducto.add(new Producto("nombre", R.drawable.ic_launcher_background,2));
        dataProducto.add(new Producto("nombre", R.drawable.ic_launcher_background,2));

        dataRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));


        dataRecycler.setLayoutManager(new GridLayoutManager(this, 2));
        dataRecycler.setLayoutManager(new StaggeredGridLayoutManager(1,LinearLayoutManager.VERTICAL));

        dataRecycler.setLayoutManager(new GridLayoutManager(this, 2, LinearLayoutManager.HORIZONTAL, false));

        dataRecycler.setLayoutManager(new StaggeredGridLayoutManager(2,LinearLayoutManager.HORIZONTAL));


        adapter = new ProductoAdapter(dataProducto);

        dataRecycler.setAdapter(adapter);


        recycleViewProducto = findViewById(R.id.recycleViewProducto);

        adapterPrueba = new PruebaAdapter(dataProducto);

        recycleViewProducto.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false) );
        recycleViewProducto.setAdapter(adapterPrueba);



    }

    public void peliculas(View view) {

        Intent intent = new Intent(this, PeliculaActivity.class);

        intent.putExtra("nombre","cesar");

        AlertDialog.Builder log = new AlertDialog.Builder(this);

        log.setTitle("siguiente");
        log.setMessage("quieres ir a la siguiente pagina");
        //log.setNegativeButton( );
        log.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        log.setPositiveButton("sui", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(intent);
            }
        });

        log.show();

    }
}
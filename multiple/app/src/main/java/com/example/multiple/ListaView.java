package com.example.multiple;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.multiple.models.Producto;

import java.util.ArrayList;

public class ListaView extends AppCompatActivity {

    private ArrayList<String> departamentos;
    private ListView lstDepartamentos;

    private ArrayList<Producto> listaProductos;
    private AdaptadorProducto adapter;
    private ListView lista_producto;

    private EditText item;

    public ArrayAdapter<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //declarar o Inicializar variables
        lstDepartamentos = findViewById(R.id.lista);
        departamentos = new ArrayList<String>();
        item = findViewById(R.id.itemN);
        listaProductos = new ArrayList<Producto>();


        departamentos.add("san miguel");
        departamentos.add("san Usulutan");
        departamentos.add("san ta ana");

        data = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, departamentos);

        lstDepartamentos.setAdapter(data);

        lstDepartamentos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                String select = departamentos.get(position);
                Toast.makeText(ListaView.this, select, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        lstDepartamentos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String select = parent.getItemAtPosition(position).toString();

                Toast.makeText(ListaView.this, select + "CLICK RAPIDO", Toast.LENGTH_SHORT).show();
            }
        });



        listaProductos = new ArrayList<>();
        listaProductos.add(new Producto(R.drawable.log, 2.22,"brocha"));


        for (int i = 0; i < 10; i++) {
            listaProductos.add(new Producto(R.drawable.img, 2.22 + i ,"brocha"));
        }

        adapter = new AdaptadorProducto( listaProductos , this);

        lista_producto = findViewById(R.id.lista_producto);

        lista_producto.setAdapter(adapter);


    }

    public void Agregar(View view) {

        String valor = item.getText().toString();

        item.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
        });

        if (valor.isEmpty())
        {
            item.setError("No dejar vacio");

        }
        else
        {

            departamentos.add(valor);
            data.notifyDataSetChanged();
            item.setText("");
        }





    }
}
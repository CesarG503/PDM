package com.example.recycledb;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.recycledb.DAO.DAO;
import com.example.recycledb.DAO.DAOingrediente;
import com.example.recycledb.Database.AppDatabase;
import com.example.recycledb.entitys.Ingrediente;
import com.example.recycledb.entitys.Receta;

import java.util.ArrayList;

public class RecetaForm extends AppCompatActivity {

    EditText editNombre, editDescripcion, editServicios, editNombreI, editCantidadI;
    Button btnEditRe;
    boolean editMode = false;
    TextView textActual;

    Receta receta;
    ArrayList<Ingrediente> ingredientes;

    AppDatabase database;
    DAO dao;
    DAOingrediente daOingrediente;


    RecyclerView recycleIngredientes2;
    AdapterIngrediente adapterIngrediente;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_receta_form);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editNombre = findViewById(R.id.editNombre);
        editDescripcion = findViewById(R.id.editDescripcion);
        editServicios = findViewById(R.id.editServicios);
        editNombreI = findViewById(R.id.editNombreI);
        editCantidadI = findViewById(R.id.editCantidadI);
        textActual = findViewById(R.id.textActual);


        btnEditRe = findViewById(R.id.btnEditRe);

        if(editMode)
        {
            activar(false);

        }else
        {
            activar(false);
        }


        receta = new Receta();
        ingredientes = new ArrayList<>();



       // ingredientes.addAll(daOingrediente.selectRecetaIngredientes())

        database = Room.databaseBuilder(this, AppDatabase.class,"db").allowMainThreadQueries().build();

        dao = database.recetaDao();

        daOingrediente = database.ingredienteDao();


        //recycle view
        recycleIngredientes2 = findViewById(R.id.recycleIngredientes2);
        recycleIngredientes2.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));
        adapterIngrediente = new AdapterIngrediente(ingredientes);
        recycleIngredientes2.setAdapter(adapterIngrediente);


    }

    private boolean validarCampos(EditText... campos) {
        boolean todosValidos = true;
        for (EditText campo : campos) {
            if (campo.getText().toString().trim().isEmpty()) {
                campo.setError("Este campo es obligatorio");
                todosValidos = false;
            }
        }
        return todosValidos;
    }

    public void guardarReceta(View view) {
        if (validarCampos(editNombre, editDescripcion, editServicios) & editNombre.isEnabled() & !editMode) {
            receta.nombre = editNombre.getText().toString();
            receta.descripcion = editDescripcion.getText().toString();
            receta.servicios = Integer.parseInt(editServicios.getText().toString());

            editNombre.setEnabled(false);
            editDescripcion.setEnabled(false);
            editServicios.setEnabled(false);
            Toast.makeText(this, "Datos de receta fijados", Toast.LENGTH_SHORT).show();

             long id = dao.insertReceta(receta);

             receta.id = (int) id;

             textActual.setText(receta.toString());

             actualizar();
             activar(true);
        }
    }

    public void guardarIngrediente(View view) {
        if (!editNombre.isEnabled())
        {
        if (validarCampos(editNombreI, editCantidadI) ) {
            Ingrediente nuevo = new Ingrediente();
            nuevo.nombre_ingrediente = editNombreI.getText().toString();
            nuevo.cantidad = Double.parseDouble(editCantidadI.getText().toString());

            nuevo.id_receta = receta.id;

            editNombreI.setText("");
            editCantidadI.setText("");
            Toast.makeText(this, "Ingrediente añadido a la lista", Toast.LENGTH_SHORT).show();

            daOingrediente.insert(nuevo);
            actualizar();

        }}
        else
        {
            Toast.makeText(this, "Primero Guardar Una Receta para Agregar Ingredientes", Toast.LENGTH_SHORT).show();
        }
    }

    public void actualizar()
    {
        ingredientes.clear();
        adapterIngrediente.notifyDataSetChanged();
        ingredientes.addAll( daOingrediente.selectRecetaIngredientes(receta.id));
    }

    public void activar(boolean si)
    {
        if (si)
        {
            btnEditRe.setVisibility(View.VISIBLE);
            btnEditRe.setEnabled(true);

        }else
        {
            btnEditRe.setVisibility(View.INVISIBLE);
            btnEditRe.setEnabled(false);
        }
    }

    public void editar(View view) {

        if (btnEditRe.isEnabled())
        {
            editNombre.setEnabled(false);
            editDescripcion.setEnabled(false);
            editServicios.setEnabled(false);




            activar(false);
        }
    }
}

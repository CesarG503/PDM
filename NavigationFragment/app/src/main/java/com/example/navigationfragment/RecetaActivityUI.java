package com.example.navigationfragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.navigationfragment.dataBase.AppDatabase;
import com.example.navigationfragment.entitys.Receta;

public class RecetaActivityUI extends AppCompatActivity {

    public EditText editTextText, editTextText2, editTextText3;
    public Button btn_guardar, btn_cancelar, btn_borrar;
    private  Toolbar toolbar;
    private AppDatabase db;
    private int id = -1;

    public Receta receta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_receta_ui);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        toolbar  = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(v -> finish());

        db = AppDatabase.getINSTANCE(this);

        editTextText = findViewById(R.id.editTextText);
        editTextText2 = findViewById(R.id.editTextText2);
        editTextText3 = findViewById(R.id.editTextText3);

        btn_guardar = findViewById(R.id.btn_guardar);
        btn_cancelar = findViewById(R.id.btn_cancelar);
        btn_borrar = findViewById(R.id.btn_borrar);


        btn_cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); //funcion para salir ya esta programada
            }
        });

        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (id == -1)
                {
                    if (ValidarCampos(editTextText, editTextText2, editTextText3))
                    {
                        receta = new Receta();
                        receta.descripcion_receta = editTextText2.getText().toString();
                        receta.nombre_receta = editTextText.getText().toString();
                        receta.servicios = Integer.valueOf(editTextText3.getText().toString());

                        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
                            @Override
                            public void run() {
                                db.daoReceta().insert(receta);

                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        LimpiarCampos(editTextText, editTextText2, editTextText3);
                                        Toast.makeText(RecetaActivityUI.this, "se agrego con exito", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        });


                    }

                }
                else
                {
                    if (ValidarCampos(editTextText, editTextText2, editTextText3))
                    {
                        receta.descripcion_receta = editTextText2.getText().toString();
                        receta.nombre_receta = editTextText.getText().toString();
                        receta.servicios = Integer.valueOf(editTextText3.getText().toString());

                        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
                            @Override
                            public void run() {
                                db.daoReceta().update(receta);

                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(RecetaActivityUI.this, "se Actualizo con exito", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        });

                    }
                }
            }
        });



        if (getIntent().hasExtra("id")) {
            id = getIntent().getIntExtra("id", -1);
            loadCategoriaData();
            btn_borrar.setVisibility(View.VISIBLE);
        }
    }

    private boolean ValidarCampos(EditText... campos)
    {
        boolean val = true;

        for(EditText campo: campos)
        {
            if (campo.getText().toString().trim().isEmpty())
            {
                campo.setError("este campo es obligatorio");
                val = false;
            }
        }
        return val;
    }
    private void LimpiarCampos(EditText... campos)
    {
        for(EditText campo: campos) {
            campo.setText("");
        }
    }

    public void loadCategoriaData()
    {
        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                receta =  db.daoReceta().selectId(id);
                receta.id = id;

                if(receta != null){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            editTextText.setText(String.valueOf(receta.nombre_receta));
                            editTextText2.setText(String.valueOf(receta.descripcion_receta));
                            editTextText3.setText(String.valueOf(receta.servicios));
                        }
                    });
                }

            }
        });


    }


}
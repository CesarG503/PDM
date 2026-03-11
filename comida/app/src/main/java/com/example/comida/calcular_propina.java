package com.example.comida;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import javax.microedition.khronos.egl.EGLDisplay;

public class calcular_propina extends AppCompatActivity {

    private EditText monto;
    private EditText propina;
    private TextView total_text;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calcular_propina);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        monto = findViewById(R.id.monto);
        propina = findViewById(R.id.propina);
        total_text = findViewById(R.id.total_text);
    }

    public void regresar(View view) {
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
    }

    public void calcular(View view) {

        String montoS = monto.getText().toString().trim();
        String propinaS = propina.getText().toString().trim();

        if (montoS.isEmpty() || propinaS.isEmpty())
        {
            monto.setError("No dejar vacio");
            propina.setError("No dejar vacio");

        }
        else{

            double montoD = Double.parseDouble(montoS);
            double propinaD = Double.parseDouble(propinaS);
            double total;

            total =  (montoD * ((propinaD / 100) +1) );

            total_text.setText(String.format("Total a pagar: %.2f porcetaje de propina %.2f",total,propinaD));

        }





    }
}
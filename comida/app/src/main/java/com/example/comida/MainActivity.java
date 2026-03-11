package com.example.comida;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText user;
    private EditText pass;



    @SuppressLint("MissingInflatedId")
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

        user = findViewById(R.id.userD);
        pass = findViewById(R.id.passD);
    }

    public void ingresar(View view) {

        String usuario = user.getText().toString().trim();
        String contraseña = pass.getText().toString().trim();

        if(usuario.equalsIgnoreCase("ADMIN") & contraseña.equals("1234"))
        {
            Intent intent = new Intent(this, Menu.class);
            startActivity(intent);
        }
        else
        {
            user.setError("usuario o contraseña incorrecto!!");

        }

    }
}
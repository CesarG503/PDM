package com.example.spinner_practica;

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

    private EditText user,pass;


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
        user = findViewById(R.id.user);
        pass = findViewById(R.id.pass);
    }

    public void iniciar(View view) {

        String userS = user.getText().toString();
        String passS = pass.getText().toString();


        if (userS.isEmpty() || passS.isEmpty())
        {
            user.setError("Esta vacio");
            pass.setError("Esta vacio");

        }else
        {

            if(userS.equalsIgnoreCase("admin") && passS.equals("1234"))
            {
                Intent intent = new Intent(this, spinner_productos.class);
                startActivity(intent);
            }else
            {
                user.setError("Contraseña o usuario incorrecto");

            }
        }


    }
}